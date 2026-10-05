package Lezione1.ReadWriteFile;
/*
In questa file contiene:
 - come scrivere testo su un file esterno tramite PrintWriter.
 - le differenze tra tre diversi approcci di lettura dello stesso file:
    - BufferedReader (ideale per grandi flussi di dati)
    - Scanner (comodo per il parsing basato su token o righe)
    - Files.readAllLines (che carica l'intero file in una lista in un'unica operazione)
*/

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class TestFile {
    // Il metodo main lancia IOException per delegare la gestione degli errori di lettura/scrittura
    static void main(String[] args) throws IOException {

        // --- 1. SCRITTURA SU FILE ---
        // Crea (o sovrascrive) un file di testo nel percorso specificato
        PrintWriter writer = new PrintWriter("./resources/files/output.txt");
        writer.println("Hello World");      // Scrivere la prima riga del file
        writer.println("Seconda riga");     // Scrivere la seconda riga del file
        writer.close();                     // Chiudere il flusso e salva definitivamente i dati sul disco

        // --- 2. Lettura con BUFFEREDREADER
        System.out.println("Lettura con BufferedReader:");
        // Apre il file combinando FileReader (lettura a caratteri) e BufferedReader (lettura efficiente a blocchi
        BufferedReader reader = new BufferedReader(new FileReader("./resources/files/output.txt"));
        String line;
        // Legge il file ripa per riga finché readline() non restituisce null (fine del file)
        while ((line = reader.readLine()) != null)
            System.out.println(line);   // Stampa la riga letta
        reader.close();                 // Chiudere il lettore liberando la risorsa

        // --- 3.LETTURA CON SCANNER ---
        System.out.println("Lettura con Scanner:");
        // inizializza uno Scanner passando un oggetto di tipo File
        Scanner scanner = new Scanner(new File("./resources/files/output.txt"));
        // Continua a ciclare finché lo scanner rileva la presenza di una riga successiva
        while (scanner.hasNextLine()) {
            String newLine = scanner.nextLine();    // Estrae la riga corrente come stringa
            System.out.println(newLine);            // Stampa la riga
        }
        scanner.close();                            // Chiudere lo scanner

        // --- 4.LETTURA CON FILES (NIO) ---
        System.out.println("Lettura con File:");
        // Metodo moderno e immediato: legge tutte le righe del file in un colpo solo
        // e le inserisce all'interno di una List di Stringhe
        List<String> righe = Files.readAllLines(Paths.get("./resources/files/output.txt"));
        // Itera sulla lista stampando ogni singola riga caricata in memoria
        for (String riga : righe) {
            System.out.println(riga);
        }
    }
}
