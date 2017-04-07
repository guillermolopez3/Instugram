package com.gru.instugram.view;

import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;


import com.gru.instugram.R;

public class PictureDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture_detail);
        showToolbar("",true);
        //este metodo lo declaro para recibir la transicion, desde la activity que se cerro y llamó a ésta
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
        {
            getWindow().setEnterTransition(new Fade());
        }
    }

    public void showToolbar(String tittle, boolean upButton)
    {
        //uso appcompatacty... xq la actividad que maneja esto tiene soporte y es de este tipo
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
    }
}
