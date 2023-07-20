import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


import java.util.*;

public class Phonebook {
    private Map<String, Set<String>> contacts;

    public Phonebook() {
        contacts = new HashMap<>();
    }

    public void addContact(String name, String phone) {
        if (contacts.containsKey(name)) {
            contacts.get(name).add(phone);
        } else {
            Set<String> phones = new HashSet<>();
            phones.add(phone);
            contacts.put(name, phones);
        }
    }

    public void removeContact(String name) {
        contacts.remove(name);
    }

    public List<Map.Entry<String, Set<String>>> getSortedContacts() {
        List<Map.Entry<String, Set<String>>> sortedContacts = new ArrayList<>(contacts.entrySet());
        sortedContacts.sort((c1, c2) -> c2.getValue().size() - c1.getValue().size());
        return sortedContacts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Phonebook phonebook = new Phonebook();

        while (true) {
            System.out.println("1. Добавить контакт");
            System.out.println("2. Удалить контакт");
            System.out.println("3. Вывести отсортированный список контактов");
            System.out.println("4. Выход");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после считывания числа

            switch (choice) {
                case 1:
                    System.out.print("Введите имя: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите номер телефона: ");
                    String phone = scanner.nextLine();
                    phonebook.addContact(name, phone);
                    System.out.println("Контакт успешно добавлен.");
                    break;
                case 2:
                    System.out.print("Введите имя контакта, который нужно удалить: ");
                    String contactToRemove = scanner.nextLine();
                    phonebook.removeContact(contactToRemove);
                    System.out.println("Контакт успешно удален.");
                    break;
                case 3:
                    List<Map.Entry<String, Set<String>>> sortedContacts = phonebook.getSortedContacts();
                    for (Map.Entry<String, Set<String>> entry : sortedContacts) {
                        String contactName = entry.getKey();
                        Set<String> contactPhones = entry.getValue();
                        System.out.println(contactName + ": " + contactPhones.size() + " телефон(ов)");
                        for (String contactPhone : contactPhones) {
                            System.out.println("    " + contactPhone);
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("Вы успешно вышли.");
                    System.exit(0);
                default:
                    System.out.println("Неверный ввод. Пожалуйста, выберите действие из списка.\n ");
            }
        }
    }
}
