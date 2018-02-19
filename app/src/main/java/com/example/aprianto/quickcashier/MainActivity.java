package com.example.aprianto.quickcashier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements ViewInterface  {

    private RecyclerView rvMenu;
    private ArrayList<Menu> list;

    Locale localeID = new Locale("in", "ID");
    NumberFormat format = NumberFormat.getNumberInstance(localeID);

    private TextView tvTotal, tvListJmlh, tvListMenu, tvListHarga;
    private Button btBayar;

    private Nota nota;

    Integer ttl;

    //menu
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    //Daftar menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.profil) {
            startActivity(new Intent(MainActivity.this, MainActivity.class));
            finish();
        }
        return true;
    }



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

        nota = new Nota();

        showRecyclerMenu();


        btBayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ttl = nota.getTotalHarga();
                //Mencegah Ada data null
                if (ttl == null) {
                    Toast.makeText(getApplicationContext(), "Minumal Pembelian 1 item", Toast.LENGTH_SHORT).show();
                } else if (ttl == 0){
                    Toast.makeText(getApplicationContext(), "Minumal Pembelian 1 item", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, BayarActivity.class);
//                intent.putExtra("nota",nota);
                    Singleton.getInstance().setNota(nota);

                    startActivity(intent);
                }
            }
        });


    }

    @Override
    public void updateNota(Menu menu, int inc) {
        NotaItem item = new NotaItem();

        item.setKode(menu.getKode());
        item.setNama(menu.getNama());
        item.setHarga(menu.getHarga());

        nota.addItem(item, inc);
        tvTotal.setText(format.format(nota.getTotalHarga()));

        tvListJmlh.setText(nota.getCurrent().getQuantity().toString());
        tvListMenu.setText(nota.getCurrent().getNama());
        tvListHarga.setText(format.format(nota.getCurrent().getJumlahHarga()));

        Log.e(nota.getTotalHarga().toString(),"ttl");

        Log.e(nota.getCurrent().getQuantity().toString(),"Jumlh");
        Log.e(nota.getCurrent().getNama(),"Nama");
        Log.e(nota.getCurrent().getJumlahHarga().toString(),"Harga");
    }


    private void showRecyclerMenu() {
        rvMenu.setLayoutManager(new LinearLayoutManager(this));
        MenuRecycler menuAdapter = new MenuRecycler(this, DataMenu.getListData());
        rvMenu.setAdapter(menuAdapter);
    }
}
