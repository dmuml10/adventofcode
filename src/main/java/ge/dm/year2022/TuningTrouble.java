package ge.dm.year2022;

import java.util.HashSet;

public class TuningTrouble {

    public static void main(String[] args) {
        System.out.println(solve());
    }

    public static int solve() {
        String line =
                JReader.ReadFileSingleLine("src/resources/year2022/Day6TuningTrouble.txt");

        for (int i=3; i<= line.length(); i++) {
            var set = new HashSet<Character>();
            set.add(line.charAt(i-3));
            set.add(line.charAt(i-2));
            set.add(line.charAt(i-1));
            set.add(line.charAt(i));
            if (set.size() == 4) {
                return i+1;
            }
        }
        return -1;
    }

}
