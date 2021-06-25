package ProgettoDiGruppo;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;
import ProgettoDiGruppo.Classi.Gestione.AzioniHost;
import ProgettoDiGruppo.Classi.Gestione.AzioniUtente;
import ProgettoDiGruppo.Classi.Gestione.DataBase;
import ProgettoDiGruppo.Classi.Gestione.Gestione;
import ProgettoDiGruppo.Classi.Utente.Host;
import ProgettoDiGruppo.Classi.Utente.Prenotazione;
import ProgettoDiGruppo.Classi.Utente.Utente;
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
        DataBase dataBase = DataBase.getInstance();

        while (true) {
            System.out.print("Benvenuto in Booking\nChe ruolo hai?\n|Host|\n|Utente|\n|Exit|\nScelta: ");
            tipoUtente = scanner.next();

            if (tipoUtente.equalsIgnoreCase("Utente")) {

                Prenotazione prenotazione;

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

                            }
                            else {

                                System.out.println("Accesso effettuato");

                            }
                            continue;

                        }

                    }
                    else {

                        AzioniUtente azioniUtente = new AzioniUtente();
                        System.out.println("Cosa vuoi fare: \n|Prenotazione| Per prenotare una abitazione\n|UltimaPrenotazione| Per visualizzare l'ultima prenotazione fatta\n|Feedback|\n|CasaGettonata| La casa più gettonata\n|Exit|");
                        System.out.print("Scelta: ");
                        scelta = scanner.next();

                        if (scelta.equalsIgnoreCase("Prenotazione")) {

                            azioniUtente.prenotaAbitazione(utente);
                            continue;

                        }

                        if (scelta.equalsIgnoreCase("UltimaPrenotazione")) {

                            prenotazione = azioniUtente.ultimaPrenotazioneUtente(utente);
                            if (prenotazione == null) {

                                System.out.println("Devi prima effettuare una prenotazione!");
                                continue;

                            }

                            System.out.println(prenotazione);

                            continue;

                        }

                        if(scelta.equalsIgnoreCase("Feedback")) {

                            azioniUtente.inserisciRecenzionePerAbitazione(utente);
                            continue;
                        }
                        if(scelta.equalsIgnoreCase("CasaGettonata")) {

                           try {

                               System.out.println(dataBase.casaGettonata());

                           }
                           catch (NullPointerException e){

                               System.out.println("Per questo mese non c'è nessuna casa selezionata");

                           }
                            continue;
                        }

                    }

                    if (scelta.equalsIgnoreCase("Exit")) {

                        break;

                    } else {

                        System.out.println("Scelta non valida!");

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

                            if (host == null) {

                                System.out.println("Accesso non riuscito, se non sei ancora registrato registrati!");

                            } else {

                                System.out.println("Accesso effettuato");

                            }
                            continue;

                        }

                    } else {

                        AzioniHost azioniHost = new AzioniHost();
                        System.out.println("Cosa vuoi fare: \n|InserisciAbitazione| Per inserire un'abitazione\n|AbitazioniHost| Lista abitazioni \n|SuperHost| Visualizza tutti i super host\n|MediaPostiLetto| Per vedere la media dei posti letto\n|HostConPrenotazioni| Per vedere l'host con più prenotazioni\n |Exit|");
                        System.out.print("Scelta: ");
                        scelta = scanner.next();

                        if (scelta.equalsIgnoreCase("InserisciAbitazione")) {

                            azioniHost.inserisciAbitazione(host);
                            continue;

                        }

                        if (scelta.equalsIgnoreCase("AbitazioniHost")) {

                            Set<Abitazione> abitazioniHost = azioniHost.abitazioniPerHost(host.getEmail());

                            if(abitazioniHost == null){

                                System.out.println("Nessuna abitazione presente");
                                continue;

                            }

                            for (Abitazione abitazione : abitazioniHost) {

                                System.out.println(abitazione.toString());

                            }
                            continue;

                        }

                        if (scelta.equalsIgnoreCase("SuperHost")) {

                            Set<Host> superHost = azioniHost.ritornaSuperHost();

                            if(superHost.size() <= 0){

                                System.out.println("Nessun super host presente");
                                continue;

                            }

                            for (Host hosts : superHost) {

                                System.out.println(hosts.toString());

                            }
                            continue;
                        }

                        if(scelta.equalsIgnoreCase("HostConPrenotazioni")) {

                            try {

                                System.out.println(dataBase.);

                            }
                            catch (NullPointerException e){

                                System.out.println("Per questo mese non c'è nessuna casa selezionata");

                            }
                            continue;
                        }


                        if (scelta.equalsIgnoreCase("MediaPostiLetto")) {

                            System.out.println("La media è: "+ azioniHost.numeroMedioPostiLetto());
                            continue;

                        }


                    }


                    if (scelta.equalsIgnoreCase("Exit")) {

                        break;

                    } else {

                        System.out.println("Scelta non valida!");

                    }

                }

            }

            if (tipoUtente.equalsIgnoreCase("Exit")) {

                System.out.println("ARRIVEDERCI!!");

                break;

            }

        }

    }
}


