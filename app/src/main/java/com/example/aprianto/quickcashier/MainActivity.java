package com.example.aprianto.quickcashier;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity  {

    private RecyclerView rvMenu;
    private ArrayList<Menu> list;

    Locale localeID = new Locale("in", "ID");
    NumberFormat format = NumberFormat.getNumberInstance(localeID);

    private TextView tvTotal, tvListJmlh, tvListMenu, tvListHarga;
    private Button btBayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTotal = (TextView) findViewById(R.id.tvTotal);
        tvTotal.setText(format.format(0));

        tvListJmlh = (TextView) findViewById(R.id.tvListJmlh);
        tvListMenu = (TextView) findViewById(R.id.tvListMenu);
        tvListHarga = (TextView) findViewById(R.id.tvListHarga);

        tvListJmlh.setText("");
        tvListMenu.setText("");
        tvListHarga.setText("");

        btBayar = (Button) findViewById(R.id.btBayar);

        rvMenu = (RecyclerView)findViewById(R.id.rv_menu);
        rvMenu.setHasFixedSize(true);

        list = new ArrayList<>();
        list.addAll(DataMenu.getListData());

    }
}
