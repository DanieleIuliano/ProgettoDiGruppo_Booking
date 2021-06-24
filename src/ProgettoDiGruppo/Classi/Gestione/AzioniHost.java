package ProgettoDiGruppo.Classi.Gestione;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;
import ProgettoDiGruppo.Classi.Utente.Host;

import java.io.*;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;


public class AzioniHost {

    private DataBase dataBase = DataBase.getInstance();
    private Scanner scanner = new Scanner(System.in);

    public void inserisciAbitazione(Host host) {

        String line;
        String comune;
        String indirizzo;
        int numeroPostiLetto = 0;
        int piano = 0;
        int numeroLocali = 0;
        LocalDate dataInizio;
        int anno;
        int mese;
        int giorno;
        LocalDate dataFine;
        String nome;
        double prezzo;
        System.out.println("Comune abitazione: ");

        while (true) {

            System.out.print("Nome: ");
            nome = scanner.nextLine();

            if (nome.length() < 3)

                break;

            System.out.println("Nome troppo corto");

        }

        try (BufferedReader file = new BufferedReader(new FileReader("src/ProgettoDiGruppo/Classi/CodiciCatastali.text"))) {

            while ((line = file.readLine()) != null) {

                System.out.print("Comune: ");
                comune = scanner.nextLine();

                if (line.contains(comune)) {

                    break;

                }

                System.out.println("Comune non disponibile");

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

        while (true) {

            System.out.print("Anno inizio prenotazione: ");
            anno = scanner.nextInt();

            if (anno >= LocalDate.now().getYear()) {

                break;

            }

            System.out.println("ANNO NON VALIDO");
            return;
        }

        while (true) {

            System.out.print("Numero mese inizio prenotazione: ");
            mese = scanner.nextInt();

            if (mese <= 12 && mese > 0) {

                break;

            }

            System.out.println("Mese non valido");

        }

        while (true) {

            System.out.print("Giorno inizio prenotazione: ");
            giorno = scanner.nextInt();

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

        dataInizio = LocalDate.of(anno, mese, giorno);

        while (true) {

            System.out.print("Anno fine prenotazione: ");
            anno = scanner.nextInt();

            if (anno >= LocalDate.now().getYear()) {

                break;

            }

            System.out.println("ANNO NON VALIDO");
            return;
        }

        while (true) {

            System.out.print("Numero mese fine prenotazione: ");
            mese = scanner.nextInt();

            if (mese <= 12 && mese > 0) {

                break;

            }

            System.out.println("Mese non valido");

        }

        while (true) {

            System.out.print("Giorno fine prenotazione: ");
            giorno = scanner.nextInt();

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

        dataFine = LocalDate.of(anno, mese, giorno);

        while (true) {

            System.out.println("Prezzo settimanale: ");
            prezzo = scanner.nextDouble();

            if (prezzo > 0)

                break;

            System.out.println("Prezzo non valido");

        }

        Abitazione abitazione = new Abitazione(prezzo, dataInizio, dataFine, nome, indirizzo, numeroLocali, numeroPostiLetto, piano);
        dataBase.addCasa(host, abitazione);

    }


    public void inserisciAbitazione(Host host, Abitazione abitazione) {

        dataBase.addCasa(host, abitazione);

    }


}
