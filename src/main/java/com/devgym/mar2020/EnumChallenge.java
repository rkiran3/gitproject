package com.devgym.mar2020;

/*
I define a class follows (the ##REPLACE## tag will be replaced with the code found in each choice):
*/
public class EnumChallenge {
    public static void main(String[] args) {
        DragonBalls dragonBall1 = DragonBalls.FIFTH;
        DragonBalls dragonBall2 = DragonBalls.SECOND;
        DragonBalls dragonBalls[] = DragonBalls.FIRST.SECOND.THIRD.FOURTH.SIXTH.invokeShaneLong();
    
        //##REPLACE## 
        System.out.println((dragonBall2 == dragonBall1) ? "Same Dragonball" : "New Dragonball");
        System.out.println(dragonBall2);
    }

    enum DragonBalls implements Invoker {
        FIRST, SECOND, THIRD, FOURTH, FIFTH, SIXTH, SEVENTH;
        public DragonBalls[] invokeShaneLong() {
            return DragonBalls.values();
        }
    }

    interface Invoker {
        DragonBalls[] invokeShaneLong();
    }
}

/*
 * Mark a choice as correct if after executing these statements....

javac EnumChallenge.java
java EnumChallenge

The following text is displayed:

New Dragonball
FOURTH

*/