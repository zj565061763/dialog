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
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.fanwe.lib.dialog.ISDDialogConfirm;
import com.fanwe.lib.dialog.R;

/**
 * 带标题，内容，确定按钮和取消按钮的窗口
 */
public class SDDialogConfirm extends SDDialogBase implements ISDDialogConfirm
{
    public TextView tv_title;

    public FrameLayout fl_content;
    public TextView tv_content;

    public TextView tv_confirm;
    public TextView tv_cancel;

    private Callback mCallback;

    public SDDialogConfirm(Activity activity)
    {
        super(activity);
        init();
    }

    private void init()
    {
        setContentView(R.layout.lib_dialog_dialog_confirm);
        tv_title = (TextView) findViewById(R.id.tv_title);

        fl_content = (FrameLayout) findViewById(R.id.fl_content);
        tv_content = (TextView) findViewById(R.id.tv_content);

        tv_confirm = (TextView) findViewById(R.id.tv_confirm);
        tv_cancel = (TextView) findViewById(R.id.tv_cancel);

        tv_confirm.setOnClickListener(this);
        tv_cancel.setOnClickListener(this);
    }

    @Override
    public SDDialogConfirm setCustomView(int layoutId)
    {
        fl_content.removeAllViews();
        LayoutInflater.from(getContext()).inflate(layoutId, fl_content, true);
        return this;
    }

    @Override
    public SDDialogConfirm setCustomView(View view)
    {
        fl_content.removeAllViews();
        fl_content.addView(view);
        return this;
    }

    @Override
    public SDDialogConfirm setCallback(Callback callback)
    {
        mCallback = callback;
        return this;
    }

    @Override
    public SDDialogConfirm setTextTitle(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_title.setVisibility(View.GONE);
        } else
        {
            tv_title.setVisibility(View.VISIBLE);
            tv_title.setText(text);
        }
        return this;
    }

    public SDDialogConfirm setTextContent(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_content.setVisibility(View.GONE);
        } else
        {
            tv_content.setVisibility(View.VISIBLE);
            tv_content.setText(text);
        }
        return this;
    }

    @Override
    public SDDialogConfirm setTextConfirm(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_confirm.setVisibility(View.GONE);
        } else
        {
            tv_confirm.setVisibility(View.VISIBLE);
            tv_confirm.setText(text);
        }
        changeBottomButtonIfNeed();
        return this;
    }

    @Override
    public SDDialogConfirm setTextCancel(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_cancel.setVisibility(View.GONE);
        } else
        {
            tv_cancel.setVisibility(View.VISIBLE);
            tv_cancel.setText(text);
        }
        changeBottomButtonIfNeed();
        return this;
    }

    @Override
    public SDDialogConfirm setTextColorTitle(int color)
    {
        tv_title.setTextColor(color);
        return this;
    }

    @Override
    public SDDialogConfirm setTextColorContent(int color)
    {
        tv_content.setTextColor(color);
        return this;
    }

    @Override
    public SDDialogConfirm setTextColorConfirm(int color)
    {
        tv_confirm.setTextColor(color);
        return this;
    }

    @Override
    public SDDialogConfirm setTextColorCancel(int color)
    {
        tv_cancel.setTextColor(color);
        return this;
    }

    @Override
    public void onClick(View v)
    {
        super.onClick(v);
        if (v == tv_confirm)
        {
            if (mCallback != null)
            {
                mCallback.onClickConfirm(v, this);
            }
            dismissAfterClickIfNeed();
        } else if (v == tv_cancel)
        {
            if (mCallback != null)
            {
                mCallback.onClickCancel(v, this);
            }
            dismissAfterClickIfNeed();
        }
    }

    protected void changeBottomButtonIfNeed()
    {
        if (tv_cancel.getVisibility() == View.VISIBLE && tv_confirm.getVisibility() == View.VISIBLE)
        {
            setBackgroundDrawable(tv_cancel, getContext().getResources().getDrawable(R.drawable.lib_dialog_sel_bg_button_bottom_left));
            setBackgroundDrawable(tv_confirm, getContext().getResources().getDrawable(R.drawable.lib_dialog_sel_bg_button_bottom_right));
        } else if (tv_cancel.getVisibility() == View.VISIBLE)
        {
            setBackgroundDrawable(tv_cancel, getContext().getResources().getDrawable(R.drawable.lib_dialog_sel_bg_button_bottom_single));
        } else if (tv_confirm.getVisibility() == View.VISIBLE)
        {
            setBackgroundDrawable(tv_confirm, getContext().getResources().getDrawable(R.drawable.lib_dialog_sel_bg_button_bottom_single));
        }
    }
}
