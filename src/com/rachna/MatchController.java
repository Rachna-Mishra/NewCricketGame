package com.rachna;

import java.util.List;

public class MatchController {
    int team1Score;
    int team2Score;
    String result;
    Match match;
    int wickets1;
    int wickets2;

    public String matchStarted(Match match, Teams team1, Teams team2)
    {
        System.out.println("----------Match Started---------------");
        System.out.println("---------Team " + team1 + " Ready for Batting----------------");
        team1Score = match.calculateScore(team1);
        wickets1 = match.getTotalWickets(team1);
        System.out.println("Total Wickets Of Team : " + wickets1);
        System.out.println();
        System.out.println("---------Now Team " + team2 + " Ready for Batting----------------");
        team2Score = match.calculateScore(team2);
        wickets2 = match.getTotalWickets(team2);
        System.out.println("Total Wickets Of Team : " + wickets2);
        System.out.println();
        printScore();
        if (team1Score > team2Score)
            result = "---------Team 1 Won----------";
        else if (team1Score < team2Score)
            result = "---------Team 2 Won----------";
        else
            result = "---------Match Tie------------";
        return result;
    }

    public void printScore() {
        System.out.println();
        System.out.println();
        System.out.println("Team1 Score : " + team1Score + " " + "Total Wickets : " + wickets1);
        System.out.println("Team2 Score : " + team2Score + " " + "Total Wickets : " + wickets2);
    }

    public void addPlayersDetail(ScoreBoard scoreBoard,Teams teamPlaying)
    {
        Teams[] teams = Teams.values();
        for (Teams team : teams) {
            if(team.equals(teamPlaying))
            {
                List<String> players=team.getPlayerList();
                for(String playerName:players)
                {
                    scoreBoard.updateScoreBoard(playerName,team, PlayerDetail.PlayerType.BATSMAN,0,0,0);
                }
                break;
            }
        }
    }
}
