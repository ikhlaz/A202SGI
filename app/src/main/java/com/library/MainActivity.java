package com.library;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String username = extras.getString("user");
            TextView user = (TextView) findViewById(R.id.username);
            user.setText(username);
        }

        InventoryDB iDB = Room.databaseBuilder(getApplicationContext(), InventoryDB.class, "inventory-database").allowMainThreadQueries().build();
        List<Inventory> inventoryList = iDB.InventoryDAO().getAllInventories();

        TextView A01_txt = (TextView) findViewById(R.id.a01_txt);
        TextView A02_txt = (TextView) findViewById(R.id.a02_txt);
        TextView A03_txt = (TextView) findViewById(R.id.a03_txt);
        TextView A04_txt = (TextView) findViewById(R.id.a04_txt);
        TextView A05_txt = (TextView) findViewById(R.id.a05_txt);
        A01_txt.setText(inventoryList.get(0).id);
        A02_txt.setText(inventoryList.get(1).id);
        A03_txt.setText(inventoryList.get(2).id);
        A04_txt.setText(inventoryList.get(3).id);
        A05_txt.setText(inventoryList.get(4).id);

        Button A01_btn = (Button) findViewById(R.id.a01_btn);
        Button A02_btn = (Button) findViewById(R.id.a02_btn);
        Button A03_btn = (Button) findViewById(R.id.a03_btn);
        Button A04_btn = (Button) findViewById(R.id.a04_btn);
        Button A05_btn = (Button) findViewById(R.id.a05_btn);

        if (!inventoryList.get(0).status) {
            A01_btn.setEnabled(false);
        } else {
            A01_btn.setEnabled(true);
        }
        if (!inventoryList.get(1).status) {
            A02_btn.setEnabled(false);
        } else {
            A02_btn.setEnabled(true);
        }if (!inventoryList.get(2).status) {
            A03_btn.setEnabled(false);
        } else {
            A03_btn.setEnabled(true);
        }
        if (!inventoryList.get(3).status) {
            A04_btn.setEnabled(false);
        } else {
            A04_btn.setEnabled(true);
        }
        if (!inventoryList.get(4).status) {
            A05_btn.setEnabled(false);
        } else {
            A05_btn.setEnabled(true);
        }

        A01_btn.setOnClickListener(view -> {
            A01_btn.setEnabled(false);
            iDB.InventoryDAO().setStatusFalse("A01");
        });
        A02_btn.setOnClickListener(view -> {
            A02_btn.setEnabled(false);
            iDB.InventoryDAO().setStatusFalse("A02");
        });
        A03_btn.setOnClickListener(view -> {
            A03_btn.setEnabled(false);
            iDB.InventoryDAO().setStatusFalse("A03");
        });
        A04_btn.setOnClickListener(view -> {
            A04_btn.setEnabled(false);
            iDB.InventoryDAO().setStatusFalse("A04");
        });
        A05_btn.setOnClickListener(view -> {
            A05_btn.setEnabled(false);
            iDB.InventoryDAO().setStatusFalse("A05");
        });
    }
}