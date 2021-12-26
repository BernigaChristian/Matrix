package me.berniga;
/**
 * @author : Christian Berniga
 * @class : 4 D
 * @created : 26/12/2021, domenica
 **/
public class SizeException extends Exception{
    public SizeException(){super();}

    @Override
    public String toString() {
        return "The number of colums of the first matrix is not equal to the number of rows of the second one,so you cannot multiply them";
    }
}
