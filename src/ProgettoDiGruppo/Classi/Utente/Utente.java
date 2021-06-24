package ProgettoDiGruppo.Classi.Utente;

import java.util.LinkedList;
import java.util.List;

public class Utente {

    private String nome;
    private String cognome;
    private String email;
    private String indirizzo;
    private List<FeedBack> feedBacks = new LinkedList<>();
    private List<Prenotazione> prenotazioni = new LinkedList<>();

    public Utente(String nome, String cognome, String email, String indirizzo) {

        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.indirizzo = indirizzo;

    }
    //To string
    /******* Getter e Setter *******/
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }
}
