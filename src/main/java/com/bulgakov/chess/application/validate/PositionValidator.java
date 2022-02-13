package com.bulgakov.chess.application.validate;

import com.bulgakov.chess.application.constant.Constant;

public class PositionValidator {

    /**
     * Checks the position for correctness.
     * <p>
     * This method checks the row and column for the correct entry.
     *
     * @param position - Position of the knight on the board
     * @throws IllegalArgumentException - Returns an exception if the position value is invalid.
     */
    public static void validate(String position) throws IllegalArgumentException {
        char firstChar = position.toLowerCase().charAt(0);
        if (!Character.isLetter(firstChar) || firstChar < 'a' || firstChar > 'h') {
            throw new IllegalArgumentException(Constant.WRONG_FIRST_LETTER);
        }

        char secondChar = position.toLowerCase().charAt(1);
        int num = Character.getNumericValue(secondChar);
        if (Character.isLetter(secondChar) || (num < 1 || num > 8)) {
            throw new IllegalArgumentException(Constant.WRONG_SECOND_LETTER);
        }
    }
}
