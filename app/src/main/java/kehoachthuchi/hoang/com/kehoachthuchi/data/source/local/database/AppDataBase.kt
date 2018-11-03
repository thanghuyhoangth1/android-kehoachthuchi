package kehoachthuchi.hoang.com.kehoachthuchi.data.source.local.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import kehoachthuchi.hoang.com.kehoachthuchi.data.model.Payment

@Database(entities = [Payment::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun paymentDao(): PaymentDao
}