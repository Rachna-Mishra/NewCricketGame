package com.rachna;

public class PlayerDetail {

    public enum PlayerType
    {
        BATSMAN,BOWLER;
    }

    private String playerName;
    private int t_shirtNumber;
    private Teams teamName;
    private  PlayerDetail.PlayerType playerType;
    private int totalBallsPlayed;
    private  int totalWicketsTaken;
    private int totalRunsScored;

    public int getT_shirtNumber() {
        return t_shirtNumber;
    }

    public void setT_shirtNumber(int t_shirtNumber) {
        this.t_shirtNumber = t_shirtNumber;
    }

    public int getTotalRunsScored() {
        return totalRunsScored;
    }

    public PlayerDetail setTotalRunsScored(int totalRunsScored) {
        this.totalRunsScored = totalRunsScored;
        return this;
    }

    public String getPlayerName() {
        return playerName;
    }

    public PlayerDetail setPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    public Teams getTeamName() {
        return teamName;
    }

    public PlayerDetail setTeamName(Teams teamName) {
        this.teamName = teamName;
        return this;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public PlayerDetail setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
        return this;
    }

    public int getTotalBallsPlayed() {
        return totalBallsPlayed;
    }

    public PlayerDetail setTotalBallsPlayed(int totalBallsPlayed) {
        this.totalBallsPlayed = totalBallsPlayed;
        return this;
    }

    public int getTotalWicketsTaken() {
        return totalWicketsTaken;
    }

    public PlayerDetail setTotalWicketsTaken(int totalWicketsTaken) {
        this.totalWicketsTaken = totalWicketsTaken;
        return this;
    }
    public  String getUniquePlayerKey(PlayerDetail player)
    {
        return player.getTeamName().name()+"_"+player.getPlayerName();
    }
}

