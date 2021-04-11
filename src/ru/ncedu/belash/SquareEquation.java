
package ru.ncedu.belash;
/**
 * Поиск решений квадратного уравнения. 
 * <p>Вид квадратного уравнения: a*x^2+b*x+c=0.</p>
 * 
 * <p>При решении квадратных уравнений возможны 3 следующих случая:</p>
 * <ul>
 * <li> Дискриминант больше нуля: уравнение имеет 2 корня.
 * <li> Дискриминант равен нулю: уравнение имеет 1 корень.
 * <li> Дискриминант меньше нуля: уравнение не имеет корней
 * </ul>
 * 
 * Метод getResults() осуществляет вычисление возможных корней квадратного
 * уравнения.
 * 
 * Класс Discriminant используется для вычисления дискриминанта квадратного
 * уравнения с помощью метода getDiscr(double a, double b, double c).
 * 
 * @params a,b,c коэффициенты уравнения.
 * 
 * @author Belash M.
 */
public class SquareEquation{
    private double a;
    private double b;
    private double c;

    public SquareEquation() {
    }

    public SquareEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }
    
    public void getResults(){ 
        double x1;
        double x2;
        try{
            Discriminant d = new Discriminant();
            double discr = d.getDiscr(a,b,c);
            if (discr>0){
                x1=(-b+Math.pow(discr,0.5))/(2*a);
                x2=(-b-Math.pow(discr,0.5))/(2*a);
                System.out.println("Result: x1 = "+x1+", x2 = "+x2);
            } else if (discr == 0){
                x1=-b/(2*a);
                System.out.println("Result: x = "+x1);
            } else{
                System.out.println("Result: no solutions");
            }
        }
        catch (ArithmeticException ex){
            System.out.println("Exception discr!");
        }
    }
    
    /**
     * Вычисление дискриминанта квадратного уравнения. Квадратное уравнение имеет
     * вид a*x^2+b*x+c=0
     * 
     * @params a,b,c коэффициенты уравнения.
     * @return значение дискриминанта discr.
     */
    
    private class Discriminant{
        double discr;

        public double getDiscr(double a, double b, double c) {
            discr = (b*b) - (4*a*c);
            return discr;
        }
        
    }
    
    public static void main(String[] args) {
        System.out.println("Решение квадратных уравнений.");
    }   
}
