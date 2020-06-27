package com.rachna;

public class PlayerDetail {

    public enum PlayerType
    {
        BATSMAN,BOWLER;
    }

    private String playerName;
    private int tshirtNumber;
    private Teams teamName;
    private  PlayerType playerType=PlayerType.BATSMAN;
    private int totalBallsPlayed=0;
    private  int totalWicketsTaken=0;
    private int totalRunsScored=0;

    PlayerDetail(int tshirtNumber,String playerName,Teams teamName)
    {
        this.tshirtNumber=tshirtNumber;
        this.playerName=playerName;
        this.teamName=teamName;
    }

    public int getTshirtNumber() {
        return tshirtNumber;
    }

    public void setTshirtNumber(int tshirtNumber) {
        this.tshirtNumber = tshirtNumber;
    }

    public int getTotalRunsScored() {
        return totalRunsScored;
    }

    public void setTotalRunsScored(int totalRunsScored) {
        this.totalRunsScored = totalRunsScored;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Teams getTeamName() {
        return teamName;
    }

    public void setTeamName(Teams teamName) {
        this.teamName = teamName;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public int getTotalBallsPlayed() {
        return totalBallsPlayed;
    }

    public void setTotalBallsPlayed(int totalBallsPlayed) {
        this.totalBallsPlayed = totalBallsPlayed;
    }

    public int getTotalWicketsTaken() {
        return totalWicketsTaken;
    }

    public void setTotalWicketsTaken(int totalWicketsTaken) {
        this.totalWicketsTaken = totalWicketsTaken;
    }

    public  String getUniquePlayerKey(PlayerDetail player)
    {
        return player.getTeamName().name()+"_"+player.getPlayerName()+"_"+getTshirtNumber();
    }
}

