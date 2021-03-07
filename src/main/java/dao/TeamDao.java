package dao;

import model.Team;

public interface TeamDao {

    void save(Team team);
    boolean isTeamPresent(Team team);
}
