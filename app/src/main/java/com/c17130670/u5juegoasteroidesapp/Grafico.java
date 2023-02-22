/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                              Elementos graficos
:*
:*  Archivo     : Graficos.java
:*  Autor       : Francisco Jossue Rodriguez Gallegos     17130670
:*  Fecha       : 28/nov/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Este Activity es donde de pone la logica del juego graficamente asi como
                  las posiciones de las imagenes
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fultano de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/



package com.c17130670.u5juegoasteroidesapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Toast;


/**
 * Created by LGV on 25/07/2015.
 */
public class Grafico {
    private Drawable     drawable;
    private double       posX,
                         posY;
    private double       incX,
                         incY;
    private int          angulo,
                         rotacion;
    private int          ancho,
                         alto;
    private int          radioColision;
    private View         view;
    public static final int MAX_VELOCIDAD = 20;


    public Grafico ( View view, Drawable drawable ) {
        this.view = view;
        this.drawable = drawable;

        ancho = drawable.getIntrinsicWidth();
        alto  = drawable.getIntrinsicHeight();
        radioColision = ( alto + ancho ) / 4;
    }


    public void dibujarGrafico ( Canvas canvas ) {
        canvas.save ();
        int x = (int) ( posX + ancho / 2 );
        int y = (int) ( posY + alto  / 2 );
        canvas.rotate ( (float) angulo, (float) x, (float) y  );
        drawable.setBounds ( (int) posX, (int) posY, (int) posX + ancho, (int) posY + alto );
        drawable.draw ( canvas );
        canvas.restore();
        int rInval = (int) distanciaE ( 0, 0, ancho, alto ) / 2 + MAX_VELOCIDAD;
        view.invalidate ( x - rInval, y - rInval, x + rInval, y + rInval );
    }

    public static int getMaxVelocidad() {
        return MAX_VELOCIDAD;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void incrementaPos () {
        posX += incX;
        if ( posX < -ancho / 2 )
            posX = view.getWidth() - ancho / 2;
        if ( posX > view.getWidth() - ancho / 2 )
            posX = -ancho / 2;

        posY += incY;
        if ( posY < -alto / 2 )
            posY = view.getHeight() - alto / 2;
        if ( posY > view.getHeight() - alto / 2 )
            posY = -alto / 2;

        angulo += rotacion;
    }

    public double distancia ( Grafico g ) {
        return distanciaE ( posX, posY, g.posX, g.posY );
    }

    public boolean verificaColision ( Grafico g ) {
        return ( distancia ( g ) < ( radioColision + g.radioColision )  );
    }

    public static double distanciaE ( double x, double y, double x2, double y2 ) {
        return Math.sqrt((x - x2) * (x - x2) + (y - y2) * (y - y2));
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getRadioColision() {
        return radioColision;
    }

    public void setRadioColision(int radioColision) {
        this.radioColision = radioColision;
    }

    public double getIncX() {
        return incX;
    }

    public void setIncX(double incX) {
        this.incX = incX;
    }

    public int getAngulo() {
        return angulo;
    }

    public void setAngulo(int angulo) {
        this.angulo = angulo;
    }

    public int getRotacion() {
        return rotacion;
    }

    public void setRotacion(int rotacion) {
        this.rotacion = rotacion;
    }

    public double getIncY() {
        return incY;
    }

    public void setIncY(double incY) {
        this.incY = incY;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }


}
