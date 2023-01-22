package com.improve10x.improveenglish10x;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class SentenceUtil {

    public static Map<String, Object> pastVerbs = new LinkedHashMap<>();

    public static String[] suggestionVerbs = {"accept", "add", "admire", "admit", "advise", "afford", "agree", "alert", "allow", "amuse", "analyse", "analyze", "announce", "annoy", "answer", "apologise", "appear", "applaud", "appreciate", "approve", "argue", "arrange", "arrest", "arrive", "ask", "attach", "attack", "attempt", "attend", "attract", "avoid", "back", "bake", "balance", "ban", "bang", "bare", "bat", "bathe", "battle", "beam", "beg", "behave", "belong", "bleach", "bless", "blind", "blink", "blot", "blush", "boast", "boil", "bolt", "bomb", "book", "bore", "borrow", "bounce", "bow", "box", "brake", "branch", "breathe", "bruise", "brush", "bubble", "bump", "burn", "bury", "buzz", "calculate", "call", "camp", "care", "carry", "carve", "cause", "challenge", "change", "charge", "chase", "cheat", "check", "cheer", "chew", "choke", "chop", "claim", "clap", "clean", "clear", "clip", "close", "coach", "coil", "collect", "colour", "comb", "command", "communicate", "compare", "compete", "complain", "complete", "concentrate", "concern", "confess", "confuse", "connect", "consider", "consist", "contain", "continue", "copy", "correct", "cough", "count", "cover", "crack", "crash", "crawl", "cross", "crush", "cry", "cure", "curl", "curve", "cycle", "dam", "damage", "dance", "dare", "decay", "deceive", "decide", "decorate", "delay", "delight", "deliver", "depend", "describe", "desert", "deserve", "destroy", "detect", "develop", "disagree", "disappear", "disapprove", "disarm", "discover", "dislike", "divide", "double", "doubt", "drag", "drain", "dream", "dress", "drip", "drop", "drown", "drum", "dry", "dust", "earn", "educate", "embarrass", "employ", "empty", "encourage", "end", "enjoy", "enter", "entertain", "escape", "examine", "excite", "excuse", "exercise", "exist", "expand", "expect", "explain", "explode", "extend", "face", "fade", "fail", "fancy", "fasten", "fax", "fear", "fence", "fetch", "file", "fill", "film", "fire", "fit", "fix", "flap", "flash", "float", "flood", "flow", "flower", "fold", "follow", "fool", "force", "form", "found", "frame", "frighten", "fry", "gather", "gaze", "glow", "glue", "grab", "grate", "grease", "greet", "grin", "grip", "groan", "guarantee", "guard", "guess", "guide", "hammer", "hand", "handle", "hang", "happen", "harass", "harm", "hate", "haunt", "head", "heal", "heap", "heat", "help", "hook", "hop", "hope", "hover", "hug", "hum", "hunt", "hurry", "identify", "ignore", "imagine", "impress", "improve", "include", "increase", "influence", "inform", "inject", "injure", "instruct", "intend", "interest", "interfere", "interrupt", "introduce", "invent", "invite", "irritate", "itch", "jail", "jam", "jog", "join", "joke", "judge", "juggle", "jump", "kick", "kill", "kiss", "kneel", "knit", "knock", "knot", "label", "land", "last", "laugh", "launch", "learn", "level", "license", "lick", "lie", "lighten", "like", "list", "listen", "live", "load", "lock", "long", "look", "love", "man", "manage", "march", "mark", "marry", "match", "mate", "matter", "measure", "meddle", "melt", "memorise", "mend", "mess up", "milk", "mine", "miss", "mix", "moan", "moor", "mourn", "move", "muddle", "mug", "multiply", "murder", "nail", "name", "need", "nest", "nod", "note", "notice", "number", "obey", "object", "observe", "obtain", "occur", "offend", "offer", "open", "order", "overflow", "owe", "own", "pack", "paddle", "paint", "park", "part", "pass", "paste", "pat", "pause", "peck", "pedal", "peel", "peep", "perform", "permit", "phone", "pick", "pinch", "pine", "place", "plan", "plant", "play", "please", "plug", "point", "poke", "polish", "pop", "possess", "post", "pour", "practise (BrE)", "practice (AmE)", "pray", "preach", "precede", "prefer", "prepare", "present", "preserve", "press", "pretend", "prevent", "prick", "print", "produce", "program", "promise", "protect", "provide", "pull", "pump", "punch", "puncture", "punish", "push", "question", "queue", "race", "radiate", "rain", "raise", "reach", "realise", "receive", "recognise", "record", "reduce", "reflect", "refuse", "regret", "reign", "reject", "rejoice", "relax", "release", "rely", "remain", "remember", "remind", "remove", "repair", "repeat", "replace", "reply", "report", "reproduce", "request", "rescue", "retire", "return", "rhyme", "rinse", "risk", "rob", "rock", "roll", "rot", "rub", "ruin", "rule", "rush", "sack", "sail", "satisfy", "save", "saw", "scare", "scatter", "scold", "scorch", "scrape", "scratch", "scream", "screw", "scribble", "scrub", "seal", "search", "separate", "serve", "settle", "shade", "share", "shave", "shelter", "shiver", "shock", "shop", "shrug", "sigh", "sign", "signal", "sin", "sip", "ski", "skip", "slap", "slip", "slow", "smash", "smell", "smile", "smoke", "snatch", "sneeze", "sniff", "snore", "snow", "soak", "soothe", "sound", "spare", "spark", "sparkle", "spell", "spill", "spoil", "spot", "spray", "sprout", "squash", "squeak", "squeal", "squeeze", "stain", "stamp", "stare", "start", "stay", "steer", "step", "stir", "stitch", "stop", "store", "strap", "strengthen", "stretch", "strip", "stroke", "stuff", "subtract", "succeed", "suck", "suffer", "suggest", "suit", "supply", "support", "suppose", "surprise", "surround", "suspect", "suspend", "switch", "talk", "tame", "tap", "taste", "tease", "telephone", "tempt", "terrify", "test", "thank", "thaw", "tick", "tickle", "tie", "time", "tip", "tire", "touch", "tour", "tow", "trace", "trade", "train", "transport", "trap", "travel", "treat", "tremble", "trick", "trip", "trot", "trouble", "trust", "try", "tug", "tumble", "turn", "twist", "type", "undress", "unfasten", "unite", "unlock", "unpack", "untidy", "use", "vanish", "visit", "wail", "wait", "walk", "wander", "want", "warm", "warn", "wash", "waste", "watch", "water", "wave", "weigh", "welcome", "whine", "whip", "whirl", "whisper", "whistle", "wink", "wipe", "wish", "wobble", "wonder", "work", "worry", "wrap", "wreck", "wrestle", "wriggle", "x-ray", "yawn", "yell", "zip", "zoom",
            "awake", "be", "beat", "become", "begin", "bend", "bet", "bid", "bite", "blow", "break", "bring", "broadcast", "build", "burn", "buy", "catch", "choose", "come", "cost", "cut", "develop", "dig", "do", "draw", "dream", "drive", "drink", "eat", "fall", "feel", "fight", "find", "fly", "forget", "forgive", "freeze", "get", "give", "go", "grow", "hang", "have", "hear", "hide", "hit", "hold", "hurt", "keep", "know", "lay", "lead", "learn", "leave", "lend", "let", "lie", "lose", "make", "mean", "meet", "pay", "put", "read", "ride", "ring", "rise", "run", "say", "see", "sell", "send", "show", "shut", "sing", "sink", "sit", "sleep", "speak", "spend", "stand", "stink", "swim", "take", "teach", "tear", "tell", "think", "throw", "understand", "wake", "wear", "win", "write"};
    
    public SentenceUtil() {
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
        pastVerbs.put("develop", "developed");
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
