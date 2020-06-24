package com.rachna;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Random;

public class Match {
    private  int noOfOvers;
    private  int totalWicketsOfTeam;
    private  String currentPlayerOnStrike;
    private  String currentPlayerOnPitch;
    private  int totalScoreOfPLayerOnStrike=0;
    private  int totalScoreOfPlayerOnPitch=0;
    private  int totalBallsByPlayerOnStrike=0;
    private  int totalBallsByPlayerOnPitch=0;
    private  String currentBowler;
    private  int totalWicketsOfBowler;
    private ScoreBoard scoreBoard;

    Match(int noOfOvers,ScoreBoard scoreBoard) {
        this.noOfOvers = noOfOvers;
        this.scoreBoard=scoreBoard;
    }

    public int calculateScore(Teams teamPlaying) {

        int score = 0;
        totalWicketsOfTeam = 0;
        totalScoreOfPLayerOnStrike=0;
        totalScoreOfPlayerOnPitch=0;
        totalBallsByPlayerOnStrike=0;
        totalBallsByPlayerOnPitch=0;
        totalWicketsOfBowler=0;

        List<String> playerList = Teams.retrivePlayerList(teamPlaying);
        int sequenceNo = 0;
        currentPlayerOnStrike = playerList.get(sequenceNo++);
        currentPlayerOnPitch = playerList.get(sequenceNo++);

        for (int i = 1; i <= noOfOvers * 6; i++) {
            Random r = GeneralUtils.getRandomFunction();
            int run = r.nextInt(8);
            if (run!=1 && run !=3 && run!=7) {
                System.out.println(currentPlayerOnStrike + " Player is on Strike");
                totalScoreOfPLayerOnStrike+=run;
                totalBallsByPlayerOnStrike+=1;
                score += run;
            }
            else if(run==1 || run ==3){
                totalScoreOfPLayerOnStrike+=run;
                totalBallsByPlayerOnStrike+=1;
                score += run;
                swapPlayersPosition();
                System.out.println(currentPlayerOnStrike + " Player is on Strike");
            }
            else{
                System.out.println("!!!!!!!!!!!!--------------Wicket---------------!!!!!!!!!!! ");
                if(run==7)
                {
                   // System.out.println(currentPlayerOnStrike+" total score of Striker "+totalScoreOfPLayerOnStrike+" "+totalBallsByPlayerOnStrike);
                    Teams team=teamPlaying;
                    scoreBoard.updateScoreBoard(currentPlayerOnStrike,team, PlayerDetail.PlayerType.BATSMAN,totalScoreOfPLayerOnStrike,0,totalBallsByPlayerOnStrike);
                    totalScoreOfPLayerOnStrike=0;
                    totalBallsByPlayerOnStrike=0;
                }
                totalWicketsOfTeam++;
                if (sequenceNo < playerList.size())
                    currentPlayerOnStrike = playerList.get(sequenceNo++);
            }
            System.out.println("Current Score : "+score);

            if (sequenceNo >= playerList.size()) {
                System.out.println("Inning Over : No remaining players are left in the team");
                break;
            }
        }
        Teams team=teamPlaying;
        scoreBoard.updateScoreBoard(currentPlayerOnStrike,team, PlayerDetail.PlayerType.BATSMAN,totalScoreOfPLayerOnStrike,0,totalBallsByPlayerOnStrike);
        scoreBoard.updateScoreBoard(currentPlayerOnPitch,team, PlayerDetail.PlayerType.BATSMAN,totalScoreOfPlayerOnPitch,0,totalBallsByPlayerOnPitch);
        return score;
    }

    public int getTotalWickets(Teams team)
    {
        return totalWicketsOfTeam;
    }

    public void swapPlayersPosition() {
        String temp = currentPlayerOnStrike;
        currentPlayerOnStrike=currentPlayerOnPitch;
        currentPlayerOnPitch= temp;
        int tem=totalScoreOfPLayerOnStrike;
        totalScoreOfPLayerOnStrike=totalScoreOfPlayerOnPitch;
        totalScoreOfPlayerOnPitch=tem;
        int te=totalBallsByPlayerOnStrike;
        totalBallsByPlayerOnStrike=totalBallsByPlayerOnPitch;
        totalBallsByPlayerOnPitch=te;
    }
}
