public class Main {
    public static void main (String []
    args) {
        if (args.length != 2) {
System.out.println("Небходимо передать два числа в качестве аргументов");
        return;
        
        }
        
        double a = 
Double.parseDouble(args[0]);
        double b = 
Double.parseDouble(args[1]);    
        
        if (a + b > 100) {
            double result = 2 * Math.sin(a);
System.out.println("Результат: " + result);

        } else {
            System.out.println("Cумма чисел меньше или равна 100");
        }
    }
}
