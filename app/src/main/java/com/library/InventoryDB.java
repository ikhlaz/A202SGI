package com.library;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Inventory.class}, version = 1)
public abstract class InventoryDB extends RoomDatabase {
    public abstract InventoryDAO InventoryDAO();
}
