package com.company;

import java.util.concurrent.atomic.AtomicInteger;

public class Libro {
    private String autore, titolo;
    private int nCopieIn;
    private int nCopieOut;
    private int id;
    private int count = 0;
    private static final AtomicInteger countP = new AtomicInteger(0);

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getnCopieIn() {
        return nCopieIn;
    }

    public void setnCopieIn(int nCopieIn) {
        this.nCopieIn = nCopieIn;
    }

    public int getnCopieOut() {
        return nCopieOut;
    }

    public void setnCopieOut(int nCopieOut) {
        this.nCopieOut = nCopieOut;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Libro(String autore, String titolo, int nCopieIn, int nCopieOut) {
        this.autore = autore;
        this.titolo = titolo;
        this.nCopieIn = nCopieIn;
        this.nCopieOut = 0;
        this.id = countP.incrementAndGet();
    }

    public String toString(){
        String st = "Autore: " + autore + "; " + " Titolo: " + titolo + "; " + " N Copie: " + nCopieIn + "; " + "N Copie prestate: " + nCopieOut + "; " + "\n";
        return st;
    }
}
