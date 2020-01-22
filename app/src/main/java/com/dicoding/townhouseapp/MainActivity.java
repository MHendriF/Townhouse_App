package com.dicoding.townhouseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.dicoding.townhouseapp.helper.adapter.CardViewHouseAdapter;
import com.dicoding.townhouseapp.model.House;
import com.dicoding.townhouseapp.model.HouseData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvHouses;
    private ArrayList<House> list = new ArrayList<>();
    private String title = "Home";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setActionBarTitle(title);

        rvHouses = findViewById(R.id.rv_house);
        rvHouses.setHasFixedSize(true);

        list.addAll(HouseData.getListData());
        showRecyclerCardView();
    }

    private void showRecyclerCardView(){
        rvHouses.setLayoutManager(new LinearLayoutManager(this));
        CardViewHouseAdapter cardViewHouseAdapter = new CardViewHouseAdapter(this);
        cardViewHouseAdapter.setListHouse(list);
        rvHouses.setAdapter(cardViewHouseAdapter);
    }
    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.btn_menu:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                break;
        }
    }

}
