package com.accenture.boot.camp.evercraft;


import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CharacterSheet {


   protected String name;
   protected String alignment;
   @Setter
   @Getter
   protected int armourClass;
   protected int hitPoints;





    public CharacterSheet(String name,String alignment) {
        setName(name);
        setAlignment(alignment);
        setArmourClass(10);
        setHitPoints(5);
    }

    public int dieRoll(int rollNumber)
    {
        if(rollNumber >1 && rollNumber<20)
        {
            return  rollNumber;
        }
        else {
            return -1;
        }
    }
}





