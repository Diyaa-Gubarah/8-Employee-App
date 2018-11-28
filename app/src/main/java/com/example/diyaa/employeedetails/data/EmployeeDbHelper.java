package com.example.diyaa.employeedetails.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.diyaa.employeedetails.data.EmployeeContract.EmployeeEntry;

/**
 * Created by Diyaa on 3/26/2018.
 */

public class EmployeeDbHelper extends SQLiteOpenHelper {

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "employees_details.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    public EmployeeDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_EMPLOYEE_TABLE = "CREATE TABLE " + EmployeeEntry.TABLE_NAME + " ("
                + EmployeeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + EmployeeEntry.COLUMN_EMPLOYEE_NAME + " TEXT NOT NULL, "
                + EmployeeEntry.COLUMN_EMPLOYEE_ADDRESS + " TEXT, "
                + EmployeeEntry.COLUMN_EMPLOYEE_BIRTH_DAY + " TEXT, "
                + EmployeeEntry.COLUMN_EMPLOYEE_NUMBER + " INTEGER DEFAULT 0, "
                + EmployeeEntry.COLUMN_EMPLOYEE_PHOTOS + " TEXT);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_EMPLOYEE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
