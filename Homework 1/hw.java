import java.util.Scanner;

public class hw {
    public static void main(String[] args) {
        Calculator();
    }


// Задание 1.1. Вычислить n-ое треугольного число (сумма чисел от 1 до n)
    static void triangleNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите ваше число: ");
        int result = 0;
        Integer number = scan.nextInt();
        for (int i = 0; i < number; i++)
            result = number * (number + 1) / 2;
        System.out.println(result);
        scan.close();
    }
//1.2 Вычислить n! (произведение чисел от 1 до n)
    static void factorial(){
        Scanner scan = new Scanner(System.in);
        System.out.println("введите ваше число");
        int result = 1;
        Integer number = scan.nextInt();
        for (int i = 1; i <= number; i++)
            result = result * i;

        System.out.println(result);
        scan.close();
    }


//Задача 2. Вывести все простые числа от 1 до 1000
    static void getPrimes() {
        for (int i = 2; i <= 1000; i++) {
            if (isPrime(i)) System.out.println(i);
        }
        System.out.println("Это все числа от 1 до 1000.");
    }

    static boolean isPrime(int N) {
        if (N < 2) return false;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) return false;
        }
        return true;
    }
    //Реализовать простой калькулятор
    static void Calculator(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Привет, выбери, что бы ты хотел сделать:\n1. Cложить. \n2. Вычесть. \n3. Умножить. \n4. Поделить");
        int doing = scan.nextInt();
        System.out.printf("Ты выбрал %s. Введи свое первое число: ", doing);
        int num1 = scan.nextInt();
        System.out.print("Теперь введи второе число: ");
        int num2 = scan.nextInt();
        if (doing == 1) System.out.println(num1 + num2);
        else if (doing == 2) System.out.println(num1 - num2);
        else if (doing == 3) System.out.println(num1 * num2);
        else if (doing == 4) System.out.println(num1 / num2);
        else System.out.println("Некорректный ввод");
        scan.close();

    }
}

