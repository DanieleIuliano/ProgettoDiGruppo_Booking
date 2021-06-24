package ProgettoDiGruppo.Classi.Utente;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;
import ProgettoDiGruppo.Classi.Abitazione.Durata;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Prenotazione {

    private String id;
    private String emailUtente;
    private int numeroPostiDaPrenotare;
    private Abitazione abitazione;

    public Prenotazione(LocalDate dataInizio, LocalDate dataFine, String emailUtente, Abitazione abitazione, int numeroPostiDaPrenotare) {

        id = UUID.randomUUID().toString();
        abitazione.getDurata().rimuoviDatePrenotate(dataInizio, dataFine);
        abitazione.setNumDiVoltePrenotata();
        this.emailUtente = emailUtente;
        this.abitazione = abitazione;
        this.numeroPostiDaPrenotare = numeroPostiDaPrenotare;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prenotazione that = (Prenotazione) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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


    public String getEmailUtente() {
        return emailUtente;
    }

    public void setEmailUtente(String emailUtente) {
        this.emailUtente = emailUtente;
    }


}
