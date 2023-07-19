package com.full.full.service;

import com.full.full.models.Team;
import com.full.full.models.User;
import com.full.full.repository.TeamRepo;
import com.full.full.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TeamServiceImpl implements TeamService {
    private final UserRepo userRepo;
    private final TeamRepo teamRepo;

    public TeamServiceImpl(UserRepo userRepo, TeamRepo teamRepo) {
        this.userRepo = userRepo;
        this.teamRepo = teamRepo;
    }

    @Override
    public Team createTeam(Team newTeam) {
        newTeam.setId(null); // This is the line that you need to change
        return teamRepo.save(newTeam);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepo.findAll();
    }

    @Override
    public Team getTeamById(Long id) {
        return teamRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Team not found with id: " + id));
    }

    @Override
    public Team updateTeam(Long id, Team updatedTeam) {
        Team existingTeam = teamRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Team not found with id: " + id));

        existingTeam.setName(updatedTeam.getName());
        // Add other properties to update as needed

        return teamRepo.save(existingTeam);
    }

    @Override
    public void deleteTeam(Long id) {
        teamRepo.deleteById(id);
    }
    @Override
    public void addUserToTeam(Long teamId, Long userId) {
        Team team = teamRepo.findById(teamId)
                .orElseThrow(() -> new NoSuchElementException("Team not found with id: " + teamId));

        User user = userRepo.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));

        user.setTeam(team);
        userRepo.save(user);
    }
    @Override
    public void removeMemberFromTeam(Long teamId, Long memberId) {
        Team team = teamRepo.findById(teamId)
                .orElseThrow(() -> new NoSuchElementException("Team not found with id: " + teamId));

        User member = userRepo.findById(memberId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + memberId));

        if (member.getTeam() != null && member.getTeam().getId().equals(teamId)) {
            member.setTeam(null);
            userRepo.save(member);
        } else {
            throw new NoSuchElementException("User with id " + memberId + " is not a member of the team with id " + teamId);
        }
    }
}





