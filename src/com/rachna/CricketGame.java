package com.rachna;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CricketGame {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of Matches do you want to organise");
        int noOfMatches=sc.nextInt();
        List<ScoreBoard> list=new ArrayList<>();
        while(noOfMatches-->0)
        {
            //System.out.println("===============Match "+"Started=====================");
            System.out.println("Enter number of overs for this match");
            int noOfOvers=sc.nextInt();

            System.out.println("Number of teams participating in this match range upto 4");
            int noOfTeams=sc.nextInt();

            ScoreBoard scoreBoard=new ScoreBoard();
            list.add(scoreBoard);

            MatchController m=new MatchController();
            Match match=new Match(noOfOvers,scoreBoard);

            // Selection Of Teams
            TeamsSelected ts=new TeamsSelected(noOfTeams);
            List<Teams> selectedTeams=ts.getSelectedTeams();

            System.out.println("-------------Match Started between Teams "+" "+selectedTeams.get(0)+" and "+selectedTeams.get(1)+"-----------------");

            //------------------Match Tossed between selected Teams-------------------
            Teams tossWonTeamCode=(GeneralUtils.getWinner()==0)? selectedTeams.get(0): selectedTeams.get(1);
            Teams selectedTeamForBatting=selectedTeams.get(0);
            Teams selectedTeamForBowling=selectedTeams.get(1);
            System.out.println("------------Team "+tossWonTeamCode+" Won the Toss------------");

            String batOrBowl=(GeneralUtils.getWinner()==0)?GeneralUtils.Constants.BATTING.name():GeneralUtils.Constants.BOWLING.name();
            System.out.println("------------Team "+tossWonTeamCode+" Opted for "+batOrBowl+"---------------");

            if(tossWonTeamCode==selectedTeams.get(1))
            {
                if(batOrBowl.equalsIgnoreCase("Batting"))
                {
                    selectedTeamForBatting=selectedTeams.get(1);
                    selectedTeamForBowling=selectedTeams.get(0);
                }
                else
                {
                    selectedTeamForBatting=selectedTeams.get(0);
                    selectedTeamForBowling=selectedTeams.get(1);
                }
            }
            else
            {
                if(batOrBowl.equalsIgnoreCase("Bowling"))
                {
                    selectedTeamForBatting=selectedTeams.get(1);
                    selectedTeamForBowling=selectedTeams.get(0);
                }
            }

            /* -------Adding Players detail Of Playing Teams in scoreBoard --------- */
            m.addPlayersDetail(scoreBoard,selectedTeamForBatting);
            m.addPlayersDetail(scoreBoard,selectedTeamForBowling);

            //----------------------------Match Started-----------------
            System.out.println(m.matchStarted(match,selectedTeamForBatting,selectedTeamForBowling));

            //------------------Showing ScoreBoard Details------------------------
            scoreBoard.displayScoreBoard(scoreBoard,selectedTeamForBatting,selectedTeamForBowling);
            System.out.println();
        }
        System.out.println("========================All Matches ScoreBoard==========================");
        int matchNumber=1;
        for(ScoreBoard list1:list)
        {
            System.out.println("==============Match "+matchNumber+" ScoreBoard===============");
            System.out.println();
            System.out.println("Team_Name Player_Name Player_Type Total_Run Total_Wickets Total_Balls_Played");
            list1.displayMatchBoard(list1);
            matchNumber++;
            System.out.println();
        }
    }
}
