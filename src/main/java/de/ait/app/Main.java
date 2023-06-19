package de.ait.app;

import de.ait.repositories.BooksRepository;
import de.ait.repositories.BooksRepositoryListImpl;
import de.ait.repositories.BooksRepositoryTextFileImpl;
import de.ait.services.BookServiceImpl;
import de.ait.services.BooksService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BooksRepository booksRepository = new BooksRepositoryTextFileImpl("files/books.txt");
        BooksService booksService = new BookServiceImpl(booksRepository);



        while (true) {
            System.out.println("1. Вывести имена всех пользователей");
            System.out.println("2. Вывести фамилию самого взрослого пользователя");

            System.out.println("3. Сохранить нового пользователя"); // с консоли считываете имя фамилию возраст рост и сохраняете в файл
            System.out.println("4. Вывести средний возраст всех пользователей");
            System.out.println("5. Вывести возраст самого высокого человека");
            System.out.println("6. Вывести имя и фамилию самого низкого человека");

            System.out.println("0. Выход");

            int command = scanner.nextInt();
            scanner.nextLine();

            switch (command) {
                case 1:
                    //System.out.println("Выводим имена пользователей...");

                    //List<String> names = usersService.getNames();

//                    for (String name : names) {
//                        System.out.println(name);
//                    }

                    booksService.addBook("Title1");

                    break;
                case 2:
//                    System.out.println("Выводим самого взрослого пользователя");
//                    //String lastName = usersService.getLastNameOfMostAging();
//                    System.out.println(lastName);

                    break;
                case 0:
                    System.out.println("Выход");
                    System.exit(0);
                default:
                    System.out.println("Команда не распознана");
            }
        }
    }
}
