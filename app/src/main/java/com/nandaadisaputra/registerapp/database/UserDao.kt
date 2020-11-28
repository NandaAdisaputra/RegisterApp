package com.nandaadisaputra.registerapp.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy.REPLACE
import com.nandaadisaputra.registerapp.model.UserModel

@Dao
interface UserDao {
    @Query("SELECT * from user")
    fun getAllUser(): List<UserModel>

    @Insert(onConflict = REPLACE)
    fun insertUser(user: UserModel)

    @Delete
    fun deleteUser(user: UserModel)

    @Query("UPDATE user SET name=:name,number =:number, gender=:gender, age=:age,age=:date WHERE id=:id")
    fun updateUser(
        name: String,
        number: String,
        gender: String,
        age: String,
        date: String,
        id: Long
    )
}