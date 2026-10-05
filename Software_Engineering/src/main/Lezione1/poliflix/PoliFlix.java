package Lezione1.poliflix;

import Lezione1.poliflix.utente.ManagerUtenti;
import Lezione1.poliflix.serie.ManagerSerie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PoliFlix {
    // Il main lancia eccezioni per la gestione dei file (IOException) e per le pause temporali (InterruptedException)
    static void main(String[] args) throws IOException, InterruptedException {

        // Flag booleano per controllare il ciclo di vita principale dell'applicazione
        boolean running = true;

        // Istanziazione tramite Composizione dei due gestori fondamentali del sistema
        ManagerUtenti managerUtenti = new ManagerUtenti(new ArrayList<>()); // Inizializza con una lista di utenti vuota
        ManagerSerie managerSerie = new ManagerSerie("./resources/files/series.csv"); // Carica il catalogo dal CSV

        System.out.println("--------------------------");
        System.out.println("Poliflix Warmup");
        System.out.println("--------------------------");

        // Loop principale dell'applicazione
        while (running) {
            // CONTROLLO DELLO STATO: Verifica se c'è un utente correntemente loggato
            if (managerUtenti.loginEffettuato()) {
                // --- MENU PER UTENTE LOGGATO ---
                managerUtenti.benvenutoUtente(); // Stampa il messaggio di bentornato personalizzato

                System.out.println("Seleziona un'opzione:");
                System.out.println("1. Elenco Serie Disponibili");
                System.out.println("2. Guarda Serie");
                System.out.println("3. Esci");

                Scanner scanner = new Scanner(System.in);
                int scelta = Integer.parseInt(scanner.nextLine()); // Legge l'input numerico dell'utente

                switch (scelta) {
                    case 1:
                        managerSerie.stampaCatalogoSerie(); // Mostra a schermo tutte le serie caricate
                        break;
                    case 2:
                        System.out.println("Inserisci il nome della serie da guardare: ");
                        String nomeSerie = scanner.nextLine();
                        managerSerie.guardaSerie(nomeSerie); // Avvia la riproduzione simulata della serie
                        break;
                    case 3:
                        running = false; // Interrompe il ciclo per terminare il programma
                        break;
                    default:
                        // Gestione implicita di scelte non valide (ritorna al ciclo)
                }

            } else {
                // --- MENU PER UTENTE NON LOGGATO (ANONIMO) ---
                System.out.println("Seleziona un'opzione:");
                System.out.println("1. Registra nuovo utente");
                System.out.println("2. Effettua il login");
                System.out.println("3. Esci");

                Scanner scanner = new Scanner(System.in);
                int scelta = Integer.parseInt(scanner.nextLine());

                switch (scelta) {
                    case 1:
                        managerUtenti.registraUtente(); // Avvia la procedura guidata di registrazione
                        break;
                    case 2:
                        managerUtenti.login(); // Avvia la procedura guidata di autenticazione
                        break;
                    case 3:
                        running = false; // Interrompe il ciclo per uscire dall'app
                        break;
                    default:
                        // Gestione di opzioni non presenti a menu
                }
            }
        }

        // Messaggio finale stampato quando si esce dal ciclo dei menu
        System.out.println("--------------------------");
        System.out.println("Goodbye!");
        System.out.println("--------------------------");

    }
}
