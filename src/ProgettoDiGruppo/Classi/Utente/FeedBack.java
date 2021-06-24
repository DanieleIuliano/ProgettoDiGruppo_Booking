package ProgettoDiGruppo.Classi.Utente;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;

public class FeedBack {

    private String id;
    private String titolo;
    private String testo;
    private int punteggio;
    private Abitazione abitazione;

    public FeedBack(String id, String titolo, String testo, int punteggio, Abitazione abitazione) {

        this.id = id;
        this.titolo = titolo;
        this.testo = testo;
        this.punteggio = punteggio;
        this.abitazione = abitazione;

    }

    //To string
    //CONTROLLI Titolo, Testo, Punteggio!!
    // Stringa univoca UUID, ELIMINARE SETTER DI ID
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }
}
