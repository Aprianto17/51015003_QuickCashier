package com.example.aprianto.quickcashier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Locale;

public class NotaActivity extends AppCompatActivity {

    private TextView tvTotal, tvBayar, tvKembali, tvNama, tvNomor, tvEmail ;
    private Button btHome;

    private Nota nota;

    User user;

    private Integer kembali;
    private int nilai1;
    private  int nilai2;

    Locale localeID = new Locale("in", "ID");
    NumberFormat format = NumberFormat.getNumberInstance(localeID);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota);


        tvTotal = (TextView) findViewById(R.id.tvTotal);
        tvBayar = (TextView) findViewById(R.id.tvBayar);
        tvKembali = (TextView) findViewById(R.id.tvKembali);
        tvNama = (TextView) findViewById(R.id.tvNama);
        tvNomor = (TextView) findViewById(R.id.tvNomor);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        btHome = (Button) findViewById(R.id.btHome);

        user = getIntent().getParcelableExtra("user");

        tvNama.setText(user.getNama());
        tvEmail.setText(user.getEmail());
        tvNomor.setText(user.getTelepon());

        Intent tampil = getIntent();
        Integer Bayar = tampil.getIntExtra("Bayar",0);

        nota = Singleton.getInstance().getNota();

        tvTotal.setText("Rp "+format.format(nota.getTotalHarga()));


        nilai1 = nota.getTotalHarga();
        nilai2 = Bayar;
        kembali = nilai2-nilai1;

        tvKembali.setText("Rp "+format.format(kembali));

        tvBayar.setText("Rp "+format.format(Bayar));

        btHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotaActivity.this, MainActivity.class);
                intent.putExtra("user",user);
                startActivity(intent);
            }
        });

    }
}
