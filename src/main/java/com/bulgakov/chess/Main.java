package com.bulgakov.chess;

import com.bulgakov.chess.application.board.Position;
import com.bulgakov.chess.application.constant.Constant;
import com.bulgakov.chess.application.path.FullPaths;
import com.bulgakov.chess.application.path.PathComputing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            System.out.println(Constant.INTRODUCTION);
            Scanner object = new Scanner(System.in);

            Position curPosition = new Position(object.nextLine());
            Position tarPosition = new Position(object.nextLine());

            String short_Path = PathComputing.computeShortPath(curPosition, tarPosition);

            System.out.println(Constant.WAY.concat(short_Path));
        } catch (NoSuchElementException e) {
            LOGGER.error(Constant.SOLUTION_NOT_EXIST, e);
        } catch (IllegalArgumentException e) {
            LOGGER.error(Constant.INTERNAL_ERROR, e);
        }
    }


}
