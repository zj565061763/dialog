package com.fanwe.www.dialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.fanwe.lib.dialog.FIDialogConfirm;
import com.fanwe.lib.dialog.FIDialogMenu;
import com.fanwe.lib.dialog.impl.FDialog;
import com.fanwe.lib.dialog.impl.FDialogConfirm;
import com.fanwe.lib.dialog.impl.FDialogMenu;
import com.fanwe.lib.dialog.impl.FDialogProgress;

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
        FDialogConfirm dialog = new FDialogConfirm(this);
        dialog.setTextTitle("title")
                .setTextContent("content")
                .setTextCancel("cancel")
                .setTextConfirm("confirm")
                .setCallback(new FIDialogConfirm.Callback()
                {
                    @Override
                    public void onClickCancel(View v, FDialog dialog)
                    {
                        Toast.makeText(getApplicationContext(), "onClickCancel", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onClickConfirm(View v, FDialog dialog)
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
        FDialogMenu dialog = new FDialogMenu(this);
        dialog.setTextTitle("请选择");
        dialog.setItems("LEWLY", "koukouz", "zhady", "NAPZ", "shNz", "heL^_x")
                .setCallback(new FIDialogMenu.Callback()
                {
                    @Override
                    public void onClickCancel(View v, FDialog dialog)
                    {
                        Toast.makeText(getApplicationContext(), "onClickCancel", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onClickItem(View v, int index, FDialog dialog)
                    {
                        Toast.makeText(getApplicationContext(), "onClickItem:" + index, Toast.LENGTH_SHORT).show();
                    }
                }).showBottom();
    }

    public void onClickOpenDialogProgress(View view)
    {
        FDialogProgress dialog = new FDialogProgress(this);

        dialog.setCanceledOnTouchOutside(true);
        dialog.setTextMsg("加载中...").show();
    }
}
