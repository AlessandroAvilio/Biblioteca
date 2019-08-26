package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Utente implements Oro {
    private String nome, cognome;
    private String codiceFiscale;
    private Date nascita;
    private ArrayList<Integer> idLibro = new ArrayList<>();
    private String tipoUtenza;
    private static int count = 0;
    private static int countPrestiti = 0;
    private int tesseraPunti;
    String className;
    List<listaUtenti> listaUtenti;

    /*public Utente(String className, List<listaUtenti> listaUtenti) {
        this.className = className;
        this.listaUtenti = listaUtenti;
    }*/

    public void setClassName(String className) {
        this.className = className;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public void setNascita(Date nascita) {
        this.nascita = nascita;
    }

    public Date getNascita() {
        return nascita;
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
        this.tesseraPunti = ++count;
    }

    public String toString() {
        String st = "Nome: " + nome + "; " + " Cognome: " + cognome + "; " + "Data di nascita: " + nascita + "; " + "Utente: " + tipoUtenza + "; " + "Prestiti effettuauti: " + getCountPrestiti() + "; " + "\n";
        return st;
    }

    public void cambiaInOro(String tipoUtenza) {
        this.tipoUtenza = "Oro";
    }

    public static class listaUtenti {
        String nome, cognome, codiceFiscale, tipoUtenza;
        Date nascita;
        int tesseraPunti;
        ArrayList<Integer> idLibro = new ArrayList<>();

        public listaUtenti(String nome, String cognome, String codiceFiscale, Date nascita, String tipoUtenza) {
            this.nome = nome;
            this.cognome = cognome;
            this.codiceFiscale = codiceFiscale;
            this.nascita = nascita;
            this.tipoUtenza = tipoUtenza;
            //this.tesseraPunti = tesseraPunti;
            //this.idLibro = idLibro;

        }
    }
}


