package com.rachna;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TeamsSelected {
    private int noOfTeams;
    private List<Teams> selectedTeams=new ArrayList<Teams>();

    TeamsSelected(int noOfTeams)
    {
        this.noOfTeams=noOfTeams;
    }

    // Teams are represented by Teams code(0,1,2,3,4...)
   public List<Teams> getSelectedTeams()
    {
        Random r=GeneralUtils.getRandomFunction();
        int index1=r.nextInt(noOfTeams);
        selectedTeams.add(Teams.values()[index1]);
        int index2;
        do
        {
            index2=r.nextInt(noOfTeams);
        }while(index1==index2);

        selectedTeams.add(Teams.values()[index2]);

        return selectedTeams;
    }
}
