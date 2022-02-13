package com.bulgakov.chess.application.path;

import com.bulgakov.chess.application.board.Position;
import com.bulgakov.chess.application.constant.Constant;
import lombok.Getter;

import java.util.LinkedHashSet;

@Getter
public class FullPaths {
    private final LinkedHashSet<Position> path;

    public FullPaths() {
        path = new LinkedHashSet<>();
    }

    public FullPaths(FullPaths fullPaths) {
        this.path = new LinkedHashSet<>();

        for (Position positions : fullPaths.getPath()) {
            this.path.add(new Position(positions.getPosition()));
        }
    }

    public void addPositionToPath(Position p) {
        path.add(p);
    }

    public String getFullPath() {
        StringBuilder fullPosition = new StringBuilder();
        for (Position position : path) {
            String name = position.getPosition().toUpperCase();
            fullPosition.append(name);
            fullPosition.append(Constant.DELIMITER);
        }
        fullPosition.delete(fullPosition.length() - Constant.LENGTH_OF_DELIMITER, fullPosition.length());
        return fullPosition.toString();
    }
}
