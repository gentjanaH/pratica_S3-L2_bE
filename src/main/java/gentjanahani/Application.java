package gentjanahani;

import gentjanahani.dao.EventoDAO;
import gentjanahani.entities.Evento;
import gentjanahani.entities.EventoType;
import gentjanahani.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {
    //per connetterci al DB dobbiamo aggiungere al main questo attributo e passarli il nome della PU
    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("gestione-eventipu");

    public static void main(String[] args) {
        // Oggetto speciale che gestisce tutte le interazioni con il DB
        EntityManager entityManager= emf.createEntityManager();
        EventoDAO evento=new EventoDAO(entityManager);

        Evento matrimonio=new Evento("Matrimonio Rossi", LocalDate.of(2026,6,20), "Centro tavola con rose giralosi, cristalleri Palazzo", EventoType.PRIVATO, 150);
Evento compleanno=new Evento("Dicciottesimo Martini", LocalDate.of(2026,3,8), "Torta a mezzannotte, tovagliato di carta", EventoType.PRIVATO, 50);
Evento cenaAziendale=new Evento("cena aziendale Epicode", LocalDate.of(2026, 7,22),"Cena di fine anno, menù a buffet", EventoType.PUBBLICO, 300 );
Evento pasqua=new Evento("pranzo di pasqua", LocalDate.of(2026,4,5), "Menù fisso, sono anocra aperte le prenotazioni", EventoType.PUBBLICO, 150);
        Evento natale=new Evento("pranzo di Natale", LocalDate.of(2025,12,25), "Menù fisso, sono ancora aperte le prenotazioni", EventoType.PUBBLICO, 150);
//------------------------------------SAVE--------------------------
//evento.save(matrimonio);
//evento.save(compleanno);
//evento.save(cenaAziendale);
//evento.save(pasqua);
//        evento.save(natale);

        //----------------------GET BY ID-------------------

        try{
            Evento eventoCercato=evento.getById(2);
            System.out.println(eventoCercato);
        }catch(NotFoundException exception){
            System.out.println(exception.getMessage());
        }



        //-------------------------DELETE-------------------
try{
    evento.delete(4);

}catch(NotFoundException exception){
    System.out.println(exception.getMessage());
}
    }
}
