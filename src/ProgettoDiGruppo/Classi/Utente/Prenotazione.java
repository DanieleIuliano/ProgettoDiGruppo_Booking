package ProgettoDiGruppo.Classi.Utente;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;


import java.time.LocalDate;

import java.util.Objects;
import java.util.UUID;

public class Prenotazione {

    private String id;
    private String emailUtente;
    private Abitazione abitazione;


    /******* Costruttore *******/

    public Prenotazione(LocalDate dataInizio, LocalDate dataFine, String emailUtente, Abitazione abitazione) {

        id = UUID.randomUUID().toString();
        abitazione.getDurata().rimuoviDatePrenotate(dataInizio, dataFine);
        abitazione.setNumDiVoltePrenotata();
        add1Mese(dataInizio,dataFine);
        this.emailUtente = emailUtente;
        this.abitazione = abitazione;

    }

    /******* Getter e Setter *******/
    //CONTROLLI, TO STRING /DATA INIZIO E FINE

    public Abitazione getAbitazione() {
        return abitazione;
    }

    public void setAbitazione(Abitazione abitazione) {
        this.abitazione = abitazione;
    }


    public String getId() {
        return id;
    }


    public String getEmailUtente() {
        return emailUtente;
    }

    public void setEmailUtente(String emailUtente) {
        this.emailUtente = emailUtente;
    }


    /******* Equals e Hashcode *******/
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

    public void add1Mese(LocalDate dataInizioPren, LocalDate dataFinePren){
        if(dataInizioPren.getMonth().equals(dataFinePren.getMonth())){
            int numPrenMeseIn = abitazione.getMesiNumPrenotazioni().get(dataInizioPren.getMonth());
            abitazione.getMesiNumPrenotazioni().put(dataInizioPren.getMonth(), numPrenMeseIn +1);
            return;
        }else {
            int numPrenMeseFin = abitazione.getMesiNumPrenotazioni().get(dataFinePren.getMonth());
            abitazione.getMesiNumPrenotazioni().put(dataFinePren.getMonth(),numPrenMeseFin+1);
            int numPrenMeseIn = abitazione.getMesiNumPrenotazioni().get(dataInizioPren.getMonth());
            abitazione.getMesiNumPrenotazioni().put(dataInizioPren.getMonth(), numPrenMeseIn +1);
        }
    }
}
