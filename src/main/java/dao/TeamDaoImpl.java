package dao;

import model.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class TeamDaoImpl implements TeamDao{

    private final EntityManagerFactory factory;

    public TeamDaoImpl(EntityManagerFactory factory) {
        this.factory = factory;
    }

    @Override
    public void save(Team team) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(team);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public boolean isTeamPresent(Team team) {
        return false;
    }
}
