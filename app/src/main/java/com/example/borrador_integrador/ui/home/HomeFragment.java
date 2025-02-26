package com.example.borrador_integrador.ui.home;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.borrador_integrador.SignIn;
import com.example.borrador_integrador.daoSQLite.DaoHelperEncuesta;
import com.example.borrador_integrador.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;

        Integer encuestas = contarEncuestas();
        homeViewModel.setTextValue("ENCUESTAS REALIZADAS: " + encuestas + "/10");
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private Integer contarEncuestas() {
        SharedPreferences sp = getActivity().getSharedPreferences(SignIn.SHARED_PREFERENCES_LOGIN_DATA, MODE_PRIVATE);
        String username = sp.getString(SignIn.SHARED_PREFERENCES_USERNAME, "desconocido");
        return DaoHelperEncuesta.obtenerPorEncuestador(username,getActivity()).size();
    }
}