package ProgettoDiGruppo.Classi.Utente;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;
import ProgettoDiGruppo.Classi.Abitazione.Durata;

import java.time.LocalDate;

public class Prenotazione {

    private String id;
    private Durata durata;
    private String emailUtente;
    private int numeroPostiDaPrenotare;
    private Abitazione abitazione;

    public Prenotazione(String id, LocalDate dataInizio, LocalDate dataFine, String emailUtente, Abitazione abitazione, int numeroPostiDaPrenotare) {

        this.id = id;
        this.durata = new Durata(dataInizio, dataFine);
        this.emailUtente = emailUtente;
        this.abitazione = abitazione;
        this.numeroPostiDaPrenotare = numeroPostiDaPrenotare;

    }

    public int getNumeroPostiDaPrenotare() {
        return numeroPostiDaPrenotare;
    }

    public void setNumeroPostiDaPrenotare(int numeroPostiDaPrenotare) {
        this.numeroPostiDaPrenotare = numeroPostiDaPrenotare;
    }

    public Abitazione getAbitazione() {
        return abitazione;
    }

    public void setAbitazione(Abitazione abitazione) {
        this.abitazione = abitazione;
    }

    //CONTROLLI, TO STRING /DATA INIZIO E FINE

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Durata getDurata() {
        return durata;
    }

    public void setDurata(Durata durata) {
        this.durata = durata;
    }

    public String getEmailUtente() {
        return emailUtente;
    }

    public void setEmailUtente(String emailUtente) {
        this.emailUtente = emailUtente;
    }


}
