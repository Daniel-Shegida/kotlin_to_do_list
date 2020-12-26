
package com.example.kotlin_to_do_list.dataDb


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kotlin_to_do_list.model.Entity

@Database(entities = [Entity::class], version = 1, exportSchema = false)
abstract class AbstactDatabase: RoomDatabase(){


    abstract fun getTodoDao(): DAO

    companion object {
        @Volatile
        private var INSTANCE: AbstactDatabase? = null

        fun getDatabase(context: Context): AbstactDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AbstactDatabase::class.java,
                    "todo_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
