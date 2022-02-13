package com.bulgakov.chess.application.board;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PositionTest {

    @Test
    public void positionCorrectWorkTest() {

        Position position = new Position("c3");

        assertEquals(2, position.getColumn());
        assertEquals(5, position.getRow());

        position = new Position("C4");

        assertEquals(2, position.getColumn());
        assertEquals(4, position.getRow());

        Optional<Position> newPosition = Position.initializePosition(4, 1);

        assertTrue(newPosition.isPresent());
        assertEquals(new Position("B4").getPosition(), newPosition.get().getPosition());
    }
}
