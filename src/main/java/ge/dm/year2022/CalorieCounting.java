package ge.dm.year2022;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CalorieCounting {

    public static void main(String[] args) {
        System.out.println(solve());
    }

    public static int solve() {
        List<String> lines =
                JReader.ReadFileAsStringList("src/resources/year2022/Day1CalorieCounting.txt");

        int sum=0;
        int max=0;
        for (String line : lines) {
            if (line.equals("")) {
                if (sum > max) {
                    max = sum;
                }
                sum = 0;
            } else {
                sum += Integer.parseInt(line);
            }
        }
        return max;
    }

}
