package com.example.appjuan.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Costo::class,HorasTrabajoRoom::class,Extras::class], version = 1)
abstract class CostoDb : RoomDatabase(){
    abstract fun costoDao():CostoDao

    companion object{
        private var db: CostoDb?=null
        fun getDb(context:Context):CostoDb{
            if (db==null){
                db = Room.databaseBuilder(context,CostoDb::class.java,"Precios").build()
            }
            return db!!
        }
        }
    }
