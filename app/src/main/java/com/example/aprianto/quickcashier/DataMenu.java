package com.example.aprianto.quickcashier;

import java.util.ArrayList;

/**
 * Created by Aprianto on 1/22/2018.
 */

public class DataMenu {

    public static  String[][] datamenu = new String[][]{
            {"01", "Bakso Mercon", "25000"},
            {"02", "Sop Iga", "40000"},
            {"03", "Ice Buah", "20000"},
            {"04", "Black Forest", "30000"},
            {"05", "Ice The", "15000"},
            {"06", "Chokolate Cinnamon", "30000"},
            {"07", "Pisang Goreng", "20000"},
            {"08", "Kentang Goreng", "20000"}
    } ;

    public static ArrayList<Menu> getListData(){
        Menu menu = null;
        ArrayList<Menu> list = new ArrayList<>();

        for (int i = 0; i < datamenu.length ; i++){
            menu = new Menu();
            menu.setKode(datamenu[i][0]);
            menu.setNama(datamenu[i][1]);
            menu.setHarga(Integer.valueOf(datamenu[i][2]));

            list.add(menu);
        }

        return list;
    }
}
