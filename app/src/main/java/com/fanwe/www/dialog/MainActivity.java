package com.fanwe.www.dialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.fanwe.library.dialog.impl.SDDialogConfirm;
import com.fanwe.library.dialog.impl.SDDialogMenu;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickOpenDialogConfirm(View view)
    {
        new SDDialogConfirm(this).show();
    }

    public void onClickOpenDialogMenu(View view)
    {
        SDDialogMenu dialogMenu = new SDDialogMenu(this);
        Object[] arrItem = new String[]{"hel", "koukouz", "zhady"};
        dialogMenu.setItems(Arrays.asList(arrItem));
        dialogMenu.showBottom();
    }
}
