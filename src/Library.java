import java.util.ArrayList;
import java.util.Scanner;

class ManageLibrary{
    private int SNo;
    private String name;
    private String Author;
    private int count;
    ManageLibrary(int SNO,String name,String Author,int count){
        this.SNo = SNO;
        this.name = name;
        this.Author = Author;
        this.count=count;
    }
    int getNO(){
      return SNo;  
    }

    String getName(){
        return name;
    }

    String getAuthor(){
        return Author;
    }

    int getbookCount(){
        return count;
    }

    void displayBook(){
        System.out.println("================ Book "+SNo+" ================");
        System.out.println("Book: "+name);
        System.out.println("Author: "+Author);
        System.out.println("No.of Copies: "+count);

    }
}

class MainLibrary{
    private ArrayList <ManageLibrary> books = new ArrayList<>();

    void addBook(int SNO,String name,String Author,int count){
        ManageLibrary newbook = new ManageLibrary(SNO, name, Author, count);
        books.add(newbook);
        System.out.println("Book "+name+" Added Successfully!");
    }

    void displayBook(){
        if (books.isEmpty()){
            System.out.println("Library is Empty!");
        }
        else{
            for (ManageLibrary book : books){
              book.displayBook();  
            }
        }
    }
}

public class Library{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MainLibrary myLibrary = new MainLibrary();
        System.out.println("Welcome to Java Library!");
        while (true){
            System.out.println("\n1.Add Book\n2.Available Books\n3.Quit");
            System.out.print("Your choice: ");
            int choice = input.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.print("S.NO: ");
                    int SNo = input.nextInt();
                    System.out.print("Book Name: ");
                    input.nextLine();
                    String name = input.nextLine();
                    System.out.print("Author: ");
                    String author = input.nextLine();
                    System.out.print("No.of.Copies: ");
                    int copies = input.nextInt();
                    myLibrary.addBook(SNo, name, author, copies);
                    break;
                }

                case 2 -> {
                    myLibrary.displayBook();
                    break;
                }
                case 3 -> {
                    System.out.println("Do you want to close the Library?");
                    System.out.print("1.Yes or 2.No: ");
                    input.nextLine();
                    String decision = input.nextLine();
                    if(decision.equals("1")) {
                        System.out.println("Library Closed!");
                        System.exit(0);
                        input.close();
                        break;
                    }
                    else if (decision.equals("2")) {
                        System.out.println("Returned to the library!");
                        break;
                    }

                    else {
                        System.out.println("Invalid Decision!");
                    }
                }

                default -> {
                    System.out.println("Something unexpected has happened! please try again later!");
                }
            }
        }
        
    }
}