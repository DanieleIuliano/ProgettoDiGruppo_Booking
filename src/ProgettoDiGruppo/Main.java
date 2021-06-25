package ProgettoDiGruppo;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;
import ProgettoDiGruppo.Classi.Abitazione.Durata;
import ProgettoDiGruppo.Classi.Gestione.AzioniHost;
import ProgettoDiGruppo.Classi.Gestione.AzioniUtente;
import ProgettoDiGruppo.Classi.Gestione.Gestione;
import ProgettoDiGruppo.Classi.Utente.Host;
import ProgettoDiGruppo.Classi.Utente.Prenotazione;
import ProgettoDiGruppo.Classi.Utente.Utente;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        Gestione gestione = new Gestione();
        Scanner scanner = new Scanner(System.in);
        String scelta;
        String tipoUtente;
        Utente utente = null;
        Host host = null;

        while (true) {
            System.out.print("Benvenuto in Booking\nChe ruolo hai?\n|Host|\n|Utente|\n|Exit|\nScelta: ");
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

                        AzioniUtente azioniUtente = new AzioniUtente();
                        System.out.println("Cosa vuoi fare: \n|Prenotazione| Per prenotare una abitazione\n|UltimaPrenotazione| Per visualizzare l'ultima prenotazione fatta\n|Exit|");
                        System.out.print("Scelta: ");
                        scelta = scanner.next();

                        if (scelta.equalsIgnoreCase("Prenotazione")) {

                            azioniUtente.prenotaAbitazione(utente);
                            continue;

                        }

                        if (scelta.equalsIgnoreCase("UtlimaPrenotazione")) {

                            Prenotazione prenotazione = azioniUtente.ultimaPrenotazioneUtente(utente);
                            if (prenotazione == null) {

                                System.out.println("Devi prima effettuare una prenotazione!");
                                continue;

                            }

                            System.out.println(prenotazione.toString());

                            continue;

                        }

                    }

                    if (scelta.equalsIgnoreCase("Exit")) {

                        System.out.println("ARRIVEDERCI!!");
                        break;

                    } else {

                        System.out.println("Scelta non valida!");
                        continue;

                    }

                }

            } else if (tipoUtente.equalsIgnoreCase("Host")) {

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

                        AzioniHost azioniHost = new AzioniHost();
                        System.out.println("Cosa vuoi fare: \n|InserisciAbitazione| Per inserire un'abitazione\n|AbitazioniHost| Abitazione per l'host\n|SuperHost| Visualizza tutti i super host\n|Exit|");
                        System.out.print("Scelta: ");
                        scelta = scanner.next();

                        if (scelta.equalsIgnoreCase("InserisciAbitazione")) {

                            azioniHost.inserisciAbitazione(host);
                            continue;

                        }

                        if (scelta.equalsIgnoreCase("AbitazioniHost")) {

                            Set<Abitazione> abitazioniHost = azioniHost.abitazioniPerHost(host.getEmail());

                            for (Abitazione abitazione : abitazioniHost) {

                                System.out.println(abitazione.toString());

                            }
                            continue;

                        }

                        if (scelta.equalsIgnoreCase("SuperHost")) {

                            Set<Host> superHost = azioniHost.ritornaSuperHost();

                            for (Host hosts : superHost) {

                                System.out.println(hosts.toString());

                            }

                        }
                        continue;

                    }


                    if (scelta.equalsIgnoreCase("Exit")) {

                        break;

                    }
                    else {

                        System.out.println("Scelta non valida!");
                        continue;

                    }

                }

            }

            if(tipoUtente.equalsIgnoreCase("Exit")) {

                System.out.println("ARRIVEDERCI!!");

                break;

            }

        }

    }

}

