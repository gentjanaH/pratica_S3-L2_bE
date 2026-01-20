package gentjanahani.dao;

import gentjanahani.entities.Evento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EventoDAO {
    //Questa classe ci serve per interagire con il DB.
    private final EntityManager entityManager;

    public EventoDAO(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    public void save(Evento newEvento){
        //1-Chiediamo all'EntityManager di creare una transazione
        EntityTransaction transaction=entityManager.getTransaction();

        //2-Facciamo partire la transazione
        transaction.begin();

        //3-Aggiungiamo il newEvento al PersistenceContext.
        entityManager.persist(newEvento);

        // 4. Per rendere effettiva l'operazione devo fare il COMMIT della transazione
transaction.commit();

        // 5. Log di avvenuto salvataggio
        System.out.println("L'evento " + newEvento.getTitolo()+ " è stato salvato corretamente.");
    }
}
