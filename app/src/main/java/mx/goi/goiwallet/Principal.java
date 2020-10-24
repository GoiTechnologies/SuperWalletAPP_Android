package mx.goi.goiwallet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import mx.goi.goiwallet.ui.Sesion.InicioSesion;

public class Principal extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    Context contexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        contexto=this;
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        fab.setVisibility(View.GONE);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.vista_navegacion);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navegacion_perfil, R.id.navegacion_monedero, R.id.navegacion_cuentas)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        View vistaDatosUsuario=navigationView.getHeaderView(0);
        //idUsuario  nombreCompleto idCuenta
        TextView vista1 =  vistaDatosUsuario.findViewById(R.id.idUsuario);
        TextView vista2 =  vistaDatosUsuario.findViewById(R.id.nombreCompleto);
        TextView vista3 =  vistaDatosUsuario.findViewById(R.id.idCuenta);
        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(this);
        String usuario = prefs.getString("idusuario", null);
        String nombres = prefs.getString("nombres", null);
        String correo = prefs.getString("correo", null);
        if(usuario!=null&&nombres!=null) {
            vista1.setText(usuario);
            vista2.setText(nombres);
            vista3.setText(correo);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ajustes, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(false);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //accion_ajustes  accion_salir
        switch (item.getItemId()) {
            case R.id.accion_ajustes:
                /*
                Intent intentoGenerico=new Intent(getApplicationContext(), SincronizarCatalogo.class);
                startActivityForResult(intentoGenerico,SINCRONIZAR);
                */

                return true;

            case R.id.accion_salir:

                salirAplicacion();

                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    private void salirAplicacion()
    {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Salida de GoiWallet")
                .setMessage("¿Seguro que desea salir ?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Eliminar los datos de SharedPreferences
                        SharedPreferences prefs= PreferenceManager.getDefaultSharedPreferences(contexto);
                        SharedPreferences.Editor nuevasPreferencias=prefs.edit();
                        nuevasPreferencias.clear();
                        nuevasPreferencias.apply();
                        //Navegar a Inicio de Sesion...
                        Intent intentoSesion = new Intent(contexto, InicioSesion.class);
                        intentoSesion.addFlags( Intent.FLAG_ACTIVITY_NEW_TASK );
                        contexto.startActivity(intentoSesion);
                    }

                })
                .setNegativeButton("No", null)
                .show();

    }



}