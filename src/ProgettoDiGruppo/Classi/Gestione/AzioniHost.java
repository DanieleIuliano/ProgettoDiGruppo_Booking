package ProgettoDiGruppo.Classi.Gestione;
import java.io.*;
import java.util.Scanner;

public class AzioniHost {

    DataBase dataBase = DataBase.getInstance();
    Scanner scanner = new Scanner(System.in);

    public void inserisciAbitazione(){

        String line;
        String comune;
        String indirizzo;
        System.out.println("Comune abitazione: ");

        try(BufferedReader file = new BufferedReader(new FileReader("src/ProgettoDiGruppo/Classi/CodiciCatastali.text"))){

            while((line = file.readLine()) != null){

                System.out.print("Comune: ");
                comune = scanner.nextLine();

                if(line.contains(comune)){

                    break;

                }

                System.out.println("Comune non disponibile");

            }

        } catch (FileNotFoundException e) {

            System.out.println("FILE NON TROVATO");

        } catch (IOException e) {

            System.out.println("ERRORE IN INPUT");

        }



    }

}
