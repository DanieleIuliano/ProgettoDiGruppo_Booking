package ProgettoDiGruppo.Classi.Utente;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;


import java.awt.event.PaintEvent;
import java.time.LocalDate;
<<<<<<< HEAD

=======
import java.time.Period;
import java.time.temporal.ChronoUnit;
>>>>>>> main
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

<<<<<<< HEAD
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
=======

    @Override
    public String toString() {
        return "Prenotazione{" +
                "emailUtente='" + emailUtente + '\'' +
                ", abitazione=" + abitazione +
                ", pagamento=" + pagamento +
                ", numeroGiorni=" + numeroGiorni +
                '}';
>>>>>>> main
    }
}
