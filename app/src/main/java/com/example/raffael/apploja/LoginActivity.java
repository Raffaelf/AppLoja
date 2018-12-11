package com.example.raffael.apploja;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btnSignIn;
    private Button btnSignUp;
    private EditText txtEmail;
    private EditText txtSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnSignIn = findViewById(R.id.btnSignIn); //Botão de login
        btnSignUp = findViewById(R.id.btnSignUp); //Botão de cadastro

        txtEmail = findViewById(R.id.emailinput); //Campo de email
        txtSenha = findViewById(R.id.senhainput); //Campo de senha

        //Esse método é executado toda vez que eu apertar em "Cadastrar"
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emptyValidation()) {

                }else{
                    Toast.makeText(LoginActivity.this, "Campo Vazio!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Esse método é executado toda vez que eu apertar em "Entrar"
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!emptyValidation()) { // Verificação pra ver se os campos foram preenchidos
                    Bundle mBundle = new Bundle();
                    mBundle.putString("user", "admin@loja.com.br"); // Passa o email digitado pelo usuário para a MainActivity(Ele é exibido no cabeçalho)
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    intent.putExtras(mBundle);
                    startActivity(intent); // Abre a MainActivity
                    Toast.makeText(LoginActivity.this, "Bem vindo(a) " + "admin@loja.com.br", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Campo Vazio!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private boolean emptyValidation() { // Verifica se os campos foram preenchidos
        if (TextUtils.isEmpty(txtEmail.getText().toString()) || TextUtils.isEmpty(txtSenha.getText().toString())) {
            return true;
        }else {
            return false;
        }
    }

}
