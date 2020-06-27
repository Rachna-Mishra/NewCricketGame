package com.rachna;

import java.util.Scanner;

public class CricketGame
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Series do you want to organise");
        int numberOfSeries=sc.nextInt();
        while(numberOfSeries-->0)
        {
            System.out.println("Enter number of Matches do you want to organise");
            int numberOfMatches=sc.nextInt();
            System.out.println("Enter number of overs for this match");
            int numberOfOvers = sc.nextInt();
            System.out.println("Number of teams participating for this match range upto 4");
            int numberOfTeams = sc.nextInt();
            MatchController matchController=new MatchController(numberOfMatches,numberOfOvers,numberOfTeams);
            matchController.organizeMatches();
        }
    }
}
