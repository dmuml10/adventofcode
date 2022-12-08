package ge.dm.year2022;

import java.util.stream.Collectors;

public class RucksackReorganization {

    public static void main(String[] args) {
        System.out.println(solve());
    }

    public static int solve() {
        var lines = JReader.ReadFileAsStringList("src/resources/year2022/Day3RucksackReorganization.txt");

        return lines.stream()
                .map(RucksackReorganization::checkRuckSack)
                .reduce(0, Integer::sum);
    }

    public static int checkRuckSack(String items) {
        var set = items.substring(0, items.length()/2)
                .chars()
                .mapToObj(i -> (char) i)
                .collect(Collectors.toSet());
        return items.substring(items.length()/2).chars().mapToObj((i) -> (char) i)
                .filter(set::contains)
                .findFirst().map(RucksackReorganizationS::calculateScore).get();
    }

    public static int calculateScore(char ch) {
        if (Character.isLowerCase(ch)) {
            return ch - 96;
        } else {
            return ch - 38;
        }
    }

}
