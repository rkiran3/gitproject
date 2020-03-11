package com.devgym.mar2020;

public class FlowControlChallenge {
      public static void main(String... doYourBest) {
         boolean isBarneyAlcoholic = true;
         boolean isHomerFat = true;
         String result = "";

         if (isHomerFat = false | (isBarneyAlcoholic = false)) {
             result += "1";
          }
          if (isHomerFat || isBarneyAlcoholic) {
             result += "2";
          }
          if (!isHomerFat && !isBarneyAlcoholic) {
             result += "3";
          }
          if ((isHomerFat = true) & (isBarneyAlcoholic = true)) {
             result += "4";
          }
          if (isHomerFat || (isBarneyAlcoholic = false)) {
             result += "5";
          }
         System.out.println(result + isHomerFat + isBarneyAlcoholic);
      }
}
/*
Mark a choice as correct if after executing these statements....

javac FlowControlChallenge.java
java FlowControlChallenge

The following text is displayed:

345truetrue

1:
if (isHomerFat = false | (isBarneyAlcoholic = false)) {
   result += "1";
}
if (isHomerFat || isBarneyAlcoholic) {
   result += "2";
}
if (!isHomerFat && !isBarneyAlcoholic) {
   result += "3";
}
if ((isHomerFat = true) & (isBarneyAlcoholic = true)) {
   result += "4";
}
if (isHomerFat || (isBarneyAlcoholic = false)) {
   result += "5";
}
 * 
 */
