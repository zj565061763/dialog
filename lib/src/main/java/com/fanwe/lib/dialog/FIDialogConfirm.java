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
package com.fanwe.lib.dialog;

import android.view.View;

import com.fanwe.lib.dialog.impl.FDialog;

public interface FIDialogConfirm
{
    /**
     * 设置自定义View，替换掉中间内容部分的布局
     *
     * @param layoutId
     * @return
     */
    FIDialogConfirm setCustomView(int layoutId);

    /**
     * 设置自定义View，替换掉中间内容部分的布局
     *
     * @param view
     * @return
     */
    FIDialogConfirm setCustomView(View view);

    /**
     * 设置点击回调
     *
     * @param callback
     * @return
     */
    FIDialogConfirm setCallback(Callback callback);

    /**
     * 设置标题文字
     *
     * @param text
     * @return
     */
    FIDialogConfirm setTextTitle(String text);

    /**
     * 设置内容文字
     *
     * @param text
     * @return
     */
    FIDialogConfirm setTextContent(String text);

    /**
     * 设置取消按钮文字
     *
     * @param text
     * @return
     */
    FIDialogConfirm setTextCancel(String text);

    /**
     * 设置确定按钮文字
     *
     * @param text
     * @return
     */
    FIDialogConfirm setTextConfirm(String text);

    /**
     * 设置标题文字颜色
     *
     * @param color
     * @return
     */
    FIDialogConfirm setTextColorTitle(int color);

    /**
     * 设置内容文字颜色
     *
     * @param color
     * @return
     */
    FIDialogConfirm setTextColorContent(int color);

    /**
     * 设置取消文字颜色
     *
     * @param color
     * @return
     */
    FIDialogConfirm setTextColorCancel(int color);

    /**
     * 设置确认文字颜色
     *
     * @param color
     * @return
     */
    FIDialogConfirm setTextColorConfirm(int color);

    interface Callback
    {
        void onClickCancel(View v, FDialog dialog);

        void onClickConfirm(View v, FDialog dialog);
    }
}
