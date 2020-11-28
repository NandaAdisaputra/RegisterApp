package com.nandaadisaputra.registerapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nandaadisaputra.registerapp.model.UserModel

@Database(entities = [UserModel::class], version = 1)
abstract class UserDatabase : RoomDatabase(){

    abstract fun userDao() : UserDao

    companion object{
        private var INSTANCE : UserDatabase? = null

        fun getInstance(context: Context) : UserDatabase?{
            if (INSTANCE == null){
                synchronized(UserDatabase::class){
                    INSTANCE = Room.databaseBuilder(context, UserDatabase::class.java, "User.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }
    }
}