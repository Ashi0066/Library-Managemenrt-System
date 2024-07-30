import java.time.LocalDate;

public class Book
{
    private String bookID;
    private String title;
    private String author;
    private boolean isIssued;
    private String issuedTo;

   private LocalDate dueDate;


   public Book(String bookID,String title,String author){
       this.author=author;
       this.title=title;
       this.bookID=bookID;

   }
   public String getBookID(){
       return bookID;
   }

   public String getTitle(){
       return title;
   }
   public String getIssuedTo(){
       return issuedTo;
   }

   public boolean getIsIssued(){
       return isIssued;
   }







   public LocalDate getDueDate(){
       return dueDate;
   }

   public void issuedBook(String memberId,LocalDate dueDate){
       this.isIssued=true;
       this.issuedTo=memberId;
       this.dueDate=dueDate;

   }

   public void returnBook(){
       this.isIssued=false;
       this.issuedTo=null;
       this.dueDate=null;

   }

    @Override
    public String toString()
    {
        return "Book{" +
                "bookID='" + bookID + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
