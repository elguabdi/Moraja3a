package com.example.moraja3a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
   EditText name ,last_name ;
   Button btn_save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     final    database db= new database(this,"scole",null,1);
        name=findViewById(R.id.txt_name);
        last_name=findViewById(R.id.txt_last_name);
        btn_save=findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.add(name.getText().toString(),last_name.getText().toString());
            }
        });
    }
}