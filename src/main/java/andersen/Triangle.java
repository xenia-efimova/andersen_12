package andersen;

import static java.lang.Math.sqrt;

public class Triangle {
    private int a;
    private int b;
    private  int c;

    public double squareTriangle(int a, int b, int c){
        if ((a<=0) || (b<=0) || (c<=0)){
            throw new ArithmeticException("Введены некорректные данные");
        } if((a+b) <= c || (b+c) <= a || (a+c) <= b){
            throw new ArithmeticException("Это не треугольник");
        }
        int p = (a + b + c)/2;
        return sqrt(p*(p - a)*(p - b)*(p - c));
    }
}
