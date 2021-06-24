package ProgettoDiGruppo.Classi.Utente;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;

import java.util.HashSet;
import java.util.Set;

public class Host extends Utente {

    private String codiceHost;
    private int numeroPrenotazioni;
    private boolean superHost;
    private Set<Abitazione> abitazioni = new HashSet<>();

    public Host(String nome, String cognome, String email, String indirizzo, String password) {

        super(nome, cognome, email, indirizzo, password);

    }

    // Varie cose
    public String getCodiceHost() {
        return codiceHost;
    }

    public void setCodiceHost(String codiceHost) {
        this.codiceHost = codiceHost;
    }

    public int getNumeroPrenotazioni() {
        return numeroPrenotazioni;
    }

    public void setNumeroPrenotazioni(int numeroPrenotazioni) {
        this.numeroPrenotazioni = numeroPrenotazioni;
    }

    public boolean isSuperHost() {
        return superHost;
    }

    public void setSuperHost(boolean superHost) {
        this.superHost = superHost;
    }
}
