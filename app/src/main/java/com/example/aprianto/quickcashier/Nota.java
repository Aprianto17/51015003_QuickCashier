package com.example.aprianto.quickcashier;

import android.os.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aprianto on 2/6/2018.
 */

public class Nota extends Menu {

    private List<NotaItem> listNota;
    private NotaItem current;
    private int currentIndex;

    private Integer totalHarga;

    public Nota(){
        listNota = new ArrayList<>();
    }

    public List<NotaItem> getListNota(){
        return this.listNota;
    }

    public int getItemCount(){
        return this.listNota.size();
    }

    public NotaItem getCurrent(){
        return this.current;
    }

    private void setCurrent(NotaItem item){
        this.current = item;
    }

    public int getCurrentIndex(){
        return this.currentIndex;
    }


    public void setCurrentIndex(int idx){
        this.currentIndex = idx;
        this.setCurrent( this.listNota.get(idx) );
    }

    public void addItem(NotaItem item, int inc){
        boolean ada = false;
        for (int i=0; i < this.listNota.size(); i++ ) {
            if( this.listNota.get(i).getKode() == item.getKode() ){
                ada = true;
                int jml = this.listNota.get(i).getQuantity() + inc;
                this.listNota.get(i).setQuantity( jml );
                if( this.listNota.get(i).getQuantity() < 0 ) this.listNota.get(i).setQuantity( 0 );
                this.setCurrentIndex(i);
            }
        }
        if(!ada ){
            item.setQuantity(inc);
            listNota.add(item);
            this.setCurrentIndex(this.getItemCount()-1);
        }
        //Tambahan
        setTotalHarga();
    }

    public Integer getTotalHarga(){
        return this.totalHarga;
    }

    void setTotalHarga(){
        Integer total = 0;
        for (int i=0; i < this.listNota.size(); i++ ) {
            total += this.listNota.get(i).getJumlahHarga();
        }
        this.totalHarga = total;
    }


    //PARCELABLE
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeList(this.listNota);
        dest.writeValue(this.totalHarga);
    }

    protected Nota(Parcel in) {
        super(in);
        this.listNota = new ArrayList<NotaItem>();
        in.readList(this.listNota, NotaItem.class.getClassLoader());
        this.totalHarga = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<Nota> CREATOR = new Creator<Nota>() {
        @Override
        public Nota createFromParcel(Parcel source) {
            return new Nota(source);
        }

        @Override
        public Nota[] newArray(int size) {
            return new Nota[size];
        }
    };
}


