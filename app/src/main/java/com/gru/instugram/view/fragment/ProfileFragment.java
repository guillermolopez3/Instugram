package com.gru.instugram.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gru.instugram.R;
import com.gru.instugram.adapter.PictureAdapterRecyclerView;
import com.gru.instugram.model.Picture;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        showToolbar("",false,view);
       RecyclerView pictureRecycler =(RecyclerView) view.findViewById(R.id.pictureProfileRecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        pictureRecycler.setLayoutManager(linearLayoutManager);

        PictureAdapterRecyclerView pictureAdapterRecyclerView = new PictureAdapterRecyclerView(buildPicture(),R.layout.cardview_picture,getActivity());
        pictureRecycler.setAdapter(pictureAdapterRecyclerView);
        return view;
    }

    public ArrayList<Picture> buildPicture()
    {
        ArrayList<Picture> pictures = new ArrayList<>();
        pictures.add(new Picture("http://www.novalandtours.com/images/guide/guilin.jpg","Guillermo López","4 días","3 Me Gusta"));
        pictures.add(new Picture("http://lorempixel.com/400/300/city/","Yael Rodriguez","1 día","10 Me Gusta"));
        pictures.add(new Picture("http://lorempixel.com/400/300/city/","Juan Pablo","20 días","1 Me Gusta"));
        return pictures;
    }

    public void showToolbar(String tittle, boolean upButton,View view)
    {
        //uso appcompatacty... xq la actividad que maneja esto tiene soporte y es de este tipo
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle(tittle);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
