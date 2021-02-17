package com.example.chatinterface0130;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PersonMsgActivity extends AppCompatActivity
{
    //ImageView imageView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        final String mark=intent.getStringExtra("Mark");
        if(mark.equals("left"))setContentView(R.layout.lperson_layout);
        else if(mark.equals("right"))setContentView(R.layout.rperson_layout);
        //imageView=(ImageView) findViewById(R.id.image_person);
        //imageView.setImageResource(R.drawable.image_leftmssg);

    }
}
