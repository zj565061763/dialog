package com.fanwe.www.dialog;

import android.app.Activity;

import com.fanwe.lib.dialog.impl.SDDialogConfirm;

/**
 * Created by Administrator on 2017/9/4.
 */

public class CustomDialog extends SDDialogConfirm
{
    public CustomDialog(Activity activity)
    {
        super(activity);
        setCustomView(R.layout.dialog_custom);
    }
}
