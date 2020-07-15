package com.example.androidjetpacksamples.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class User {
    @PrimaryKey
    @ColumnInfo(name = "user_name")
    var userName: String

    @ColumnInfo(name = "password")
    var password: String

    constructor(userName: String, password: String) {
        this.userName = userName
        this.password = password
    }
}