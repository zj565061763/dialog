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
import android.view.ViewGroup;

public interface ISDDialogBase
{
    /**
     * 返回内容View
     *
     * @return
     */
    View getContentView();

    /**
     * 设置内容布局id
     *
     * @param layoutId
     */
    void setContentView(int layoutId);

    /**
     * 设置内容
     *
     * @param view
     */
    void setContentView(View view);

    /**
     * 设置内容
     *
     * @param view
     * @param params
     */
    void setContentView(View view, ViewGroup.LayoutParams params);

    /**
     * 设置宽度
     *
     * @param width
     * @return
     */
    ISDDialogBase setWidth(int width);

    /**
     * 设置高度
     *
     * @param height
     * @return
     */
    ISDDialogBase setHeight(int height);

    /**
     * 设置全屏
     *
     * @return
     */
    ISDDialogBase setFullScreen();

    /**
     * 返回默认的padding
     *
     * @return
     */
    int getDefaultPadding();

    /**
     * 设置左边间距
     *
     * @param padding
     * @return
     */
    ISDDialogBase paddingLeft(int padding);

    /**
     * 设置顶部间距
     *
     * @param padding
     * @return
     */
    ISDDialogBase paddingTop(int padding);

    /**
     * 设置右边间距
     *
     * @param padding
     * @return
     */
    ISDDialogBase paddingRight(int padding);

    /**
     * 设置底部间距
     *
     * @param padding
     * @return
     */
    ISDDialogBase paddingBottom(int padding);

    /**
     * 设置上下左右间距
     *
     * @param paddings
     * @return
     */
    ISDDialogBase paddings(int paddings);

    /**
     * 是否点击按钮后自动关闭窗口
     *
     * @return
     */
    boolean isDismissAfterClick();

    /**
     * 设置是否点击按钮后自动关闭窗口,默认true(是)
     *
     * @param dismissAfterClick
     * @return
     */
    ISDDialogBase setDismissAfterClick(boolean dismissAfterClick);

    /**
     * 设置窗口显示的位置
     *
     * @param gravity
     * @return
     */
    ISDDialogBase setGrativity(int gravity);

    /**
     * 设置窗口动画style
     *
     * @param resId
     * @return
     */
    ISDDialogBase setAnimations(int resId);

    /**
     * 显示顶部
     */
    void showTop();

    /**
     * 显示中央
     */
    void showCenter();

    /**
     * 显示底部
     */
    void showBottom();

    /**
     * 延迟多久后关闭窗口
     *
     * @param delay （毫秒）
     * @return
     */
    ISDDialogBase startDismissRunnable(long delay);

    /**
     * 停止延迟关闭任务
     *
     * @return
     */
    ISDDialogBase stopDismissRunnable();
}
