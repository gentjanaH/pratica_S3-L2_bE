package gentjanahani;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    //per connetterci al DB dobbiamo aggiungere al main questo attributo e passarli il nome della PU
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("gestione-eventipu");

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
