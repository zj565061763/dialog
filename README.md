## Gradle
`compile 'com.fanwe.android:dialog:1.0.6'`

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

## SDDialogProgress
![](http://thumbsnap.com/i/IQwIGyF7.gif?0830)<br>
```java
SDDialogProgress dialog = new SDDialogProgress(this);

dialog.setCanceledOnTouchOutside(true);
dialog.setTextMsg("加载中...").show();
```

## ISDDialogBase
ISDDialogBase是所有的SDDialog的基类实现的接口
```java
public interface ISDDialogBase
{
    /**
     * 返回内容View
     *
     * @return
     */
    View getContentView();

    /**
     * 设置内容布局id
     *
     * @param layoutId
     */
    void setContentView(int layoutId);

    /**
     * 设置内容
     *
     * @param view
     */
    void setContentView(View view);

    /**
     * 设置内容
     *
     * @param view
     * @param params
     */
    void setContentView(View view, ViewGroup.LayoutParams params);

    /**
     * 设置宽度
     *
     * @param width
     * @return
     */
    ISDDialogBase setWidth(int width);

    /**
     * 设置高度
     *
     * @param height
     * @return
     */
    ISDDialogBase setHeight(int height);

    /**
     * 设置全屏
     *
     * @return
     */
    ISDDialogBase setFullScreen();

    /**
     * 返回默认的padding
     *
     * @return
     */
    int getDefaultPadding();

    /**
     * 设置左边间距
     *
     * @param padding
     * @return
     */
    ISDDialogBase paddingLeft(int padding);

    /**
     * 设置顶部间距
     *
     * @param padding
     * @return
     */
    ISDDialogBase paddingTop(int padding);

    /**
     * 设置右边间距
     *
     * @param padding
     * @return
     */
    ISDDialogBase paddingRight(int padding);

    /**
     * 设置底部间距
     *
     * @param padding
     * @return
     */
    ISDDialogBase paddingBottom(int padding);

    /**
     * 设置上下左右间距
     *
     * @param paddings
     * @return
     */
    ISDDialogBase paddings(int paddings);

    /**
     * 是否点击按钮后自动关闭窗口
     *
     * @return
     */
    boolean isDismissAfterClick();

    /**
     * 设置是否点击按钮后自动关闭窗口,默认true(是)
     *
     * @param dismissAfterClick
     * @return
     */
    ISDDialogBase setDismissAfterClick(boolean dismissAfterClick);

    /**
     * 设置窗口显示的位置
     *
     * @param gravity
     * @return
     */
    ISDDialogBase setGrativity(int gravity);

    /**
     * 设置窗口动画style
     *
     * @param resId
     * @return
     */
    ISDDialogBase setAnimations(int resId);

    /**
     * 显示顶部
     */
    void showTop();

    /**
     * 显示中央
     */
    void showCenter();

    /**
     * 显示底部
     */
    void showBottom();

    /**
     * 延迟多久后关闭窗口
     *
     * @param delay （毫秒）
     * @return
     */
    ISDDialogBase startDismissRunnable(long delay);

    /**
     * 停止延迟关闭任务
     *
     * @return
     */
    ISDDialogBase stopDismissRunnable();
}

```
