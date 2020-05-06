package com.google.distlergrace.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity
{
    ImageView   mainImageView;
    TextView    title;
    TextView    description;

    String  data1;
    String  data2;
    int     myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        mainImageView	=	findViewById(R.id.mainImageView);
        title		    =	findViewById(R.id.title);
        description 	=	findViewById(R.id.description);

        getData();
        setData();
    }

    private void getData()
    {
        if(getIntent().hasExtra("myImage") &&
           getIntent().hasExtra("data1") &&
           getIntent().hasExtra("data2"))
        {
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage", 1);
        } else
        {
            Toast.makeText(this, "Error in data.", Toast.LENGTH_LONG).show();
        }
    }

    private void setData()
    {
        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myImage);
    }
}
