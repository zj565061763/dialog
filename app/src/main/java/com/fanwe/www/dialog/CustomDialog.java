package com.fanwe.www.dialog;

import android.app.Activity;

import com.fanwe.lib.dialog.impl.FDialogConfirm;

/**
 * Created by Administrator on 2017/9/4.
 */

public class CustomDialog extends FDialogConfirm
{
    public CustomDialog(Activity activity)
    {
        super(activity);
        setCustomView(R.layout.dialog_custom);
    }
}
