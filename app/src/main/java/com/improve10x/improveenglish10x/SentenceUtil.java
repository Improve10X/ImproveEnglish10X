package com.improve10x.improveenglish10x;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class SentenceUtil {

    public static Map<String, Object> pastVerbs;

    public static Map<String, String> prepositionsForPlace;
    public static Map<String, String> prepositionsForTime;
    public static String[] suggestionVerbs = null;

    public SentenceUtil(){
        prepositionsForPlace = new LinkedHashMap<String, String>();
        prepositionsForPlace.put("in", 	"లో");
        prepositionsForPlace.put("at",	"వద్ద");
        prepositionsForPlace.put("on",	"పై");
        prepositionsForPlace.put("by/ next to/ beside",	"ద్వారా");
        prepositionsForPlace.put("under",	"కింద");
        prepositionsForPlace.put("below",	"క్రింద");
        prepositionsForPlace.put("over",	"పైగా");
        prepositionsForPlace.put("above",	"పైన");
        prepositionsForPlace.put("across",	"అంతటా");
        prepositionsForPlace.put("through",	"ద్వారా");
        prepositionsForPlace.put("to",	"కు");
        prepositionsForPlace.put("into",	"లోకి");
        prepositionsForPlace.put("towards",	"వైపు");
        prepositionsForPlace.put("onto",	"పై");
        prepositionsForPlace.put("from",	"నుండి");

        prepositionsForTime = new LinkedHashMap<>();
        prepositionsForTime.put("on",	"కు / కి");
        prepositionsForTime.put("in",	"లో");
        prepositionsForTime.put("at",	"కు / కి");
        prepositionsForTime.put("since",	"నుండి");
        prepositionsForTime.put("for",	"కోసం");
        prepositionsForTime.put("ago",	"క్రితం");
        prepositionsForTime.put("before",	"ముందు");
        prepositionsForTime.put("to",	"కు / కి");
        prepositionsForTime.put("to / till / until",	"వరకు");
        prepositionsForTime.put("till / until",	"వరకు");
        prepositionsForTime.put("by",	"కల్లా");
    }

    public String generateSentence(String subject, String verb, String object, String tense, boolean isPositive) {
        String sentence = "";
        if (tense.equalsIgnoreCase("present")) {
            if (subject.equalsIgnoreCase("I")) {
                sentence = subject + " am " + getPerfectTenseForVerb(tense, verb, isPositive) + " " + object;
            } else if (subject.equalsIgnoreCase("WE") || subject.equalsIgnoreCase("THEY")) {
                sentence = subject + " are " + getPerfectTenseForVerb(tense, verb, isPositive) + " " + object;
            } else if (subject.equalsIgnoreCase("IT") ||
                    subject.equalsIgnoreCase("SHE") ||
                    subject.equalsIgnoreCase("HE")) {
                sentence = subject + " is " + getPerfectTenseForVerb(tense, verb, isPositive) + " " + object;
            } else {
                sentence = subject + getPerfectTenseForVerb(tense, verb, isPositive);
            }
        } else {
            sentence = subject + " " + getPerfectTenseForVerb(tense, verb, isPositive) + " " + object;
        }
        sentence = sentence.trim() + ".";
        return sentence;
    }

    private String getPerfectTenseForVerb(String tense, String verb, boolean isPositive) {
        String tenseInCaps = tense.toUpperCase(Locale.ROOT);
        boolean endsWithE = false;
        boolean endsWithY = false;
        boolean vowelBeforeConsonant = false;
        String lastChar = "";
        if (verb.endsWith("e")) {
            endsWithE = true;
        } else if (verb.endsWith("y")) {
            endsWithY = true;
        }
        if (!checkIfEndingWithVowel(verb.substring(0, verb.length() - 2)) &&
                checkIfEndingWithVowel(verb.substring(0, verb.length() - 1)) &&
                !checkIfEndingWithVowel(verb)) {
            vowelBeforeConsonant = true;
            lastChar = verb.charAt(verb.length() - 1) + "";
        }
        switch (tenseInCaps) {
            case "PAST":
                if (isPositive) {
                    if(pastVerbs.containsKey(verb.toLowerCase(Locale.ROOT))) {
                        return pastVerbs.get(verb.toLowerCase(Locale.ROOT)).toString();
                    } else if (endsWithE) {
                        return verb + "d";
                    } else if (endsWithY) {
                        return verb.substring(0, verb.length() - 1) + "ied";
                    } else if (vowelBeforeConsonant) {
                        return verb + lastChar + "ed";
                    } else
                        return verb + "ed";
                } else {
                    return "did not " + verb;
                }

            case "PRESENT":
                String word = "";
                if (endsWithE) {
                    word = verb.substring(0, verb.length() - 1) + "ing";
                } else if (endsWithY) {
                    word = verb + "ing";
                } else if (vowelBeforeConsonant) {
                    word = verb + lastChar + "ing";
                } else
                    word = verb + "ing";
                if (isPositive) {
                    return word;
                } else {
                    return "not " + word;
                }
            case "FUTURE":
                if (isPositive) {
                    return "will " + verb;
                } else {
                    return "will not " + verb;
                }
            default:
                return verb;
        }
    }

    private static boolean checkIfEndingWithVowel(String word) {
        if (word.endsWith("a") ||
                word.endsWith("e") ||
                word.endsWith("i") ||
                word.endsWith("o") ||
                word.endsWith("u")) {
            return true;
        }
        return false;
    }
    // TODO : Add write - wrote in map
    // beat, eat,
}
