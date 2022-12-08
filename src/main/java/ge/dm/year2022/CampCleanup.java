package ge.dm.year2022;

import java.util.List;

public class CampCleanup {

    public static void main(String[] args) {
        System.out.println(solve());
    }

    public static long solve() {
        List<String> lines =
                JReader.ReadFileAsStringList("src/resources/year2022/Day4CampCleanup.txt");

        return lines.stream().filter(CampCleanupS::containsOther).count();
    }

    public static boolean containsOther(String line) {
        var areas = line.split(",");
        var left = areas[0].split("-");
        var right = areas[1].split("-");
        return (Integer.parseInt(left[0]) <= Integer.parseInt(right[0]) && Integer.parseInt(left[1]) >= Integer.parseInt(right[1])) ||
                (Integer.parseInt(left[0]) >= Integer.parseInt(right[0]) && Integer.parseInt(left[1]) <= Integer.parseInt(right[1]));
    }
}