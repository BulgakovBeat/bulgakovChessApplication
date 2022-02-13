package com.bulgakov.chess.application.board;

import com.bulgakov.chess.application.constant.Constant;
import com.bulgakov.chess.application.validate.PositionValidator;
import lombok.Getter;

import java.util.Locale;
import java.util.Objects;
import java.util.Optional;

/**
 * Description of the position on board.
 * <p>
 * Move operations are calculated using numeric values, because it is easier than working with characters or strings.
 * Also, the function from Position uses lowercase characters for all calculations.
 */
@Getter
public class Position {
    private final int row;
    private final int column;
    private final String position;

    private Position(int row, int column) {
        this.row = row;
        this.column = column;
        this.position = String.format("%s%d", getCharForNumber(column), Constant.WIDTH_OF_BOARD - row).toLowerCase();
    }

    public Position(String position) throws IllegalArgumentException {
        if (position == null || position.length() != 2) {
            throw new IllegalArgumentException(Constant.WRONG_POSITION);
        }

        PositionValidator.validate(position);

        this.position = position.toLowerCase();
        this.row = Constant.WIDTH_OF_BOARD - Character.getNumericValue(this.position.charAt(1));
        this.column = this.position.charAt(0) - Constant.FIRST_LETTER;
    }

    public static Optional<Position> initializePosition(int x, int y) {
        if (x < 0 || x > 7 || y < 0 || y > 7) {
            return Optional.empty();
        }
        return Optional.of(new Position(x, y));
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof Position))
            return false;
        return Objects.equals(this.position, ((Position) object).position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    /**
     * Converts a number to a character.
     *
     * @param i - Column position.
     * @return Position in Char Value.
     */
    private char getCharForNumber(int i) {
        return (char) (Constant.FIRST_LETTER + i);
    }
}
