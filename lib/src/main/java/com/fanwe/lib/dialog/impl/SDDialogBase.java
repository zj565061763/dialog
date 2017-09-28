/*
 * Copyright (C) 2017 zhengjun, fanwe (http://www.fanwe.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.fanwe.lib.dialog.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.fanwe.lib.dialog.ISDDialogBase;
import com.fanwe.lib.dialog.R;

public class SDDialogBase extends Dialog implements
        ISDDialogBase,
        View.OnClickListener,
        DialogInterface.OnDismissListener
{

    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());

    private View mContentView;
    private boolean mDismissAfterClick = true;

    public SDDialogBase(Activity activity)
    {
        this(activity, R.style.libDialog_Dialog_Dim);
    }

    public SDDialogBase(Activity activity, int theme)
    {
        super(activity, theme);

        setOwnerActivity(activity);
        setOnDismissListener(this);
        setCanceledOnTouchOutside(false);
    }

    //---------- ISDDialogBase implements start----------

    @Override
    public View getContentView()
    {
        return mContentView;
    }

    @Override
    public void setContentView(int layoutId)
    {
        FrameLayout tempLayout = new FrameLayout(getContext());
        View view = LayoutInflater.from(getContext()).inflate(layoutId, tempLayout, false);
        tempLayout.removeView(view);

        setDialogView(view, view.getLayoutParams());
    }

    @Override
    public void setContentView(View view)
    {
        setDialogView(view, view.getLayoutParams());
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params)
    {
        setDialogView(view, params);
    }

    @Override
    public SDDialogBase setWidth(int width)
    {
        ViewGroup.LayoutParams params = mContentView.getLayoutParams();
        params.width = width;
        mContentView.setLayoutParams(params);

        synchronizeWidth();
        return this;
    }

    /**
     * 设置宽度
     *
     * @param height
     * @return
     */
    public SDDialogBase setHeight(int height)
    {
        ViewGroup.LayoutParams params = mContentView.getLayoutParams();
        params.height = height;
        mContentView.setLayoutParams(params);

        synchronizeHeight();
        return this;
    }

    @Override
    public SDDialogBase setFullScreen()
    {
        paddings(0);
        setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        return this;
    }

    @Override
    public int getDefaultPadding()
    {
        int screenWidth = getContext().getResources().getDisplayMetrics().widthPixels;
        int value = (int) (screenWidth * 0.1f);
        return value;
    }

    @Override
    public SDDialogBase paddingLeft(int left)
    {
        View view = getWindow().getDecorView();
        view.setPadding(left, view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        return this;
    }

    @Override
    public SDDialogBase paddingTop(int top)
    {
        View view = getWindow().getDecorView();
        view.setPadding(view.getPaddingLeft(), top, view.getPaddingRight(), view.getPaddingBottom());
        return this;
    }

    @Override
    public SDDialogBase paddingRight(int right)
    {
        View view = getWindow().getDecorView();
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), right, view.getPaddingBottom());
        return this;
    }

    @Override
    public SDDialogBase paddingBottom(int bottom)
    {
        View view = getWindow().getDecorView();
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), bottom);
        return this;
    }

    @Override
    public SDDialogBase paddings(int paddings)
    {
        View view = getWindow().getDecorView();
        view.setPadding(paddings, paddings, paddings, paddings);
        return this;
    }

    @Override
    public boolean isDismissAfterClick()
    {
        return mDismissAfterClick;
    }

    @Override
    public SDDialogBase setDismissAfterClick(boolean dismissAfterClick)
    {
        mDismissAfterClick = dismissAfterClick;
        return this;
    }

    @Override
    public SDDialogBase setGrativity(int gravity)
    {
        getWindow().setGravity(gravity);
        return this;
    }

    @Override
    public SDDialogBase setAnimations(int resId)
    {
        getWindow().setWindowAnimations(resId);
        return this;
    }

    @Override
    public void showTop()
    {
        setGrativity(Gravity.TOP);
        setAnimations(R.style.libDialog_Anim_SlidingTopTop);
        show();
    }

    @Override
    public void showCenter()
    {
        setGrativity(Gravity.CENTER);
        show();
    }

    @Override
    public void showBottom()
    {
        setGrativity(Gravity.BOTTOM);
        setAnimations(R.style.libDialog_Anim_SlidingBottomBottom);
        show();
    }

    @Override
    public SDDialogBase startDismissRunnable(long delay)
    {
        stopDismissRunnable();
        MAIN_HANDLER.postDelayed(mDismissRunnable, delay);
        return this;
    }

    @Override
    public SDDialogBase stopDismissRunnable()
    {
        MAIN_HANDLER.removeCallbacks(mDismissRunnable);
        return this;
    }

    //---------- ISDDialogBase implements end----------

    private SDDialogBase setDialogView(View view, ViewGroup.LayoutParams params)
    {
        mContentView = view;
        if (params == null)
        {
            params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        super.setContentView(mContentView, params);

        paddings(getDefaultPadding());
        synchronizeWidth();
        return this;
    }

    /**
     * 把contentView的宽度同步到window
     */
    private void synchronizeWidth()
    {
        if (mContentView == null)
        {
            return;
        }
        ViewGroup.LayoutParams p = mContentView.getLayoutParams();
        if (p == null)
        {
            return;
        }

        WindowManager.LayoutParams wParams = getWindow().getAttributes();
        if (wParams.width != p.width)
        {
            wParams.width = p.width;
            getWindow().setAttributes(wParams);
        }
    }

    /**
     * 把contentView的高度同步到window
     */
    private void synchronizeHeight()
    {
        if (mContentView == null)
        {
            return;
        }
        ViewGroup.LayoutParams p = mContentView.getLayoutParams();
        if (p == null)
        {
            return;
        }

        WindowManager.LayoutParams wParams = getWindow().getAttributes();
        if (wParams.height != p.height)
        {
            wParams.height = p.height;
            getWindow().setAttributes(wParams);
        }
    }

    protected void dismissAfterClickIfNeed()
    {
        if (isDismissAfterClick())
        {
            dismiss();
        }
    }

    private Runnable mDismissRunnable = new Runnable()
    {
        @Override
        public void run()
        {
            dismiss();
        }
    };

    @Override
    public void onClick(View v)
    {

    }

    @Override
    protected void onStop()
    {
        super.onStop();
        stopDismissRunnable();
    }

    @Override
    public void show()
    {
        try
        {
            if (getOwnerActivity() != null && !getOwnerActivity().isFinishing())
            {
                super.show();
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog)
    {

    }

    @Override
    public void dismiss()
    {
        stopDismissRunnable();
        try
        {
            super.dismiss();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    protected static void setBackgroundDrawable(View view, Drawable drawable)
    {
        if (view == null)
        {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingTop = view.getPaddingTop();
        int paddingRight = view.getPaddingRight();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundDrawable(drawable);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }
}
