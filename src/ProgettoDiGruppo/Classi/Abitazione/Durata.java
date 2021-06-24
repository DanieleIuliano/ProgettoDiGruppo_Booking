package ProgettoDiGruppo.Classi.Abitazione;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Durata {

    private LocalDate dataInizio;
    private LocalDate dataFine;


    public Durata(LocalDate dataInizio, LocalDate dataFine) {

        this.dataInizio = dataInizio;
        this.dataFine = dataFine;

    }

    /***** Getter e Setter ***/
    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }
    


}
