package ProgettoDiGruppo.Classi.Utente;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Pattern;

public class Utente {

    private String nome;
    private String cognome;
    private String email;
    private String indirizzo;
    private String password;
    private List<FeedBack> feedBacks = new LinkedList<>();
    private Queue<Prenotazione> prenotazioni = new LinkedList<>();

    /******* Costruttore *******/

    public Utente(String nome, String cognome, String email, String indirizzo, String password) {

        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.indirizzo = indirizzo;
        this.password = password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Queue<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }


    /******* toString *******/
    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'';
    }
}
