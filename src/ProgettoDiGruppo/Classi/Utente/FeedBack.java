package ProgettoDiGruppo.Classi.Utente;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;

import java.util.UUID;

public class FeedBack {
    private String id;
    private String titolo;
    private String testo;
    private int punteggio;
    private Abitazione abitazione;

    /******* Costruttore *******/
    public FeedBack(String titolo, String testo, int punteggio, Abitazione abitazione) {
        this.id = UUID.randomUUID().toString();
        setTitolo(titolo);
        setTesto(testo);
        setPunteggio(punteggio);
        this.abitazione = abitazione;
    }

    //To string
    //CONTROLLI Titolo, Testo, Punteggio!!

    /******* Getter e Setter *******/
    public void setTitolo(String titolo) {
        if (titolo == null) {
            System.out.println("Hai inserito un titolo errato!!");
        } else {
            this.titolo = titolo;
        }
    }


    public void setTesto(String testo) {
        if (testo == null) {
            System.out.println("Hai inserito un testo errato!!");
        } else {
            this.testo = testo;
        }
    }


    public void setPunteggio(int punteggio) {
        if (punteggio > 5 || punteggio < 0) {
            System.out.println("Hai inserito un punteggio errato!!");
        } else {
            this.punteggio = punteggio;
        }
    }

    public int getPunteggio() {
        return punteggio;
    }


    public String getId() {
        return id;
    }


    public String getTesto() {
        return testo;
    }


    public String getTitolo() {
        return titolo;
    }

    /******* ToString *******/
    @Override
    public String toString() {
        return "FeedBack{" +
                "titolo='" + titolo + '\'' +
                ", testo='" + testo + '\'' +
                ", punteggio=" + punteggio +
                '}';
    }

}
