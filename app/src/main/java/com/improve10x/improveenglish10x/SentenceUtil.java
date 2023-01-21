package com.improve10x.improveenglish10x;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class SentenceUtil {

    private Map<String, String> pastVerbs = new LinkedHashMap<>();

    public SentenceUtil() {
        // Load this data from firebase in Splash
        pastVerbs.put("awake", "awoke");
        pastVerbs.put("be", "was");
        pastVerbs.put("beat", "beat");
        pastVerbs.put("become", "became");
        pastVerbs.put("begin", "began");
        pastVerbs.put("bend", "bent");
        pastVerbs.put("bet", "bet");
        pastVerbs.put("bid", "bid");
        pastVerbs.put("bite", "bit");
        pastVerbs.put("blow", "blew");
        pastVerbs.put("break", "broke");
        pastVerbs.put("bring", "brought");
        pastVerbs.put("broadcast", "broadcast");
        pastVerbs.put("build", "built");
        pastVerbs.put("burn", "burned");
        pastVerbs.put("buy", "bought");
        pastVerbs.put("catch", "caught");
        pastVerbs.put("choose", "chose");
        pastVerbs.put("come", "came");
        pastVerbs.put("cost", "cost");
        pastVerbs.put("cut", "cut");
        pastVerbs.put("dig", "dug");
        pastVerbs.put("do", "did");
        pastVerbs.put("draw", "drew");
        pastVerbs.put("dream", "dreamed");
        pastVerbs.put("drive", "drove");
        pastVerbs.put("drink", "drank");
        pastVerbs.put("eat", "ate");
        pastVerbs.put("fall", "fell");
        pastVerbs.put("feel", "felt");
        pastVerbs.put("fight", "fought");
        pastVerbs.put("find", "found");
        pastVerbs.put("fly", "flew");
        pastVerbs.put("forget", "forgot");
        pastVerbs.put("forgive", "forgave");
        pastVerbs.put("freeze", "froze");
        pastVerbs.put("get", "got");
        pastVerbs.put("give", "gave");
        pastVerbs.put("go", "went");
        pastVerbs.put("grow", "grew");
        pastVerbs.put("hang", "hung");
        pastVerbs.put("have", "had");
        pastVerbs.put("hear", "heard");
        pastVerbs.put("hide", "hid");
        pastVerbs.put("hit", "hit");
        pastVerbs.put("hold", "held");
        pastVerbs.put("hurt", "hurt");
        pastVerbs.put("keep", "kept");
        pastVerbs.put("know", "knew");
        pastVerbs.put("lay", "laid");
        pastVerbs.put("lead", "led");
        pastVerbs.put("learn", "learned");
        pastVerbs.put("leave", "left");
        pastVerbs.put("lend", "lent");
        pastVerbs.put("let", "let");
        pastVerbs.put("lie", "lay");
        pastVerbs.put("lose", "lost");
        pastVerbs.put("make", "made");
        pastVerbs.put("mean", "meant");
        pastVerbs.put("meet", "met");
        pastVerbs.put("pay", "paid");
        pastVerbs.put("put", "put");
        pastVerbs.put("read", "read");
        pastVerbs.put("ride", "rode");
        pastVerbs.put("ring", "rang");
        pastVerbs.put("rise", "rose");
        pastVerbs.put("run", "ran");
        pastVerbs.put("say", "said");
        pastVerbs.put("see", "saw");
        pastVerbs.put("sell", "sold");
        pastVerbs.put("send", "sent");
        pastVerbs.put("show", "showed");
        pastVerbs.put("shut", "shut");
        pastVerbs.put("sing", "sang");
        pastVerbs.put("sink", "sank");
        pastVerbs.put("sit", "sat");
        pastVerbs.put("sleep", "slept");
        pastVerbs.put("speak", "spoke");
        pastVerbs.put("spend", "spent");
        pastVerbs.put("stand", "stood");
        pastVerbs.put("stink", "stank");
        pastVerbs.put("swim", "swam");
        pastVerbs.put("take", "took");
        pastVerbs.put("teach", "taught");
        pastVerbs.put("tear", "tore");
        pastVerbs.put("tell", "told");
        pastVerbs.put("think", "thought");
        pastVerbs.put("throw", "threw");
        pastVerbs.put("understand", "understood");
        pastVerbs.put("wake", "woke");
        pastVerbs.put("wear", "wore");
        pastVerbs.put("win", "won");
        pastVerbs.put("write", "wrote");
    }

    public String generateSentence(String subject, String verb, String object, String tense, boolean isPositive) {
        String sentence = "";
        if (tense.equalsIgnoreCase("present")) {
            if (subject.equalsIgnoreCase("I")) {
                sentence = subject + " am " + getPerfectTenseForVerb(tense, verb, isPositive) + " " + object;
            } else if (subject.equalsIgnoreCase("WE")) {
                sentence = subject + " are " + getPerfectTenseForVerb(tense, verb, isPositive) + " " + object;
            } else {
                sentence = subject + getPerfectTenseForVerb(tense, verb, isPositive);
            }
        } else if((subject.equalsIgnoreCase("code"))) {
            sentence = subject + " " + getPerfectTenseForVerb(tense, verb, isPositive);
        } else {
            sentence = subject + " " + getPerfectTenseForVerb(tense, verb, isPositive) + " " + object;
        }
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
                        return pastVerbs.get(verb.toLowerCase(Locale.ROOT));
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
