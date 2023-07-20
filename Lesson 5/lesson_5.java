import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * lesson_5
 */
public class lesson_5 {
    public static void main(String[] args) {
        ex3_2();
    }
    // Task 1. Создать структуру для хранения 
    // номеров паспортов и фамилий сотрудников.
    static void ex1(){
        Map<String, String> workers = new HashMap<>();
        workers.put("100", "Ivanov");
        workers.put("101", "Petrov");
        workers.put("102", "Ivanov");
        workers.put("103", "Sidoroc");
        workers.put("104", "Ivanov");
        workers.put("105", "Pupkin");
        
        for(Map.Entry<String, String> worker : workers.entrySet()){
            if(worker.getValue().equals("Petrov"))
            System.out.printf("Passport number: %s, Worker surname: %s\n", worker.getKey(), worker.getValue());
        }
    }

// Task 2. Написать метод, который переведет число из римского формата записи в арабский.
    static void ex2(){
        Map<Character, Integer> rimNums = new HashMap<>();
        rimNums.put('I', 1);
        rimNums.put('V', 5);
        rimNums.put('X', 10);
        rimNums.put('L',50);
        rimNums.put('C', 100);
        rimNums.put('D', 500);
        rimNums.put('M', 1000);

        Scanner input = new Scanner(System.in);

        System.out.println("Input a number in a Rome case: ");
        char[] romeNumber = input.nextLine().toUpperCase().toCharArray();
        int res = 0;

        for (int i = 0; i < romeNumber.length; i++) {
            if(i != romeNumber.length -1 && rimNums.get(romeNumber[i]) < rimNums.get(romeNumber[i+1])){
                res += rimNums.get(romeNumber[i+1]) - rimNums.get(romeNumber[i]);
                i++;
            }
            else res += rimNums.get(romeNumber[i]);
        }
        System.out.println(res);
        input.close();
    }
    
// Написать метод, который сортирует строки по длине с помощью 
//TreeMap. Строки с одинаковой длиной не должны “потеряться”.
    static void ex3_1(){
        Scanner input = new Scanner(System.in);

        System.out.print("Input a string: ");
        String[] words = input.nextLine().split(" ");

        Map<Integer, String> sortWords = new TreeMap<>();

        for (String word : words)
            sortWords.put(word.length(), word);

        System.out.println(sortWords);
        input.close();
    }
    
    static void ex3_2(){
        Scanner input = new Scanner(System.in);

        System.out.print("Input a string: ");
        String[] words = input.nextLine().split(" ");

        Map<Integer, LinkedList<String>> sortedWords = new TreeMap<>();

        for (String word : words) {
            if(sortedWords.containsKey(word.length())){
                sortedWords.get(word.length()).add(word);
            } else {
                sortedWords.put(word.length(), new LinkedList<>());
                sortedWords.get(word.length()).add(word);
            }
        }
        System.out.println(sortedWords);
        input.close();
    }

}
