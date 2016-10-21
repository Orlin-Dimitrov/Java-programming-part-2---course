/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import gameoflife.GameOfLifeBoard;
import java.util.Random;

/**
 *
 * @author Dmitry
 */
public class PersonalBoard extends GameOfLifeBoard {
    
    public PersonalBoard(int width, int height) {
        super(width, height);
    }

    @Override
    public void initiateRandomCells(double d) {
        if(d == 1.0) {
            for (int y = 0; y < getHeight(); y++) {
                for (int x = 0; x < getWidth(); x++) {
                    turnToLiving(x, y);
                }
            }
        }
        else if(d == 0.0) {
            for (int y = 0; y < getHeight(); y++) {
                for (int x = 0; x < getWidth(); x++) {
                    turnToDead(x, y);
                }
            }
        }
        else {
            for (int y = 0; y < getHeight(); y++) {
                for (int x = 0; x < getWidth(); x++) {
                    if (prosenttiaElossa(getBoard()) >= d * 100){
                        return;
                    }
                    double val = new Random().nextDouble();
                    if(val < d)
                        turnToLiving(x, y);
                }
            }
        }
    }
    
    public double prosenttiaElossa(boolean[][] matriisi) {
        int koko = matriisi.length * matriisi[0].length;

        int lkm = 0;
        for (boolean[] rivi : matriisi) {
            for (boolean alkio : rivi) {
                if (alkio) {
                    lkm++;
                }
            }
        }

        return 100.0 * lkm / koko;
    }

    @Override
    public boolean isAlive(int i, int i1) {
        try {
            return getBoard()[i][i1];
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void turnToLiving(int i, int i1) {
        try {
            getBoard()[i][i1] = true;
        } catch (Exception e) {};
    }

    @Override
    public void turnToDead(int i, int i1) {
        try {
            getBoard()[i][i1] = false;
        } catch (Exception e) {};
    }

    @Override
    public int getNumberOfLivingNeighbours(int i, int i1) {
        int count = 0;
        int row = i;
        int col = i1;
        int cols = getHeight();
        int rows = getWidth();
        boolean[][] grid = getBoard();
    if (row-1 >= 0) {
        if (grid[row-1][col] == true) count++;
    }
    if (row-1 >= 0 && col-1 >= 0) {
        if (grid[row-1][col-1] == true) count++;
    }
    if (row-1 >= 0 && col+1 < cols) {
        if (grid[row-1][col+1] == true) count++;
    }
    if (col-1 >= 0) {
        if (grid[row][col-1] == true) count++;
    }
    if (col+1 < cols) {
        if (grid[row][col+1] == true) count++;
    }
    if (row+1 < rows) {
        if (grid[row+1][col] == true) count++;
    }
    if (row+1 < rows && col-1 >= 0) {
        if (grid[row+1][col-1] == true) count++;
    }
    if (row+1 < rows && col+1 < cols) {
        if (grid[row+1][col+1] == true) count++;
    }
    return count;
    }

    @Override
    public void manageCell(int x, int y, int numNeighbors) {
        boolean[][] grid = getBoard();
        int row = x;
        int col = y;
        if (grid[row][col] == true) {
        if (numNeighbors < 2) {
            grid[row][col] = false;
        } else if (numNeighbors == 2 || numNeighbors == 3) {
            grid[row][col] = true;
        } else if (numNeighbors > 3) {
            grid[row][col] = false;
        }
    } else if (grid[row][col] == false) {
        if (numNeighbors == 3) {
            grid[row][col] = true;
        }
    }
    }
    
}
