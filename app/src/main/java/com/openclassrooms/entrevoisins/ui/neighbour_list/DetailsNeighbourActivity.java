package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.media.AudioRecord;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.security.PKCS12Attribute;
import java.security.PublicKey;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.openclassrooms.entrevoisins.ui.neighbour_list.MyNeighbourRecyclerViewAdapter.EXTRA_NEIGHBOUR;

public class DetailsNeighbourActivity extends AppCompatActivity {

    private Neighbour mNeighbour;
    public static final String FAVORITE_NEIGHBOUR = "com.example.myFirstApp.FAVORITE_NEIGHBOUR";

    @BindView(R.id.favorite)
    public FloatingActionButton favoriteActButton;
    @BindView(R.id.first_neighbour_name)
    public TextView mFirstNeighbourName;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_neighbour_activity);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            mNeighbour = (Neighbour) bundle.getSerializable(EXTRA_NEIGHBOUR);
            mFirstNeighbourName.setText(mNeighbour.getName());
        }
    }

    @OnClick(R.id.favorite)
    void onFavoriteClick(){ mNeighbour.getFavorite(); }


    private void handleFloatingButtonInit(){
       if(mNeighbour.getFavorite()){
        favoriteActButton.setImageResource(R.drawable.ic_star_white_24dp);}
       else {favoriteActButton.setImageResource(R.drawable.ic_star_border_white_24dp);}
    }
}