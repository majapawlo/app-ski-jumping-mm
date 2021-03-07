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
        team.getCountry().setTeam(team);

        transaction.commit();
        entityManager.close();
    }

    @Override
    public boolean isTeamPresent(Team team) {
        return false;
    }

    @Override
    public Team find(Long id) {
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Team team = entityManager.getReference(Team.class, id);

        transaction.commit();
        entityManager.close();

        return team;
    }
}
