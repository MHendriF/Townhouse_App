package com.dicoding.townhouseapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.townhouseapp.helper.MoneyFormatting;
import com.dicoding.townhouseapp.model.House;

public class DetailHouseActivity extends AppCompatActivity implements View.OnClickListener{

    private String title = "Detail House";

    ImageView imgPhoto;
    TextView tvName, tvSize, tvDescription;
    TextView tvPrice;
    Button btnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_house);
        setActionBarTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        House houseTrim = getIntent().getParcelableExtra("HOUSE");
        imgPhoto = findViewById(R.id.iv_detail_photo);
        tvName = findViewById(R.id.tv_detail_name);
        tvSize = findViewById(R.id.tv_detail_size);
        tvDescription = findViewById(R.id.tv_detail_description);
        tvPrice = findViewById(R.id.tv_detail_price);
        btnCall = findViewById(R.id.btn_call);

        tvName.setText(houseTrim.getName());
        tvSize.setText(houseTrim.getSize());
        tvDescription.setText(houseTrim.getDescription());
        tvPrice.setText(MoneyFormatting.showRupiahFormat(Integer.parseInt(houseTrim.getPrice())));
        Glide.with(this)
                .load(houseTrim.getPhoto())
                .apply(new RequestOptions().override(550, 250))
                .into(imgPhoto);

        btnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String phoneNumber = "000011112222";
        Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
        startActivity(dialPhoneIntent);
        //Toast.makeText(v.getContext(), "Calling "+"089789894566", Toast.LENGTH_SHORT).show();
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
