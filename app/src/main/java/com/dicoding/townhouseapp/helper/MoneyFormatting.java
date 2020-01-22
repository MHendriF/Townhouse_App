package com.dicoding.townhouseapp.helper;

import java.text.NumberFormat;
import java.util.Locale;

public class MoneyFormatting {

    public MoneyFormatting(){}

    public static String showRupiahFormat(int angka){
        Locale localeID = new Locale("in", "ID");
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(localeID);
        return  formatRupiah.format((double)angka);
    }
}
