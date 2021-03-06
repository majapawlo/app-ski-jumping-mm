package dao;

import model.Jumper;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class JumperDaoImpl implements JumperDao {

    private final EntityManagerFactory factory;

    public JumperDaoImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public void save(Jumper jumper) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(jumper);




        transaction.commit();
        entityManager.close();

    }
}
