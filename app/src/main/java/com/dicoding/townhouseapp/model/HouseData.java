package com.dicoding.townhouseapp.model;

import com.dicoding.townhouseapp.R;

import java.util.ArrayList;

public class HouseData {
    private static String[] houseName = {
            "Type Firdaus",
            "Type Hafiz",
            "Type 36",
            "Type 52",
            "Cordova 55",
            "Type Arsy",
            "Type 45",
            "Type Shofa",
            "Type Marwah",
            "Type Ameena"
    };

    private static String[] houseSize = {
            "5 x 10",
            "6 x 12",
            "7 x 12",
            "8 x 12",
            "9 x 12",
            "8 x 8",
            "9 x 9",
            "7 x 15",
            "10 x 10",
            "9 x 12"
    };

    private static String[] houseDescription = {
            "kamar mandi dalam, dilengkapi dengan fasilitas loundry dan tempat makan, dan tempat menerima tamu",
            "Rumah type 46  ini memiliki 2 kamar tidur, 1 kamar mandi,1 ruang tamu , 1 dapur, 1 carport dan taman.",
            "2 kamar tidur, 1 kamar mandi, 1 carport",
            "3 Kamar Tidur, 2 Kamar mandi, 1 Ruang tamu, 1 Dapur, 1 Ruang Makan, 1 Car port, 1 taman depan, 1 taman belakang",
            "satu kamar mandi, dua kamar tidur, 1 ruang tamu, 1 ruang keluarga, taman, garasi dan karpot.",
            "2 kamar tidur, 1 kamar mandi, 1 ruang tamu, 1 carport (1 mobil), 1 dapur, 1 ruang makan, 1 taman depan",
            "4 kamar tidur, 3 kamar mandi, 1 ruang tamu, 1 ruang utama, 1 carport (2 mobil), 1 dapur, 1 ruang makan, 1 taman depan",
            "1 Kamar Mandi, 2 Lantai, Luas Tanah 46,65 m2",
            "3 Kamar Tidur (1 Kamar Tidur Lantai Bawah , 2 Kamar Tidur Lantai Atas) , 1 Kamar Mandi Lantai Bawah , 1 Ruang Tamu, Carpot (1 Mobil), Taman Depan, Taman Belakang",
            "Luas Bangunan 36, Luas Tanah 72, Lebar x Panjang 6 x 12. Terdiri dari 2 Kamar Tidur, 1 Kamar Mandi, 1 Ruang Tamu, 1 Ruang Makan,  1 Carport 1 Car, 1 Dapur, 1 Taman Depan"
    };

    private static String[] housePrice = {
            "200000000",
            "300000000",
            "400000000",
            "500000000",
            "660000000",
            "780000000",
            "875000000",
            "900000000",
            "250000000",
            "450000000"
    };

    private static int[] housePhoto = {
            R.drawable.house_1,
            R.drawable.house_2,
            R.drawable.house_3,
            R.drawable.house_4,
            R.drawable.house_5,
            R.drawable.house_6,
            R.drawable.house_7,
            R.drawable.house_8,
            R.drawable.house_9,
            R.drawable.house_10
    };

    public static ArrayList<House> getListData() {
        ArrayList<House> list = new ArrayList<>();
        for (int position = 0; position < houseName.length; position++){
              House house = new House();
              house.setName(houseName[position]);
              house.setSize(houseSize[position]);
              house.setDescription(houseDescription[position]);
              house.setPrice(housePrice[position]);
              house.setPhoto(housePhoto[position]);
              list.add(house);
        }
        return list;
    }

}
