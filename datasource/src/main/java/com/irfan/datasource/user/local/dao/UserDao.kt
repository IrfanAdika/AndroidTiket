package com.irfan.datasource.user.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.irfan.datasource.user.local.entity.UserL
import com.irfan.datasource.util.BaseDao

@Dao
abstract class UserDao: BaseDao<UserL> {

    @Query("SELECT * FROM User WHERE id = :userId")
    abstract fun getMovie(userId: String): UserL?
}