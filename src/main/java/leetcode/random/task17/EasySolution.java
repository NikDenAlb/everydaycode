package leetcode.random.task17;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class EasySolution {
    List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return List.of();
        }
        List<StringBuilder> out = new ArrayList<>();
        switch (digits.charAt(0)) {
            case '2' -> {
                out.add(new StringBuilder("a"));
                out.add(new StringBuilder("b"));
                out.add(new StringBuilder("c"));
            }
            case '3' -> {
                out.add(new StringBuilder("d"));
                out.add(new StringBuilder("f"));
                out.add(new StringBuilder("e"));
            }
            case '4' -> {
                out.add(new StringBuilder("g"));
                out.add(new StringBuilder("h"));
                out.add(new StringBuilder("i"));
            }
            case '5' -> {
                out.add(new StringBuilder("j"));
                out.add(new StringBuilder("k"));
                out.add(new StringBuilder("l"));
            }
            case '6' -> {
                out.add(new StringBuilder("m"));
                out.add(new StringBuilder("n"));
                out.add(new StringBuilder("o"));
            }
            case '7' -> {
                out.add(new StringBuilder("p"));
                out.add(new StringBuilder("q"));
                out.add(new StringBuilder("r"));
                out.add(new StringBuilder("s"));
            }
            case '8' -> {
                out.add(new StringBuilder("t"));
                out.add(new StringBuilder("u"));
                out.add(new StringBuilder("v"));
            }
            case '9' -> {
                out.add(new StringBuilder("w"));
                out.add(new StringBuilder("x"));
                out.add(new StringBuilder("y"));
                out.add(new StringBuilder("z"));
            }
        }

        for (int i = 1; i < digits.length(); i++) {
            List<StringBuilder> temp = new ArrayList<>();
            for (StringBuilder sB : out) {
                switch (digits.charAt(i)) {
                    case '2' -> {
                        StringBuilder next = new StringBuilder(sB);
                        next.append("a");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("b");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("c");
                        temp.add(next);
                    }
                    case '3' -> {
                        StringBuilder next = new StringBuilder(sB);
                        next.append("d");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("e");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("f");
                        temp.add(next);
                    }
                    case '4' -> {
                        StringBuilder next = new StringBuilder(sB);
                        next.append("g");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("h");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("i");
                        temp.add(next);
                    }
                    case '5' -> {
                        StringBuilder next = new StringBuilder(sB);
                        next.append("j");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("k");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("l");
                        temp.add(next);
                    }
                    case '6' -> {
                        StringBuilder next = new StringBuilder(sB);
                        next.append("m");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("n");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("o");
                        temp.add(next);
                    }
                    case '7' -> {
                        StringBuilder next = new StringBuilder(sB);
                        next.append("p");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("q");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("r");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("s");
                        temp.add(next);
                    }
                    case '8' -> {
                        StringBuilder next = new StringBuilder(sB);
                        next.append("t");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("u");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("v");
                        temp.add(next);
                    }
                    case '9' -> {
                        StringBuilder next = new StringBuilder(sB);
                        next.append("w");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("x");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("y");
                        temp.add(next);
                        next = new StringBuilder(sB);
                        next.append("z");
                        temp.add(next);
                    }
                }
            }
            out = temp;
        }
        return out.stream().map(StringBuilder::toString).collect(Collectors.toList());
    }
}
