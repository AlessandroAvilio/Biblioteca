package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Utente {
    private String nome, cognome;
    private String codiceFiscale;
    private Date nascita;
    private ArrayList<Integer> idLibro = new ArrayList<Integer>();
    private String tipoUtenza;
    private static final AtomicInteger count = new AtomicInteger(0);
    private int countPrestiti;
    private int tesera;


    public Utente(String nome, String cognome, Date nascita, ArrayList<Integer> idLibro, String tipoUtenza) {
        this.nome = nome;
        this.cognome = cognome;
        this.nascita = nascita;
        this.idLibro = idLibro;
        this.tipoUtenza = "Argento";

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

    public void setIdLibro(ArrayList<Integer> idLibro) {
        this.idLibro = idLibro;
    }

    public String getTipoUtenza() {
        return tipoUtenza;
    }

    public void setTipoUtenza(String tipoUtenza) {
        this.tipoUtenza = tipoUtenza;
    }

    public int getCountPrestiti() {
        return countPrestiti;
    }

    public void setCountPrestiti(int countPrestiti) {
        this.countPrestiti = count.incrementAndGet();
    }

    public String toString(){
        String st = "Nome: " + nome + " Cognome: " + cognome + "Data di nascita: " + nascita + "Utente: " + tipoUtenza + "Libri in prestito: " + idLibro.toString() + "Prestiti effettuauti: " + countPrestiti + "\n";
        return st;
    }
}
