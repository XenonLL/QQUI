package org.example.qqui;

import android.*;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

import javax.crypto.Mac;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView reg = findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
        TextView fgt = findViewById(R.id.forget_psd);
        fgt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display_choice();
            }
        });
    }

    private void display_choice() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        final String[] way = {"找回密码", "短信验证登录", "取消"};
        builder.setItems(way, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(way[which] == "短信验证登录") {
                    Intent intent = new Intent(MainActivity.this, Confirm.class);
                    startActivity(intent);
                }
            }
        });
        builder.show();
    }
}
