package com.bulgakov.chess.application.path;

import com.bulgakov.chess.application.board.Position;
import com.bulgakov.chess.application.constant.Constant;
import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class PathComputingTest {

    @Test
    public void computeFullPathsTest() {
        Position curPosition = new Position("A1");
        Position tarPosition = new Position("B3");
        TreeSet<FullPaths> paths = new TreeSet<>(Comparator.comparing(fullPaths -> fullPaths.getFullPath().length()));
        paths.addAll(PathComputing.computeFullPaths(curPosition, tarPosition));

        Set<String> expected = new HashSet<>();
        expected.add("A1" + Constant.DELIMITER + "B3");
        expected.add("A1" + Constant.DELIMITER + "C2" + Constant.DELIMITER + "B3");
        expected.add("A1" + Constant.DELIMITER + "C2" + Constant.DELIMITER + "D4" + Constant.DELIMITER + "B3");

        assertEquals(expected.toString(), paths.stream().map(FullPaths::getFullPath)
                .collect(Collectors.toList()).toString());
    }

    @Test
    public void computeShortPathTest() {
        Position curPosition = new Position("A1");
        Position tarPosition = new Position("B3");
        TreeSet<FullPaths> paths = new TreeSet<>(Comparator.comparing(fullPaths -> fullPaths.getFullPath().length()));
        paths.addAll(PathComputing.computeFullPaths(curPosition, tarPosition));
        String short_Path = paths.first().getFullPath();

        Set<String> expected = new HashSet<>();
        expected.add("A1" + Constant.DELIMITER + "B3");

        assertEquals(String.join(",", expected), short_Path);
    }
}
