package com.example.ejerciciotramosluz;

import android.graphics.Color;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ActualizarHora extends Thread {
    private TextView tMostrarHora;
    private Calendar tAhora;
    private Calendar[] horasColor;

    public ActualizarHora(TextView tMostrarHora, Calendar tAhora, Calendar[] horasColor) {
        super();
        this.tMostrarHora = tMostrarHora;
        this.tAhora = tAhora;
        this.horasColor = horasColor;
    }

    /**
     * Verde: 12:00 - 18:00
     * Amarillo: 9:00 - 12:00 / 18:00 - 20:00
     * Rojo: 20:00 - 9:00
     */
    @Override
    public void run() {
        try {
            while (true) {
                tAhora = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
                String tAhoraString = sdf.format(tAhora.getTime());
                tMostrarHora.setText(tAhoraString);
                int hora = tAhora.getTime().getHours();
                System.out.println(hora);
                if ((hora <=12)&&(hora>9)){
                    tMostrarHora.setTextColor(Color.YELLOW);
                } else if ((hora <=18) && (hora>12)){
                    tMostrarHora.setTextColor(Color.GREEN);
                } else if ((hora <=20)&&(hora>18)) {
                    tMostrarHora.setTextColor(Color.YELLOW);
                } else if ((hora >20)||(hora<=9)) {
                    tMostrarHora.setTextColor(Color.RED);
                }


                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
