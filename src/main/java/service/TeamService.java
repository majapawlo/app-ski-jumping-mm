package service;

import dao.TeamDao;
import lombok.AllArgsConstructor;
import model.Team;

@AllArgsConstructor
public class TeamService {

    private final TeamDao teamDao;

    public void saveTeam(Team team){
        if (teamDao.isTeamPresent(team)){
            System.out.println("Team already present");
        } else {
            teamDao.save(team);
        }
    }

    public Team findTeam(Long id){
        if (teamDao.find(id) != null) {
            return teamDao.find(id);
        }
        return new Team();
    }

}
