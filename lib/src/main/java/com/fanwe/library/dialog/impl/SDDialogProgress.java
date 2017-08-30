package com.fanwe.library.dialog.impl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fanwe.library.dialog.R;

/**
 * 带环形进度条，和信息提示的窗口
 */
public class SDDialogProgress extends SDDialogBase
{
    public SDDialogProgress(Activity activity)
    {
        super(activity);
        init();
    }

    private TextView tv_msg;
    private ProgressBar pb_progress;

    private void init()
    {
        setContentView(R.layout.lib_dialog_dialog_progress);
        tv_msg = (TextView) findViewById(R.id.tv_msg);
        pb_progress = (ProgressBar) findViewById(R.id.pb_progress);
    }

    public SDDialogProgress setTextMsg(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_msg.setVisibility(View.GONE);
        } else
        {
            tv_msg.setVisibility(View.VISIBLE);
            tv_msg.setText(text);
        }
        return this;
    }
}
