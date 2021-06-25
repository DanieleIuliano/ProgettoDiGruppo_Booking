package ProgettoDiGruppo.Classi.Abitazione;


import ProgettoDiGruppo.Classi.Utente.FeedBack;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Abitazione extends TreeSet<Abitazione> {

    private double prezzo; // Al giorno
    private Durata durata;
    private String id;
    private String nome;
    private String indirizzo;
    private int numeroLocali;
    private int numeroPostiLetto;
    private int piano;
    private int numDiVoltePrenotata = 0;
    private String emailHost;
    private List<FeedBack> feedBacksSullAbitazione = new LinkedList<>();
    private Map<Month,Integer> mesiNumPrenotazioni = new HashMap<>();



    /******* Costruttore *******/

    public Abitazione(double prezzo, LocalDate dataInizio, LocalDate dataFine, String nome, String indirizzo, int numeroLocali, int numeroPostiLetto, int piano,  String emailHost) {
        this.prezzo = prezzo;
        this.durata = new Durata(dataInizio, dataFine);
        id = UUID.randomUUID().toString();
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.numeroLocali = numeroLocali;
        this.numeroPostiLetto = numeroPostiLetto;
        this.piano = piano;
        this.emailHost = emailHost;
    }




    /******* Getter e Setter *******/
    public Map<Month, Integer> getMesiNumPrenotazioni() {
        return mesiNumPrenotazioni;
    }

    public void setMesiNumPrenotazioni(Map<Month, Integer> mesiNumPrenotazioni) {
        this.mesiNumPrenotazioni = mesiNumPrenotazioni;
    }

    public String getEmailHost() {
        return emailHost;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(int prezzo) {
        this.prezzo = prezzo;
    }

    public Durata getDurata() {
        return durata;
    }

    public void setDurata(Durata durata) {
        this.durata = durata;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getNumeroLocali() {
        return numeroLocali;
    }

    public void setNumeroLocali(int numeroLocali) {
        this.numeroLocali = numeroLocali;
    }

    public int getNumeroPostiLetto() {
        return numeroPostiLetto;
    }

    public void setNumeroPostiLetto(int numeroPostiLettoInseritiDallaPrenotazione) {
        this.numeroPostiLetto -= numeroPostiLettoInseritiDallaPrenotazione;
    }

    public int getPiano() {
        return piano;
    }

    public void setPiano(int piano) {
        this.piano = piano;
    }

    /******* toString *******/

    @Override
    public String toString() {
        return "Abitazione{" +
                "prezzo giornaliero=" + prezzo +
                ", id='" + id + '\'' +
                ", data Inizio='" + getDurata().getDataInizio() +
                ", data Fine='"+getDurata().getDataFine() +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", numeroLocali=" + numeroLocali +
                ", numeroPostiLetto=" + numeroPostiLetto +
                ", piano=" + piano +
                ", feedBacksSullAbitazione=" + feedBacksSullAbitazione +
                '}';
    }

    /******* Equals e Hashcode *******/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abitazione that = (Abitazione) o;
        return numeroLocali == that.numeroLocali && numeroPostiLetto == that.numeroPostiLetto && piano == that.piano && Objects.equals(indirizzo, that.indirizzo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(indirizzo, numeroLocali, numeroPostiLetto, piano);
    }

    /******* CompareTo in base a numero di volte prenotate *******/
    public int compareTo(Abitazione o) {

        return Integer.compare(o.getNumDiVoltePrenotata(), getNumDiVoltePrenotata());

    }

    /******* Funzioni della classe *******/

    public int getNumDiVoltePrenotata() {
        return numDiVoltePrenotata;
    }

    public void setNumDiVoltePrenotata() {
        numDiVoltePrenotata = numDiVoltePrenotata + 1;
    }

    public void stampaGiorniDisponibili() {
        System.out.println(getDurata().toString());
    }

    public void addFeedback(String titolo, String descrizione, int punteggio){

       // feedBacksSullAbitazione.add(new FeedBack(titolo, descrizione, punteggio, this));

    }

}
