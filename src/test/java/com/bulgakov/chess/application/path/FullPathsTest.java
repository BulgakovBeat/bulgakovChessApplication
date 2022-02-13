package com.bulgakov.chess.application.path;

import com.bulgakov.chess.application.board.Position;
import com.bulgakov.chess.application.constant.Constant;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FullPathsTest {

    @Test
    public void getFullPathTest() {

        FullPaths p = new FullPaths();

        p.addPositionToPath(new Position("a1"));
        p.addPositionToPath(new Position("b3"));
        p.addPositionToPath(new Position("c5"));

        assertEquals("A1" + Constant.DELIMITER + "B3" + Constant.DELIMITER + "C5", p.getFullPath());
    }

    @Test
    public void addFullPathConstructorTest() {

        FullPaths temp = new FullPaths();
        temp.addPositionToPath(new Position("B2"));

        FullPaths path = new FullPaths(temp);
        path.addPositionToPath(new Position("d5"));
        path.addPositionToPath(new Position("a4"));

        assertEquals("B2" + Constant.DELIMITER + "D5" + Constant.DELIMITER + "A4", path.getFullPath());

    }
}
