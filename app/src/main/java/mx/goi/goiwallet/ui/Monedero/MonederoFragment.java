package mx.goi.goiwallet.ui.Monedero;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.baoyz.widget.PullRefreshLayout;

import mx.goi.goiwallet.R;

public class MonederoFragment extends Fragment {

    private PullRefreshLayout swipeRefreshLayout1;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_monedero, container, false);

        swipeRefreshLayout1 = (PullRefreshLayout) root.findViewById(R.id.swipeRefreshLayout);


        swipeRefreshLayout1.setOnRefreshListener(() -> {
            swipeRefreshLayout1.setRefreshing(true);

            swipeRefreshLayout1.postDelayed(() -> swipeRefreshLayout1.setRefreshing(false), 3000);
        });




        return root;
    }
}