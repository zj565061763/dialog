package com.fanwe.library.dialog;

import android.view.View;

import com.fanwe.library.dialog.impl.SDDialogBase;

/**
 * Created by Administrator on 2017/8/30.
 */

public interface ISDDialogConfirm
{
    /**
     * 设置自定义View，替换掉中间内容部分的布局
     *
     * @param layoutId
     * @return
     */
    ISDDialogConfirm setCustomView(int layoutId);

    /**
     * 设置自定义View，替换掉中间内容部分的布局
     *
     * @param view
     * @return
     */
    ISDDialogConfirm setCustomView(View view);

    /**
     * 设置点击回调
     *
     * @param callback
     * @return
     */
    ISDDialogConfirm setCallback(Callback callback);

    /**
     * 设置标题文字
     *
     * @param text
     * @return
     */
    ISDDialogConfirm setTextTitle(String text);

    /**
     * 设置内容文字
     *
     * @param text
     * @return
     */
    ISDDialogConfirm setTextContent(String text);

    /**
     * 设置取消按钮文字
     *
     * @param text
     * @return
     */
    ISDDialogConfirm setTextCancel(String text);

    /**
     * 设置确定按钮文字
     *
     * @param text
     * @return
     */
    ISDDialogConfirm setTextConfirm(String text);

    interface Callback
    {
        void onClickCancel(View v, SDDialogBase dialog);

        void onClickConfirm(View v, SDDialogBase dialog);
    }
}
