package mx.goi.goiwallet.ui.Perfil;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.baoyz.widget.PullRefreshLayout;

import org.w3c.dom.Text;

import mx.goi.goiwallet.R;
import mx.goi.goiwallet.utilerias.Permisos;

public class PerfilFragment extends Fragment {

    //private HomeViewModel homeViewModel;


    Button btnCancelar;
    TextView txtEdicionImagen;
    final int LLAMADA_CAMARA=1000;
    ImageView fotoPerfil;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_perfil, container, false);
        btnCancelar=root.findViewById(R.id.btnCancelar);

        txtEdicionImagen=root.findViewById(R.id.txtEdicionImagen);
        fotoPerfil=root.findViewById(R.id.fotoPerfil);

        Activity b=this.getActivity();
        Permisos permisosAndroid=new Permisos(b);


        txtEdicionImagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean tengoPermisoCamara=permisosAndroid.checkPermissionForCamera();
                if(!tengoPermisoCamara)
                {
                    permisosAndroid.requestPermissionForCamera();
                }
                else
                {
                    //LLAMADA_CAMARA
                    Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(camera_intent, LLAMADA_CAMARA);
                }



            }
        });


        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmento=getParentFragment();
                NavController navController= NavHostFragment.findNavController(fragmento);
                navController.navigate(R.id.navegacion_monedero);
            }
        });



        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//clicked_image_id.setImageBitmap(photo);

        if(resultCode==Activity.RESULT_OK)
        {
            switch(requestCode)
            {
                case LLAMADA_CAMARA:
                    Bitmap foto_capturada = (Bitmap) data.getExtras().get("data");
                    //fotoPerfil.setImageBitmap(foto_capturada);
                    Drawable d = new BitmapDrawable(getResources(), foto_capturada);
                    fotoPerfil.setBackground(d);
                    break;
                case 1002: break;

            }

        }

    }

}