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
        inserimentoDati();

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

    private void inserimentoDati(){

        Utente utente1 = new Utente("Raffaele", "Pellecchia","raffaelepellecchia@gmail.com", "Via tree 3", "Raffaele");
        Host host1 = new Host(utente1);
        utentiInseriti.put(utente1.getEmail(), utente1);
        hostInseriti.put(host1.getEmail(), host1);


        Utente utente2 = new Utente("Daniele", "Iuliano","danieleIuliano@gmail.com", "Via horse 3", "Daniele");
        Host host2 = new Host(utente2);
        utentiInseriti.put(utente2.getEmail(), utente2);
        hostInseriti.put(utente2.getEmail(), host2);


        Utente utente3 = new Utente("Giovanni", "Cidu","giovanniCidu@gmail.com", "Via mariss 3", "Giovanni");
        Host host3 = new Host(utente2);
        utentiInseriti.put(utente3.getEmail(), utente3);
        hostInseriti.put(host3.getEmail(), host3);

        LocalDate inizioDate =LocalDate.of(2021,10,3);
        LocalDate fineDate =LocalDate.of(2021,12,31);
        Abitazione abitazione1= new Abitazione(50.3,inizioDate,fineDate,"Appartamento a via Roma","via Roma 3",10,15,2,"raffaelepellecchia@gmail.com");

        inizioDate =LocalDate.of(2021,8,3);
        fineDate =LocalDate.of(2021,10,1);
        Abitazione abitazione2 = new Abitazione(12.3,inizioDate,fineDate,"Appartamento Puglia","Strada Rodi XXI",2,1,1,"raffaelepellecchia@gmail.com");

        inizioDate =LocalDate.of(2021,11,3);
        fineDate =LocalDate.of(2021,12,1);
        Abitazione abitazione3 = new Abitazione(21.2,inizioDate,fineDate,"Appartamento trentino","Strada treno I",2,3,1,"raffaelepellecchia@gmail.com");

        inizioDate =LocalDate.of(2021,10,3);
        fineDate =LocalDate.of(2021,10,20);
        Abitazione abitazione4 = new Abitazione(21.2,inizioDate,fineDate,"Appartamento di Giovanni","Strada no I",2,3,1,"giovanniCidu@gmail.com");

        addCasa(host1, abitazione1);
        addCasa(host1, abitazione2);
        addCasa(host1, abitazione3);
        addCasaPerComune("Napoli", abitazione1);
        addCasaPerComune("Assisi", abitazione2);
        addCasaPerComune("Campobasso", abitazione3);
        addCasa(host3, abitazione4);
        addCasaPerComune("Villachiara", abitazione4);

    }

}
