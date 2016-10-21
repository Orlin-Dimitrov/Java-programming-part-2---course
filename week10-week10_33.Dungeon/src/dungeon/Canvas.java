/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dungeon;

/**
 *
 * @author Dmitry
 */
public class Canvas {
    private int width;
    private int height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height][width];
    }

    public void clear() {
        this.matrix = new char[height][width];
    }
    
    public void print() {
        
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void setPoint(int x, int y, char c) {
        matrix[y][x] = c;
    }
}
