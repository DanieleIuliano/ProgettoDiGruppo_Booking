package ProgettoDiGruppo.Classi.Gestione;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;
import ProgettoDiGruppo.Classi.Abitazione.Durata;
import ProgettoDiGruppo.Classi.Utente.FeedBack;
import ProgettoDiGruppo.Classi.Utente.Prenotazione;
import ProgettoDiGruppo.Classi.Utente.Utente;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AzioniUtente {

    private Scanner scanner = new Scanner(System.in);
    private DataBase dataBase = DataBase.getInstance();
    Map<String, Abitazione> abitazioniDisponibili = new HashMap<>();

    public void prenotaAbitazione(Utente utente) {

        LocalDate inizioPrenotazione;
        LocalDate finePrenotazione;
        int numeroPostiLetto;
        String line;
        String comune = null;
        String idCasa;

        try (BufferedReader file = new BufferedReader(new FileReader("src/ProgettoDiGruppo/Classi/CodiciCatastali.text"))) {

            System.out.print("Comune: ");
            comune = scanner.nextLine();

            while ((line = file.readLine()) != null) {

                if (line.contains(comune)) {

                    break;

                }

            }

            if (line == null) {

                System.out.println("Comune non disponibile");
                return;

            }

        } catch (FileNotFoundException e) {

            System.out.println("FILE NON TROVATO");

        } catch (IOException e) {

            System.out.println("ERRORE IN INPUT");

        }

        System.out.println("Da che data vuoi prenotare la casa? ");
        inizioPrenotazione = ritornaData();
        System.out.println("Fino a che data vuoi prenotare la casa? ");
        finePrenotazione = ritornaData();

        while (true) {

            System.out.print("Posti letto: ");
            numeroPostiLetto = scanner.nextInt();

            if (numeroPostiLetto > 0)

                break;

            System.out.println("HAI BISOGNO DI ALMENO UN LETTO, RIPOSARSI E' IMPORTANTE");

        }

        ritronaStanzeDalleSpecifiche(comune, inizioPrenotazione, finePrenotazione, numeroPostiLetto);
        if (abitazioniDisponibili.size() == 0){

            System.out.println("Nessuna casa disponibile");
            return;

        }

        while (true) {

            System.out.print("Id casa da prenotare: ");
            idCasa = scanner.next();
            int numeroGiorniPrenotati = inizioPrenotazione.getDayOfYear() - finePrenotazione.getDayOfYear();

            if(numeroGiorniPrenotati < 0)

                numeroGiorniPrenotati *= -1;

            if(abitazioniDisponibili.containsKey(idCasa)){

                String scelta;
                System.out.println("Il prezzo da pagare è di: " + (abitazioniDisponibili.get(idCasa).getPrezzo() * numeroGiorniPrenotati));
                System.out.print("Prenoti: ");
                scelta = scanner.next();

                if(scelta.equalsIgnoreCase("Si")) {

                    Prenotazione prenotazione = new Prenotazione(inizioPrenotazione,finePrenotazione,utente.getEmail(),abitazioniDisponibili.get(idCasa));
                    utente.getPrenotazioni().add(prenotazione);
                    dataBase.getHostInseriti().get(abitazioniDisponibili.get(idCasa).getEmailHost()).addNumeroPrenotazioni();
                    System.out.println("Prenotazione effettuata!");
                    return;

                }

                else {

                    System.out.println("Okay, sarà per la prossima");
                    return;
                }

            }

            else {

                System.out.println("Casa non disponibile");
                return;
            }
        }

    }

    private void ritronaStanzeDalleSpecifiche(String comune, LocalDate dataInizio, LocalDate dataFine, int postiLetto){


        for(Abitazione abitazione : dataBase.getCasePerComune().get(comune)){

            if(abitazione.getNumeroPostiLetto() >= postiLetto){

                if (abitazione.getDurata().isDataDisponibile(dataInizio, dataFine)) {

                    abitazioniDisponibili.put(abitazione.getId(), abitazione);
                    System.out.println(abitazione.toString());

                }
            }
        }
    }

    private LocalDate ritornaData(){

        int anno;
        int mese;
        int giorno;

        while (true) {

            System.out.print("Anno: ");
            anno = scanner.nextInt();

            if (anno >= LocalDate.now().getYear()) {

                break;

            }

            System.out.println("ANNO NON VALIDO");

        }

        while (true) {

            System.out.print("Numero mese: ");
            mese = scanner.nextInt();

            if (anno == LocalDate.now().getYear()) {

                if (mese >= LocalDate.now().getMonthValue() && mese <= 12)

                    break;

                else {

                    System.out.println("Mese non valido");
                    continue;

                }


            } else {

                if (mese <= 12 && mese > 0) {

                    break;

                }

                System.out.println("Mese non valido");

            }
        }

        while (true) {

            System.out.print("Giorno prenotazione: ");
            giorno = scanner.nextInt();

            if (mese == LocalDate.now().getMonthValue()) {

                if(giorno >= LocalDate.now().getDayOfMonth()){

                    break;

                }

                continue;

            }

            else {

                if (mese == 2) {

                    if (giorno <= 28 && giorno > 0)

                        break;

                    else {

                        System.out.println("Giorno non valido");

                    }

                }

                if (mese == 1 || mese == 3 || mese == 5 || mese == 7 || mese == 8 || mese == 10 || mese == 12) {

                    if (giorno <= 31 && giorno > 0)

                        break;

                    else {

                        System.out.println("Giorno non valido");

                    }

                } else {

                    if (giorno <= 30 && giorno > 0)

                        break;

                    else

                        System.out.println("Giorno non valido");

                }

            }
        }

        return LocalDate.of(anno, mese, giorno);

    }

    public Prenotazione ultimaPrenotazioneUtente(Utente utente){

        return utente.getPrenotazioni().peek();

    }



    public void inserisciRecenzionePerAbitazione(Utente utente){

        String idAbitazione;
        String titolo;
        String descrizione;
        int punteggio;

        for (Prenotazione prenotazione : utente.getPrenotazioni()){

            System.out.println(prenotazione);

        }

        System.out.print("Id abitazione: ");
        idAbitazione = scanner.nextLine();

            System.out.print("Titolo: ");
            titolo = scanner.nextLine();


            System.out.print("Descrizione: ");
            descrizione = scanner.nextLine();


            System.out.println("Punteggio: ");
            punteggio = scanner.nextInt();

            FeedBack feedBack = new FeedBack(titolo, descrizione, punteggio, dataBase.getCasePresentiNelDatabase().get(idAbitazione));


    }

}


