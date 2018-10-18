package com.example.bgautier.myfirstapp;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    TextView txtResultado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResultado = findViewById(R.id.txt_resultado);
    }

    public void escribirArchivo(View view) {
        try {
            FileOutputStream fout = openFileOutput("prueba_int.text", Context.MODE_PRIVATE);
            String texto = " TExto prueba de mem interna";
            fout.write(texto.getBytes());
            fout.close();
            txtResultado.setText("Archivo Creado!");
        } catch (Exception e) {
            Log.e("HolaArchivos", "Error al escribir archivo en memoria interna");
            txtResultado.setText("Error al escribir arcvhio en mem interna");
        }
    }

    public void leerArchivo(View view)
    {
        try {
            BufferedReader fin = new BufferedReader(
                    new InputStreamReader(openFileInput("prueba_int.txt"))
            );
            String texto = fin.readLine();
            fin.close();
            txtResultado.setText(texto);
        } catch (Exception e){
            Log.e("HolaArchivos", "error al leer desde memoria interna");
            txtResultado.setText("error al leer el archivo de memoria interna");
        }
    }

    public void escribirSD(View view) {
        boolean sdDisponible = false;
        boolean sdAccesoEscritura = false;
        String estado = Environment.getExternalStorageState();

        if(estado.equals(Environment.MEDIA_MOUNTED))
        {
            sdDisponible = true;
            sdAccesoEscritura = true;
        } else if (estado.equals(Environment.MEDIA_MOUNTED_READ_ONLY)){
            sdDisponible = true;
            sdAccesoEscritura = false;
        } else {
            sdDisponible = false;
            sdAccesoEscritura = false;
        }

        if( sdDisponible && sdAccesoEscritura){
            try{
                File ruta_sd = Environment.getExternalStorageDirectory();
                File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");

                OutputStreamWriter fout = new OutputStreamWriter(new FileOutputStream(f));
                fout.write("Texto para memoria SD");
                fout.close();
                txtResultado.setText("Arhivo en SD Creado!");
            } catch (Exception e){
                Log.e("HolaArchivos", "error al escribir desde memoria SD");
                txtResultado.setText("error al escribir el archivo de memoria SD");
            }
        }
    }

    public void leerSD(View view) {
        try{
            File ruta_sd = Environment.getExternalStorageDirectory();
            File f = new File(ruta_sd.getAbsolutePath(), "prueba_sd.txt");
            BufferedReader fin = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
            String texto = fin.readLine();
            fin.close();
            txtResultado.setText(texto);
        } catch (Exception e)
        {
            Log.e("HolaArchivos", "error al leer desde memoria SD");
            txtResultado.setText("error al leer el archivo de memoria SD");

        }
    }

    public void leerRaw(View view) {
    }
}