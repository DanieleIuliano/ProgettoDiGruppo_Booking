package ProgettoDiGruppo;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;
import ProgettoDiGruppo.Classi.Abitazione.Durata;
import ProgettoDiGruppo.Classi.Gestione.Gestione;
import ProgettoDiGruppo.Classi.Utente.Host;
import ProgettoDiGruppo.Classi.Utente.Prenotazione;
import ProgettoDiGruppo.Classi.Utente.Utente;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
/*
        Gestione gestione = new Gestione();
        Scanner scanner = new Scanner(System.in);
        String scelta;
        String tipoUtente;
        Utente utente = null;
        Host host = null;

        System.out.print("Benvenuto in Booking\nChe ruolo hai?\n|Host|\n|Utente|\nScelta: ");
        tipoUtente = scanner.next();

        if (tipoUtente.equalsIgnoreCase("Utente")) {
            while (true) {

                if (utente == null) {

                    System.out.println("|Registrazione|\n|Accesso|\n|Exit|");
                    System.out.print("Scelta: ");
                    scelta = scanner.next();

                    if (scelta.equalsIgnoreCase("Registrazione")) {

                        gestione.registrazione();
                        continue;

                    }

                    if (scelta.equalsIgnoreCase("Accesso")) {

                        utente = gestione.accesso();

                        if (utente == null) {

                            System.out.println("Accesso non riuscito, se non sei ancora registrato registrati!");
                            continue;

                        } else {

                            System.out.println("Accesso effettuato");
                            continue;

                        }

                    }

                } else {

                    System.out.println("Cosa vuoi fare: \n|Prenotazione|\n|Exit|");
                    System.out.print("Scelta: ");
                    scelta = scanner.next();

                }


                if (scelta.equalsIgnoreCase("Exit")) {

                    System.out.println("ARRIVEDERCI!!");
                    break;

                } else {

                    System.out.println("Scelta non valida!");
                    continue;

                }

            }

        }

        else if(tipoUtente.equalsIgnoreCase("Host")){

            while (true) {

                if (host == null) {

                    System.out.println("|Registrazione|\n|Accesso|\n|Exit|");
                    System.out.print("Scelta: ");
                    scelta = scanner.next();

                    if (scelta.equalsIgnoreCase("Registrazione")) {

                        gestione.registrazione();
                        continue;

                    }

                    if (scelta.equalsIgnoreCase("Accesso")) {

                        host = gestione.accessoHost();

                        if (utente == null) {

                            System.out.println("Accesso non riuscito, se non sei ancora registrato registrati!");
                            continue;

                        } else {

                            System.out.println("Accesso effettuato");
                            continue;

                        }

                    }

                } else {

                    System.out.println("Cosa vuoi fare: \n|Prenotazione|\n|Exit|");
                    System.out.print("Scelta: ");
                    scelta = scanner.next();

                }


                if (scelta.equalsIgnoreCase("Exit")) {

                    System.out.println("ARRIVEDERCI!!");
                    break;

                } else {

                    System.out.println("Scelta non valida!");
                    continue;

                }

            }

        }
*/
        LocalDate data1 = LocalDate.of(2021, 6, 24);
        LocalDate data2 = LocalDate.of(2021, 8, 24);
        LocalDate data3 = LocalDate.of(2021, 7, 24);
        LocalDate data4 = LocalDate.of(2021, 8, 24);
        Durata calendario1 = new Durata(data1,data2);
        Abitazione ab1 = new Abitazione(20,data1,data2,"casaFusco","viale",2,3,3);
        System.out.println(ab1);
        Prenotazione p1 = new Prenotazione(data3,data4,"coldfierz@gmail",ab1,1);
        ab1.getDurata().rimuoviDatePrenotate(data3,data4);
        System.out.println(ab1);
        System.out.println(ab1.getNumDiVoltePrenotata());



    }



}

