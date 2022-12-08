package ge.dm.year2022;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class NoSpaceLeftOnDevice {

    public static void main(String[] args) {
        System.out.println(solve());
    }

    //1391690
    //5469168

    private static Map<String, Integer> dirMap = new HashMap<>();

    private static Stack<String> dirNames = new Stack<>();

    public static int solve() {
        List<String> lines =
                JReader.ReadFileAsStringList("src/resources/year2022/Day7NoSpaceLeftOnDevice.txt");

        for (String line: lines) {
            if (line.contains("$")) {
                if (line.contains("cd") && !line.contains("..")) {
                    dirNames.add(line.split(" ")[2]);
                } else if(line.contains("$ cd ..")) {
                    dirNames.pop();
                }
            } else if (!line.contains("dir ")) {
                addElement(line.split(" ")[0]);
            }
        }

        return dirMap.values().stream()
                .filter(i -> i <= 100000)
                .reduce(0, Integer::sum);
    }

    private static void addElement(String value) {
        for (String key: dirNames) {
            if (dirMap.containsKey(key)) {
                dirMap.put(key, dirMap.get(key) + Integer.parseInt(value));
            } else {
                dirMap.put(key, Integer.parseInt(value));
            }
        }
    }
}
