package com.example.chatinterface0130;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter <MsgAdapter.ViewHolder>
{
    private List<Msg>mMsgList;


    public MsgAdapter(List<Msg>msgList)
    {
        mMsgList=msgList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder (@NonNull final ViewGroup parent, int viewType) {
        final View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_item,parent,false);
        //Log.d("onCreat","ok");
        final ViewHolder holder=new ViewHolder(view);
        holder.rightIcon.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {

                //int position=holder.getAdapterPosition();
                //Msg msg=mMsgList.get(position);
                Intent intent = new Intent(v.getContext(), PersonMsgActivity.class);
                String rightMark="right";
                intent.putExtra("Mark", rightMark);
                v.getContext().startActivity(intent);

                //Toast.makeText(v.getContext(), "you clicked rightIcon ", Toast.LENGTH_LONG).show();
            }


        });

        holder.leftIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int position=holder.getAdapterPosition();
                //Msg msg=mMsgList.get(position);
                Intent intent = new Intent(v.getContext(), PersonMsgActivity.class);
                String leftMark="left";
                intent.putExtra("Mark",leftMark);
                v.getContext().startActivity(intent);
                //Toast.makeText(v.getContext(),"you clicked lefttIcon ",Toast.LENGTH_LONG).show();

            }
        });


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Msg msg=mMsgList.get(position);
        holder.leftIcon.setImageResource(msg.getleftIconId());
        holder.rightIcon.setImageResource(msg.getRightIconId());
        if(msg.getType()==Msg.TYPR_RECEIVED)
        {
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.INVISIBLE);
            holder.leftMsg.setText(msg.getContent());
        }
        else if(msg.getType()==msg.TYPE_SENT)
        {
            holder.leftLayout.setVisibility(View.INVISIBLE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightMsg.setText(msg.getContent());
        }

    }

    @Override
    public int getItemCount() {
        return mMsgList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        RelativeLayout leftLayout;

        RelativeLayout rightLayout;

        TextView leftMsg;

        TextView rightMsg;

        ImageView leftIcon;

        ImageView rightIcon;

        View msgView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            msgView=itemView;
            leftLayout=(RelativeLayout)itemView.findViewById(R.id.left_layout);
            rightLayout=(RelativeLayout) itemView.findViewById(R.id.right_layout);
            leftMsg=(TextView)itemView.findViewById(R.id.left_msg);
            rightMsg=(TextView)itemView.findViewById(R.id.right_msg);
            leftIcon=(ImageView)itemView.findViewById(R.id.icon_left);
            rightIcon=(ImageView)itemView.findViewById(R.id.icon_right);
            //Log.d("ViewHolder","ok");
        }
    }


}
