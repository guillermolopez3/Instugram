package com.gru.instugram.adapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gru.instugram.R;
import com.gru.instugram.model.Picture;
import com.gru.instugram.view.PictureDetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by guill on 27/03/2017.
 */

public class PictureAdapterRecyclerView extends RecyclerView.Adapter<PictureAdapterRecyclerView.PictureViewHolder>
{

    private ArrayList<Picture> pictures;
    private int resource; //mi layout carview picture.xml
    private Activity activity;

    public PictureAdapterRecyclerView(ArrayList<Picture> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public PictureViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource,parent,false);

        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PictureViewHolder holder, int position) {
        Picture picture = pictures.get(position);
        holder.usernameCard.setText(picture.getUserName());
        holder.timeCard.setText(picture.getTime());
        holder.likeNumberCard.setText(picture.getLike_number());
        Picasso.with(activity).load(picture.getPicture()).into(holder.pictureCard);

        holder.pictureCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(activity, PictureDetailActivity.class);

                //Para aplicar el efecto de transicion (Explode) primero debo ver que la version sea mayor o igual a lollipop
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
                {
                    Explode explode = new Explode(); //creo un objeto de la transicion
                    explode.setDuration(1000); //le doy la duracion
                    activity.getWindow().setExitTransition(explode); //le digo que al salir de la actividad use la transicion

                    //le paso por parametro el nombre de la propiedad del XML transitionName declarada en el la img del layout
                    activity.startActivity(i, ActivityOptionsCompat.makeSceneTransitionAnimation(activity,v,activity.getString(R.string.transitionNameCard_picture)).toBundle());
                }
                else
                {
                    activity.startActivity(i);
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView pictureCard;
        private TextView usernameCard;
        private TextView timeCard;
        private TextView likeNumberCard;
        public PictureViewHolder(View itemView) {
            super(itemView);

            pictureCard     = (ImageView)itemView.findViewById(R.id.pictureCard);
            usernameCard    = (TextView)itemView.findViewById(R.id.username_card);
            timeCard        = (TextView)itemView.findViewById(R.id.timeCard);
            likeNumberCard  = (TextView)itemView.findViewById(R.id.likeNumberCrads);
        }
    }
}
