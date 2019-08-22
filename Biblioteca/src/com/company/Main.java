package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {


    public static void main(String[] args) {
         
        Scanner scan = new Scanner(System.in);
        String cod;
        HashMap<Integer, Libro> biblio = new HashMap<>();
        HashMap<String,Utente> Users = new HashMap<>();
        int scelta;
        int x;
        Utente utente;
        Libro libro;

        //VARIABILI DI LIBRO
        int  nCopieIn;
        String autore, titolo;
        Libro l;

        //VARIABILI DI UTENTI
        String nome, cognome, codiceFiscale;
        Date nascita;
        Utente u;

        try {
            do {
                try {
                    System.out.println("Benvenuto nel sistema informatico della Biblioteca! Per favore, selezionare una delle seguenti opzioni:\n" +
                            "1.Acquisizione di un nuovo libro, con relativo numero di copie\n" +
                            "2.Numero di copie prestate di un libro\n" +
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
                                scan.nextLine();
                                autore = scan.nextLine();
                                System.out.println("Titolo: ");
                                titolo = scan.nextLine();
                                System.out.println("Numero copie: ");
                                nCopieIn = scan.nextInt();
                                l = new Libro();
                                l.setTitolo(titolo);
                                l.setAutore(autore);
                                l.setnCopieIn(nCopieIn);

                                biblio.put(l.getId(), l);

                                System.out.println("Libro inserito correttamente!");
                            break;
                        case 2:
                            System.out.println("Inserire il titolo del libro: ");
                            scan.nextLine();
                            String copiePrestate = scan.nextLine();
                            for (Integer i : biblio.keySet()) {
                                if (biblio.get(i).getTitolo().equals(copiePrestate)) {
                                    System.out.println("Sono state prestate: " + biblio.get(i).getnCopieOut() + " copie di questo libro");
                                }
                            }
                            break;
                        case 3:
                            ArrayList<Integer> listaIDLibri;    //Lista ID Libri presi in prestito dagli Utenti

                            System.out.println("Inserire il codice fiscale");
                            scan.nextLine();
                            cod = scan.nextLine().toUpperCase();
                            if (Users.containsKey(cod)) {
                                utente = Users.get(cod);
                                listaIDLibri = Users.get(cod).getIdLibro();

                                System.out.println("Quanti ID di libri sono richiesti in input?");
                                int nLibriDaPrestare = scan.nextInt();
                                for (int i = 0; i < nLibriDaPrestare; i++) {
                                    System.out.println("Inserire l'ID del libro che si vuole prestare");
                                    int idLibro = scan.nextInt();
                                    libro = biblio.get(idLibro);
                                    if (biblio.containsKey(idLibro) && (libro.getnCopieIn() > 0) && (!(utente.getIdLibro().contains(idLibro)))) {
                                        listaIDLibri.add(idLibro);
                                        System.out.println("Libri prestato: " + libro.getTitolo() + "\n" + "Utente: " + utente.getNome());
                                        System.out.println("Libri presi in prestito dall'utente: " + utente.getIdLibro());
                                        System.out.println("Prestiti effettuati: " + utente.getCountPrestiti());
                                        libro.setnCopieOut(libro.getnCopieOut() + 1);
                                        System.out.println("Unità prestate: " + libro.getnCopieOut());
                                        libro.setnCopieIn(libro.getnCopieIn() - 1);
                                        System.out.println("Unità rimaste: " + libro.getnCopieIn());
                                    } else if (!(biblio.containsKey(idLibro))) {
                                        System.out.println("Non è presente alcun libro con questo ID");
                                        break;
                                    } else if (libro.getnCopieIn() == 0) {
                                        System.out.println("Questo libro non è più disponibile");
                                        break;
                                    } else if (utente.getIdLibro().contains(idLibro)){
                                        System.out.println("Questo utente è già in possesso di questo libro");
                                        break;
                                    }

                                    if (utente.getCountPrestiti() == 5) {
                                        System.out.println("Hai appena effettuato il quinto prestito presso la nostra biblioteca!\n Per ringraziarti, la tua utenza verrà convertita da Argento a Oro, permettendoti di avere accesso alla nostra tessera punti");
                                        System.out.println("Attendere prego. . .");
                                        try {
                                            Thread.sleep(5000);
                                        } catch (InterruptedException e) {
                                            System.out.println("Errore.");
                                        }
                                        utente.cambiaInOro(utente.getTipoUtenza());
                                        System.out.println("Conversione avvenuta con successo!");
                                    } else if (utente.getTipoUtenza().equals("Oro")) {    //== confronta gli HashCode (Numero univoco)
                                        utente.setTesseraPunti(utente.getTesseraPunti());
                                        System.out.println("Un punto aggiunto alla tessera personale. Punti ottenuti: " + utente.getTesseraPunti());
                                    }
                                }
                            } else {
                                System.out.println("Non è presente alcun utente registrato con questo Codice Fiscale");
                            }
                            break;
                        case 4:
                            ArrayList<Integer> listaUtenti;
                            System.out.println("Inserire il codice fiscale");
                            scan.nextLine();
                            cod = scan.nextLine().toUpperCase();
                            if (Users.containsKey(cod)) {
                                listaUtenti = Users.get(cod).getIdLibro();
                                System.out.println("Inserire l'ID del libro che si vuole ritirare");
                                int idLibro = scan.nextInt();
                                libro = biblio.get(idLibro);
                                if ((biblio.containsKey(idLibro)) && (libro.getnCopieOut() > 0)) {
                                    listaUtenti.remove((Integer) idLibro);
                                    libro.setnCopieIn(libro.getnCopieIn() + 1);
                                    libro.setnCopieOut(libro.getnCopieOut() - 1);

                                    System.out.println("\nLibro Ritirato");
                                } else if (!(biblio.containsKey(idLibro))) {
                                    System.out.println("Non esiste alcun libro registrato con quell'ID");
                                    break;
                                } else if (libro.getnCopieOut() == 0) {
                                    System.out.println("Tutte le copie di questo libro sono già presenti in biblioteca");
                                }
                            } else {
                                System.out.println("Non è presente alcun utente registrato con questo Codice Fiscale");
                                break;
                            }
                            break;
                        case 5:
                            System.out.println("Inserire il titolo del libro che si desidera dismettere: ");
                            String lOut = scan.next();
                            for (Integer i : biblio.keySet()) {
                                if (biblio.get(i).getTitolo().equals(lOut)){
                                    if (biblio.get(i).getnCopieOut() == 0) {
                                        biblio.remove(i);
                                    }else {
                                        System.out.println("Non sono presenti tutte le copie del libro immesso.");
                                    }
                                }
                            }
                            break;
                        case 6:
                            System.out.println(biblio);
                            break;
                        case 7:
                            System.out.println("Inserisci le informazioni della nuova utenza, quali nome, cognome, codice fiscale, data di nascita(Formato gg/MM/aaaa)");
                            System.out.println("Nome: ");
                            scan.nextLine();
                            nome = scan.nextLine(); //nextLine()
                            System.out.println("Cognome: ");
                            cognome = scan.nextLine();
                            while (true) {
                                System.out.println("Codice Fiscale: ");
                                codiceFiscale = scan.nextLine();
                                codiceFiscale = codiceFiscale.toUpperCase();
                                if (codiceFiscale.length() == 16) {
                                    break;
                                } else {
                                    System.out.println("Il codice fiscale deve essere composto da 16 caratteri.");
                                }
                            }
                            System.out.println("Data di nascita: ");
                            String data = scan.nextLine();
                            nascita = new SimpleDateFormat("dd/MM/yyyy").parse(data);
                            for (String cerca : Users.keySet()) {
                                if (codiceFiscale.equals(Users.get(cerca).getCodiceFiscale())) {
                                    System.out.println("Esiste già un altro utente con questo codice fiscale");
                                    break;
                                }
                            }

                            u = new Utente();
                            u.setTipoUtenza("Argento");
                            u.setNome(nome);
                            u.setCognome(cognome);
                            u.setCodiceFiscale(codiceFiscale);
                            u.setNascita(nascita);

                            Users.put(u.getCodiceFiscale(), u);
                            break;
                        case 8:
                            System.out.println(Users);
                            System.out.println("Libri presi in prestito:\n");
                            for (String cf : Users.keySet()) {
                                System.out.println(Users.get(cf).getIdLibro());
                            }
                            break;
                        default:
                            System.out.println("Input non corretto. Si prega di scegliere una delle opzioni elencate sopra");
                            break;
                    }
                }catch (InputMismatchException e){
                    System.out.println("Input errato");
                    break;
                }
                System.out.println("Vuoi eseguire altre operazioni? (1=si/0=no)");
                try {
                    x = scan.nextInt();
                    if(!(x == 0) && (!(x == 1))){
                        System.out.println("Inserire 0 oppure 1");
                    }
                }catch (InputMismatchException e){
                    System.out.println("Inserire 0 oppure 1");
                    break;
                }
            } while (x == 1);
            System.out.println("Arrivederci ;)");
        }catch (ParseException e) {
            e.printStackTrace();
        }
    }
}