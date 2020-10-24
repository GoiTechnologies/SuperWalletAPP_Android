package mx.goi.goiwallet.ui.Sesion;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

import mx.goi.goiwallet.Principal;
import mx.goi.goiwallet.R;

class Conexion {
    public static class Splash extends AppCompatActivity {

        Context contexto;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.actividad_splash);
            contexto=this;

            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run()
                {
                    SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(contexto);
                    String usuario = prefs.getString("idusuario", null);
                    Intent i;
                    if(usuario==null)
                        i = new Intent(getBaseContext(), InicioSesion.class);
                  else
                        i = new Intent(getBaseContext(), Principal.class);

                  startActivity(i);

                }
            },3000);


        }
    }
}
