package com.fanwe.library.dialog;

import android.view.View;
import android.widget.BaseAdapter;

import com.fanwe.library.dialog.impl.SDDialogBase;

import java.util.List;

/**
 * Created by Administrator on 2017/8/30.
 */

public interface ISDDialogMenu
{
    /**
     * 设置标题文字
     *
     * @param text
     * @return
     */
    ISDDialogMenu setTextTitle(String text);

    /**
     * 设置取消文字
     *
     * @param text
     * @return
     */
    ISDDialogMenu setTextCancel(String text);

    /**
     * 设置回调
     *
     * @param callback
     * @return
     */
    ISDDialogMenu setCallback(Callback callback);

    ISDDialogMenu setItems(List<Object> listModel);

    /**
     * 设置适配器
     *
     * @param adapter
     * @return
     */
    ISDDialogMenu setAdapter(BaseAdapter adapter);


    interface Callback
    {
        void onClickCancel(View v, SDDialogBase dialog);

        void onClickItem(View v, int index, SDDialogBase dialog);
    }
}
