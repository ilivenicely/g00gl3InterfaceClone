package com.robertmccormick.mccormickrobert_ce04_google.activities;

//Robert McCormick
//MDV3325-O 01
//McCormickRob_CE04



import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.robertmccormick.mccormickrobert_ce04_google.R;
import com.robertmccormick.mccormickrobert_ce04_google.adapters.AppReviewsAdapter;
import com.robertmccormick.mccormickrobert_ce04_google.models.AppReviewItemModel;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private final Handler handler = new Handler();
    private RecyclerView appScreenshotsRecyclerView;
    private RecyclerView appReviewsRecyclerView;
    private int progressStatus = 0;
    private TextView downloadSize;
    private TextView downloadPercent;
    private ProgressBar downloadProgress;
    private RelativeLayout downloadLayout;
    private LinearLayout openAppLayout;
    private AppCompatButton installButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        Toolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);



        appScreenshotsRecyclerView = findViewById(R.id.rv_app_screenshots);
        RecyclerView.LayoutManager horizontalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        appScreenshotsRecyclerView.setLayoutManager(horizontalLayoutManager);
        appScreenshotsRecyclerView.setHasFixedSize(true);


        appReviewsRecyclerView = findViewById(R.id.rv_app_reviews);
        RecyclerView.LayoutManager verticalLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        appReviewsRecyclerView.setLayoutManager(verticalLayoutManager);
        appReviewsRecyclerView.setHasFixedSize(true);
        loadAppReviewsDataAndSetAdapter();




    }

    private void loadAppReviewsDataAndSetAdapter() {
        ArrayList<AppReviewItemModel> appReviews = new ArrayList<>();
        appReviews.add(new AppReviewItemModel("John Scubadood", "Holy Guacamole this app is hot!! ", 4, "02/04/18", R.drawable.person_1));

        appReviews.add(new AppReviewItemModel("David Purpleshirt", "Did this app just change my life?! No, " +
                "of course not...but it's ok.", 5, "09/04/18", R.drawable.person_2));

        appReviews.add(new AppReviewItemModel("Dora Fishworthy", "You make your grandma so proud!", -5, "09/04/18", R.drawable.person_3));

        appReviews.add(new AppReviewItemModel("Steven Stevens", "I kind've liked it. No really, I did.", 5, "02/04/18", R.drawable.person_4));

        appReviews.add(new AppReviewItemModel("Dora Fishworthy", "An app so nice I commented twice.", -5, "09/04/18", R.drawable.person_3));

        appReviewsRecyclerView.setAdapter(new AppReviewsAdapter(appReviews, this));
    }



}

