package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        HashMap<Integer, Libro> biblio = new HashMap<Integer, Libro>();
        HashMap<String,Utente> Users = new HashMap<String, Utente>();
        int scelta;
        int x;

        //VARIABILI DI LIBRO
        int  nCopieIn = 0, nCopieOut = 0;
        String autore = "", titolo = "";
        Libro l;
        //VARIABILI DI UTENTI
        String nome = "", cognome = "", codiceFiscale = "", tipoUtenza = "";
        Date nascita = null;
        ArrayList<Integer> idLibriInPrestito = new ArrayList<Integer>();
        Utente u;

        try {
            do {
                System.out.println("Benvenuto nel sistema informatico della Biblioteca! Per favore, selezionare una delle seguenti opzioni:\n" +
                        "1.Acquisizione di un nuovo libro, con relativo numero di copie\n" +
                        "2.Numero di copie in prestito di un libro\n" +
                        "3.Dare in prestito una copia del libro\n" +
                        "4.Ricevere in restituzione una copia del libro\n" +
                        "5.Dismettere un libro dalla biblioteca\n" +
                        "6.Mostra libri presenti\n" +
                        "7.Inserisci un nuovo utente nel sistema\n" +
                        "8. Visualizza utenze\n" +
                        "0.Uscire dal programma");

                scelta = scan.nextInt();

                switch (scelta) {
                    case 1:
                        System.out.println("Inserire le caratteristiche del libro, quali autore e titolo. Inserire inoltre il numero di copie");
                        System.out.println("Autore: ");
                        autore = scan.next();
                        System.out.println("Titolo: ");
                        titolo = scan.next();
                        System.out.println("Numero copie: ");
                        nCopieIn = scan.nextInt();
                        l = new Libro(autore, titolo, nCopieIn, nCopieOut);

                        biblio.put(l.getId(), l);

                        System.out.println("Libro inserito correttamente!");
                        break;
                    case 2:
                        System.out.println("Inserire il titolo del libro: ");
                        String copiePrestate = scan.next();
                        for (Integer i : biblio.keySet()) {
                            if (biblio.get(i).getTitolo().equals(copiePrestate)) {
                                System.out.println(biblio.get(i).getnCopieOut());
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Inserire il codice fiscale");
                        String cod = scan.next();

                        if(Users.containsKey(cod)){
                            System.out.println("Inserire l'ID del libro che si vuole prestare");
                            int idLibro = scan.nextInt();
                            if(biblio.containsKey(idLibro)){
                                Users.get(cod).getIdLibro().add(biblio.get(idLibro).getId());
                                System.out.println("Libro prestato: "+ biblio.get(idLibro).getTitolo() + "\n" + "Utente: "+ Users.get(cod).getNome());
                                System.out.println(Users.get(cod).getIdLibro());
                                Users.get(cod).setCountPrestiti(Users.get(cod).getCountPrestiti());
                                System.out.println("Prestiti effettuati: " + Users.get(cod).getCountPrestiti());
                            } else{
                                System.out.println("Non è presente alcun libro con questo ID");
                                break;
                            }
                        }else{
                            System.out.println("Non è presente alcun utente registrato con questo Codice Fiscale");
                        }
                        break;
                    case 4:
                        System.out.println("Inserire il codice fiscale");
                        String cod = scan.next();

                        if(Users.containsKey())

                    case 5:
                        System.out.println("Inserire il titolo del libro che si desidera dismettere: ");
                        String lOut = scan.next();
                        for (Integer i : biblio.keySet()) {
                            if (biblio.get(i).getTitolo().equals(lOut)) {
                                biblio.remove(i);
                            }
                        }
                        break;
                    case 6:
                        System.out.println(biblio);
                        break;
                    case 7:
                        System.out.println("Inserisci le informazioni della nuova utenza, quali nome, cognome, codice fiscale, data di nascita(Formato gg/MM/aaaa)");
                        System.out.println("Nome: ");
                        nome = scan.next();
                        System.out.println("Cognome: ");
                        cognome = scan.next();
                        System.out.println("Codice Fiscale: ");
                        codiceFiscale = scan.next();
                        System.out.println("Data di nascita: ");
                        String data = scan.next();
                        nascita = new SimpleDateFormat("dd/MM/yyyy").parse(data);

                        u = new Utente(nome, cognome, nascita, idLibriInPrestito, tipoUtenza);
                        u.setCodiceFiscale(codiceFiscale);

                        Users.put(u.getCodiceFiscale(), u);
                        break;
                    case 8:
                        System.out.println(Users);
                        break;
                }
                System.out.println("Vuoi eseguire altre operazioni? (1=si/0=no)");
                x = scan.nextInt();
            } while (x == 1);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
