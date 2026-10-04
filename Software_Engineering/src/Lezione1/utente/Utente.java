package src.Lezione1.utente;

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

    public boolean equals(Utente altro) {
        return username.equals(altro.username);
    }
}
