## SDDialogConfirm
![](http://thumbsnap.com/i/zWa4uIPF.gif?0830)<br>
```java
SDDialogConfirm dialog = new SDDialogConfirm(this);
dialog.setTextTitle("title") //设置标题文字，null不显示
        .setTextContent("content") //设置内容文字
        .setTextCancel("cancel") //设置取消文字，null不显示
        .setTextConfirm("confirm") //设置确认文字，null不显示
        .setCallback(new ISDDialogConfirm.Callback() //设置点击回调
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
//  dialog.showTop(); //显示在屏幕顶部
//  dialog.showBottom(); //显示在屏幕底部
```

## SDDialogMenu
![](http://thumbsnap.com/i/IagAApF0.gif?0830)<br>
```java
SDDialogMenu dialog = new SDDialogMenu(this);
dialog.setItems("hel", "koukouz", "zhady") //设置要显示的内容
//dialog.setAdapter(baseAdapter); //设置数据内容适配器
        .setCallback(new ISDDialogMenu.Callback() //设置点击回调
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
        }).showBottom(); //显示在屏幕底部
```
