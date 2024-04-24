package org.example.Models;

import java.util.List;
import org.example.Models.Cell;
import org.example.Models.Move;

public class Bot extends Player {
    private BotDifficultyLevel botDifficultyLevel;

    public Bot(String name, Symbol symbol, PlayerType playerType, BotDifficultyLevel botDifficultyLevel) {
        super(name, symbol, playerType);
        this.botDifficultyLevel = botDifficultyLevel;
    }

    @Override
    public Move makeMove( Board board) {
        //Find the first empty cell and make the move there.
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }

    public enum BotDifficultyLevel {
        EASY,
        MEDIUM,
        HARD
    }
}
