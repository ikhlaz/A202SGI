package com.library;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface InventoryDAO {
    @Insert
    void insertAll(Inventory... inventories);

    @Query("SELECT * FROM inventory ")
    List<Inventory> getAllInventories();

    @Query("SELECT EXISTS(SELECT * FROM inventory WHERE id = :id)")
    boolean doesIdExist(String id);

    @Query("UPDATE inventory SET status = 0 WHERE id = :id")
    void setStatusFalse(String id);

    @Query("UPDATE inventory SET status = 1 WHERE id = :id")
    void setStatusTrue(String id);
}
