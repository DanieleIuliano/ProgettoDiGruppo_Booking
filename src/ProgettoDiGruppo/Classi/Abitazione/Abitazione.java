package ProgettoDiGruppo.Classi.Abitazione;


import ProgettoDiGruppo.Classi.Utente.FeedBack;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

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

    public Abitazione(int prezzo, LocalDate dataInizio, LocalDate dataFine, String nome, String indirizzo, int numeroLocali, int numeroPostiLetto, int piano) {
        this.prezzo = prezzo;
        this.durata = new Durata(dataInizio, dataFine);
        id = UUID.randomUUID().toString();
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.numeroLocali = numeroLocali;
        this.numeroPostiLetto = numeroPostiLetto;
        this.piano = piano;
    }

    @Override
    public String toString() {
        return "Abitazione{" +
                "prezzo=" + prezzo +
                ", id='" + id + '\'' +
                ", durata='"+ getDurata().toString() +
                ", nome='" + nome + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", numeroLocali=" + numeroLocali +
                ", numeroPostiLetto=" + numeroPostiLetto +
                ", piano=" + piano +
                ", feedBacksSullAbitazione=" + feedBacksSullAbitazione +
                '}';
    }

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
