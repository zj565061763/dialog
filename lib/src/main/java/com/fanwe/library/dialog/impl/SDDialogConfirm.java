package com.fanwe.library.dialog.impl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fanwe.library.dialog.R;

/**
 * 带标题，内容，确定按钮和取消按钮的窗口
 *
 * @author js02
 */
public class SDDialogConfirm extends SDDialogCustom
{

    public TextView tv_content;

    public SDDialogConfirm(Activity activity)
    {
        super(activity);
    }

    @Override
    protected void init()
    {
        super.init();

        setCustomView(R.layout.dialog_confirm);
        tv_content = (TextView) findViewById(R.id.dialog_confirm_tv_content);

    }

    public SDDialogConfirm setTextGravity(int gravity)
    {
        if (tv_content.getLayoutParams() instanceof LinearLayout.LayoutParams)
        {
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tv_content.getLayoutParams();
            if (params.gravity != gravity)
            {
                params.gravity = gravity;
                tv_content.setLayoutParams(params);
            }
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
}
