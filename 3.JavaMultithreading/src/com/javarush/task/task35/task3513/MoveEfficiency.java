package com.javarush.task.task35.task3513;

/**
 * Created by Dennis on 24.06.2017.
 */
public class MoveEfficiency implements Comparable<MoveEfficiency> {
    private int numberOfEmptyTiles;
    private int score;
    private Move move;

    public MoveEfficiency(int numberOfEmptyTiles, int score, Move move) {
        this.numberOfEmptyTiles = numberOfEmptyTiles;
        this.score = score;
        this.move = move;
    }

    public Move getMove() {
        return move;
    }

    @Override
    public int compareTo(MoveEfficiency o) {
        if (o == null) return 1;
        int result = Integer.compare(numberOfEmptyTiles, o.numberOfEmptyTiles);
        if (result != 0)
            return result;

        return Integer.compare(score, o.score);
    }
}
