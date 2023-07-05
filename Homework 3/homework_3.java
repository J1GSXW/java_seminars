import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class homework_3 {
    public static void main(String[] args) {
        // Задание 1.1
        ArrayList<Integer> myArray = createRandomArray(10, 20);
        showArray(myArray);
        ArrayList<Integer> newArray = deleteEvenNumber(myArray);
        showArray(newArray);
        // // Задания 1.2 1.3
        // findMinOfMaxValue(myArray);
        // // Задание 1.4
        // averageFound(myArray);
        // // Задание 2
        // List<String> planetArray = planetsCounter(10);
        // showList(planetArray);
        // List<String> removedArray = removeDuplicates(planetArray);
        // showList(removedArray);
    }

// 1.Пусть дан произвольный список целых чисел.
// 1.1) Нужно удалить из него чётные числа
// 1.2) Найти минимальное значение
// 1.3) Найти максимальное значение
// 1.4) Найти среднее значение
    static ArrayList<Integer> createRandomArray(int size, int maxValue){
        Random rand = new Random();
        ArrayList<Integer> array = new ArrayList<>(size);
        for (int i = 0; i < size; i++)
            array.add(rand.nextInt(maxValue));
        return array;
    }

    static void showArray(ArrayList<Integer> array){
        for (Integer idx : array)
            System.out.print(idx + " ");
        System.out.println();
    }

    static void showList(List<String> array){
        for (String str : array)
            System.out.print(str + " ");
        System.out.println();
    }

    //удаление чётных чисел
    static ArrayList<Integer> deleteEvenNumber(ArrayList<Integer> array){
        int size = array.size();
        for (int i = 0; i < size - 1; i++)
            for (int j = i; j < size; j++) {
            if(array.get(i) % 2 == 0){
                array.remove(i);
                size--;
                j--;
            }
            }
        return array;
    }

    //максимальное и минимальное значение
    static void findMinOfMaxValue(ArrayList<Integer> array){
        Scanner scan = new Scanner(System.in);
        System.out.println("Вы ищете минимальное или максимальное число?\n1.Введите min если минимальное\n2.Введите max если максимальное");
        int user_choice = scan.nextInt();
        int minValue = array.get(0);
        int maxValue = array.get(0);
        if(user_choice == 1){
            for (int i = 0; i < array.size(); i++)
                if(array.get(i) < minValue) minValue = array.get(i);
            System.out.print(minValue);
        }
        else if(user_choice == 2){
            for(int i = 0; i < array.size(); i++)
                if(array.get(i) > maxValue) maxValue = array.get(i);
            System.out.println(maxValue);
        }
        else System.out.println("Некорректный ввод");
        scan.close();
    }
    //среднее арифметическое
    static void averageFound(ArrayList<Integer> array){
        double current = 0;
        double count = 0;
        double average = 0;
        for (int i = 0; i < array.size(); i++) {
            current += array.get(i);
            count++;
        }
        average = current / count;
        System.out.print("Cреднее арифметическое чисел в массиве: " + average);
        System.out.println();
    }

//Для списка из задачи про Солнечную систему удалить все повторяющиеся элементы.
    static List<String> planetsCounter(int n){
        List<String> listPlanets = List.of("Mercury", "Earth", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune");
        List<String> randPlanets = new ArrayList<String>(n);

        Random rand = new Random();
        
        for (int i = 0; i < n; i++){
            randPlanets.add(listPlanets.get(rand.nextInt(listPlanets.size())));
        }
        return randPlanets;
    }

    static List<String> removeDuplicates(List<String> strings) {
    int size = strings.size();
    for (int i = 0; i < size - 1; i++) {
        for (int j = i + 1; j < size; j++) {
            if (!strings.get(j).equals(strings.get(i)))
                continue;
            strings.remove(j);
            j--;
            size--;
        }
    }

    return strings;

    }
}