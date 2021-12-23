package me.berniga;
/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 23/12/2021, giovedì
 **/
public class Main {
    public static void main(String[] args) {
        Matrix m1=new Matrix(5);
        Matrix m2=new Matrix(2);
        Matrix m3=new Matrix(4);
        Matrix m4=new Matrix(3);
        m1.randomFill();
        m2.zeroFill();
        m3.oneFill();
        m4.oneFill();
        Matrix m5=m3.matrixMultiplication(m4);
        System.out.println("Matrix 1\n"+m1);
        System.out.println("Matrix 2\n"+m2);
        System.out.println("Matrix 3\n"+m3);
        System.out.println("Matrix 4\n"+m4);
        System.out.println("Matrix 5\n"+m5);
        m1.matrixSum(m2);
        System.out.println("Matrix 1+Matrix 2\n"+m1);
        System.out.println("Matrix 1 properties\n"+m1.isPalindrome()+"\t"+m1.isLessProperty()+"\t"+m1.isChessBoard()+"\t"+m1.multiplicationProperty());
        System.out.println("Matrix 2 properties\n"+m2.isPalindrome()+"\t"+m2.isLessProperty()+"\t"+m2.isChessBoard()+"\t"+m2.multiplicationProperty());
    }
}
