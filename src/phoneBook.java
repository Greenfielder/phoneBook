import java.util.*;

//Задание:
//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что в во входной структуре будут повторяющиеся имена с разными телефонами,
// их необходимо считать, как одного человека с разными телефонами.
// Вывод должен быть отсортирован по убыванию числа телефонов.

public class phoneBook {
    public static void main(String[] args) {
        HashMap<String, HashSet<String>> phoneBook = new HashMap<>();
        // Добавление записей в телефонную книгу
        addContact(phoneBook, "Билл Голдберг", "123456789");
        addContact(phoneBook, "Билл Голдберг", "987654321");
        addContact(phoneBook, "Халк Хоган", "555555555");
        addContact(phoneBook, "Стив Остин", "111111111");
        addContact(phoneBook, "Халк Хоган", "222222222");
        addContact(phoneBook, "Халк Хоган", "5554321");
        addContact(phoneBook, "Стинг", "777777777");

        // Вывод телефонной книги, отсортированной по убыванию числа телефонов
        printPhoneBook(phoneBook);
    }
    public static void addContact(HashMap<String, HashSet<String>> phoneBook, String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            HashSet<String> phoneNumbers = phoneBook.get(name);
            phoneNumbers.add(phoneNumber);
        } else {
            HashSet<String> phoneNumbers = new HashSet<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }
    public static void printPhoneBook(HashMap<String, HashSet<String>> phoneBook) {
        List<Map.Entry<String, HashSet<String>>> sortedList = new ArrayList<>(phoneBook.entrySet());
        // Сортировка списка по убыванию числа телефонов
        sortedList.sort(new Comparator<Map.Entry<String, HashSet<String>>>() {
            @Override
            public int compare(Map.Entry<String, HashSet<String>> o1, Map.Entry<String, HashSet<String>> o2) {
                return Integer.compare(o2.getValue().size(), o1.getValue().size());
            }
        });
        // Вывод отсортированного списка
        for (Map.Entry<String, HashSet<String>> entry : sortedList) {
            System.out.println(entry.getKey() + " имеет " + entry.getValue().size() + " телефон(а)" + ": " + entry.getValue());
        }
    }
}