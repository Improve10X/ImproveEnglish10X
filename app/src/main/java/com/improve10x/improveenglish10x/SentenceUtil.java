package com.improve10x.improveenglish10x;

import com.improve10x.improveenglish10x.models.Preposition;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SentenceUtil {

    public static Map<String, Object> pastVerbs;

    public static List<Preposition> placePrepositions = new ArrayList<>();
    public static List<Preposition> timePrepositions = new ArrayList<>();
    public static List<Preposition> otherPrepositions = new ArrayList<>();
    public static String[] suggestionVerbs = null;

    public SentenceUtil() {
        placePrepositions.add(new Preposition("in", "లో", "place"));
        placePrepositions.add(new Preposition("at", "వద్ద", "place"));
        placePrepositions.add(new Preposition("on", "పై", "place"));
        placePrepositions.add(new Preposition("by/next to/beside", "ద్వారా", "place"));
        placePrepositions.add(new Preposition("under", "కింద", "place"));
        placePrepositions.add(new Preposition("below", "క్రింద", "place"));
        placePrepositions.add(new Preposition("over", "పైగా", "place"));
        placePrepositions.add(new Preposition("above", "పైన", "place"));
        placePrepositions.add(new Preposition("across", "అంతటా", "place"));
        placePrepositions.add(new Preposition("through", "ద్వారా", "place"));
        placePrepositions.add(new Preposition("to", "కు", "place"));
        placePrepositions.add(new Preposition("into", "లోకి", "place"));
        placePrepositions.add(new Preposition("towards", "వైపు", "place"));
        placePrepositions.add(new Preposition("onto", "పై", "place"));
        placePrepositions.add(new Preposition("from", "నుండి", "place"));

        timePrepositions.add(new Preposition("on", "కు / కి", "time"));
        timePrepositions.add(new Preposition("in", "లో", "time"));
        timePrepositions.add(new Preposition("at", "కు / కి", "time"));
        timePrepositions.add(new Preposition("since", "నుండి", "time"));
        timePrepositions.add(new Preposition("for", "కోసం", "time"));
        timePrepositions.add(new Preposition("ago", "క్రితం", "time"));
        timePrepositions.add(new Preposition("before", "ముందు", "time"));
        timePrepositions.add(new Preposition("to", "కు / కి", "time"));
        timePrepositions.add(new Preposition("to/till/until", "వరకు", "time"));
        timePrepositions.add(new Preposition("till/until", "వరకు", "time"));
        timePrepositions.add(new Preposition("by", "కల్లా", "time"));

        otherPrepositions.add(new Preposition("aboard", "", "others"));
        otherPrepositions.add(new Preposition("about", "", "others"));
        otherPrepositions.add(new Preposition("after", "", "others"));
        otherPrepositions.add(new Preposition("against", "", "others"));
        otherPrepositions.add(new Preposition("along", "", "others"));
        otherPrepositions.add(new Preposition("amid", "", "others"));
        otherPrepositions.add(new Preposition("among", "", "others"));
        otherPrepositions.add(new Preposition("anti", "", "others"));
        otherPrepositions.add(new Preposition("around", "", "others"));
        otherPrepositions.add(new Preposition("as", "", "others"));
        otherPrepositions.add(new Preposition("behind", "", "others"));
        otherPrepositions.add(new Preposition("beneath", "", "others"));
        otherPrepositions.add(new Preposition("besides", "", "others"));
        otherPrepositions.add(new Preposition("between", "", "others"));
        otherPrepositions.add(new Preposition("beyond", "", "others"));
        otherPrepositions.add(new Preposition("but", "", "others"));
        otherPrepositions.add(new Preposition("concerning", "", "others"));
        otherPrepositions.add(new Preposition("considering", "", "others"));
        otherPrepositions.add(new Preposition("despite", "", "others"));
        otherPrepositions.add(new Preposition("down", "", "others"));
        otherPrepositions.add(new Preposition("during", "", "others"));
        otherPrepositions.add(new Preposition("except", "", "others"));
        otherPrepositions.add(new Preposition("excepting", "", "others"));
        otherPrepositions.add(new Preposition("excluding", "", "others"));
        otherPrepositions.add(new Preposition("following", "", "others"));
        otherPrepositions.add(new Preposition("inside", "", "others"));
        otherPrepositions.add(new Preposition("like", "", "others"));
        otherPrepositions.add(new Preposition("minus", "", "others"));
        otherPrepositions.add(new Preposition("near", "", "others"));
        otherPrepositions.add(new Preposition("of", "", "others"));
        otherPrepositions.add(new Preposition("off", "", "others"));
        otherPrepositions.add(new Preposition("opposite", "", "others"));
        otherPrepositions.add(new Preposition("outside", "", "others"));
        otherPrepositions.add(new Preposition("past", "", "others"));
        otherPrepositions.add(new Preposition("per", "", "others"));
        otherPrepositions.add(new Preposition("plus", "", "others"));
        otherPrepositions.add(new Preposition("regarding", "", "others"));
        otherPrepositions.add(new Preposition("round", "", "others"));
        otherPrepositions.add(new Preposition("save", "", "others"));
        otherPrepositions.add(new Preposition("than", "", "others"));
        otherPrepositions.add(new Preposition("toward", "", "others"));
        otherPrepositions.add(new Preposition("underneath", "", "others"));
        otherPrepositions.add(new Preposition("unlike", "", "others"));
        otherPrepositions.add(new Preposition("until", "", "others"));
        otherPrepositions.add(new Preposition("up", "", "others"));
        otherPrepositions.add(new Preposition("upon", "", "others"));
        otherPrepositions.add(new Preposition("versus", "", "others"));
        otherPrepositions.add(new Preposition("via", "", "others"));
        otherPrepositions.add(new Preposition("with", "", "others"));
        otherPrepositions.add(new Preposition("within", "", "others"));
        otherPrepositions.add(new Preposition("without", "", "others"));
    }

    public String generateSentence(String subject, String verb, String object, String tense, String preposition, boolean isPositive) {
        String sentence = "";
        String prepObj = preposition + " " + object;
        if (tense.equalsIgnoreCase("present")) {
            if (subject.equalsIgnoreCase("I")) {
                sentence = subject + " am " + getPerfectTenseForVerb(tense, verb, isPositive) + " " + prepObj;
            } else if (subject.equalsIgnoreCase("WE") || subject.equalsIgnoreCase("THEY")) {
                sentence = subject + " are " + getPerfectTenseForVerb(tense, verb, isPositive) + " " + prepObj;
            } else if (subject.equalsIgnoreCase("IT") ||
                    subject.equalsIgnoreCase("SHE") ||
                    subject.equalsIgnoreCase("HE")) {
                sentence = subject + " is " + getPerfectTenseForVerb(tense, verb, isPositive) + " " + prepObj;
            } else {
                sentence = subject + getPerfectTenseForVerb(tense, verb, isPositive);
            }
        } else {
            sentence = subject + " " + getPerfectTenseForVerb(tense, verb, isPositive) + " " + prepObj;
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
                    if (pastVerbs.containsKey(verb.toLowerCase(Locale.ROOT))) {
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
