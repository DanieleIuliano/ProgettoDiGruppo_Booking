package ProgettoDiGruppo.Classi.Gestione;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;
import ProgettoDiGruppo.Classi.Utente.Host;
import ProgettoDiGruppo.Classi.Utente.Prenotazione;
import ProgettoDiGruppo.Classi.Utente.Utente;

import java.util.*;

public class DataBase {

    Map<String, Set<Abitazione>> caseInserite; // STRING == CODICE HOST
    Map<String, Utente> utentiInseriti; //STRING == EMAIL UTENTE
    Map<String, Host> hostInseriti;
    Map<String, Set<Prenotazione>> prenotazioniEffettuate;
    private static DataBase instance = null;

    private DataBase(){

        caseInserite = new HashMap<>(); // STRING == CODICE HOST
        utentiInseriti = new HashMap<>(); //STRING == EMAIL UTENTE
        hostInseriti = new HashMap<>();
        prenotazioniEffettuate = new HashMap<>();

    }

    public static DataBase getInstance(){

        if(instance == null){

            instance = new DataBase();

        }

        return instance;

    }


    public void addUtente(Utente utente){

        utentiInseriti.put(utente.getEmail(), utente);

    }
    public void addHost(Host host){

        hostInseriti.put(host.getEmail(), host);

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
