package com.javarush.task.task35.task3513;

import java.util.*;

/**
 * Created by Dennis on 24.06.2017.
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    private Tile[][]gameTiles;

    public int score;
    public int maxTile;

    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private List<Tile> getEmptyTiles() {
        List<Tile>emptyTiles = new ArrayList<>();
        /*for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++)
                if (gameTiles[i][j].isEmpty())
                    emptyTiles.add(gameTiles[i][j]);
        }*/
        for (Tile[]tiles : gameTiles) {
            for (Tile tile : tiles) {
                if (tile.isEmpty())
                    emptyTiles.add(tile);
            }
        }

        return emptyTiles;
    }

    private void addTile() {
        List<Tile> tiles = getEmptyTiles();
        if (tiles != null && tiles.size() > 0) {
            Tile randomTile = tiles.get((int) (tiles.size() * Math.random()));
            randomTile.value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    public void resetGameTiles() {
        score = 0;
        maxTile = 2;
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++)
                gameTiles[i][j] = new Tile();
        }
        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int k = 0; k < tiles.length - 1; k++) {
            for (int i = 0; i < tiles.length - 1; i++) {
                if (tiles[i].isEmpty() && !tiles[i+1].isEmpty()) {
                    isChanged = true;
                    tiles[i] = tiles[i+1];
                    tiles[i+1] = new Tile();
                }
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        List<Tile> tmpList = new ArrayList<>();
        tmpList.addAll(Arrays.asList(tiles));
        for (int i = 0; i < tmpList.size() - 1; i++){
            if (tmpList.get(i).value == tmpList.get(i + 1).value &&
                    !tmpList.get(i).isEmpty() &&
                    !tmpList.get(i + 1).isEmpty()) {
                tmpList.get(i).value *= 2;
                score += tmpList.get(i).value;
                if (tmpList.get(i).value > maxTile) {
                    maxTile = tmpList.get(i).value;
                }

                tmpList.remove(i + 1);
                tmpList.add(new Tile());
                isChanged = true;
            }
        }
        if (isChanged) {
            for (int i = 0; i < tiles.length; i++) {
                tiles[i] = tmpList.get(i);
            }
        }
        return isChanged;
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            boolean a = compressTiles(gameTiles[i]);
            boolean b = mergeTiles(gameTiles[i]);
            if(a || b){
                isChanged = true;
            }
        }
        isSaveNeeded = true;
        if (isChanged)
            addTile();
    }

    private Tile[][] turnMatrix90Degrees(Tile[][] tiles) {
        Tile[][]tmpGameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tmpGameTiles[i][j] = gameTiles[gameTiles.length - 1 - j][i];
            }
        }
        return tmpGameTiles;
    }
    private Tile[][] turnBackMatrix90Degrees(Tile[][] tiles) {
        Tile[][]tmpGameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tmpGameTiles[i][j] = gameTiles[j][gameTiles.length - 1 - i];
            }
        }
        return tmpGameTiles;
    }

    public void up() {
        saveState(gameTiles);
        gameTiles = turnBackMatrix90Degrees(gameTiles);
        left();
        gameTiles = turnMatrix90Degrees(gameTiles);
    }

    public void down() {
        saveState(gameTiles);
        gameTiles = turnMatrix90Degrees(gameTiles);
        left();
        gameTiles = turnBackMatrix90Degrees(gameTiles);
    }

    public void right() {
        saveState(gameTiles);
        gameTiles = turnMatrix90Degrees(gameTiles);
        gameTiles = turnMatrix90Degrees(gameTiles);
        left();
        gameTiles = turnBackMatrix90Degrees(gameTiles);
        gameTiles = turnBackMatrix90Degrees(gameTiles);
    }

    public boolean canMove() {
        if(!getEmptyTiles().isEmpty()) return true;

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value == gameTiles[i][j-1].value)
                    return true;
            }
        }
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 1; j < gameTiles.length; j++) {
                if (gameTiles[j][i].value == gameTiles[j-1][i]. value)
                    return true;
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][]newTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                try {
                    newTiles[i][j] = (Tile) tiles[i][j].clone();
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        }

        previousStates.push(newTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (previousScores != null && previousScores.size() > 0 &&
                previousStates != null && previousStates.size() > 0) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 1:
                left(); break;
            case 2:
                up(); break;
            case 3:
                right(); break;
            case 4:
                down(); break;
        }
    }

    public boolean hasBoardChanged() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (gameTiles[i][j].value != previousStates.peek()[i][j].value)
                    return true;
            }
        }
        return false;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        MoveEfficiency moveEfficiency = null;
        move.move();
        if (!hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        } else {
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        }
        rollback();
        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                left();
            }
        }));
        priorityQueue.offer(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                right();
            }
        }));
        priorityQueue.offer(getMoveEfficiency(this::down));
        priorityQueue.offer(getMoveEfficiency(new Move() {
            @Override
            public void move() {
                up();
            }
        }));

        priorityQueue.peek().getMove().move();
    }
}
