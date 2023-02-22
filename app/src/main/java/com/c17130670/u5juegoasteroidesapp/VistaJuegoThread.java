/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                              Tiempos y animacion del juego
:*
:*  Archivo     : Graficos.java
:*  Autor       : Francisco Jossue Rodriguez Gallegos     17130670
:*  Fecha       : 28/nov/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Este Activity es donde da los sleeping y el tiempo del juego
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fultano de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/

package com.c17130670.u5juegoasteroidesapp;

import android.util.Log;

public class VistaJuegoThread extends Thread{
    private VistaJuegoView vistaJuegoView;
    private int periodoSleep;

    public VistaJuegoThread ( VistaJuegoView vistaJuegoView, int periodo ) {
        super ();
        this.vistaJuegoView = vistaJuegoView;
        periodoSleep = periodo;
    }

    @Override
    public void run () {
        boolean corriendo =  vistaJuegoView.isCorriendo () ;
        while (corriendo) {
            corriendo = vistaJuegoView.isCorriendo ();
            vistaJuegoView.actualizarFisica ();
            try {
                Thread.sleep(periodoSleep);
            } catch ( InterruptedException ex) {
                Log.e ( "Asteroides", ex.toString() );
            }
        }
    }

}
