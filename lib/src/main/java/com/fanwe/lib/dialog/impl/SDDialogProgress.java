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
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.fanwe.lib.dialog.R;

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
