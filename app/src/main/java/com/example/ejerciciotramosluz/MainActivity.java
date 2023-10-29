package com.example.ejerciciotramosluz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    /**
     * Verde: 12:00 - 19:00
     * Amarillo: 9:00 - 12:00 / 18:00 - 20:00
     * Rojo: 20:00 - 9:00
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calendar tAhora = Calendar.getInstance();
        Calendar amarilo1=Calendar.getInstance();
        Calendar verde=Calendar.getInstance();
        Calendar amarillo2=Calendar.getInstance();
        Calendar rojo=Calendar.getInstance();

        System.out.println(tAhora.toString());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String tAhoraString = sdf.format(tAhora.getTime());
        System.out.println(tAhoraString);

        ponerHoraCalendar(amarilo1,9);
        ponerHoraCalendar(verde,12);
        ponerHoraCalendar(amarillo2,18);
        ponerHoraCalendar(rojo,20);

        Calendar[] horasColor = {amarilo1,verde,amarillo2,rojo};

        TextView tHora = findViewById(R.id.mostrarHora);
        tHora.setText(tAhoraString);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        ActualizarHora ah = new ActualizarHora(tHora,tAhora,horasColor);
        ah.start();

    }

    private void ponerHoraCalendar(Calendar calendar, int i) {
        calendar.set(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.MONTH),i,0,0);
    }

}