package com.exercism;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.*;

public class ProteinTranslator {
	public static Logger logger = Logger.getLogger(ProteinTranslator.class.getName()); 
	
	public static HashMap <String, String>proteinMap = new HashMap<>(); 
	
	public ProteinTranslator() {
		
		multiPut("Methionine", "AUG");
	}
	
	public static void multiPut(String value, String ... keys) {
		
		Arrays.asList(keys).stream()
			.map(k -> proteinMap.put(k, value))
			.collect(Collectors.toList());
		
	}
	
	List<String> translate(String rnaSequence) {
		List <String>proteinList = new LinkedList<>();
		
		// create a pattern to extract three alpha characters at a time.
		Pattern pattern = Pattern.compile("(\\p{Alpha}){3}");
		Matcher matcher = pattern.matcher(rnaSequence);
		
		boolean stop = false;
		while (matcher.find() && !stop) {
			logger.info("Codon: " + matcher.group());
			String codon = matcher.group();
			
			
			switch(codon) {
			case "AUG":	
				proteinList.add("Methionine");
				break;
				
			case "UUU":
			case "UUC":
				proteinList.add("Phenylalanine");
				break;
				
			case "UUA":
			case "UUG":
				proteinList.add("Leucine");
				break;
				
			case "UCU":
			case "UCC":
			case "UCA":
			case "UCG":
				proteinList.add("Serine");
				break;
				
			case "UAU":
			case "UAC":
				proteinList.add("Tyrosine");
				break;
			case "UGU":
			case "UGC":
				proteinList.add("Cysteine");
				break;
				
			case "UGG":
				proteinList.add("Tryptophan");
				break;
			case "UAA":
			case "UAG":
			case "UGA":
				stop = true;
				break;
			}
		}
		return proteinList;		
    }

	List<String> translateVer2(String rnaSequence) {
		List <String>proteinList = new LinkedList<>();
		
		// create a pattern to extract three alpha characters at a time.
		Pattern pattern = Pattern.compile("(\\p{Alpha}){3}");
		Matcher matcher = pattern.matcher(rnaSequence);
		
		boolean stop = false;
		while (matcher.find() && !stop) {
			logger.info("Codon: " + matcher.group());
			String codon = matcher.group();
			
			
			switch(codon) {
			case "AUG":	
				proteinList.add("Methionine");
				break;
				
			case "UUU":
			case "UUC":
				proteinList.add("Phenylalanine");
				break;
				
			case "UUA":
			case "UUG":
				proteinList.add("Leucine");
				break;
				
			case "UCU":
			case "UCC":
			case "UCA":
			case "UCG":
				proteinList.add("Serine");
				break;
				
			case "UAU":
			case "UAC":
				proteinList.add("Tyrosine");
				break;
			case "UGU":
			case "UGC":
				proteinList.add("Cysteine");
				break;
				
			case "UGG":
				proteinList.add("Tryptophan");
				break;
			case "UAA":
			case "UAG":
			case "UGA":
				stop = true;
				break;
			}
		}
		return proteinList;		
    }

	
	public static void main(String[] args) {
		String sequence = "AUGUUUUCUUAAAUG";
		ProteinTranslator translator = new ProteinTranslator();
		List <String> proteinList = translator.translate(sequence);
		
		String output = proteinList.stream()
			.collect(Collectors.joining(", "));
		
		System.out.println(output);
	}

}
