package source;

import java.util.*;

public class FormulaRuneParser {

        public static int solveExpression( final String expression ) {

            List<String> numbersList = new ArrayList<>();
            String tmp = expression;
            String[] equa = tmp.split("=");

            //kind of operation
            String toDo = "";
            {
                if (expression.contains("+")) {
                    toDo = "\\+";
                } else if (expression.contains("*")) {
                    toDo = "\\*";
                } else if (expression.contains("-")) {
                    toDo = "\\-";
                }
            }

            //checking negative string
            if (expression.startsWith("-")) {
                equa[0] = equa[0].replaceFirst("-", "");
            }

            //splitting by operation and adding to list
            String[] elements = equa[0].split(toDo, 2);
            if (expression.startsWith("-")) {
                numbersList.add("-" + elements[0]);
            } else {
                numbersList.add(elements[0]);
            }
            numbersList.add(elements[1]);
            numbersList.add(equa[1]);

            //check for 6 '?'
            if (numbersList.get(0).equals(numbersList.get(1)) && numbersList.get(1).equals(numbersList.get(2))) return -1;

            //main logic
            boolean isEqual = false;
            for (int i = 0; i <= 9; i++) {
                if (!expression.contains(String.valueOf(i))) {
                    try {
                        switch (toDo) {
                            case "\\+": {
                                isEqual = getInteger(numbersList.get(0), i)
                                        + getInteger(numbersList.get(1), i) == getInteger(numbersList.get(2), i);
                            }
                            break;
                            case "\\*": {
                                isEqual = getInteger(numbersList.get(0), i)
                                        * getInteger(numbersList.get(1), i) == getInteger(numbersList.get(2), i);
                            }
                            break;
                            case "\\-": {
                                isEqual = getInteger(numbersList.get(0), i)
                                        - getInteger(numbersList.get(1), i) == getInteger(numbersList.get(2), i);
                            }
                            break;
                        }
                        if (isEqual) return i;
                    } catch (RuntimeException e) { }
                }
            }
            return -1;
        }

        //this method takes string with '?' and integer. returns integer with i extend of '?'
        public static int getInteger(String s, int i) {
            if (!s.contains("?")) return Integer.parseInt(s);
            else {
                if (s.length() == 1) {
                    s = s.replaceAll("\\?", Integer.toString(i));
                } else {
                    if (i == 0 && s.indexOf('?') == 0) {
                        throw new RuntimeException();
                    } else {
                        s = s.replaceAll("\\?", Integer.toString(i));
                    }
                }
            }
            return Integer.parseInt(s);
        }

}
