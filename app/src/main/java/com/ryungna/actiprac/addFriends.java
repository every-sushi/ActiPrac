package com.ryungna.actiprac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class addFriends extends AppCompatActivity {

    Button adding =(Button)findViewById(R.id.adding);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friends);

        adding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(addFriends.this,"친구를 추가해야함 이제",Toast.LENGTH_SHORT);
            }
        });
    }
}
