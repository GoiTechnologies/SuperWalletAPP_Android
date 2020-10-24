package mx.goi.goiwallet.ui.Sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import mx.goi.goiwallet.Principal;
import mx.goi.goiwallet.R;

public class InicioSesion extends AppCompatActivity {

    Button b;
    Context c;
    TextView tvUsuario;
    TextView tvContrasena;
    ProgressBar barraProgreso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_inicio_sesion);
        c=this;
        b=findViewById(R.id.btnInicioSesion);
        tvUsuario=findViewById(R.id.txtUsuario);
        tvContrasena=findViewById(R.id.txtContrasena);
        barraProgreso=findViewById(R.id.barraProgreso1);
        barraProgreso.setVisibility(View.GONE);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ocultarTeclado(c,tvUsuario);
                ocultarTeclado(c,tvContrasena);

                if(esValidaDatosIngreso())
                {
                    barraProgreso.setVisibility(View.VISIBLE);
                    Toast.makeText(c,"Validando credenciales...",Toast.LENGTH_SHORT).show();
                    new Handler().postDelayed(new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(c);
                            SharedPreferences.Editor editor=prefs.edit();
                            editor.putString("idusuario",tvUsuario.getText().toString());
                            editor.putString("nombres","Nombre completo del cliente");
                            editor.putString("correo","it@goi.mx");
                            editor.apply();
                            barraProgreso.setVisibility(View.GONE);
                            Intent i=new Intent(c, Principal.class);
                            startActivity(i);
                        }
                    },4000);


                }
                else
                {
                    Toast.makeText(c,"Ingrese credenciales.",Toast.LENGTH_LONG).show();
                }


         }
        });

    }

    private boolean esValidaDatosIngreso()
    {
        String valor1=tvUsuario.getText().toString();
        String valor2=tvContrasena.getText().toString();
        boolean b1=!valor1.isEmpty();
        boolean b2=!valor2.isEmpty();
        return b1&b2;
    }

    public static void ocultarTeclado(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if(view!=null)
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }



}