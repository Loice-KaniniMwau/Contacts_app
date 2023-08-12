package com.loice.twitterclone.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.loice.twitterclone.model.Contacts_Data

@Database(entities = arrayOf(Contacts_Data::class), version = 1)
abstract class ContactsDB: RoomDatabase() {
    abstract fun getContactDao():ContactDao

    companion object{
        private var database:ContactsDB?=null

        fun getDatabase(context: Context):ContactsDB{
            if(database==null){
                database=Room.databaseBuilder(context,ContactsDB::class.java,"ContactsDB")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return database as ContactsDB
        }
    }

}

//create an instance of the room datanbse
//a single instance that can be reused
