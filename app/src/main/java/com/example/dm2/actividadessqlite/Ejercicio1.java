package com.example.dm2.actividadessqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Ejercicio1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        TextView txt= (TextView) findViewById(R.id.txtAgenda);

        //Abrimos la BBDD
        AgendaSQLiteHelper ash= new AgendaSQLiteHelper(this,"DBAgenda",null,1);
        SQLiteDatabase db=ash.getReadableDatabase();

        ArrayList<String> agenda=new ArrayList<String>();

        if (db != null) {
            Cursor c= db.rawQuery("SELECT nombre,apellido,numero FROM Agenda",null);
            if(c.moveToFirst()){
                do {
                    String nombre=c.getString(0);
                    int numero=c.getInt(2);
                    txt.append(nombre+"-->"+numero+"\n");
                }while (c.moveToNext());
            }
        }
    }
}
