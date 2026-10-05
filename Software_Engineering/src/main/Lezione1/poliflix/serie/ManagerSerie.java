package Lezione1.poliflix.serie;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ManagerSerie {
    // Contiene l'elenco ad oggetti di tutte le serie TV disponibili nell'applicazione
    private List<Serie> serie;

    // Costruttore: riceve il percorso del file e popola la lista richiamando il metodo di importazione di Serie
    public ManagerSerie(String pathCatalogoSerie) throws IOException {
        this.serie = Serie.importaCatalogoSerieDaCsv(pathCatalogoSerie);
    }

    // --- GETTER E SETTER ---
    public List<Serie> getSerie() { return serie; }

    public void setSerie(List<Serie> serie) { this.serie = serie; }

    // Scorre il catalogo e stampa un elenco numerato delle serie con il rispettivo numero di episodi.
    public void stampaCatalogoSerie() {
        int i = 1;
        for (Serie s : serie) {
            System.out.println(i + " Titolo: " + s.getNome() + " - " + s.getEpisodi().size() + " episodi");
            i++;
        }
    }

    // Cerca una serie per nome (case-insensitive) e ne simula la riproduzione.
    public void guardaSerie(String nomeSerie) throws InterruptedException {
        Serie serieScelta = null;

        // Ricerca lineare all'interno della lista ignorando maiuscole/minuscole
        for (Serie s : serie) {
            if (s.getNome().equalsIgnoreCase(nomeSerie))
                serieScelta = s;
        }

        // Se la ricerca fallisce, interrompe il metodo con un messaggio di avviso
        if (serieScelta == null) {
            System.out.println("Serie non trovata.");
            return;
        }

        // Se la serie viene trovata, cicla ed esegue tutti gli episodi associati
        for (Episodio e : serieScelta.getEpisodi()) {
            System.out.println("Riproduzione: " + e.getTitolo() + " in corso...");
            // Mette in pausa il thread corrente per un numero di secondi pari alla durata dell'episodio
            TimeUnit.SECONDS.sleep(e.getDurata());
        }
    }
}
