package com.rachna;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ScoreBoard {
    public Map<String, PlayerDetail> playerDetailsMap = new LinkedHashMap<>();

    public void displayScoreBoard(ScoreBoard scoreBoard, Teams team1, Teams team2) {
        System.out.println();
        System.out.println();
        System.out.println("=================TEAM 1 SCOREBOARD================");
        System.out.println("Team_Name Player_Name Player_Type Total_Run Total_Wickets Total_Balls_Played");
        show(team1);
        System.out.println();
        System.out.println();
        System.out.println("=================TEAM 2 SCOREBOARD================");
        System.out.println("Team_Name Player_Name Player_Type Total_Run Total_Wickets Total_Balls_Played");
        show(team2);
    }

    public void show(Teams team) {
        List<String> playerList = Teams.retrivePlayerList(team);
        for (String playerName : playerList) {
            displayPlayerRecord(team.name() + "_" + playerName);
        }
    }

    public void displayPlayerRecord(String key)
    {
        PlayerDetail playerDetails = playerDetailsMap.get(key);
        System.out.println(playerDetails.getTeamName() + " "
                + playerDetails.getPlayerName() + " "
                + playerDetails.getPlayerType() + " "
                + playerDetails.getTotalRunsScored() + " "
                + playerDetails.getTotalWicketsTaken() + " "
                + playerDetails.getTotalBallsPlayed());
    }

    public void updateScoreBoard(String playerName, Teams teamName, PlayerDetail.PlayerType playerType, int totalRunsScored, int totalWicketsTaken, int totalBallsPlayed)
    {
        PlayerDetail newPlayer = new PlayerDetail().
                setPlayerName(playerName).
                setTeamName(teamName).
                setPlayerType(playerType).
                setTotalRunsScored(totalRunsScored).
                setTotalWicketsTaken(totalWicketsTaken).
                setTotalBallsPlayed(totalBallsPlayed);

        String playerKey = newPlayer.getUniquePlayerKey(newPlayer);
        playerDetailsMap.put(playerKey, newPlayer);
    }

    public void displayMatchBoard(ScoreBoard list1)
    {
       for( Map.Entry<String, PlayerDetail> matchScore:list1.playerDetailsMap.entrySet())
       {
           PlayerDetail playerDetail=matchScore.getValue();
           System.out.println(playerDetail.getTeamName()+" "
                            +playerDetail.getPlayerName()+" "
                            +playerDetail.getPlayerType()+" "
                            +playerDetail.getTotalRunsScored()+" "
                            +playerDetail.getTotalWicketsTaken()+" "
                            +playerDetail.getTotalBallsPlayed());
       }
    }
}
