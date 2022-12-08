package ge.dm.year2021.java;

import ge.dm.year2022.JReader;

public class SonarSweep {

    public static void main(String[] args) {
        var data = JReader.ReadFileAsStringList("src/resources/year2021/Day1SonarSweep.txt");

        int count = 0;
        for (int i=1; i<data.size(); i++) {
            if (Integer.parseInt(data.get(i)) > Integer.parseInt(data.get(i-1)))
                count ++;
        }
        System.out.println(count);
    }

}
