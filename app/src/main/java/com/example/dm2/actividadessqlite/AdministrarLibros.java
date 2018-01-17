package com.example.dm2.actividadessqlite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class AdministrarLibros extends AppCompatActivity {

    private EditText cod;
    private EditText tit;
    private EditText aut;
    LibrosSQLiteHelper ldb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrar_libros);

        LibrosSQLiteHelper ldb=new LibrosSQLiteHelper(this,"DBLibros",null,1);

        String sqlCreate="CREATE TABLE Libro(codigo INETEGER PRIMARY KEY, titulo TEXT, autor TEXT)";
        SQLiteDatabase db=ldb.getWritableDatabase();
        db.execSQL(sqlCreate);
        ldb.close();



        cod= (EditText) findViewById(R.id.codigo);
        tit= (EditText) findViewById(R.id.titulo);
        aut= (EditText) findViewById(R.id.autor);

    }

    void insertarLibro(View v){
       // cod.getText().toString();
        //tit.getText().toString();
        //aut.getText().toString();
        LibrosSQLiteHelper ldb=new LibrosSQLiteHelper(this,"DBLibros",null,1);
        SQLiteDatabase db=ldb.getWritableDatabase();
        ldb.insertar(cod.getText().toString(),tit.getText().toString(),aut.getText().toString(), db);
        db.close();
    }

    void borrarLibro(View v){
        LibrosSQLiteHelper ldb=new LibrosSQLiteHelper(this,"DBLibros",null,1);
        ldb.borrar(v,null);
    }

    void modificarLibro(View v){
        LibrosSQLiteHelper ldb=new LibrosSQLiteHelper(this,"DBLibros",null,1);
        ldb.borrar(v,null);

    }

    void muestraLibro(View v){
        TextView txt= (TextView) findViewById(R.id.campoConsulta);

        LibrosSQLiteHelper ldb=new LibrosSQLiteHelper(this,"DBLibros",null,1);
        ArrayList<String>arr=ldb.consultar(v,null);

        for (String str:arr) {
            txt.setText(txt.getText().toString()+str+"\n");
        }
    }
}
