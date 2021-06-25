package ProgettoDiGruppo.Classi.Utente;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Host extends Utente {

    private String codiceHost;
    private int numeroPrenotazioni = 0;
    private boolean superHost = false;
    private Set<Abitazione> abitazioni = new HashSet<>();

    public Host(String nome, String cognome, String email, String indirizzo,String password) {

        super(nome, cognome, email, indirizzo,password);
        codiceHost = UUID.randomUUID().toString();

    }

    public Host(Utente utente) {

        super(utente.getNome(), utente.getCognome(), utente.getEmail(), utente.getIndirizzo(), utente.getPassword());
        codiceHost = UUID.randomUUID().toString();

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

    public void addNumeroPrenotazioni() {

        numeroPrenotazioni++;

        if(numeroPrenotazioni == 100)

            superHost = true;

    }

    public boolean isSuperHost() {
        return superHost;
    }

    public void setSuperHost(boolean superHost) {
        this.superHost = superHost;
    }




}
