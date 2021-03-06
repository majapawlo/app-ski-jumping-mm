package dao;

import model.Coach;

public interface CoachDao {

    void save(Coach coach);

    boolean isCoachPresent(Coach coach);
}
