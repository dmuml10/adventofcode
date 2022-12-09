package ge.dm.year2022;

import java.util.Arrays;
import java.util.List;

public class TreetopTreeHouse {

    public static void main(String[] args) {
        System.out.println(solve());
    }

    public static int solve() {
        List<String> lines =
                JReader.ReadFileAsStringList("src/resources/year2022/Day8TreetopTreeHouse.txt");

        int columns = lines.get(0).length();
        int[][] grid = new int[lines.size()][columns];
        for(int i=0; i<lines.size(); i++) {
            for (int j=0; j<columns; j++) {
                grid[i][j] = Character.getNumericValue(lines.get(i).charAt(j));
            }
        }

        int sum = columns*2 + lines.size()*2 - 4;
        for(int i=1; i<lines.size()-1; i++) {
            for (int j = 1; j < columns - 1; j++) {
                if (isTreeVisible(grid, i, j)) {
                    sum ++;
                }
            }
        }

        System.out.println(Arrays.deepToString(grid));
        return sum;
    }

    private static boolean isTreeVisible(int[][] grid, int a, int b) {

        var top = true;
        for(int i=0; i<a; i++) {
            if (grid[i][b] >= grid[a][b]) {
                top = false;
                break;
            }
        }

        var bottom = true;
        for(int i=a+1; i<grid.length; i++) {
            if (grid[i][b] >= grid[a][b]) {
                bottom = false;
                break;
            }
        }

        var left = true;
        for (int j=0; j<b; j++) {
            if (grid[a][j] >= grid[a][b]) {
                left = false;
                break;
            }
        }

        var right = true;
        for (int j=b+1; j<grid[0].length; j++) {
            if (b != j && grid[a][j] >= grid[a][b]) {
                right = false;
                break;
            }
        }

        return top || bottom || left || right;
    }
}
