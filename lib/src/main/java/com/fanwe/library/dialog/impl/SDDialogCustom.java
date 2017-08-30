package com.fanwe.library.dialog.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwe.library.dialog.R;
import com.fanwe.library.drawable.SDDrawable;
import com.fanwe.library.model.SDDelayRunnable;
import com.fanwe.library.utils.SDLayoutParamsUtil;
import com.fanwe.library.utils.SDViewUtil;

public class SDDialogCustom extends SDDialogBase
{
    public TextView tv_title;
    public TextView tv_tip;
    private LinearLayout ll_content;
    public TextView tv_cancel;
    public TextView tv_confirm;

    private SDDialogCustomCallback mCallback;

    /**
     * 用setCallback(callback)
     *
     * @param listener
     * @return
     */
    @Deprecated
    public SDDialogCustom setmListener(SDDialogCustomListener listener)
    {
        return setCallback(listener);
    }

    public SDDialogCustom setCallback(SDDialogCustomCallback callback)
    {
        mCallback = callback;
        return this;
    }

    public SDDialogCustom(Activity activity)
    {
        super(activity);
        init();
    }

    protected void init()
    {
        setContentView(R.layout.lib_dialog_dialog_confirm);
        tv_title = (TextView) findViewById(R.id.dialog_custom_tv_title);
        tv_tip = (TextView) findViewById(R.id.dialog_custom_tv_tip);
        ll_content = (LinearLayout) findViewById(R.id.dialog_custom_ll_content);
        tv_cancel = (TextView) findViewById(R.id.dialog_custom_tv_cancel);
        tv_confirm = (TextView) findViewById(R.id.dialog_custom_tv_confirm);

        SDViewUtil.setBackgroundDrawable(getContentView(), new SDDrawable().color(Color.WHITE).cornerAll(getLibraryConfig().getCorner()));
        initViewStates();
    }

    private void initViewStates()
    {
        SDViewUtil.setGone(tv_title);
        SDViewUtil.setGone(tv_cancel);
        SDViewUtil.setGone(tv_confirm);

        tv_cancel.setOnClickListener(this);
        tv_confirm.setOnClickListener(this);

        setTextColorCancel(getLibraryConfig().getColorMain());
        setTextColorConfirm(getLibraryConfig().getColorMain());

        setTextTitle("提示").setTextConfirm("确定").setTextCancel("取消");
    }

    public SDDialogCustom setCustomView(View view)
    {
        setCustomView(view, null);
        return this;
    }

    public SDDialogCustom setCustomView(View view, LinearLayout.LayoutParams params)
    {
        ll_content.removeAllViews();
        if (params == null)
        {
            params = SDLayoutParamsUtil.newParamsLinearLayoutMM();
        }
        ll_content.addView(view, params);
        return this;
    }

    public SDDialogCustom setCustomView(int layoutId)
    {
        ll_content.removeAllViews();
        LayoutInflater.from(getContext()).inflate(layoutId, ll_content, true);
        return this;
    }

    private void changeBackground()
    {
        if (tv_cancel.getVisibility() == View.VISIBLE && tv_confirm.getVisibility() == View.VISIBLE)
        {
            SDViewUtil.setBackgroundDrawable(tv_cancel, getBackgroundBottomLeft());
            SDViewUtil.setBackgroundDrawable(tv_confirm, getBackgroundBottomRight());
        } else if (tv_cancel.getVisibility() == View.VISIBLE)
        {
            SDViewUtil.setBackgroundDrawable(tv_cancel, getBackgroundBottomSingle());
        } else if (tv_confirm.getVisibility() == View.VISIBLE)
        {
            SDViewUtil.setBackgroundDrawable(tv_confirm, getBackgroundBottomSingle());
        }
    }

    // tip
    public void showTip(String tip, long time)
    {
        if (!TextUtils.isEmpty(tip) && time > 0)
        {
            tv_tip.setText(tip);
            SDViewUtil.setVisible(tv_tip);
            mHideTipRunnable.runDelay(time);
        }
    }

    public void showTip(String tip)
    {
        showTip(tip, 2000);
    }

    private SDDelayRunnable mHideTipRunnable = new SDDelayRunnable()
    {
        @Override
        public void run()
        {
            tv_tip.setText("");
            SDViewUtil.setGone(tv_tip);
        }
    };

    // ---------------------------color

    public SDDialogCustom setTextColorTitle(int color)
    {
        tv_title.setTextColor(color);
        return this;
    }

    public SDDialogCustom setTextColorCancel(int color)
    {
        tv_cancel.setTextColor(color);
        return this;
    }

    public SDDialogCustom setTextColorConfirm(int color)
    {
        tv_confirm.setTextColor(color);
        return this;
    }

    // ---------------------------text
    public SDDialogCustom setTextTitle(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            SDViewUtil.setGone(tv_title);
        } else
        {
            SDViewUtil.setVisible(tv_title);
            tv_title.setText(text);
        }
        return this;
    }

    public SDDialogCustom setTextCancel(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            SDViewUtil.setGone(tv_cancel);
        } else
        {
            SDViewUtil.setVisible(tv_cancel);
            tv_cancel.setText(text);
        }
        changeBackground();
        return this;
    }

    public SDDialogCustom setTextConfirm(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            SDViewUtil.setGone(tv_confirm);
        } else
        {
            SDViewUtil.setVisible(tv_confirm);
            tv_confirm.setText(text);
        }
        changeBackground();
        return this;
    }

    @Override
    public void onClick(View v)
    {
        if (v == tv_cancel)
        {
            clickCancel(v);
        } else if (v == tv_confirm)
        {
            clickConfirm(v);
        }

    }

    private void clickCancel(View v)
    {
        if (mCallback != null)
        {
            mCallback.onClickCancel(v, SDDialogCustom.this);
        }
        dismissAfterClick();
    }

    private void clickConfirm(View v)
    {
        if (mCallback != null)
        {
            mCallback.onClickConfirm(v, SDDialogCustom.this);
        }
        dismissAfterClick();
    }

    @Override
    public void onDismiss(DialogInterface dialog)
    {
        if (mCallback != null)
        {
            if (mCallback instanceof SDDialogCustomListener)
            {
                SDDialogCustomListener listener = (SDDialogCustomListener) mCallback;
                listener.onDismiss(SDDialogCustom.this);
            }
        }
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        mHideTipRunnable.removeDelay();
    }

    /**
     * 用SDDialogCustomCallback
     */
    @Deprecated
    public interface SDDialogCustomListener extends SDDialogCustomCallback
    {
        @Deprecated
        void onDismiss(SDDialogCustom dialog);
    }

    public interface SDDialogCustomCallback
    {
        void onClickCancel(View v, SDDialogCustom dialog);

        void onClickConfirm(View v, SDDialogCustom dialog);
    }
}
