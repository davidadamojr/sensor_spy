package com.unt.sell.sensor_spy.db.schema;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by davidadamojr on 6/26/15.
 */
public class AccTable {

    // Database table - all values are in m/s^2
    public static final String TABLE_NAME = "acceleration";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_X = "x_value";
    public static final String COLUMN_Y = "y_value";
    public static final String COLUMN_Z = "z_value";
    public static final String COLUMN_TIMESTAMP = "timestamp";
    public static final String COLUMN_UPLOADED = "uploaded";

    // Database creation SQL statement
    private static final String DATABASE_CREATE = "create table " + TABLE_NAME + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_X + " text not null, " +
            COLUMN_Y + " text not null, " + COLUMN_Z + " text not null, " + COLUMN_TIMESTAMP +
            " text not null, " + COLUMN_UPLOADED + " integer default 0);";

    public static void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
    }

    public static void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        Log.w(AccTable.class.getName(), "Upgrading database from version " + oldVersion +
            " to " + newVersion + ", which will destroy all old data.");
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(database);
    }
}
