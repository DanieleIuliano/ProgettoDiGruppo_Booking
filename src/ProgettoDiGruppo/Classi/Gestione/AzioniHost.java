package ProgettoDiGruppo.Classi.Gestione;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;
import ProgettoDiGruppo.Classi.Utente.Host;

import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class AzioniHost {

    private DataBase dataBase = DataBase.getInstance();
    private Scanner scanner = new Scanner(System.in);

    public void inserisciAbitazione(Host host) {

        String line;
        String comune = null;
        String indirizzo;
        int numeroPostiLetto = 0;
        int piano = 0;
        int numeroLocali = 0;
        LocalDate dataInizio;
        LocalDate dataFine;
        String nome;
        double prezzo;

        while (true) {

            System.out.print("Nome: ");
            nome = scanner.nextLine();

            if (nome.length() > 3)

                break;

            System.out.println("Nome troppo corto");

        }

        try (BufferedReader file = new BufferedReader(new FileReader("src/ProgettoDiGruppo/Classi/CodiciCatastali.text"))) {

            System.out.print("Comune: ");
            comune = scanner.nextLine();

            while ((line = file.readLine()) != null) {

                if(line.toLowerCase(Locale.ROOT).contains(comune)) {

                    if(line.length() == (comune.length() + 4)) {

                        break;

                    }

                }

            }

            if(line == null){

                System.out.println("Comune non disponibile");
                return;

            }

        } catch (FileNotFoundException e) {

            System.out.println("FILE NON TROVATO");

        } catch (IOException e) {

            System.out.println("ERRORE IN INPUT");

        }

        while (true) {

            System.out.print("Indirizzo: ");
            indirizzo = scanner.nextLine();

            if (indirizzo.length() > 3)

                break;

            System.out.println("Indirizzo non valido");

        }

        while (true) {

            System.out.print("Posti letto: ");
            try {

                numeroPostiLetto = scanner.nextInt();

            } catch (InputMismatchException inputMismatchException) {

                System.out.println("Devi mettere un numero!");

            }

            if (numeroPostiLetto > 0)

                break;

            System.out.println("ERRORE, POSTI NON VALIDI");

        }

        while (true) {

            System.out.print("Numero locali: ");
            try {

                numeroLocali = scanner.nextInt();

            } catch (InputMismatchException inputMismatchException) {

                System.out.println("Devi mettere un numero!");

            }

            if (numeroLocali > 0)

                break;

            System.out.println("ERRORE!");

        }

        while (true) {

            System.out.print("Piano: ");
            try {

                piano = scanner.nextInt();

            } catch (InputMismatchException inputMismatchException) {

                System.out.println("Devi mettere un numero!");

            }

            if (piano > 0)

                break;

            System.out.println("ERRORE, PIANO NON VALIDI");

        }

        System.out.println("Informazioni sull'inizio della disponibilità dell'abitazione");
        dataInizio = ritornaData();

        System.out.println("Informazioni sulla fine della disponibilità dell'abitazione");
        dataFine = ritornaData();

        while (true) {

            System.out.print("Prezzo settimanale: ");
            prezzo = scanner.nextDouble();

            if (prezzo > 0)

                break;

            System.out.println("Prezzo non valido");

        }

        Abitazione abitazione = new Abitazione(prezzo, dataInizio, dataFine, nome, indirizzo, numeroLocali, numeroPostiLetto, piano, host.getEmail());
        dataBase.addCasa(host, abitazione);
        dataBase.addCasaPerComune(comune, abitazione);


    }


    public void inserisciAbitazione(Host host, Abitazione abitazione, String comune) {

        dataBase.addCasa(host, abitazione);
        dataBase.addCasaPerComune(comune, abitazione);

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

                if (mese >= LocalDate.now().getMonthValue())

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

    /**
     *
     * @param emailHost .
     * @return le case relative all'utente.
     */

    public Set<Abitazione> abitazioniPerHost(String emailHost){

        return dataBase.getCaseInseriteDallHost().get(emailHost);

    }

    public Set<Host> ritornaSuperHost(){

        Set<Host> superHost = new HashSet<>();

        for(Host host : dataBase.getHostInseriti().values()){

            if(host.isSuperHost())

                superHost.add(host);

        }

        return superHost;

    }

    public int numeroMedioPostiLetto(){

        return dataBase.mediaPostiLetto();

    }



}
