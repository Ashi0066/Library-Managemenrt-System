public interface LibraryOperations
{
    void addBook(Book book);
    void removeBook(String bookId);
    Book searchBook(String title);
    void addMember(Member member);
    Member searchMember(String memberId);
    void issueBook(String bookId,String memberId);
    void returnBook(String bookId,String memberId);

    double calculateFine(String bookId);
    void ListAllMember();

    void listAllBooks();
    void deleteMember(String id);
    


}
