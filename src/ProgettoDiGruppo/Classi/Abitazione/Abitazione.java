package ProgettoDiGruppo.Classi.Abitazione;


import ProgettoDiGruppo.Classi.Utente.FeedBack;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Abitazione {

    private int prezzo;
    private Durata durata;
    private String id;
    private String nome;
    private String indirizzo;
    private int numeroLocali;
    private int numeroPostiLetto;
    private int piano;
    private List<FeedBack> feedBacksSullAbitazione = new LinkedList<>();

    public Abitazione(int prezzo, LocalDate dataInizio, LocalDate dataFine, String id, String nome, String indirizzo, int numeroLocali, int numeroPostiLetto, int piano) {
        this.prezzo = prezzo;
        this.durata = new Durata(dataInizio, dataFine);
        this.id = id;
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.numeroLocali = numeroLocali;
        this.numeroPostiLetto = numeroPostiLetto;
        this.piano = piano;
    }

    //Controlli, AGGIUNTA ID
    //DATA INIZIO E FINE
    //TO string

    public int getPrezzo() {
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

    public void setId(String id) {
        this.id = id;
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

    public void setNumeroPostiLetto(int numeroPostiLetto) {
        this.numeroPostiLetto = numeroPostiLetto;
    }

    public int getPiano() {
        return piano;
    }

    public void setPiano(int piano) {
        this.piano = piano;
    }

    public void stampaGiorniDisponibili(){

    }

}
