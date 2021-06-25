package ProgettoDiGruppo.Classi.Gestione;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;
import ProgettoDiGruppo.Classi.Utente.Host;
import ProgettoDiGruppo.Classi.Utente.Utente;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class DataBase {

    private Map<String, Set<Abitazione>> caseInseriteDallHost; // STRING == CODICE HOST
    private Map<String, Set<Abitazione>> casePerComune; //STRING, serve per facilitare la ricerca in AzioniUtente nel metodo ritronaStanzeDalleSpecifiche
    private Map<String, Utente> utentiInseriti; //STRING == EMAIL UTENTE
    private Map<String, Host> hostInseriti;

    private int mediaPostiLetto;
    private int numeroAbitazioniInserite = 0;

    private static DataBase instance = null;

    private DataBase() {

        caseInseriteDallHost = new HashMap<>(); // STRING == CODICE HOST
        utentiInseriti = new HashMap<>(); //STRING == EMAIL UTENTE
        hostInseriti = new HashMap<>();
        casePerComune = new HashMap<>();

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

        Set<Abitazione> abitazioni = caseInseriteDallHost.getOrDefault(host.getEmail(), new HashSet<>());
        abitazioni.add(abitazione);
        caseInseriteDallHost.put(host.getEmail(), abitazioni);

        mediaPostiLetto += abitazione.getNumeroPostiLetto();
        numeroAbitazioniInserite++;

    }

    public void addCasaPerComune(String comune, Abitazione abitazione) {

        Set<Abitazione> abitazioni = casePerComune.getOrDefault(comune, new HashSet<>());
        abitazioni.add(abitazione);
        casePerComune.put(comune, abitazioni);

    }

    public int mediaPostiLetto() {

        return (mediaPostiLetto / numeroAbitazioniInserite);

    }

    public Abitazione casaGettonata() {
        LocalDate dataAttuale = LocalDate.now();
        Month mesePrecendente = dataAttuale.minusMonths(1).getMonth();
        Abitazione abitazioGettonata = null;
        int max = 0;
        for (String emailHost : caseInseriteDallHost.keySet()) {
            for (Abitazione abit : caseInseriteDallHost.get(emailHost)) {
                if (abit.getMesiNumPrenotazioni().get(mesePrecendente) > max) {
                    max = abit.getMesiNumPrenotazioni().get(mesePrecendente);
                    abitazioGettonata = abit;
                }
            }
        }
        return  abitazioGettonata;

    }


    public Map<String, Set<Abitazione>> getCaseInseriteDallHost() {
        return caseInseriteDallHost;
    }

    public Map<String, Utente> getUtentiInseriti() {
        return utentiInseriti;
    }

    public Map<String, Host> getHostInseriti() {
        return hostInseriti;
    }

    public Map<String, Set<Abitazione>> getCasePerComune() {

        return casePerComune;

    }


}
