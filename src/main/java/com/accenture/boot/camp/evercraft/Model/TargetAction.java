package com.accenture.boot.camp.evercraft.Model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TargetAction {

    protected CharacterSheet subject;
    protected CharacterSheet target;


    public TargetAction(CharacterSheet subject,CharacterSheet target)
    {
        setSubject(subject);
        setTarget(target);

    }

    public  boolean isSuccessfull(int rollNumber)
    {

               return getSubject().dieRoll(rollNumber)>=getTarget().getArmourClass();

    }
}
