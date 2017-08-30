package com.fanwe.library.dialog.impl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.fanwe.library.dialog.ISDDialogMenu;
import com.fanwe.library.dialog.R;

import java.util.List;

/**
 * 带取消按钮的菜单选择窗口
 */
public class SDDialogMenu extends SDDialogBase implements ISDDialogMenu
{
    public TextView tv_title;
    public TextView tv_cancel;
    public ListView lv_content;

    private Callback mCallback;

    public SDDialogMenu(Activity activity)
    {
        super(activity);
        init();
    }

    private void init()
    {
        setContentView(R.layout.lib_dialog_dialog_menu);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_cancel = (TextView) findViewById(R.id.tv_cancel);
        lv_content = (ListView) findViewById(R.id.lv_content);

        tv_cancel.setOnClickListener(this);
        setTextTitle(null);
    }

    //---------- ISDDialogMenu implements start ----------

    @Override
    public SDDialogMenu setTextTitle(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_title.setVisibility(View.GONE);
        } else
        {
            tv_title.setVisibility(View.VISIBLE);
            tv_title.setText(text);
        }
        return this;
    }

    @Override
    public SDDialogMenu setTextCancel(String text)
    {
        if (TextUtils.isEmpty(text))
        {
            tv_cancel.setVisibility(View.GONE);
        } else
        {
            tv_cancel.setVisibility(View.VISIBLE);
            tv_cancel.setText(text);
        }
        return this;
    }

    @Override
    public SDDialogMenu setCallback(Callback callback)
    {
        mCallback = callback;
        return this;
    }

    @Override
    public SDDialogMenu setItems(List<Object> listModel)
    {
        if (listModel != null && listModel.size() > 0)
        {

        }
        return this;
    }

    @Override
    public SDDialogMenu setAdapter(BaseAdapter adapter)
    {
        lv_content.setAdapter(adapter);
        lv_content.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                if (mCallback != null)
                {
                    mCallback.onClickItem(view, (int) id, SDDialogMenu.this);
                }
                dismissAfterClickIfNeed();
            }
        });
        return this;
    }

    //---------- ISDDialogMenu implements end ----------

    @Override
    public int getDefaultPadding()
    {
        int value = (int) (getContext().getResources().getDisplayMetrics().density * 10);
        return value;
    }


    @Override
    public void onClick(View v)
    {
        if (v == tv_cancel)
        {
            if (mCallback != null)
            {
                mCallback.onClickCancel(v, this);
            }
            dismissAfterClickIfNeed();
        }
    }

}
