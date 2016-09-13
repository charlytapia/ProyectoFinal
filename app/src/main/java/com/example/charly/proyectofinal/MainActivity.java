package com.example.charly.proyectofinal;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    //Declarando nuestras variables para el calendario

    private int año;
    private int mes;
    private int dia;
    //Declarando los elementos que tenemos

    private EditText ETfecha;
    private Button btnfecha;

    //Creando variable la cual es constante por eso se le agrega un valor al final
    private static final int Tdialogo = 0;
    private static DatePickerDialog.OnDateSetListener selectfecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ETfecha = (EditText)findViewById(R.id.ETfecha);
        btnfecha = (Button) findViewById(R.id.btnfecha);

        //Metodo para obtener la fecha real del dispositivo

        Calendar calendario = Calendar.getInstance();
        año = calendario.get(Calendar.YEAR);
        mes = calendario.get(Calendar.MONTH);
        dia = calendario.get(Calendar.DAY_OF_MONTH);
        mostrarfecha();
        selectfecha = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {

                año = i;
                mes = i1;
                dia = i2;
                mostrarfecha();
            }
        };
    }

    //Metodo de Activity

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id){
            case 0:
                return new DatePickerDialog(this,selectfecha,año,mes,dia);

        }
        return null;
    }

    //Metodo para que el boton seleccione fecha

    public void calendario (View control) {
    showDialog(Tdialogo);
    }


//Creando Metodo para mostar la fecha

public void mostrarfecha () {
ETfecha.setText(año+"-"+mes+"-"+dia);
}
}


