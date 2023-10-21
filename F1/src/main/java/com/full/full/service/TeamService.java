package com.full.full.service;

import com.full.full.models.Team;
import com.full.full.models.User;

import java.util.List;

public interface TeamService {
    Team createTeam(Team newTeam);
    List<Team> getAllTeams();
    Team getTeamById(Long id);
    Team updateTeam(Long id, Team updatedTeam);
    void deleteTeam(Long id);
    void addUserToTeam(Long teamId, Long userId);
    void removeMemberFromTeam(Long teamId, Long memberId);
}



