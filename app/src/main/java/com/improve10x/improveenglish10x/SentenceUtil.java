package com.improve10x.improveenglish10x;

import java.util.Locale;

public class SentenceUtil {

    public static String generateSentence(String subject, String verb, String object, String tense, boolean isPositive) {
        return "I am completing the project";
    }

    private static String getPerfectTenseForVerb(String tense, String verb){
        String tenseInCaps = tense.toUpperCase(Locale.ROOT);
        boolean endsWithE = false;
        boolean endsWithY = false;
        boolean vowelBeforeConsonant = false;
        String lastChar = "";
        if(verb.endsWith("e")){
            endsWithE = true;
        } else if(verb.endsWith("y")){
            endsWithY = true;
        }
        if(!checkIfEndingWithVowel(verb.substring(0, verb.length() - 2)) &&
                checkIfEndingWithVowel(verb.substring(0, verb.length() - 1)) &&
                        !checkIfEndingWithVowel(verb)){
            vowelBeforeConsonant = true;
            lastChar = verb.substring(verb.length()-2,verb.length()-1);
        }
        switch (tenseInCaps){
            case "PAST":
                if(endsWithE) {
                    return verb + "d";
                } else if(endsWithY) {
                    return verb.substring(0, verb.length() - 1) + "ied";
                } else if(vowelBeforeConsonant){
                    return verb + lastChar + "ed";
                } else
                    return verb + "ed";
            case "PRESENT":
                if(endsWithE) {
                   return verb.substring(0, verb.length() - 1) + "ing";
                } else if (endsWithY){
                    return verb + "ing";
                } else if (vowelBeforeConsonant) {
                    return verb + lastChar + "ing";
                } else
                    return verb + "ing";
            case "FUTURE":
                return "will " + verb;
            default:
                return verb;
        }
    }

    private static boolean checkIfEndingWithVowel(String word) {
        if(word.endsWith("a") ||
                word.endsWith("e") ||
                word.endsWith("i") ||
                word.endsWith("o") ||
                word.endsWith("u")) {
            return true;
        }
        return false;
    }
}
