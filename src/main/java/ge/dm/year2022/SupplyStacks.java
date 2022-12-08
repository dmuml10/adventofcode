package ge.dm.year2022;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SupplyStacks {

    private static List<Stack<Character>> boxes = new ArrayList<>();

    public static void main(String[] args) {
        var lines = JReader.ReadFileAsStringList("src/resources/year2022/Day5SupplyStacks.txt");

        for (int i=0; i<9; i++) {
            boxes.add(new Stack<>());
        }

        for (int i=7; i>=0; i--) {
            readBoxes(lines.get(i));
        }

        lines.subList(10, lines.size()).forEach(SupplyStacks::executeCommand);

        for (Stack<Character> box : boxes) {
            System.out.print(box.pop());
        }

    }

    private static void executeCommand(String command) {
        int num = Integer.parseInt(command.substring(5, command.indexOf(" from")));
        int first = Integer.parseInt(command.substring(command.indexOf("from ") + 5, command.indexOf(" to")));
        int second = Integer.parseInt(command.substring(command.indexOf("to") + 3));

        for (int i=0; i<num; i++) {
            char c = boxes.get(first - 1).pop();
            boxes.get(second - 1).add(c);
        }
    }

    private static void readBoxes(String s) {
        int index = 0;
        int charSize = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                charSize++;
                if (charSize == 4) {
                    index ++;
                    charSize = 0;
                }
            } else {
                if (charSize > 0) {
                    charSize = 0;
                    index++;
                }
                i++;
                char box = s.charAt(i);
                addElementToStack(box, index);
                i++;
            }
        }
    }

    private static void addElementToStack(char c, int index) {
        var stack = boxes.get(index);
        stack.add(c);
    }

}