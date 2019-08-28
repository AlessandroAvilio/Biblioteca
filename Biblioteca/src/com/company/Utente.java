package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Utente implements Oro {
    private String nome, cognome;
    private String codiceFiscale;
    private Date nascita;
    private ArrayList<Integer> idLibro = new ArrayList<>();
    private String tipoUtenza;
    private static int count = 0;
    private int countPrestiti;
    private int tesseraPunti;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public void setCountPrestiti(int countPrestiti) {
        this.countPrestiti = countPrestiti;
    }

    public int getCountPrestiti() {
        return countPrestiti;
    }

    public int getTesseraPunti() {
        return tesseraPunti;
    }

    public void setTesseraPunti(int tesseraPunti) {
        this.tesseraPunti = tesseraPunti;
    }

    public String toString() {
        String st = "Nome: " + nome + "; " + " Cognome: " + cognome + "; " + "Data di nascita: " + nascita + "; " + "Utente: " + tipoUtenza + "; " + "Prestiti effettuauti: " + getCountPrestiti() + "; " + "\n";
        return st;
    }

    public void cambiaInOro(String tipoUtenza) {
        this.tipoUtenza = "Oro";
    }

}


