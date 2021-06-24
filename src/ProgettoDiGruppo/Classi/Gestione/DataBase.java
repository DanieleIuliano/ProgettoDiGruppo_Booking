package ProgettoDiGruppo.Classi.Gestione;

import ProgettoDiGruppo.Classi.Abitazione.Abitazione;
import Host;
import Prenotazione;
import ProgettoDiGruppo.Classi.Utente.Utente;

import java.util.*;

public class DataBase {

    Map<String, Set<Abitazione>> caseInserite = new HashMap<>(); // STRING == CODICE HOST
    Map<String, Utente> utentiInseriti = new HashMap<>(); //STRING == EMAIL UTENTE
    Map<String, Host> hostInseriti = new HashMap<>();
    Map<String, Set<Prenotazione>> prenotazioniEffettuate = new HashMap<>();


}
