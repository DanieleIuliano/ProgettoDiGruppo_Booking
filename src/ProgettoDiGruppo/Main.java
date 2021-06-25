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

    }



}

