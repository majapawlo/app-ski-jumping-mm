import dao.SessionConnector;
import model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory factory = SessionConnector.createFactory(Country.class, Jumper.class, Jumps.class,
                Coach.class, Hill.class, Competition.class, Record.class, Team.class);

        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();


        transaction.commit();
        entityManager.close();

    }
}
