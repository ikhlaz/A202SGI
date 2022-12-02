package com.library;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        UserDB uDB = Room.databaseBuilder(getApplicationContext(), UserDB.class, "user-database").allowMainThreadQueries().build();

        EditText txt_username = (EditText) findViewById(R.id.register_input_username);
        EditText txt_password = (EditText) findViewById(R.id.register_input_password);

        Button btn_login = (Button) findViewById(R.id.register_btn_register);
        btn_login.setOnClickListener(view -> {
            String username = txt_username.getText().toString();
            String password = txt_password.getText().toString();

            if (uDB.userDAO().doesUsernameExist(username)) {
                Log.d("error", "Username already exists");
            } else {
                Log.d("success", "User registered successfully");
                User user = new User(username, password);
                uDB.userDAO().insertAll(user);
                startActivity(new Intent(getApplicationContext(), List.class));
            }
        });

        TextView link_login = (TextView) findViewById(R.id.register_txt_loginlink);
        link_login.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Login.class));
        });
    }
}