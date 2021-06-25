package ProgettoDiGruppo.Classi.Utente;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;


import java.awt.event.PaintEvent;
import java.time.LocalDate;

import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.UUID;

public class Prenotazione {

    private String id;
    private String emailUtente;
    private Abitazione abitazione;
    private double pagamento;
    private int numeroGiorni;


    /******* Costruttore *******/

    public Prenotazione(LocalDate dataInizio, LocalDate dataFine, String emailUtente, Abitazione abitazione) {

        numeroGiorni = Period.between(LocalDate.now().minusDays(30), LocalDate.now()).getDays();
        pagamento = abitazione.getPrezzo() * numeroGiorni;
        this.abitazione = abitazione;
        id = UUID.randomUUID().toString();
        abitazione.getDurata().rimuoviDatePrenotate(dataInizio, dataFine);
        abitazione.setNumDiVoltePrenotata();
        add1Mese(dataInizio, dataFine);
        this.emailUtente = emailUtente;


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

    public boolean equals(String abitazioneId) {

        if(abitazioneId.equals(abitazione.getId()))

            return true;

        return false;


    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void add1Mese(LocalDate dataInizioPren, LocalDate dataFinePren) {

        if (dataInizioPren.getMonth().equals(dataFinePren.getMonth())) {

            int numPrenMeseIn;

            try {

                numPrenMeseIn = abitazione.getMesiNumPrenotazioni().get(dataInizioPren.getMonth());

            }

            catch (NullPointerException e){

                abitazione.getMesiNumPrenotazioni().put(dataInizioPren.getMonth(), 1);
                numPrenMeseIn = 1;

            }
                abitazione.getMesiNumPrenotazioni().put(dataInizioPren.getMonth(), numPrenMeseIn + 1);
                return;

        } else {
            int numPrenMeseFin = abitazione.getMesiNumPrenotazioni().get(dataFinePren.getMonth());
            abitazione.getMesiNumPrenotazioni().put(dataFinePren.getMonth(), numPrenMeseFin + 1);
            int numPrenMeseIn = abitazione.getMesiNumPrenotazioni().get(dataInizioPren.getMonth());
            abitazione.getMesiNumPrenotazioni().put(dataInizioPren.getMonth(), numPrenMeseIn + 1);
        }

    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "emailUtente='" + emailUtente + '\'' +
                ", Id abitazione: " + abitazione.getId()+
                ", Nome abitazione=" + abitazione.getNome() +
                ", Prezzo giornaliero = "+ abitazione.getPrezzo()+
                ", via: "+abitazione.getIndirizzo() +
                ", numeroLocali=" + abitazione.getNumeroLocali() +
                ", numeroPostiLetto=" + abitazione.getNumeroPostiLetto() +
                ", piano=" + abitazione.getPiano() +
                ", pagamento=" + pagamento +
                ", numeroGiorni=" + numeroGiorni +
                '}';
    }

}
