import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class lesson_4 {
    public static void main(String[] args) {
        addStrings();
    }
// 1) Замерьте время, за которое в ArrayList добавятся 1000000 элементов.
// 2) Замерьте время, за которое в LinkedList добавятся 1000000 элементов. Сравните с предыдущим.
    static void timeCompairing(){
        ArrayList<Integer> al = new ArrayList<>();
        LinkedList<Integer> ll = new LinkedList<>();

        long start1 = System.currentTimeMillis();

        for (int i = 0; i < 1_000_000; i++) {
            al.add(5);
        }
        System.out.println(System.currentTimeMillis() - start1);

        long start2 = System.currentTimeMillis();

        for (int i = 0; i < 1_000_000; i++) {
            ll.add(5);
        }
        System.out.println(System.currentTimeMillis() - start2);
    }

// Реализовать консольное приложение, которое:
// 1. Принимает от пользователя строку вида text~num;
// 2. Рассплитить строку по ~, сохранить text в связный список на позицию num;
// 3. Если введено print~num - выводить строку из позиции num в связном списке и удалить её из списка.

    static void splitText(){
        LinkedList<String> myList = new LinkedList<>();

        Scanner input = new Scanner(System.in);
        String data = "end";
        while (true){
            System.out.printf("Input text~num, 0 <= num <= %d\n", myList.size());
            data = input.nextLine();
            if(data.equals("end")) {
                input.close();
                return;
            }
            changingList(myList, data);
            System.out.println(myList);
        }
    }

    static void changingList(LinkedList<String> myList, String data) {
        try {
            int index = Integer.parseInt(data.split("~")[1]);
            String text = data.split("~")[0];
            if(text.equals("print")){
                System.out.println(myList.get(index));
                myList.remove(index);
            } else myList.add(index, text);
        } catch (Exception e) {
            System.out.println("You have to input a correct number!");
        }
    }

// Реализовать консольное приложение, которое:
// 1. Принимает от пользователя строки;
// 2. Если введено print - выводит строки от последней к первой;
// 3. Если введено revert - удаляет предыдущую введенную строку из памяти.

    static void addStrings() {
        Deque<String> myList = new LinkedList<>();

        Scanner input = new Scanner(System.in);
        String data = "end";
        while (true){
            System.out.println("Input something, of print, or revert, or end");
            data = input.nextLine();
            if(data.equals("end")) {
                input.close();
                return;
            }
            changingList(myList, data);
            System.out.println(myList);
        }
    }
    static void changingList(Deque<String> myList, String data) {
        if(data.equals("print")){
            for (String item : myList)
                System.out.printf("%s ",item);
        } else if (data.equals("revert")) {
            myList.pollFirst();
        } else {
            myList.addFirst(data);
        }
    }
}
