package com.example.aprianto.quickcashier;

import java.util.ArrayList;

/**
 * Created by Aprianto on 1/22/2018.
 */

public class DataMenu {

    public static  String[][] datamenu = new String[][]{
            {"01", "Bakso Mercon", "m01" , "25000"},
            {"02", "Sop Iga", "m02" , "40000"},
            {"03", "Ice Buah", "m03" , "20000"},
            {"04", "Black Forest", "m04" , "30000"},
            {"05", "Ice The", "m05" , "15000"},
            {"06", "Chokolate Cinnamon", "m06" , "30000"},
            {"07", "Pisang Goreng", "m07" , "20000"},
            {"08", "Kentang Goreng", "m08" , "20000"}
    } ;

    public static ArrayList<Menu> getListData(){
        Menu menu = null;
        ArrayList<Menu> list = new ArrayList<>();

        for (int i = 0; i < datamenu.length ; i++){
            menu = new Menu();
            menu.setKode(datamenu[i][0]);
            menu.setNama(datamenu[i][1]);
            menu.setGbr(datamenu[i][2]);
            menu.setHarga(Integer.valueOf(datamenu[i][3]));

            list.add(menu);
        }

        return list;
    }
}
