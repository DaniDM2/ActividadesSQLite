package com.example.dm2.actividadessqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by dm2 on 15/01/2018.
 */

public class LibrosSQLiteHelper extends SQLiteOpenHelper {
    public LibrosSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlCreate="CREATE TABLE Libro(codigo INETEGER PRIMARY KEY, titulo TEXT, autor TEXT)";
        db.execSQL(sqlCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void insertar(String cod, String tit, String aut, SQLiteDatabase db){

        int codigo=Integer.parseInt(cod);
        String titulo=tit;
        String autor=aut;

        if (codigo==0 || titulo.equals("") || autor.equals("")){
            Toast.makeText(null, "No puede haber campos vacios", Toast.LENGTH_SHORT).show();
        }else{
           // String insert= "INSERT INTO Libro values("+codigo+",'"+tit+"','"+autor+"')";
            String insert= "INSERT INTO Libro values(2,'titulo','autor')";
            db.execSQL(insert);
            Toast.makeText(null, "Tupla insertada", Toast.LENGTH_SHORT).show();
        }

    }

    void actualizar(View v,SQLiteDatabase db){
        EditText cod= (EditText) v.findViewById(R.id.codigo);
        EditText tit= (EditText) v.findViewById(R.id.titulo);
        EditText aut= (EditText)v.findViewById(R.id.autor);

        int codigo=Integer.parseInt(cod.getText().toString());
        String titulo=tit.getText().toString();
        String autor=aut.getText().toString();

        if(codigo==0){
            Toast.makeText(null, "El codigo no puede ser 0 ni estar vacio", Toast.LENGTH_SHORT).show();
        }else {
            String upload="UPDATE Libro SET titulo='"+titulo+"', autor='"+autor+"' WHERE codigo="+codigo;
            db.execSQL(upload);
            Toast.makeText(null, "Tupla actualizada", Toast.LENGTH_SHORT).show();
        }

    }

    void borrar(View v,SQLiteDatabase db){
        EditText cod= (EditText) v.findViewById(R.id.codigo);

        int codigo=Integer.parseInt(cod.getText().toString());;

        if(codigo==0){
            Toast.makeText(null, "El codigo no puede ser 0 ni estar vacio", Toast.LENGTH_SHORT).show();
        }else {
            String upload="DELETE FROM Libro WHERE codigo="+codigo;
            db.execSQL(upload);
            Toast.makeText(null, "Tupla borrada", Toast.LENGTH_SHORT).show();
        }
    }

    ArrayList<String> consultar(View v,SQLiteDatabase db){
        ArrayList<String> arr= new ArrayList<String>();
        Cursor c= db.rawQuery("SELECT codigo,titutlo,autor FROM Libros",null);
        if(c.moveToFirst()){
            do{
                int codigo=c.getInt(0);
                String titulo=c.getString(1);
                String autor=c.getString(2);

                arr.add(codigo+" - "+titulo+" - "+autor);
            }while (c.moveToNext());
        }

        return arr;
    }
}
