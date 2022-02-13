package com.bulgakov.chess.application.knight;

import com.bulgakov.chess.application.board.Position;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PossibleMovesTest {

	@Test
	public void computePossibleMovesTest() {
		Position currentPosition = new Position("b2");
		Set<Position> result = PossibleMoves.computePossibleMoves(currentPosition);
		Set<Position> expected = new HashSet<>();
		expected.add(new Position("d1"));
		expected.add(new Position("c4"));
		expected.add(new Position("a4"));
		expected.add(new Position("d3"));

		assertEquals(expected, result);
	}
}
