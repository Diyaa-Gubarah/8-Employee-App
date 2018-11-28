package com.example.diyaa.employeedetails;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.diyaa.employeedetails.data.EmployeeContract.EmployeeEntry;

/**
 * Created by Diyaa on 3/26/2018.
 */

public class EmployeeCursorAdapter extends CursorAdapter {

    public EmployeeCursorAdapter(Context context, Cursor c) {
        super(context, c, 0);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.employee_list_item, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        // Find individual views that we want to modify in the list item layout
        TextView nameTextView = (TextView) view.findViewById(R.id.employee_list_item_name);
        TextView addressTextView = (TextView) view.findViewById(R.id.employee_list_item_address);
        TextView birthTextView = (TextView) view.findViewById(R.id.employee_list_item_birth_day);
        ImageView employeeImageView = (ImageView) view.findViewById(R.id.employee_list_item_image);

        // Find the columns of pet attributes that we're interested in
        int nameColumnIndex = cursor.getColumnIndex(EmployeeEntry.COLUMN_EMPLOYEE_NAME);
        int addressColumnIndex = cursor.getColumnIndex(EmployeeEntry.COLUMN_EMPLOYEE_ADDRESS);
        int imageColumnIndex = cursor.getColumnIndex(EmployeeEntry.COLUMN_EMPLOYEE_PHOTOS);
        int birthColumnIndex = cursor.getColumnIndex(EmployeeEntry.COLUMN_EMPLOYEE_BIRTH_DAY);


        // Read the employee attributes from the Cursor for the current employee
        String employeeName = cursor.getString(nameColumnIndex);
        String employeeAddress = cursor.getString(addressColumnIndex);
        String employeeImagePath = cursor.getString(imageColumnIndex);
        //String employeeBirthDay = cursor.getString(birthColumnIndex);


        // Update the TextViews with the attributes for the current pet
        nameTextView.setText(employeeName);
        addressTextView.setText(employeeAddress);
        if (employeeImagePath != null) {
            Glide.with(context)
                    .load(employeeImagePath)
                    .placeholder(R.drawable.ic_user)
                    .centerCrop()
                    .override(100, 100).into(employeeImageView);
        } else {
            employeeImageView.setImageResource(R.drawable.ic_user);
        }
        // birthTextView.setText(employeeBirthDay);
    }

}
