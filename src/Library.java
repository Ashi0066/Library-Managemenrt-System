import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Library implements LibraryOperations
{
    List<Book> bookList;
    List<Member> libraryMembers;
    List<Transaction> transactionList;



    public Library(){
        bookList= new ArrayList<>();
        libraryMembers= new ArrayList<>();
        transactionList= new ArrayList<>();
    }
    @Override
    public void addBook(Book book)
    {

        bookList.add(book);
//      if (searchMember(book.getTitle())!=null){
//          bookList.add(book);
//          System.out.println("Book "+book.getTitle() + " added to the system");
//      }else {
//          System.out.println("Book already exist");
//      }
    }

    @Override
    public void removeBook(String title)
    {
       Book bookToRemove = searchBook(title);
       if (bookToRemove!=null){
           bookList.remove(bookToRemove);
       }


    }

    @Override
    public Book searchBook(String title)
    {

        for (Book bookFind : bookList)
        {
            if (bookFind.getTitle().equalsIgnoreCase(title))
            {
                return bookFind;

            }
        }


        return null;
    }

    @Override
    public void addMember(Member member)
    {
        if (searchMember(member.getId())==null){
            libraryMembers.add(member);
        }


    }

    @Override
    public Member searchMember(String memberId)
    {
        for (var member : libraryMembers)
        {
            if (member.getId().equalsIgnoreCase(memberId))
            {
                return member;
            }

        }



        return null;
    }

    public void ListAllMember(){

        for (int i = 0; i < libraryMembers.size(); i++)
        {
            Member member = libraryMembers.get(i);
            System.out.println("[ "+(i+1)+" ]" + " Member ID = "+ member.getId() + " Member name = " + member.getName()  );

        }
    }

    @Override
    public void listAllBooks()
    {
        for (int i = 0; i < bookList.size(); i++)
        {
            Book book = bookList.get(i);

            System.out.println("[ "+(i+1)+" ]"+" Title = "+ book.getTitle() +"Book ID = "+ book.getBookID()+ "is in library = "+book.getIsIssued());

        }

    }

    @Override
    public void deleteMember(String id)
    {
        Member member = searchMember(id);
        if (member.id.equalsIgnoreCase(id)){
            libraryMembers.remove(member);
        }

    }
    public Book getBookBYID(String bookID){
        for (int i = 0; i < bookList.size(); i++)
        {
            Book book = bookList.get(i);
            if (book.getBookID().equalsIgnoreCase(bookID)){
                return book;
            }

        }
        return null;
    }

    @Override
    public void issueBook(String bookId, String memberId)
    {

        Member member = searchMember(memberId);
        if (member==null){
            System.out.println("Member not Found " + memberId);
            return;
        }

        Book book1 = getBookBYID(bookId);
        if (book1==null){
            System.out.println("Book not Found " + bookId);
            return;
        }
        if (book1.getIsIssued()){
            System.out.println("Book is already issued ");
            return;
        }



            LocalDate dueDate = LocalDate.now().plusWeeks(2);
            String randomString = "B"+(transactionList.size()+1);
            Random random= new Random();
            int randomInts = random.nextInt(1,100);
             String randomID= randomString + (Integer.toString(randomInts));

             book1.issuedBook(memberId,dueDate);
             member.addIssuedBook(book1);
             Transaction transaction1 = new Transaction(randomID,bookId,memberId,LocalDate.now(),dueDate,0);

             transactionList.add(transaction1);
        System.out.println("Book ID = "+bookId +" Issued to member ID = "+ memberId );
        System.out.println("-".repeat(30));

    }

    @Override
    public void returnBook(String bookId, String memberId)
    {
        for (int i = 0; i < transactionList.size(); i++)
        {
           Transaction transaction = transactionList.get(i);
           if (transaction.getBookID().equalsIgnoreCase(bookId)&&searchMember(memberId)!=null){
               transactionList.remove(transaction);
               Book book = bookList.get(i);
               book.returnBook();
               System.out.println("Book return | "+ bookId );
               
           }
        }

    }

    @Override
    public double calculateFine(String bookId)
    {
        for (int i =0 ;i<transactionList.size();i++){
            Transaction transaction = transactionList.get(i);
            if (transaction.getBookID().equalsIgnoreCase(bookId)){
                double fine = 10.0;
                transaction.setFine(fine);
            }
     
            
        }
        return 0;
    }


}
