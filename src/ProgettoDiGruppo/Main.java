package ProgettoDiGruppo;

import ProgettoDiGruppo.Classi.Abitazione.Durata;
import ProgettoDiGruppo.Classi.Gestione.Gestione;
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
        Utente utente = null;

        System.out.println("Benvenuto in Booking\nCosa vuoi fare: ");

        while (true){

            if(utente == null) {

                System.out.println("|Registrazione|\n|Accesso|\n|Exit|");
                System.out.print("Scelta: ");
                scelta = scanner.next();

                if(scelta.equalsIgnoreCase("Registrazione")){

                    gestione.registrazione();
                    continue;

                }

                if(scelta.equalsIgnoreCase("Accesso")){

                    utente = gestione.accesso();

                    if(utente == null){

                        System.out.println("Accesso non riuscito, se non sei ancora registrato registrati!");
                        continue;

                    }

                    else {

                        System.out.println("Accesso effettuato");
                        continue;

                    }

                }

            }

            else {

                System.out.println("Cosa vuoi fare: \n|Prenotazione|\n|Exit|");
                System.out.print("Scelta: ");
                scelta = scanner.next();

            }


            if(scelta.equalsIgnoreCase("Exit")){

                System.out.println("ARRIVEDERCI!!");
                break;

            }

            else{

                System.out.println("Scelta non valida!");
                continue;

            }

        }
*/
        LocalDate data1 = LocalDate.of(2021, 6, 24);
        LocalDate data2 = LocalDate.of(2021, 8, 24);
        LocalDate data3 = LocalDate.of(2021, 7, 24);
        LocalDate data4 = LocalDate.of(2021, 8, 24);
        Durata calendario1 = new Durata(data1,data2);
        calendario1.riempiListaDate();
        System.out.println(calendario1.getDates().toString());
        calendario1.rimuoviDatePrenotate(data3,data4);
        System.out.println(calendario1.getDates().toString());

    }



}

