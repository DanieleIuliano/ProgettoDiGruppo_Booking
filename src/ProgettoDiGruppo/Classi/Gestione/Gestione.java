package ProgettoDiGruppo.Classi.Gestione;

import ProgettoDiGruppo.Classi.Utente.Host;
import ProgettoDiGruppo.Classi.Utente.Utente;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Gestione {

    private final DataBase dataBase = DataBase.getInstance();
    private final Scanner scanner = new Scanner(System.in);

    public void registrazione() {

        String nomeUtente;
        String cognomeUtente;
        String email;
        String password;
        String indirizzo;

        System.out.println("Procediamo con la registrazione!");
        while (true) {

            System.out.print("Il tuo nome: ");
            nomeUtente = scanner.nextLine();

            if (nomeUtente.length() > 2) {

                break;

            }

            System.out.println("ATTENZIONE NOME TROPPO CORTO! ");
        }

        while (true) {

            System.out.print("Il tuo cognome: ");
            cognomeUtente = scanner.nextLine();

            if (cognomeUtente.length() > 2) {

                break;

            }

            System.out.println("ATTENZIONE COGNOME TROPPO CORTO! ");

        }

        while (true) {

            System.out.print("Il tuo indirizzo: ");
            indirizzo = scanner.nextLine();

            if (indirizzo.length() > 2) {

                break;

            }

            System.out.println("ATTENZIONE INDIRIZZO TROPPO CORTO! ");

        }

        while (true) {

            System.out.print("Email: ");
            Pattern patternEmail = Pattern.compile("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}");

            //while ((email = scanner.nextLine()).equals("") || email.contains(" "));

            email = scanner.nextLine();

            if(patternEmail.matcher(email).find())

                break;

            if(dataBase.getUtentiInseriti().containsKey(email)){

                System.out.println("ATTENZIONE EMAIL GIA' INSERITA");
                continue;

            }

            System.out.println("Email non valida, riprova");

        }

        while (true) {

            System.out.print("Password: ");
            password = scanner.next();

            if (password.length() < 8) {

                System.out.println("Password troppo corta");
                continue;

            }

            break;

        }

        Utente utente = new Utente(nomeUtente, cognomeUtente, email, indirizzo, password);
        dataBase.addUtente(utente);

    }

    public Utente accesso() {

        String email;
        String password;

        while (true) {

            System.out.print("Email: ");
            Pattern patternEmail = Pattern.compile("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}");
            email = scanner.next();

            if(patternEmail.matcher(email).find())

                break;

            System.out.println("Email errata");

        }

        while (true) {

            System.out.print("Password: ");
            password = scanner.next();

            if (password.length() < 8) {

                System.out.println("FORMATO PASSWORD ERRATO");
                continue;

            }

            break;

        }

        if(dataBase.getUtentiInseriti().containsKey(email))

            if(dataBase.getUtentiInseriti().get(email).getPassword().equalsIgnoreCase(password)) {

                return dataBase.getUtentiInseriti().get(email);

            }

        return null;

    }

    public boolean richiestaHost(String email){

        Utente utente = dataBase.getUtentiInseriti().get(email);
        if(utente == null){

            return false;

        }

        Host host = new Host(utente.getNome(), utente.getCognome(), utente.getEmail(), utente.getIndirizzo(), utente.getPassword());
        dataBase.addHost(host);
        return true;
    }

    public Host accessoHost(){

        String email;
        String password;

        while (true) {

            System.out.print("Email: ");
            Pattern patternEmail = Pattern.compile("[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,3}");
            email = scanner.next();

            if(patternEmail.matcher(email).find())

                break;

            System.out.println("Email errata");

        }

        if(!richiestaHost(email))

            return null;

        while (true) {

            System.out.print("Password: ");
            password = scanner.next();

            if (password.length() < 8) {

                System.out.println("FORMATO PASSWORD ERRATO");
                continue;

            }

            break;

        }

        if(dataBase.getHostInseriti().containsKey(email.toLowerCase(Locale.ROOT)))

            if(dataBase.getHostInseriti().get(email).getPassword().equalsIgnoreCase(password)) {

                return dataBase.getHostInseriti().get(email);

            }

        return null;


    }

}
