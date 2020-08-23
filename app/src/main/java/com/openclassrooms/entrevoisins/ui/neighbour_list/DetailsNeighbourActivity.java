package com.openclassrooms.entrevoisins.ui.neighbour_list;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.openclassrooms.entrevoisins.R;
import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;
import com.openclassrooms.entrevoisins.service.NeighbourApiService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.bumptech.glide.Glide.init;
import static com.openclassrooms.entrevoisins.ui.neighbour_list.MyNeighbourRecyclerViewAdapter.EXTRA_NEIGHBOUR;

public class DetailsNeighbourActivity extends AppCompatActivity {

    private NeighbourApiService mApiService;
    private Neighbour mNeighbour;

    @BindView(R.id.floating_action_button)
    public FloatingActionButton favoriteActButton;
    @BindView(R.id.neighbour_avatar)
    public ImageView mAvatar;
    @BindView(R.id.first_neighbour_name)
    public TextView mFirstNeighbourName;
    @BindView(R.id.second_neighbour_name)
    public TextView mSecondNeighbourName;
    @BindView(R.id.localisation)
    public TextView mNeighbourAddress;
    @BindView(R.id.phone_number)
    public TextView mNeighbourPhone;
    @BindView(R.id.website)
    public TextView mNeighbourWebsite;
    @BindView(R.id.description_details)
    public TextView mNeighbourDetails;
    @BindView(R.id.return_arrow)
    public ImageView mReturnBackArrow;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_neighbour_activity);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        initData();
        initView();
        handlefloatingbutton();
        mApiService = DI.getNeighbourApiService();
    }


    public void initData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mNeighbour = (Neighbour) bundle.getSerializable(EXTRA_NEIGHBOUR);
            mFirstNeighbourName.setText(mNeighbour.getName());
        }
    }


    public void initView() {
        Glide.with(this)
                .load(mNeighbour.getAvatarUrl())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(mAvatar);
        mSecondNeighbourName.setText(mNeighbour.getName());
        mNeighbourPhone.setText(mNeighbour.getPhoneNumber());
        mNeighbourDetails.setText(mNeighbour.getAboutMe());
        mNeighbourAddress.setText(mNeighbour.getAddress());
        handlefloatingbutton();
    }


    @OnClick(R.id.floating_action_button)
    public void OnFavoriteClick() {
        mNeighbour.setFavorite(!mNeighbour.getFavorite());
        handlefloatingbutton();
    }


    @OnClick(R.id.return_arrow)
    public void onBackPressed() {
        super.onBackPressed();
        mApiService.updateFavoriteNeighbour(mNeighbour);
    }


    private void handlefloatingbutton() {
        if (mNeighbour.getFavorite()) {
            favoriteActButton.setImageResource((R.drawable.ic_star_white_24dp));
        } else {
            favoriteActButton.setImageResource(R.drawable.ic_star_border_white_24dp);
        }
    }
}