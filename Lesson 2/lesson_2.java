import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class lesson_2 {
    public static void main(String[] args) throws SecurityException, IOException {
        //Задача 1
        // System.out.println(longStringBuilding(10, 'a', 'b'));
        //Задача 2
        // System.out.println(stringCompress("aaaabbbcdd"));
        //Задача 3
        // System.out.println(isPalindrome("tenet"));
        //Задача 4
        String pathProject = System.getProperty("user.dir");
        // String pathFile1 = pathProject.concat("\\seminar2-1.txt");
        // addingToFile(pathFile, longStringCreator("Hello", 5));
        //Задача 5
        String pathFile2 = pathProject.concat("\\Seminar2-2.txt");
        addListToFile(pathFile2, showCurrentFiles(pathProject));

    }
//Дано чётное положительное число N и символы c1 и с2.
//Написать метод, который вернёт строку длины N которая состоит из
//чередущихся символов с1 и с2, начиная с с1.
    static String longStringBuilding(int N, char c1, char c2){
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < N / 2; i++) {
            newStr.append(c1);
            newStr.append(c2);
        }
        return newStr.toString();

    }
 
// Напишите метод, который сжимает строку.
// Пример: вход aaaabbbcdd. Результат - a4b3cd2 для примера
    static String stringCompress(String str){
        StringBuilder newStr = new StringBuilder();
        char symbol = str.charAt(0);
        newStr.append(symbol);
        int count = 0;

        for (char letter : str.toCharArray()) {
            if(letter == symbol) count++;
            else{
                if (count != 1 )newStr.append(count);

                newStr.append(letter);
                symbol = letter;
                count = 1;
            }
        }
        if (count != 1 )newStr.append(count);

        return newStr.toString();
    }

//Напишите метод, который принимает на вход строку, и определяет
//является ли строка палиндромом
    static boolean isPalindrome(String str){
        StringBuilder res = new StringBuilder("");
        for (int i = str.length() - 1; i >= 0; i--) {
            res.append(str.charAt(i));
        }
        return str.equals((res.toString()));
    }

//Напишите метод который составит строку, состоящую из 
//N повтоврений слова word
//и метод, который запишет эту строку в текстовый файл
//и обработать исключения
    static String longStringCreator(String word, int iters){
        StringBuilder newStr = new StringBuilder();

        for (int i = 0; i < iters; i++) {
            newStr.append(word);
        }
        return newStr.toString() + "\n";
    }

    static void addingToFile(String filePath, String text){
        try {
            File myFile = new File(filePath);
            FileWriter writer = new FileWriter(myFile, true);

            writer.write(text);
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//Напишите метод, который вернёт содержимое текущей папки в виде массива строк
//Напишите метод, который запишет массив, возвращённый предыдущим методом в файл.
//Обработайте ошибки с помощью try-catch конструкции
//В случае возникновения исключения оно должно записаться в лог-файл.

    static String[] showCurrentFiles(String dirPath){
        File currentDir = new File(dirPath);
        return currentDir.list();
    }

    static void addListToFile(String filePath, String[] list) throws SecurityException, IOException{
        Logger logger = Logger.getLogger(lesson_2.class.getName());
        FileHandler fh = new FileHandler("Seminar2-2(log).txt");

        logger.addHandler(fh);
        SimpleFormatter simple = new SimpleFormatter();
        fh.setFormatter(simple);

        try {
            File myFile = new File(filePath);
            FileWriter writer = new FileWriter(myFile);
            for (String str : list) writer.write(str + "\n");
            writer.close();
        
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }

}
//ДЗ таймкод 1:11:57