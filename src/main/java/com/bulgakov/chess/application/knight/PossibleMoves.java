package com.bulgakov.chess.application.knight;

import com.bulgakov.chess.application.board.Position;
import com.bulgakov.chess.application.constant.Constant;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class PossibleMoves {

    /**
     * Returns all possible moves by the knight from the current position.
     * <p>
     * This method calculates all possible positions of the knight.
     * The knight walks like an L in different angles and ways.
     *
     * @param currentPosition - The current position of the knight.
     * @return The set of possible moves, or Null if they don't exist
     */
    public static Set<Position> computePossibleMoves(Position currentPosition) {
        int currX = currentPosition.getRow();
        int currY = currentPosition.getColumn();
        Set<Optional<Position>> setPositions = new HashSet<>(Constant.MOVEMENT_WAYS);
        for (int i = 1; i <= 2; i++)
            for (int j = -1; j <= 1; j = j + 2) {
                setPositions.add(Position.initializePosition(currX + i, currY + j * (i - 3)));
                setPositions.add(Position.initializePosition(currX - i, currY + j * (i - 3)));
            }

        return setPositions.stream().filter(Optional::isPresent).map(Optional::get).collect(Collectors.toSet());
    }
}
