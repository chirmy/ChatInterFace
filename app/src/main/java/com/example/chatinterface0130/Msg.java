package com.example.chatinterface0130;

import android.widget.ProgressBar;

public class Msg
{
    public static final int TYPR_RECEIVED=0;/*表示是一条收到的消息*/

    public static final int TYPE_SENT=1;/*表示是一条发送的消息*/

    public String content; /*消息内容*/

    private int leftIcon;

    private int rightIcon;

    private int type;/*消息类型*/

    public Msg(String content, int type,int leftIcon,int rightIcon)
    {
        this.content=content;
        this.type=type;
        this.leftIcon=leftIcon;
        this.rightIcon=rightIcon;
    }

    public int getType()
    {
        return type;
    }

    public int getleftIconId()
    {
        return this.leftIcon;
    }

    public int getRightIconId()
    {
        return this.rightIcon;
    }

    public String getContent()
    {
        return content;
    }
}
