package Lezione1.poliflix.utente;

import java.util.List;
import java.util.Scanner;

public class ManagerUtenti {
    // Stato del manager: lista totale degli iscritti e sessione dell'utente corrente
    private List<Utente> utente;
    private Utente utenteLoggato;

    // Costruttore: riceve la lista esterna e inizializza l''utente loggato come oggetto
    public ManagerUtenti(List<Utente> utente) {
        this.utente = utente;
        this.utenteLoggato = new Utente(null,null);
    }

    public List<Utente> getUtente() {
        return utente;
    }

    public void setUtente(List<Utente> utente) {
        this.utente = utente;
    }

    public Utente getUtenteLoggato() {
        return utenteLoggato;
    }

    public void setUtenteLoggato(Utente utenteLoggato) {
        this.utenteLoggato = utenteLoggato;
    }

    // Metodo privato di utilità interna per verificare l'esistenza di un username nel database
    private boolean esisteUtente(String username){
        for(Utente utente : utente){
            if(utente.getUsername().equals(username)){
                System.out.println("Username già esistente!");
                return true; // Trovato un duplicato
            }
        }
        return false;   // L'username libero
    }

    // Inserire un nuovo utente nel sistema
    public void registraUtente(){
        Scanner scanner = new Scanner(System.in);
        Utente new_utente = new Utente(null,null);
        String new_username;

        // Ciclo Do-While: continua a richiedere le credenziali finché l'username inserito esiste già
        do{
            System.out.println("Inserisci username:");
            new_username = scanner.nextLine();
            new_utente.setUsername(new_username);
            System.out.println("Inserisci password:");
            new_utente.setPassword(scanner.nextLine());
        }while(esisteUtente(new_username));

        // aggiunge il nuovo utente valido alla lista globale
        this.utente.add(new_utente);

        // Feedback di conferma che recupera dinamicamente l'ultimo elemento inserito nella lista
        System.out.println("Utente " + this.getUtente().getLast().getUsername() + " registrato!");
    }

    // Gestisce la logica di login confrontando l'input con gli utenti registrati.
    public void login(){

        Scanner scanner = new Scanner(System.in);
        Utente tentativo_login = new Utente(null,null);

       // Prende in input le credenziali del tentativo di accesso
       System.out.println("Inserisci username:");
       tentativo_login.setUsername(scanner.nextLine());
        System.out.println("Inserisci password:");
        tentativo_login.setPassword(scanner.nextLine());

        // Cerca una corrispondenza esatta nella lista utente
        for(Utente utente : utente){
            if(utente.equals(tentativo_login)){
                this.utenteLoggato = utente;
                System.out.println("Login effettuato con successo!");
                return;
            }
        }

        // Messaggio eseguito solo se il ciclo termina senza aver trovato corrispondenze
        System.out.println("Username o password errato!");
    }

    // Verifica se un utente ha effettuato l'accesso controllando lo stato dell'oggetto sessione.
    public boolean loginEffettuato(){
        return this.utenteLoggato.nonNull();
    }

    // Stampa un messaggio di benvenuto a schermo
    public void benvenutoUtente(){
        System.out.println("\n\nBenvenuto " + this.utenteLoggato.getUsername() + "!");
    }
}
