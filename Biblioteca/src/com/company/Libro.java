package com.company;

public class Libro {
    private String autore, titolo;
    private int nCopieIn;
    private int nCopieOut;
    private int id;
    private static int count = 0;

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

    public Libro() {
        this.id = ++count;
    }

    public String toString(){
        String st = "Autore: " + autore + "; " + " Titolo: " + titolo + "; " + " N Copie: " + nCopieIn + "; " + "N Copie prestate: " + nCopieOut + "; " + "\n";
        return st;
    }
}
