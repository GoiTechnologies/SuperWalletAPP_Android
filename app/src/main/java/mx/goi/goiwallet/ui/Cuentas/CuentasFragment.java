package mx.goi.goiwallet.ui.Cuentas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import mx.goi.goiwallet.R;

public class CuentasFragment extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_cuentas, container, false);
        Toast.makeText(getContext(),"CuentasFragment",Toast.LENGTH_SHORT).show();
        final TextView textView = root.findViewById(R.id.text_cuentas);
        textView.setText("Cuentas 3");
        return root;
    }
}