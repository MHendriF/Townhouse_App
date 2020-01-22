package com.dicoding.townhouseapp.helper.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.townhouseapp.DetailHouseActivity;
import com.dicoding.townhouseapp.R;
import com.dicoding.townhouseapp.helper.MoneyFormatting;
import com.dicoding.townhouseapp.model.House;

import java.util.ArrayList;

public class CardViewHouseAdapter extends RecyclerView.Adapter<CardViewHouseAdapter.CardViewViewHolder> {

    private Context mcontext;
    private ArrayList<House> listHouse;

    public CardViewHouseAdapter(Context context){
        this.mcontext = context;
    }

    public void setListHouse(ArrayList<House> list){
        this.listHouse = list;
    }

    public ArrayList<House> getListHouse(){
        return listHouse;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_house, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {
        House house = getListHouse().get(position);

        Glide.with(holder.itemView.getContext())
                .load(house.getPhoto())
                .apply(new RequestOptions().override(450, 300))
                .into(holder.imgPhoto);

        holder.tvName.setText(house.getName());
        holder.tvSize.setText(house.getSize());
        holder.tvDescription.setText(house.getDescription());
        holder.tvPrice.setText(MoneyFormatting.showRupiahFormat(Integer.parseInt(house.getPrice())));
        holder.house = house;
    }

    @Override
    public int getItemCount() {
        return listHouse.size();
    }

    public class CardViewViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imgPhoto;
        TextView tvName, tvSize, tvDescription;
        TextView tvPrice;
        Button btnDetail;
        House house;

        public CardViewViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.iv_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvSize = itemView.findViewById(R.id.tv_item_size);
            tvDescription = itemView.findViewById(R.id.tv_item_description);
            tvPrice = itemView.findViewById(R.id.tv_item_price);

            btnDetail = itemView.findViewById(R.id.btn_detail_item);
            btnDetail.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(mcontext, DetailHouseActivity.class);
            intent.putExtra("HOUSE", house);
            mcontext.startActivity(intent);
        }
    }
}
