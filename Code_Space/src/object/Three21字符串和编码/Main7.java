package object.Three21字符串和编码;

import java.util.Arrays;

public class Main7 {
	public static void main(String[] args) {
        int[] scores = new int[] { 88, 77, 51, 66 };
        Score2 s = new Score2(scores);
        s.printScores();
        scores[2] = 99;
        s.printScores();
    }
}

class Score2 {
    private int[] scores;
    public Score2(int[] scores) {
        this.scores = scores;
    }

    public void printScores() {
        System.out.println(Arrays.toString(scores));
    }
}