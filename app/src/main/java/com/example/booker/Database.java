package com.example.booker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "freelancers";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_FREELANCER = "freelancer";
    private static final String USERNAME = "username";
    private static final String NAME = "name";
    private static final String LOCATION = "location";
    private static final String DESCRIPTION = "description";
    private static final String SKILL = "skill";
    private static final String PHONE = "phone";
    private static final String AGE = "age";
    private static final String RATE = "rate";



    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_FREELANCER_TABLE = "CREATE TABLE " + TABLE_FREELANCER + "("
                + USERNAME + " TEXT PRIMARY KEY ," + NAME + " TEXT,"
                + SKILL + " TEXT," + LOCATION + " TEXT," + AGE + " INTEGER," + PHONE + " INTEGER," +  DESCRIPTION + " TEXT," + RATE + " NUMBER"+ ")";
        db.execSQL(CREATE_FREELANCER_TABLE);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FREELANCER);

        // Create tables again
        onCreate(db);
    }

    void addFreelancer(Freelancer freelancer) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USERNAME, freelancer.getUsername());
        values.put(NAME, freelancer.getName());
        values.put(SKILL, freelancer.getSkills());
        values.put(LOCATION, freelancer.getLocation());
        values.put(AGE, freelancer.getAge());
        values.put(PHONE, freelancer.getPhoneNo());
        values.put(DESCRIPTION, freelancer.getDescription());
        values.put(RATE, freelancer.getRate());


        // Inserting Row
        db.insert(TABLE_FREELANCER, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }

    public List<Freelancer> getallFreelancers() {
        List<Freelancer> freelancerList = new ArrayList<Freelancer>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_FREELANCER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Freelancer freelancer = new Freelancer();
                freelancer.setUsername(cursor.getString(0));
                freelancer.setName(cursor.getString(1));
                freelancer.setSkills(cursor.getString(2));
                freelancer.setLocation(cursor.getString(3));
                freelancer.setAge(Integer.parseInt(cursor.getString(4)));
                freelancer.setPhoneNo(Integer.parseInt(cursor.getString(5)));
                freelancer.setDescription(cursor.getString(6));
                freelancer.setRate(Integer.parseInt(cursor.getString(7)));

                // Adding contact to list
                freelancerList.add(freelancer);
            } while (cursor.moveToNext());
        }

        // return contact list
        return freelancerList;
    }
    public ArrayList<Freelancer> readFreelancers() {
        // on below line we are creating a
        // database for reading our database.
        SQLiteDatabase db = this.getReadableDatabase();

        // on below line we are creating a cursor with query to read data from database.
        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + TABLE_FREELANCER, null);

        // on below line we are creating a new array list.
        ArrayList<Freelancer> courseModalArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new Freelancer(cursorCourses.getString(0),
                        cursorCourses.getString(1),
                        cursorCourses.getString(2),
                        cursorCourses.getString(3),
                        cursorCourses.getInt(4),
                        cursorCourses.getInt(5),
                        cursorCourses.getString(6),
                        cursorCourses.getInt(7)));
            } while (cursorCourses.moveToNext());
            // moving our cursor to next.
        }
        // at last closing our cursor
        // and returning our array list.
        cursorCourses.close();
        return courseModalArrayList;
    }
    public void deleteFreelancer(Freelancer freelancer) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FREELANCER, USERNAME + " = ?",
                new String[] { String.valueOf(freelancer.getUsername())});
        db.close();
    }
}


