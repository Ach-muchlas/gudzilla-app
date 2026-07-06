package com.sss.gudzillaapps.database

object AppDatabaseManager {
    private var db: AppDatabase? = null

    fun setDatabase(db: AppDatabase) {
        AppDatabaseManager.db = db
    }
}
