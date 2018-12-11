package com.example.raffael.apploja.subclasses;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.raffael.apploja.R;

public class Carrinho extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Chama a content referente a classe
        return inflater.inflate(R.layout.content_carrinho, container, false);
    }

}
