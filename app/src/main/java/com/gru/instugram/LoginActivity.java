package com.gru.instugram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gru.instugram.view.ContainerActivity;
import com.gru.instugram.view.CreateAccount;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void irACrearCuenta(View view)
    {
        Intent intent = new Intent(this, CreateAccount.class);
        startActivity(intent);
    }

    public void irListado(View view)
    {
        Intent intent = new Intent(this, ContainerActivity.class);
        startActivity(intent);
    }
}
