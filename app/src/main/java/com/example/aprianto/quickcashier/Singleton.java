package com.example.aprianto.quickcashier;

/**
 * Created by Aprianto on 2/16/2018.
 */

public class Singleton {

    private static Singleton  instance = null;

    private Nota nota;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }
}
