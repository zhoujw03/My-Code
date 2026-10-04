package src.Lezione1;

import src.Lezione1.utente.*;

public class Test {
    static void main(String[] args){
        Utente u1 = new Utente("antonio","1234");
        Utente u2 = new Utente("gabriele","5678");
        Utente u3 = new Utente("gabriele","5678");

        System.out.print("Username del primo utente: ");
        System.out.println(u1.getUsername());

        System.out.print("Username del secondo utente: ");
        System.out.println(u2.getUsername());

        System.out.print("Username del terzo utente: ");
        System.out.println(u3.getUsername());
    }
}
