package com.library;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Inventory {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    public String id;

    @ColumnInfo(name = "status")
    public boolean status;

    public Inventory(String id, boolean status) {
        this.id = id;
        this.status = status;
    }
}