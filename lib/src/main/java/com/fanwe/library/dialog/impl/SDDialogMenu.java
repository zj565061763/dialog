package com.fanwe.library.dialog.impl;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

    private List<Object> mListModel;

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
        mListModel = listModel;
        setAdapter(mInternalAdapter);
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

    private BaseAdapter mInternalAdapter = new BaseAdapter()
    {
        @Override
        public int getCount()
        {
            if (mListModel != null && !mListModel.isEmpty())
            {
                return mListModel.size();
            }
            return 0;
        }

        @Override
        public Object getItem(int position)
        {
            return getModel(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            if (convertView == null)
            {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.lib_dialog_item_dialog_menu, parent, false);
            }
            TextView textView = (TextView) convertView.findViewById(R.id.tv_content);
            Object object = getItem(position);
            if (object != null)
            {
                textView.setText(String.valueOf(object));
            }
            return convertView;
        }
    };

    private Object getModel(int position)
    {
        if (mListModel != null && !mListModel.isEmpty()
                && position >= 0
                && position < mListModel.size())
        {
            return mListModel.get(position);
        }
        return null;
    }

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
