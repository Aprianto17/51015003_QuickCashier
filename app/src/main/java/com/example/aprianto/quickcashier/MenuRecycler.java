package com.example.aprianto.quickcashier;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by Aprianto on 1/22/2018.
 */

public class MenuRecycler extends RecyclerView.Adapter<MenuRecycler.MenuHolder> {

    List<Menu> menu;
    private LayoutInflater inflater;
    private Context context;
    String test;

    Locale localeID = new Locale("in", "ID");
    NumberFormat formatcur = NumberFormat.getCurrencyInstance(localeID);

    public MenuRecycler(Context context, List<Menu> listmenu) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.menu = listmenu;
    }

    @Override
    public MenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_menu, parent,false);
        MenuHolder holder = new MenuHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MenuHolder holder, int position) {
        Menu current = menu.get(position);
        holder.setData(current, position);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return menu.size();
    }

    public class MenuHolder extends RecyclerView.ViewHolder {

        TextView tvNama, tvHarga, tvTotal;
        ImageView menu_pic;
        Button tb_plus, tb_minus;

        Integer jml_input=0;

        int position;
        Menu current;

        View itemView;

        public MenuHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;

            tvNama = (TextView) itemView.findViewById(R.id.tvNamaMenu);
            tvHarga = (TextView) itemView.findViewById(R.id.tvHarga);
            menu_pic = (ImageView) itemView.findViewById(R.id.menuImg);

            tb_plus = (Button) itemView.findViewById(R.id.btPlus);
            tb_minus = (Button) itemView.findViewById(R.id.btMin);

            tvTotal = (TextView) itemView.findViewById(R.id.tvTotal);
        }

        public void setData(Menu current, int position) {

            //UNTUKPENGAMBILAN GAMBAR
            int img = context.getResources().getIdentifier("@drawable/"+current.getGbr(), null, context.getPackageName());

            menu_pic.setImageResource(img);

            tvNama.setText(current.getNama());
            tvHarga.setText(formatcur.format(current.getHarga()));

            this.position = position;
            this.current = current;
        }

        public void setListeners() {

        }
    }
}
