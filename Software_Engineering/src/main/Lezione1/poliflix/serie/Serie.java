package Lezione1.poliflix.serie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Serie {
    String nome;
    private List<Episodio> episodi;

    // Costruttore: inizializza il nome e crea una lista vuota pronta a ricevere gli episodi
    public Serie(String nome) {
        this.nome = nome;
        this.episodi = new ArrayList<>();
    }

        // --- GETTER E SETTER ---

    public List<Episodio> getEpisodi() {
        return episodi;
    }

    public void setEpisodi(List<Episodio> episodi) {
        this.episodi = episodi;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Cerca una serie specifica per nome all'interno di una lista data.
    // Ritorna l'oggetto Serie se trovato, altrimenti ritorna null
    public static Serie serieEsistenteInLista(List<Serie> listSerie, String nomeSerie) {
        for (Serie s : listSerie) {
            if (s.getNome().equals(nomeSerie))
                return s;
        }
        return null;
    }

    //Legge un file CSV strutturato come: NomeSerie;TitoloEpisodio;Durata
    //Genera e popola la lista delle Serie TV convertendo il testo in oggetti.
    public static List<Serie> importaCatalogoSerieDaCsv(String pathFile) throws IOException {
        // Legge tutte le linee del CSV tramite la libreria NIO
        List<String> righe = Files.readAllLines(Path.of(pathFile));
        List<Serie> nuoveSerie = new ArrayList<>();

        // Itera riga per riga sul file letto
        for (String riga : righe) {
            String rigaPulita = riga.trim(); // Rimuove spazi vuoti superflui a inizio/fine riga
            String[] campi = rigaPulita.split(";"); // Divide la riga in array usando il punto e virgola come separatore

            String nomeSerie = campi[0].trim(); // Il primo elemento è il nome della serie

            // Crea l'oggetto Episodio estraendo titolo (campi[1]) e durata convertita in intero (campi[2])
            Episodio nuovoEpisodio = new Episodio(campi[1].trim(), Integer.parseInt(campi[2].trim()));

            // Controlla se la serie in questione è già stata creata e inserita nella lista nei cicli precedenti
            Serie serieEsistente = serieEsistenteInLista(nuoveSerie, nomeSerie);

            if (serieEsistente != null) {
                // Se la serie esiste già, aggiunge semplicemente il nuovo episodio alla sua lista interna
                serieEsistente.getEpisodi().add(nuovoEpisodio);
            } else {
                // Se è la prima volta che si incontra questa serie:
                Serie nuovaSerie = new Serie(nomeSerie);    // 1. Crea la nuova istanza della serie
                nuovaSerie.getEpisodi().add(nuovoEpisodio); // 2. Le associa l'episodio corrente
                nuoveSerie.add(nuovaSerie);                 // 3. Aggiunge la nuova serie al catalogo globale
            }
        }
        return nuoveSerie; // Ritorna l'intera collezione di oggetti pronti
    }
}
