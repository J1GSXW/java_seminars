import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;



public class lesson_3 {
    public static void main(String[] args) {
        //Задача 1
        //createRandomList(5, 10);
        //Задача 2
        // planetsCounter(10);
        createTable(3);

    }

//Заполнить список N случайными числами,
//Отсортировать список методом Sort и вывести его на экран

    static void createRandomList(int size, int maxValue){
        ArrayList<Integer> nums = new ArrayList<>(size);
        Random rand = new Random();

        for (int i = 0; i < size; i++) 
            nums.add(rand.nextInt(maxValue));
        
        for (Integer num : nums)
            System.out.print(num + " ");
        System.out.println();

        nums.sort(Comparator.naturalOrder());

        Iterator<Integer> iter = nums.iterator();

        while(iter.hasNext())
            System.out.print(iter.next() + " ");
        System.out.println();
    }

//Заполнить список названиями планет солнечной системы в произвольном
//порядке с повторениями. Вывести название каждой планеты, и количество
//её повторений в списке

    static void planetsCounter(int n){
        List<String> listPlanets = List.of("Mercury", "Earth", "Venus", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune");
        List<String> randPlanets = new ArrayList<String>(n);
        int[] counts = new int[listPlanets.size()];

        Random rand = new Random();
        for (int i = 0; i < n; i++){
            randPlanets.add(listPlanets.get(rand.nextInt(listPlanets.size())));
            System.out.print(randPlanets.get(i) + " ");
            counts[listPlanets.indexOf(randPlanets.get(i))]++;
        }
        System.out.println();

        // for (String planet : randPlanets) {
        //     counts[listPlanets.indexOf(planet)]++;
        // }

        for (int i = 0; i < counts.length; i++) {
            System.out.printf("%s - %s\n", listPlanets.get(i), counts[i]);
        }

    }


//Каталог товаров книжного магазина сохранен в виде двумерного списка
//List<ArrayList<String>>, так, что на нулевой позиции каждого внутреннего списка содержится
//название жанра, а на остальных позициях названия книг.
//Напишите метод, который заполнит данную структуру
    static void createTable(int size){
        List<String> genres = List.of("Фантастика", "Комедия", "Детектив", "Ужасы");
        List<ArrayList<String>> table = new ArrayList<>(genres.size());
        Scanner input = new Scanner(System.in, "Cp866");

        for (int i = 0; i < genres.size(); i++) {
            ArrayList<String> booksOfGenre = new ArrayList<>(size);
            booksOfGenre.add(genres.get(i) + ":");
            System.out.printf("Input %d titles of %s genre down here:\n", size, genres.get(i));
            for (int j = 0; j < size; j++)
                booksOfGenre.add(input.nextLine());
            
            table.add(booksOfGenre);
        }
        input.close();

        for (ArrayList<String> books : table) {
            for (String book : books) {
                System.out.print(book + " ");
            }
            System.out.println();
        }
    }
}