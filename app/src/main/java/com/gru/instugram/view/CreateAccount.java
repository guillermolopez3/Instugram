package com.gru.instugram.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.gru.instugram.R;

public class CreateAccount extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        //en el parametro llamo un recurso con el nombre del titulo que guardé en values/string
        showToolbar(getResources().getString(R.string.toolbar_tittle_createaccount),true);
    }

    public void showToolbar(String tittle, boolean upButton)
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
