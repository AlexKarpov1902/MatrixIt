/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package karpov.iterator;

/**
 *
 * @author Alex_2
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {

    private final int[][] data;
    private int row = 0;
    private int column = -1;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        int c = column;
        int r = row;
        while (true) {
            if (data[r].length <= c + 1) {
                c = -1;
                r++;
            } else {
                return true;
            }
            if (data.length <= r) {
                return false;
            }
        }
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (true) {
            if (data[row].length <= ++column) {
                column = -1;
                row++;
            } else {
                return data[row][column];
            }
        }
    }
}
