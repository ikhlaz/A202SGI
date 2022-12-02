package com.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        InventoryDB iDB = Room.databaseBuilder(getApplicationContext(), InventoryDB.class, "inventory-database").allowMainThreadQueries().build();
        if (!iDB.InventoryDAO().doesIdExist("A01")) {
            Inventory A01 = new Inventory("A01", true);
            iDB.InventoryDAO().insertAll(A01);
        }
        if (!iDB.InventoryDAO().doesIdExist("A02")) {
            Inventory A02 = new Inventory("A02", true);
            iDB.InventoryDAO().insertAll(A02);
        }
        if (!iDB.InventoryDAO().doesIdExist("A03")) {
            Inventory A03 = new Inventory("A03", true);
            iDB.InventoryDAO().insertAll(A03);
        }
        if (!iDB.InventoryDAO().doesIdExist("A04")) {
            Inventory A04 = new Inventory("A04", true);
            iDB.InventoryDAO().insertAll(A04);
        }
        if (!iDB.InventoryDAO().doesIdExist("A05")) {
            Inventory A05 = new Inventory("A05", true);
            iDB.InventoryDAO().insertAll(A05);
        }
        iDB.InventoryDAO().setStatusTrue("A01");
        iDB.InventoryDAO().setStatusTrue("A02");
        iDB.InventoryDAO().setStatusTrue("A03");
        iDB.InventoryDAO().setStatusTrue("A04");
        iDB.InventoryDAO().setStatusTrue("A05");

        UserDB uDB = Room.databaseBuilder(getApplicationContext(), UserDB.class, "user-database").allowMainThreadQueries().build();
        if (uDB.userDAO().doesUsernameExist("admin")) {
            Log.d("username", "username admin already exists");
        } else {
            Log.d("username", "username admin does not exist");
            User admin = new User("admin", "nidma");
            uDB.userDAO().insertAll(admin);
        }

        List<User> userList = uDB.userDAO().getAllUsers();
        for(User list: userList){
            Log.d("users", "username : " + list.username + " || password: " + list.password);
        }

        EditText txt_username = (EditText) findViewById(R.id.register_input_username);
        EditText txt_password = (EditText) findViewById(R.id.register_input_password);

        Button btn_login = (Button) findViewById(R.id.register_btn_register);
        btn_login.setOnClickListener(view -> {
            String username = txt_username.getText().toString();
            String password = txt_password.getText().toString();

            Toast success = Toast.makeText(getApplicationContext(), "Logged In Successfully", Toast.LENGTH_LONG);
            Toast error = Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG);
            if (uDB.userDAO().doesUsernamePasswordMatch(username, password)) {
                Log.d("success", "Logged In Successfully");
                success.show();
                startActivity(new Intent(getApplicationContext(), MainActivity.class).putExtra("user", username));
            } else {
                Log.d("error", "Invalid username or password");
                error.show();
            }
        });

        TextView link_register = (TextView) findViewById(R.id.register_txt_loginlink);
        link_register.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), Register.class));
        });
    }
}