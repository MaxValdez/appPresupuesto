package com.example.appjuan.db

import android.app.Application
import androidx.room.Room

class CostoApp: Application() {
    //val room = Room.databaseBuilder(this,CostoDb::class.java,"Precios").build()
    companion object{
        private var db:CostoDb?=null
        public fun getDb():CostoDb{
            return db !!
        }
    }
    override fun onCreate() {
        super.onCreate()
        db = CostoDb.getDb(applicationContext)
    }
}