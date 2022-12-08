package ge.dm.year2021.java;

import ge.dm.year2022.JReader;

public class Dive {

    public static void main(String[] args) {
        var data = JReader.ReadFileAsStringList("src/resources/year2021/Day2Dive.txt");

        int h = 0;
        int d = 0;
        for (String line : data) {
            if (line.contains("forward")) {
                h += getNum(line);
            } else if (line.contains("up")) {
                d -= getNum(line);
            } else {
                d += getNum(line);
            }
        }
        System.out.println(h*d);
    }

    private static int getNum(String line) {
        return Integer.parseInt(line.substring(line.indexOf(" ") + 1));
    }

}
