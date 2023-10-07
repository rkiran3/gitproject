# Extract a Pattern of characters from a String

Suppose we are expected to extract a sequence of characters from a String, then we can use a Pattern and specify the number we want to extract.

For example: we want to extract sequences of 3 characters in a long String of codes, we can use

        (\\p{Alpha}){3}

Above pattern will specify 3 characters, then we can use that pattern to separate the codes into batches of 3 character codes.

        import java.util.regex.*;

        String rnaSequence = "AUGUUUUCUUAAAUG";

        Pattern pattern = Pattern.compile("(\\p{Alpha}){3}");
        Matcher matcher = pattern.matcher(rnaSequence);
        
        while (matcher.find()) {
            String codon = matcher.group();
            System.out.println(codon);
        }

Example [Code](../JavaExamples/src/main/java/com/exercism/ProteinTranslator.java)

