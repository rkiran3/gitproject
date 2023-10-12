package com.devgym.apr2020;

//import java.util.Optional;
//import java.util.stream.Collectors;

/* *Java 10 or higher
 *  
 */
public class OptionalChallenge {
    static String finalZionValue = "";
    static int matrixCount = 0;

    public static void main(String... matrix) {

    }
}
/*
 * public static void main(String... matrix) {
 * Optional<String> optFromMatrix = Optional.ofNullable(finalZionValue);
 * 
 * String agentSmith = "Virus";
 * 
 * finalZionValue +=
 * Optional.ofNullable(agentSmith).orElse(getVisionFromOracle());
 * finalZionValue +=
 * optFromMatrix.orElseGet(OptionalChallenge::getVisionFromOracle);
 * 
 * finalZionValue += matrixCount;
 * String neo = null;
 * 
 * try {
 * Optional.ofNullable(neo).orElseThrow(IllegalArgumentException::new);
 * } catch (Exception exception) {
 * finalZionValue += Optional.ofNullable(neo).or(() ->
 * Optional.of("theOne")).get();
 * }
 * 
 * finalZionValue += Optional.of("trinity").stream().map(String::toUpperCase)
 * .filter(trinity -> trinity.equals("TRINITY")).collect(Collectors.joining());
 * 
 * System.out.println(finalZionValue);
 * }
 * 
 * static String getVisionFromOracle() {
 * matrixCount++;
 * finalZionValue = "KeyMaker";
 * return "Architect";
 * }
 * 
 * }
 * 
 * What will happen after the main method is executed as follows?
 * 
 * javac OptionalChallenge.java
 * java OptionalChallenge
 * 
 * Choices - Select all that apply.
 * Choice 1
 * 
 * keyMakerVirus1theOne
 * 
 * Choice 2
 * 
 * keyMakerVirusArchitect2theOneTRINITY
 * 
 * Choice 3
 * 
 * Virus1theOneTRINITY
 * 
 * Choice 4
 * 
 * keyMakerVirus2theOneTRINITY
 */
