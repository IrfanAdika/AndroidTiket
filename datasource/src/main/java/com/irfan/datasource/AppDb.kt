package com.irfan.datasource

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.irfan.datasource.user.local.dao.UserDao
import com.irfan.datasource.user.local.entity.UserL
import com.irfan.datasource.util.converter.DateTypeConverter

@Database(
    entities = [UserL::class],
    version = 4,
    exportSchema = false
)
@TypeConverters(DateTypeConverter::class)
abstract class AppDb : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "AppDatabase"

        private var sInstance: AppDb? = null

        @JvmStatic
        fun getDatabase(context: Context): AppDb {
            if (sInstance == null) {
                synchronized(this) {
                    if (sInstance == null)
                        sInstance = buildDatabase(context, AppDb::class.java, DATABASE_NAME).build()
                }
            }

            return sInstance as AppDb
        }

        private fun <T : RoomDatabase> buildDatabase(
            context: Context,
            dbClass: Class<T>,
            databaseName: String,
            inMemory: Boolean = false

        ): Builder<T> {

            // In Memory
            return if (inMemory) Room.inMemoryDatabaseBuilder(context, dbClass)

            // Persistent
            else Room.databaseBuilder(context, dbClass, databaseName)
        }
    }

    // Movie
    abstract fun UserDao(): UserDao

}
