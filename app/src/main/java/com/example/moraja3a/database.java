package com.example.moraja3a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {
    public database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table student(id INTERGER primary key AUTOINCREMENT,name TEXT,last_name TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //method insert
    public void add(String _name,String _last_name){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv= new ContentValues();
        cv.put("name",_name);
        cv.put("last_name",_last_name);
        db.insert("student",null,cv);
        db.close();
    }
    //get all data
    public ArrayList<String> getProfilesCount() {
        String Query = "SELECT  * FROM student";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(Query, null);
        ArrayList<String> list_student=new ArrayList<String>();
        cursor.moveToNext();
        while (cursor.isAfterLast()==false){
            int id=cursor.getInt(cursor.getColumnIndex("id"));
            String name=cursor.getString(cursor.getColumnIndex("name"));
            String last_name=cursor.getString(cursor.getColumnIndex("last_name"));
            final String s = list_student.add(String.valueOf(id)) + "|" + name + "|" + last_name);
            cursor.moveToNext();
        }
        db.close();
        return list_student;
    }
    public   ArrayList<Hashtable<String,String>> getListStagiaires(){
        ArrayList<Hashtable<String,String>> liste = new ArrayList<Hashtable<String,String>>();
        SQLiteDatabase db = this.getReadableDatabase();
        Hashtable<String,String> ht;
        Cursor cs = db.rawQuery("select * from student",null);
        cs.moveToFirst();
        while (cs.isAfterLast()==false){
            
            String n = cs.getString(1);
            String p = cs.getString(2);

            ht= new Hashtable<String,String>();
            ht.put("nom",n);
            ht.put("prenom",p);
            ht.put("descF",this.getDescById(f));
            liste.add(ht);
            cs.moveToNext();
        }
        return liste;
    }




}
