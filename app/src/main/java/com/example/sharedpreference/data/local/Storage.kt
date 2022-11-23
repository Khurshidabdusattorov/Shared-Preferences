package com.example.sharedpreference.data.local

import android.content.Context
import android.content.SharedPreferences

class Storage {
    companion object{
        private lateinit var shared: SharedPreferences
        private var instance: Storage? = null

        fun getInctance(context: Context): Storage{
            if (instance == null){
                shared = context.getSharedPreferences("Storage", Context.MODE_PRIVATE)
                instance = Storage()
            }
            return instance!!
        }
    }

    fun save(info: String){
        shared.edit().putString("info", info).apply()
    }

    fun get(): String{
        return shared.getString("info", "")!!
    }
}