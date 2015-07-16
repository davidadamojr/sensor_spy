package com.unt.sell.sensor_spy.db.schema;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by SELL-1 on 3/25/2015.
 */
public class LocationTable {

    // Database table
    public static final String TABLE_NAME = "locations";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_LAT = "latitude";
    public static final String COLUMN_LONG = "longitude";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_UPLOADED = "uploaded";

    // Database creation SQL statement
    private static final String DATABASE_CREATE = "create table " + TABLE_NAME + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_LAT + " text not null, " +
            COLUMN_LONG + " text not null, " + COLUMN_TIMESTAMP + " text not null, " +
            COLUMN_UPLOADED + " integer default 0);";

    public static void onCreate(SQLiteDatabase database){
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion){
        Log.w(LocationTable.class.getName(), "Upgrading database from version " + oldVersion +
                " to " + newVersion + ", which will destroy all old data");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }
}
