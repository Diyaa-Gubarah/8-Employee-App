package com.example.diyaa.employeedetails.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by Diyaa on 3/26/2018.
 */

public final class EmployeeContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private EmployeeContract() {
    }

    /**
     * The "Content authority" is a name for the entire content provider, similar to the
     * relationship between a domain name and its website.  A convenient string to use for the
     * content authority is the package name for the app, which is guaranteed to be unique on the
     * device.
     */
    public static final String CONTENT_AUTHORITY = "com.example.diyaa.employeedetails";

    /**
     * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
     * the content provider.
     */
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);

    /**
     * Possible path (appended to base content URI for possible URI's).
     */
    public static final String PATH_EMPLOYEES_TABLE = "employees";

    /**
     * Inner class that defines constant values for the pets database table.
     * Each entry in the table represents a single Employee.
     */
    public static final class EmployeeEntry implements BaseColumns {

        /**
         * The content URI to access the employees data in the provider
         */
        public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_EMPLOYEES_TABLE);

        /**
         * The MIME type of the {@link #CONTENT_URI} for a list of employees.
         */
        public static final String CONTENT_LIST_TYPE =
                ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_EMPLOYEES_TABLE;

        /**
         * The MIME type of the {@link #CONTENT_URI} for a single employee.
         */
        public static final String CONTENT_ITEM_TYPE =
                ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_EMPLOYEES_TABLE;

        /**
         * Name of database table for employees
         */
        public final static String TABLE_NAME = "employees";

        /**
         * Unique ID number for the Employee (only for use in the database table).
         * <p>
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the Employee.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_EMPLOYEE_NAME = "employee_name";

        /**
         * Address of the Employee.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_EMPLOYEE_ADDRESS = "employee_address";

        /**
         * BirthDay of the Employee.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_EMPLOYEE_BIRTH_DAY = "employee_birth";

        /**
         * Number of the Employee.
         * <p>
         * Type: INTEGER
         */
        public final static String COLUMN_EMPLOYEE_NUMBER = "employee_number";

        /**
         * Photos Path of the Employee.
         * <p>
         * Type: TEXT
         */
        public final static String COLUMN_EMPLOYEE_PHOTOS = "employee_photo";

    }


}
