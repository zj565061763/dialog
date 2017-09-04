package com.fanwe.www.dialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.fanwe.library.dialog.ISDDialogConfirm;
import com.fanwe.library.dialog.ISDDialogMenu;
import com.fanwe.library.dialog.impl.SDDialogBase;
import com.fanwe.library.dialog.impl.SDDialogConfirm;
import com.fanwe.library.dialog.impl.SDDialogMenu;
import com.fanwe.library.dialog.impl.SDDialogProgress;

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
        SDDialogConfirm dialog = new SDDialogConfirm(this);
        dialog.setTextTitle("title")
                .setTextContent("content")
                .setTextCancel("cancel")
                .setTextConfirm("confirm")
                .setCallback(new ISDDialogConfirm.Callback()
                {
                    @Override
                    public void onClickCancel(View v, SDDialogBase dialog)
                    {
                        Toast.makeText(getApplicationContext(), "onClickCancel", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onClickConfirm(View v, SDDialogBase dialog)
                    {
                        Toast.makeText(getApplicationContext(), "onClickConfirm", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }

    public void onClickOpenDialogCustomConfirm(View view)
    {
        CustomDialog dialog = new CustomDialog(this);
        dialog.show();
    }

    public void onClickOpenDialogMenu(View view)
    {
        SDDialogMenu dialog = new SDDialogMenu(this);
        dialog.setTextTitle("请选择");
        dialog.setItems("LEWLY", "koukouz", "zhady", "NAPZ", "shNz", "heL^_x")
                .setCallback(new ISDDialogMenu.Callback()
                {
                    @Override
                    public void onClickCancel(View v, SDDialogBase dialog)
                    {
                        Toast.makeText(getApplicationContext(), "onClickCancel", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onClickItem(View v, int index, SDDialogBase dialog)
                    {
                        Toast.makeText(getApplicationContext(), "onClickItem:" + index, Toast.LENGTH_SHORT).show();
                    }
                }).showBottom();
    }

    public void onClickOpenDialogProgress(View view)
    {
        SDDialogProgress dialog = new SDDialogProgress(this);

        dialog.setCanceledOnTouchOutside(true);
        dialog.setTextMsg("加载中...").show();
    }
}
