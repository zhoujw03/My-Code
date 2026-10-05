package Lezione1.poliflix.serie;

public class Episodio {

    // Attributi che descrivono le proprietà di un singolo episodio
    private String titolo;
    private int durata;

    // Costruttore completo
    public Episodio(String titolo, int durata) {
        this.titolo = titolo;
        this.durata = durata;
    }

    // --- GETTER E SETTER ---

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
}
