import java.util.ArrayList;
import java.util.List;

public class Member extends Person
{



    private String email ;

    List<Book> booksIssued;



    public Member(String memberID,String name,String email){
        super(memberID,name);
        this.email= email;
        booksIssued=new ArrayList<>();
    }

    @Override
    public String getId()
    {
        return super.getId();
    }

    public String getEmail()
    {
        return email;
    }

    public void addIssuedBook(Book book){
        booksIssued.add(book);
    }

    public void removeBook(Book book){
        booksIssued.add(book);
    }


}
