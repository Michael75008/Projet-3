package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.media.AudioRecord;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;

import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.security.PKCS12Attribute;
import java.security.PublicKey;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.openclassrooms.entrevoisins.ui.neighbour_list.MyNeighbourRecyclerViewAdapter.EXTRA_NEIGHBOUR;

public class DetailsNeighbourActivity extends AppCompatActivity {

    private Neighbour mNeighbour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_neighbour_activity);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
          mNeighbour= (Neighbour) bundle.getSerializable(EXTRA_NEIGHBOUR);
            TextView textView = findViewById(R.id.first_neighbour_name);
            textView.setText(mNeighbour.getName());
        }
    }

}