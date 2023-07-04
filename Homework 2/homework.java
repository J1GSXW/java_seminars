import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class homework {
    public static void main(String[] args) throws SecurityException, IOException {
        //Задание 1.
        printFileExtension();
        //Задание 2.
        int[] array = {3, 8, 2, 1, 5, 7, 4, 6, 9, 15, 10, 14, 20, 11, 17, 13, 18, 12, 16, 19};
        bubbleSort(array);
    }
//1) Напишите метод, который определит тип (расширение) файлов из текущей папки и выведет в консоль результат вида
// 1 Расширение файла: txt
// 2 Расширение файла: pdf
// 3 Расширение файла:
// 4 Расширение файла: jpg
    static void printFileExtension(){
        File folder = new File(".");
        
        File[] files = folder.listFiles();
        for (int i = 0; i < files.length; i++) {
                File file = files[i];
                String fileName = file.getName();
                String extension = getFileExtension(fileName);
                if (extension == "") extension = "папка";
                    System.out.println((i + 1) + " Расширение файла" + " - " + extension);
                }
    }
    static String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        
        if (dotIndex >= 0 && dotIndex < fileName.length() - 1) {
            return fileName.substring(dotIndex + 1);
        } else {
            return "";
        }
    }

// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
static void bubbleSort(int[] array) throws SecurityException, IOException {
    Logger logger = Logger.getLogger(homework.class.getName());
    FileHandler fh = new FileHandler("hw-log.txt");
    logger.addHandler(fh);
    SimpleFormatter simple = new SimpleFormatter();
    fh.setFormatter(simple);
        
    try {
        int utilswaps = 0; 
        for (int i = 0; i < array.length - 1; i++) {
            boolean swapped = false; 
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                    utilswaps++;
                }
            }     
            logger.info("Итерация " + (i + 1) + ": " + Arrays.toString(array));
            if (!swapped) {
                break;
            }
        }
        logger.info("Количество обменов " + utilswaps);
    } catch (Exception e) {
        logger.warning(e.getMessage());
    }
    }
}
