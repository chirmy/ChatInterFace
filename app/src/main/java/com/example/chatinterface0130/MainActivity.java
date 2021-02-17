package com.example.chatinterface0130;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg>msgList=new ArrayList<>();

    private EditText inputText;

    private Button send;

    private Button switch1;

    private RecyclerView msgRecyclerView;

    private MsgAdapter msgAdapter;

    public  String markSend="RIGHT";

    private void initMsgs()
    {
        Msg msg1=new Msg("嘿~ 萌萌！",Msg.TYPR_RECEIVED,R.drawable.icon_left,R.drawable.icon_right);
        msgList.add(msg1);
        Msg msg2=new Msg("无论生气还是不开心，我都爱你鸭",Msg.TYPR_RECEIVED,R.drawable.icon_left,R.drawable.icon_right);
        msgList.add(msg2);
       /* Msg msg3=new Msg("",Msg.TYPR_RECEIVED,R.drawable.icon_left,R.drawable.icon_right);
        msgList.add(msg3);
        Msg msg4=new Msg("你可以在这里偷偷说我坏话，我看不到哒！",Msg.TYPR_RECEIVED,R.drawable.icon_left,R.drawable.icon_right);
        msgList.add(msg4);*/
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null)actionBar.hide();

        initMsgs();
        inputText=(EditText)findViewById(R.id.input_text);
        send=(Button)findViewById(R.id.send);
        switch1=(Button) findViewById(R.id.btn_switch);
        msgRecyclerView=(RecyclerView)findViewById(R.id.msg_recycler_view);
        msgAdapter=new MsgAdapter(msgList);
        LinearLayoutManager layoutManager=new LinearLayoutManager(MainActivity.this);
        msgRecyclerView.setLayoutManager(layoutManager);
        msgRecyclerView.setAdapter(msgAdapter);

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(markSend=="RIGHT") {
                    markSend = "LEFT";
                    Toast.makeText(MainActivity.this,"已切换为左方发言",Toast.LENGTH_LONG).show();
                }
                else if(markSend=="LEFT")
                {
                    markSend="RIGHT";
                    Toast.makeText(MainActivity.this,"已切换为右方发言",Toast.LENGTH_LONG).show();
                }
            }
        });



        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content=inputText.getText().toString();
                if(!content.equals(""))
                {
                    if(markSend=="RIGHT")
                    {
                        Msg msg=new Msg(content,Msg.TYPE_SENT,R.drawable.icon_left,R.drawable.icon_right);
                        msgList.add(msg);
                        msgAdapter.notifyItemInserted(msgList.size()-1);//当有新消息时，刷新ListView中的显示
                        msgRecyclerView.scrollToPosition(msgList.size()-1);//将ListView定位到最后一行
                        inputText.setText("");//清空输入框内容
                    }
                    else if(markSend=="LEFT")
                    {
                        Msg msg=new Msg(content,Msg.TYPR_RECEIVED,R.drawable.icon_left,R.drawable.icon_right);
                        msgList.add(msg);
                        msgAdapter.notifyItemInserted(msgList.size()-1);//当有新消息时，刷新ListView中的显示
                        msgRecyclerView.scrollToPosition(msgList.size()-1);//将ListView定位到最后一行
                        inputText.setText("");//清空输入框内容
                    }
                    }
                }
        });


    }
}