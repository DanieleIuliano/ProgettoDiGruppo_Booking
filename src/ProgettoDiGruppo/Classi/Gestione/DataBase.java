package ProgettoDiGruppo.Classi.Gestione;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;
import ProgettoDiGruppo.Classi.Utente.Host;
import ProgettoDiGruppo.Classi.Utente.Prenotazione;
import ProgettoDiGruppo.Classi.Utente.Utente;

import java.util.*;

public class DataBase {

    private Map<String, Set<Abitazione>> caseInserite; // STRING == CODICE HOST
    private Map<String, Utente> utentiInseriti; //STRING == EMAIL UTENTE
    private Map<String, Host> hostInseriti;
    private Map<String, Set<Prenotazione>> prenotazioniEffettuate;
    private int mediaPostiLetto;
    private int numeroAbitazioniInserite = 0;

    private static DataBase instance = null;

    private DataBase() {

        caseInserite = new HashMap<>(); // STRING == CODICE HOST
        utentiInseriti = new HashMap<>(); //STRING == EMAIL UTENTE
        hostInseriti = new HashMap<>();
        prenotazioniEffettuate = new HashMap<>();

    }

    public static DataBase getInstance() {

        if (instance == null) {

            instance = new DataBase();

        }

        return instance;

    }


    public void addUtente(Utente utente) {

        utentiInseriti.put(utente.getEmail(), utente);

    }

    public void addHost(Host host) {

        hostInseriti.put(host.getEmail(), host);

    }

    public void addCasa(Host host, Abitazione abitazione) {

        caseInserite.put(host.getEmail(), Collections.singleton(abitazione));
        mediaPostiLetto += abitazione.getNumeroPostiLetto();
        numeroAbitazioniInserite++;

    }

    public int mediaPostiLetto(){

        return (mediaPostiLetto / numeroAbitazioniInserite);

    }


    public Map<String, Set<Abitazione>> getCaseInserite() {
        return caseInserite;
    }

    public Map<String, Utente> getUtentiInseriti() {
        return utentiInseriti;
    }

    public Map<String, Host> getHostInseriti() {
        return hostInseriti;
    }

    public Map<String, Set<Prenotazione>> getPrenotazioniEffettuate() {
        return prenotazioniEffettuate;
    }
}
