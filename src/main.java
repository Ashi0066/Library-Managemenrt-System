import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class main
{


    public static void main(String[] args)
    {
        Library library = new Library();
        String Chars = "ABCDEFGHIJKLMNOPQRTSUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();


        System.out.println();
        System.out.println(" Please read the menu below Carefully and select the task you want to perform.");
        System.out.println();
        System.out.println("-".repeat(50));

        String menu= """
               |    [1]. To add a book                   |
               |    [2]. Remove a book                   |
               |    [3]. Search a book by Title          |
               |    [4]. List all books                  |
               |    [5]. Add a new member                |
               |    [6]. Remove an existing member.      |
               |    [7]. List all members                |
               |    [8]. Issue a book                    |
               |    [9]. Return book(Borrowed Books)      |
               |    [10]. Add Fine                       |
               |    [11]. Exit                           |
                """;

        System.out.println(menu);
        System.out.println("-".repeat(50));


        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag){
            System.out.println("Please Select an option  = " );
            int input = sc.nextInt();
            sc.nextLine();
            switch (input){
                case 1->{

                    try{


                        System.out.println("PLease enter book details");
                        System.out.println("Book ID = ");
                        String bookId =sc.next();

                        System.out.println("Book Title");
                        String bookTitle= sc.nextLine();
                        if (bookTitle.isEmpty()){
                            bookTitle = sc.nextLine();
                        }
                        System.out.println("Book Author");
                        String bookAuthor=sc.nextLine();


                        Book book = new Book(bookId,bookTitle,bookAuthor);
                        library.addBook(book);



                    }catch (Exception e){

                        System.out.println("Please enter correct format ");
                    }


                }
                case 2->{

                    System.out.println("Please Enter book Title to remove");
                    System.out.println("Book Title = ");
                    String title = sc.next();
                    library.removeBook(title);
                }
                case 3 ->{
                    System.out.println("Please enter book title you want to search by ");
                    System.out.println("Book Title = ");
                    String title = sc.next();
                   Book book =  library.searchBook(title);
                    System.out.println("the Book found is "+book);

                }
                case 4 ->{
                    library.listAllBooks();
                }
                case 5->{
                    System.out.println(" Please enter the member details you want to add ");


                    System.out.println("Member ID = ");
                    String memberId= sc.nextLine();
                    System.out.println("Member Name = ");
                    String name = sc.nextLine();
                    System.out.println("Member Email = ");
                    String email = sc.nextLine();



                    Member member = new Member(memberId,name,email);
                    library.addMember(member);
                }
                case 6->{
                    System.out.println("Please enter the Member ID you want to delete");
                    System.out.println("Member ID = ");
                    String memberId= sc.nextLine();
                    library.deleteMember(memberId);

                }
                case 7 ->{
                    System.out.println("Below are all the members");
                        library.ListAllMember();

                }
                case 8->{
                    System.out.println("Please enter the details to issue a book ");
                    System.out.println("Book ID = ");
                    String bookID = sc.nextLine();
                    System.out.println("Member ID = ");
                    String memberId= sc.nextLine();

                    library.issueBook(bookID,memberId);

                }
                case 9 -> {
                    System.out.println("Please enter the details to return a book ");
                    System.out.println("Book ID = ");
                    String bookID = sc.nextLine();
                    System.out.println("Member ID = ");
                    String memberId= sc.nextLine();


                    library.returnBook(bookID,memberId);
                }
                case 10-> {

                    System.out.println("Please add fine ");

                    System.out.println("Book ID = ");
                    String bookID = sc.nextLine();
                    library.calculateFine(bookID);

                }
                case 11->{
                    flag = false;
                }
                default -> flag=false;


            }

            System.out.println(menu);




        }





    }


}
