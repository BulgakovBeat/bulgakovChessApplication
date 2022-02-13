package com.bulgakov.chess.application.path;

import com.bulgakov.chess.application.board.Position;
import com.bulgakov.chess.application.constant.Constant;
import com.bulgakov.chess.application.knight.PossibleMoves;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class PathComputing {
    private static final Logger LOGGER = LoggerFactory.getLogger(PathComputing.class);

    public static String computeShortPath(Position curPosition, Position tarPosition) {
        TreeSet<FullPaths> paths = new TreeSet<>(Comparator.comparing(fullPaths -> fullPaths.getFullPath().length()));
        paths.addAll(PathComputing.computeFullPaths(curPosition, tarPosition));
        return paths.first().getFullPath();
    }

    public static Set<FullPaths> computeFullPaths(Position start, Position end) {
        Set<FullPaths> pathsResult = new LinkedHashSet<>();
        FullPaths fullPaths = new FullPaths();
        Boolean result = computePath(pathsResult, start, end, 0, fullPaths);

        System.out.println(LOGGER.getClass() + Constant.RESULT.concat(result.toString().toUpperCase()));
        return pathsResult;
    }

    /**
     * Calculates all possible paths to get the target position.
     *
     * <p>
     * Calculates all possible paths using DFS algorithms for the knight. Uses a turn counter for existing restrictions.
     *
     * @param paths        - All possible paths from the starting position to the current position
     *                     that satisfy the conditions
     * @param curPos       - The current position.
     * @param tarPos       - The target position.
     * @param movesCounter - The number of steps for the target position.
     * @param currentPath  - List of steps from current position to target position.
     * @return True - if the path exists, otherwise False.
     */
    private static Boolean computePath(Set<FullPaths> paths, Position curPos, Position tarPos, int movesCounter,
                                       FullPaths currentPath) {
        if (movesCounter > Constant.MOVES_LIMIT) {
            return false;
        }

        currentPath.addPositionToPath(curPos);

        if (curPos.equals(tarPos)) {
            paths.add(currentPath);
            return true;
        }

        Set<Position> possibleMoves = PossibleMoves.computePossibleMoves(curPos);

        return possibleMoves.stream()
                .map(possibleMove -> computePath(paths, possibleMove, tarPos, movesCounter + 1,
                        new FullPaths(currentPath))).reduce(false, (a, b) -> a || b);
    }
}
