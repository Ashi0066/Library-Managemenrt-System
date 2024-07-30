import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Transaction
{

    private String transactionID;
    private String bookID;

    private String memberID;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private double fine;




    public Transaction(String transactionID, String bookID, String memberID, LocalDate issueDate, LocalDate returnDate, double fine)
    {
        this.transactionID = transactionID;
        this.bookID = bookID;
        this.memberID = memberID;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.fine = fine;

    }

    public String getTransactionID()
    {
        return transactionID;
    }

    public String getBookID()
    {
        return bookID;
    }

    public LocalDate getIssueDate(){
        return issueDate;
    }

    public LocalDate getReturnDate(){
        return returnDate;
    }

    public void setFine(double fine){
        this.fine=fine;
    }
}
