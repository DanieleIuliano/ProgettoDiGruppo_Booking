package ProgettoDiGruppo.Classi.Abitazione;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Durata {

    private LocalDate dataInizio;
    private LocalDate dataFine;
    private List<LocalDate> dates = new ArrayList<>();

    public List<LocalDate> getDates() {
        return dates;
    }


    public Durata(LocalDate dataInizio, LocalDate dataFine) {

        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        riempiListaDate();

    }

    @Override
    public String toString() {
        return "Durata{" +
                " dates=" + dates +
                '}';
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

    public void CalendarioDisponibilita() {

    }


    public void riempiListaDate() {
        for (LocalDate d = dataInizio; !d.isAfter(dataFine); d = d.plusDays(1)) {
            dates.add(d);
        }
    }

    public boolean isDataDisponibile(LocalDate dataInizioPren, LocalDate dataFinePren){

        List<LocalDate> giorniDaPrenotare = new ArrayList<>();

        for (LocalDate d = dataInizioPren; !d.isAfter(dataFinePren); d = d.plusDays(1)) {

            giorniDaPrenotare.add(d);

        }

        if(dates.contains(giorniDaPrenotare))

            return true;

        return false;


    }

    public void rimuoviDatePrenotate(LocalDate dataInizioPren, LocalDate dataFinePren) {
        List<LocalDate> datePrenotate = new ArrayList<>();
        for (LocalDate d = dataInizioPren; !d.isAfter(dataFinePren); d = d.plusDays(1)) {
            datePrenotate.add(d);
        }
        if (dates.containsAll(datePrenotate)) {
            dates.removeAll(datePrenotate);
            System.out.println("Hai rimosso le date");
        } else System.out.println("le date scelte non sono contenute");


    }


}
