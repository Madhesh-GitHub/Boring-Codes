import java.util.Scanner;

public class LibraryManagementSystem {
    Scanner in =  new Scanner(System.in);
    int borrow = 0;
    String book;
    static String[] books = {
            "1. The Great Gatsby",
            "2. To Kill a Mockingbird",
            "3. 1984",
            "4. Pride and Prejudice",
            "5. The Catcher in the Rye",
            "6. The Hobbit",
            "7. Harry Potter and the Sorcerer's Stone",
            "8. The Lord of the Rings",
            "9. The Diary of a Young Girl",
            "10. Moby Dick"
    };
    void ViewBooks(){
        System.out.println("Available Books:");
        for (String i:books){
            System.out.println(i);
        }
    }
    String BorrowBooks(){
        int num;
        if(borrow<3){
            System.out.println("Enter the Book number: ");
            num = in.nextInt();
            book = books[num-1];
            books[num-1] = null;
            System.out.println("Here's your "+ book);
            return book;
        }
        else{
            System.out.println("You have already borrowed 3 books, return 1 to get a new one.");
            return null ;
        }
    }
    void ReturnBooks(String book, int number){
        books[number-1] = book;
        System.out.println("Thank you🤗.");
    }
}
class MainArea{
    public static void main(String[] args) {
        System.out.println("=====================================================================================");
        System.out.println("\n                         Welcome to Madhesh Library\n");
        System.out.println("=====================================================================================");
        Scanner in = new Scanner(System.in);
        boolean run = true;
        int choice;
        char ch;
        String[] my_books = new String[4];
        LibraryManagementSystem L = new LibraryManagementSystem();
        while (run) {
            System.out.println("Enter your choice:\n1. View Books\n2. Borrow Books\n3. Return Books\n4. Exit");
            choice = in.nextInt();
            switch (choice) {
                case 1:
                    L.ViewBooks();
                    break;
                case 2:
                    my_books[L.borrow] = L.BorrowBooks();
                    L.borrow++;
                    break;
                case 3:
                    if (L.borrow != 0){
                        System.out.println("Enter the Book number you want to return: ");
                        int no = in.nextInt();
                        in.nextLine();
                        System.out.println("Enter the Book name you want to return: ");
                        String name = in.nextLine();
                        L.borrow --;
                        for (int i = 0; i < my_books.length; i++) {
                            if (my_books[i].equals(name)) {
                                my_books[i] = null;
                            }
                        }
                        L.ReturnBooks(name, no);
                    }
                    else{
                        System.out.println("You doesn't have any book!");
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Choice!!");
            }
            System.out.println("Do You Want To Continue (y/n)? ");
            ch = in.next().charAt(0);
            if (ch == 'y') {
                run = true;
            } else if (ch == 'n') {
                run = false;
            } else {
                System.out.println("Sorry! Service Unavailable!");
                run = false;
            }

        }
    }
}
