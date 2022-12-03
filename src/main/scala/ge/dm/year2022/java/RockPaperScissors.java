package ge.dm.year2022.java;

import ge.dm.utils.JReader;

import java.util.Map;

public class RockPaperScissors {

    private static Map<String, Integer> symbols
            = Map.of("A", 1, "B", 2, "C" , 3, "X" , 1, "Y" , 2, "Z" , 3);

    public static void main(String[] args) {
        System.out.println(solve());
    }

    public static int solve() {
        var list =
                JReader.ReadFileAsString("src/resources/year2022/Day2RockPaperScissors.txt");

        return list.stream()
                .map(RockPaperScissors::calculateScore)
                .reduce(0, Integer::sum);
    }

    public static int calculateScore(String play) {
        int score = 0;
        String[] hands = play.split(" ");
        int rival = symbols.get(hands[0]);
        int you = symbols.get(hands[1]);
        if (rival - you == 0) {
            score += rival + 3;
        } else if (rival - you == -1 || rival - you== 2) {
            score += you + 6;
        } else {
            score += you;
        }
        return score;
    }

}
