package me.berniga;

import java.util.Random;
import java.util.Scanner;

/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 23/12/2021, giovedì
 **/
public class Matrix {
    private int[][] matrix;

    public Matrix(int size){
        matrix=new int[size][size];
    }

    public int getSize(){
        return matrix[0].length;
    }

    public int getValue(int row,int column){
        return matrix[row][column];
    }

    public void setValue(int row,int column,int value){
        matrix[row][column]=value;
    }

    public void zeroFill(){
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix.length;j++)
                matrix[i][j]=(i==j)?1:0;
    }

    public void randomFill(){
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix.length;j++)
                matrix[i][j]=new Random().nextInt(101);
    }

    public void inputFill(){
        Scanner scan=new Scanner(System.in);
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix.length;j++)
                matrix[i][j]=scan.nextInt();
    }

    private int rowSum(int rowNumber){
        int sum=0;
        for(int i=0;i<matrix.length;i++)
            sum+=matrix[rowNumber][i];
        return sum;
    }

    public boolean isPalindrome(){
        for(int i=0;i<(matrix.length/2);i++)
            if(rowSum(i)!=rowSum(matrix.length-i-1))   return false;
        return true;
    }

    private boolean onlyZerosOnes(){
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix.length;j++)
                if(matrix[i][j]!=0&&matrix[i][j]!=1)    return false;
        return true;
    }

    public void chessBoardFill(){
        int num=0;
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix.length;j++)
                matrix[i][j]=(i==0&&j==0)?(num=0):((num==0)?++num:--num);
    }

    public boolean isChessBoard(){
        if(!onlyZerosOnes())    return false;
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j< matrix.length&&(i!=(matrix.length-1)&&j!=(matrix.length-1));j++) {
                /**controllo pima cella di ogni riga che sia diversa dall'ultima della riga precedente**/
                if(j==0&&i>0) {
                    if (matrix.length % 2 == 0 && (matrix[i][0] == matrix[i - 1][0])) return false;
                    if(matrix[i][0]==matrix[i-1][matrix.length-1])    return false;
                }
                if (matrix[i][j + 1] != (matrix[i][j] - 1) && matrix[i][j + 1] != (matrix[i][j] + 1)) return false;
            }
        return true;
    }

    private boolean rowsCheck(int row,int column){
        for(int i=row;i<(matrix.length-1);i++)
            if(matrix[i][column]>matrix[i+1][column])   return false;
        return true;
    }

    private boolean columnsCheck(int row,int column){
        for(int i=column;i<(matrix.length-1);i++)
            if(matrix[row][i]>matrix[row][i+1])   return false;
        return true;
    }

    public boolean isLessProperty(){
        for(int i=0;i< matrix.length;i++)
            for(int j=0;j< matrix.length;j++)
                if(!rowsCheck(i,j)&&!columnsCheck(i,j))  return false;
        return true;
    }

    public boolean multiplicationProperty(){
        for(int i=0;i< matrix.length;i++)
            for(int j=0;j< matrix.length;j++)
                if(matrix[i][j]!=(i*j))  return false;
        return true;
    }

    public void matrixSum(Matrix m){
        try{
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix.length; j++)
                    matrix[i][j] += m.getValue(i, j);
        } catch(ArrayIndexOutOfBoundsException e){}
    }

    private int rowMultiplication(int row,int column){
        int result=1;
        for(int i=0;i<=column;i++)
            result*=matrix[row][i];
        return result;
    }

    private int columnMultiplication(int row,int column){
        int result=1;
        for(int i=0;i<=row;i++)
            result*=matrix[i][column];
        return result;
    }

    public Matrix matrixMultiplication(Matrix m)    throws SizeException{
        if(matrix.length!=m.getSize())  throw new SizeException();
        Matrix result=new Matrix(matrix.length);
            for (int i = 0; i < matrix.length; i++)
                for (int j = 0; j < matrix.length; j++)
                    result.setValue(i, j, this.rowMultiplication(i, j) + m.columnMultiplication(i, j));
        return result;
    }

    public String toString(){
        String matrixString="";
        for(int i=0;i< matrix.length;i++) {
            for (int j = 0; j < matrix.length; j++)
                matrixString += matrix[i][j] + "\t";
            matrixString+="\n";
        }
        return matrixString;
    }
}
