package com.bulgakov.chess.application.validate;

import com.bulgakov.chess.application.board.Position;
import com.bulgakov.chess.application.constant.Constant;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionValidateTest {
    @Test
    public void validateFirstWrongLetterTest() {

        try {
            new Position("11");
        } catch (IllegalArgumentException ex) { // then
            assertEquals(Constant.WRONG_FIRST_LETTER, ex.getMessage());
        }
    }

    @Test
    public void validateSecondWrongLetterTest() {
        try {
            new Position("AA");
        } catch (IllegalArgumentException ex) { // then
            assertEquals(Constant.WRONG_SECOND_LETTER, ex.getMessage());
        }
    }

    @Test
    public void validateWrongPositionTest() {
        try {
            new Position("1Aba1");
        } catch (IllegalArgumentException ex) { // then
            assertEquals(Constant.WRONG_POSITION, ex.getMessage());
        }
    }
}
