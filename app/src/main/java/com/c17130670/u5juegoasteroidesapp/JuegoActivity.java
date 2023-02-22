/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                                CAMPUS LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: AGO-DIC/2022    HORA: 08-09 HRS
:*
:*                              Audio y Fondos
:*
:*  Archivo     : Graficos.java
:*  Autor       : Francisco Jossue Rodriguez Gallegos     17130670
:*  Fecha       : 28/nov/2022
:*  Compilador  : Android Studio Artic Fox 2020.3
:*  Descripción : Este Activity es donde se controla los recursos del audio y fondos
:*  Ultima modif:
:*  Fecha       Modificó             Motivo
:*==========================================================================================
:*  dd/mmm/aaaa Fultano de tal       Motivo de la modificacion, puede ser en mas de 1 renglon.
:*------------------------------------------------------------------------------------------*/


package com.c17130670.u5juegoasteroidesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;

public class JuegoActivity extends AppCompatActivity {
    private VistaJuegoView vistaJuegoView;
    private MediaPlayer mplayAudioFondo;
    private MediaPlayer mplayAudioDisparo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juego_layout);

        this.setVolumeControlStream (AudioManager.STREAM_MUSIC );

        vistaJuegoView = findViewById(R.id.vistaJuegoView);

        mplayAudioFondo     = MediaPlayer.create ( this, R.raw.audio_fondo );
        mplayAudioFondo.setLooping( true );

        mplayAudioDisparo   = MediaPlayer.create ( this, R.raw.audio_disparo );
        vistaJuegoView.setplayAudioDisparo (mplayAudioDisparo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mplayAudioFondo != null )
            mplayAudioFondo.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mplayAudioFondo != null )
            mplayAudioFondo.pause();
    }

    @Override
    protected void onDestroy() {
        if (mplayAudioFondo != null )
            mplayAudioFondo.stop();
        if (mplayAudioDisparo != null )
            mplayAudioDisparo.stop();


        vistaJuegoView.setCorriendo ( false );
        VistaJuegoThread hilo = vistaJuegoView.getVistaJuegoThread ();
        try {
            hilo.join();
        } catch ( InterruptedException ex ) {
            Log.e ( "Asteroides", ex.toString());
        }
        super.onDestroy();

    }
}