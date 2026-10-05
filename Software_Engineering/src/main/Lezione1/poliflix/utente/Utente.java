package Lezione1.poliflix.utente;

public class Utente {

    //public: elemento accessibile da qualsiasi classe
    //nessun keyword: elemento accessibili dalle classi nello stesso package
    //private: elemento accessibile solo all'interno della classe stessa

    private String username;
    private String password;

    public Utente(String u, String p){
        username = u;
        password = p;
    }

    // --- GETTER E SETTER (Metodi di accesso controllato agli attributi privati) ---
    // username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Verifica l'uguaglianza delle credenziali tra questo utente e l'altro
    // È un overload personalizzato del classico metodo equals
    public boolean equals(Utente altro) {
        boolean stessoUsername = this.username.equals(altro.username);
        boolean stessoPassword = this.password.equals(altro.password);
        return stessoUsername && stessoPassword; // Ritorna vero solo se coincidono sia username che password
    }

    // controlla che le credenziali non siano nulle
    // Utilizzato per verificare se l'utente rappresenta un utente reale o un oggetto "vuoto"
    public boolean nonNull(){
        return this.username != null && this.password != null;
    }
}
