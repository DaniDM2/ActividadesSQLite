package com.example.dm2.actividadessqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by dm2 on 10/01/2018.
 */

public class AgendaSQLiteHelper extends SQLiteOpenHelper {
    //Creamos la tabla de la agenda
    String sqlCreate="CREATE TABLE Agenda(numero INETEGER PRIMARY KEY, nombre TEXT, apellido TEXT)";
    String sqlInserts="INSERT INTO Agenda VALUES(666999888,'Jaime','Marichalar'),(666333222,'Ibai','Montes')," +
            "(666555444,'Slodoban','Karlovich'),(666454444,'Edorta','Cierrabares')";

    public AgendaSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Toast.makeText(null, "Estoy en el onCreate", Toast.LENGTH_SHORT).show();
        db.execSQL(sqlCreate);
        db.execSQL(sqlInserts);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
