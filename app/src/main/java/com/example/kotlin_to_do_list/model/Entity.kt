
package com.example.kotlin_to_do_list.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Entity1")
data class Entity(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title:String,
    val detail: String
)

