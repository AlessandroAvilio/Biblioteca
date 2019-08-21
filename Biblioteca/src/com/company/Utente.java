package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Utente {
    private String nome, cognome;
    private String codiceFiscale;
    private Date nascita;
    private ArrayList<Integer> idLibro = new ArrayList<Integer>();
    //private HashMap<Integer, Integer> idLibro = new HashMap<Integer, Integer>();
    private String tipoUtenza;
    private final AtomicInteger countPunti = new AtomicInteger(0);
    private int tesseraPunti;


    public Utente(String tipoUtenza) {
        this.tipoUtenza = tipoUtenza;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public Date getNascita() {
        return nascita;
    }

    public void setNascita(Date nascita) {
        this.nascita = nascita;
    }

    public ArrayList<Integer> getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(ArrayList<Integer> idLibro) { //Integer = WrapperClass
        this.idLibro = idLibro;
    }

    public String getTipoUtenza() {
        return tipoUtenza;
    }

    public void setTipoUtenza(String tipoUtenza) {
        this.tipoUtenza = tipoUtenza;
    }

    public int getCountPrestiti() {
        return idLibro.size();
    }

    public int getTesseraPunti() {
        return tesseraPunti;
    }

    public void setTesseraPunti(int tesseraPunti) {
        this.tesseraPunti = countPunti.incrementAndGet();
    }

    public String toString(){
        String st = "Nome: " + nome + "; " + " Cognome: " + cognome + "; " + "Data di nascita: " + nascita + "; " +  "Utente: " + tipoUtenza + "; " + "Prestiti effettuauti: " + getCountPrestiti() + "; " + "\n";
        return st;
    }
}
