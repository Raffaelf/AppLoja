package com.example.raffael.apploja.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.raffael.apploja.R;

public class CadastroActivity extends AppCompatActivity {
    public EditText nome;
    public EditText email;
    public EditText senha;
    public Button btnCadastrar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        nome = (EditText) findViewById(R.id.nomeCadastrado);
        email = (EditText) findViewById(R.id.emailCadastro);
        senha = (EditText) findViewById(R.id.senhaCadastro);
        btnCadastrar = (Button) findViewById(R.id.btn_Cadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!emptyValidation()) {
                    Toast.makeText(CadastroActivity.this, "CADASTRADO TIO!", Toast.LENGTH_SHORT).show();
                } else {

                }
            }
        });
    }

    private boolean emptyValidation() { // Verifica se os campos foram preenchidos
        if (TextUtils.isEmpty(email.getText().toString()) || TextUtils.isEmpty(senha.getText().toString()) || TextUtils.isEmpty(nome.getText().toString())) {
            return true;
        }else {
            return false;
        }
    }
}
