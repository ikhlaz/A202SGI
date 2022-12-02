package com.library;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDAO {
    @Insert
    void insertAll(User... users);

    @Query("SELECT * FROM user ")
    List<User> getAllUsers();

    @Query("SELECT EXISTS(SELECT * FROM user WHERE username = :username)")
    boolean doesUsernameExist(String username);

    @Query("SELECT EXISTS(SELECT * FROM user WHERE username = :username AND password = :password)")
    boolean doesUsernamePasswordMatch(String username, String password);
}
