package a1q10;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A1q10  {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("********************Welcome to the Student Library!********************");
        System.out.println("              Please Select From The Following Options:               ");
        System.out.println("**********************************************************************");
        Books ob = new Books();
        Students obStudent = new Students();
        int choice = 0;
        int searchChoice;

        do {
            displayMenu();
            try {
                choice = input.nextInt();
            } catch (Exception e) {
                System.out.println("Exception: " + e.toString());
            }

            switch (choice) {

                case 1:
                    //Add a book
                    System.out.println("Enter Serial No of Book:");
                    int isbnNo = input.nextInt();
                    input.nextLine();
                    System.out.println("Enter Book Name:");
                    String bookName = input.nextLine();
                    System.out.println("Enter Author Name:");
                    String authorName = input.nextLine();

                    Book b = new Book(isbnNo, bookName, authorName);
                    ob.addBook(b);
                    break;

                case 2:
                    //Delete a Book
                    System.out.println("Enter Serial No of Book:");
                    int deleteIsnoNo = input.nextInt();
                    ob.deleteBookWithIsbnNo(deleteIsnoNo);
                    break;

                case 3:
                    System.out.println("Enter 1 to Search with Serial No.");
                    System.out.println("Enter 2 to Search with Author Name(Full Name).");
                    System.out.println("Enter 3 to Search with BookName");
                    searchChoice = input.nextInt();

                    input.nextLine();
                    System.out.println("Please enter the search keyword: ");
                    String searchKeyword = input.nextLine();

                    switch (searchChoice) {

                        case 1:
                            int searchIsbnNo = Integer.parseInt(searchKeyword);
                            Book searchedBook = ob.findBySerialNo(searchIsbnNo);
                            if (searchedBook != null) {
                                searchedBook.print();
                            } else {
                                System.out.println("No Found");
                            }
                            break;
                        case 2:
                            Book searchedBook2 = ob.findByAuthorName(searchKeyword);
                            if (searchedBook2 != null) {
                                searchedBook2.print();
                            } else {
                                System.out.println("No Found");
                            }
                            break;

                        case 3:
                            Book searchedBook3 = ob.findByTitle(searchKeyword);
                            if (searchedBook3 != null) {
                                searchedBook3.print();
                            } else {
                                System.out.println("No Found");
                            }
                            break;

                        default:
                            break;
                    }
                    break;
                case 4:
                    if (ob.areBooksAvailableForBorrow()) {
                        ob.showAllBooks();
                    } else {
                        System.out.println("No Books in Library. Add books.");
                    }

                    break;
                case 5:
                    input.nextLine();
                    System.out.println("Enter Student Name:");
                    String studentName = input.nextLine();

                    System.out.println("Enter Roll Number:");
                    int rollNum = input.nextInt();
                    Student s = new Student(studentName, rollNum);
                    obStudent.addStudent(s);
                    break;
                case 6:
                    if (obStudent.areStudentsRegistered()) {
                        obStudent.showAllStudents();
                    } else {
                        System.out.println("No Students are registered.");
                    }
                    break;
                case 7:
                    if (ob.areBooksAvailableForBorrow()) {
                        System.out.println("Enter Roll Number:");
                        int rollNum1 = input.nextInt();

                        if (obStudent.isStudent(rollNum1)) { //validate if student is registered.
                            ob.showAllBooks();
                            System.out.println("Enter Book isbn which you wish to borrow:");
                            int bookToBorrowIsbnNo = input.nextInt();
                            obStudent.issueBook(ob, rollNum1, bookToBorrowIsbnNo);
                        } else {
                            System.out.println("Register yourself first.");
                        }
                    } else {
                        System.out.println("No Books in Library. Add books.");
                    }

                    break;
                default:
                    System.out.println("CHOICE SHOULD BE BETWEEN 0 TO 8.");

            }
        }
        while (choice != 0);
    }

    private static void displayMenu() {
        System.out.println("---------------------------");
        System.out.println("Enter 0 to Exit Application.");
        System.out.println("Enter 1 to Add new Book.");
        System.out.println("Enter 2 to Delete a Book.");
        System.out.println("Enter 3 to Search a Book.");
        System.out.println("Enter 4 to Show All Books.");
        System.out.println("Enter 5 to Register Student.");
        System.out.println("Enter 6 to Show All Registered Students.");
        System.out.println("Enter 7 to Borrow Book.");
        System.out.println("---------------------------");
        // TODO code application logic here
    }

    
    public class Student {
    String studentName;
    int rollNum;

    List<Book> borrowedBooks = new ArrayList<>();

    public Student(String studentName, int rollNum) {
        this.studentName = studentName;
        this.rollNum = rollNum;
    }

    public void print() {
        System.out.println("___________________________");
        System.out.println(studentName + "\t\t" + rollNum);
        System.out.println("Number of books issued: " + borrowedBooks.size());
        if (borrowedBooks.size() > 0) {
            System.out.println("=====================");
            System.out.println("Issued Books: ");
            System.out.println("ISBN No \t\t Title \t\t Author" );
            for (int i = 0; i < borrowedBooks.size(); i++) {
                Book b = borrowedBooks.get(i);
                b.print();
            }
        }
        System.out.println("___________________________");
    }

}
    
    class Students {

        List<Student> theStudents = new ArrayList<>();


        Student findByRollNo(int rollno) {
            for (int i = 0; i < theStudents.size(); i++) {
                if (theStudents.get(i).rollNum == rollno) {
                    return theStudents.get(i);
                }
            }
            return null;
        }

        public void addStudent(Student s) {

            if (findByRollNo(s.rollNum) != null) {
                System.out.println("Student of Reg Num " + s.rollNum + " is Already Registered.");
                return;
            }

            theStudents.add(s);
        }

        public void showAllStudents() {

            System.out.println("Student Name\t\tReg Number");
            for (int i = 0; i < theStudents.size(); i++) {
                Student s = theStudents.get(i);
                s.print();
            }
        }

        public boolean areStudentsRegistered() {
            return theStudents.size() > 0;
        }


        public boolean isStudent(int rollno) {

            Student s = findByRollNo(rollno);
            if (s == null) {
                System.out.println("Student is not Registered.");
                System.out.println("Get Registered First.");
                return false;
            } else {
                return true;
            }
        }

        public void issueBook(Books books, int rollno, int borrowedBookIsbnNo) {
            System.out.println("checking out");
            if (books.theBooks.size() > 0) {
                Book b = books.findBySerialNo(borrowedBookIsbnNo);
                if (b != null) {
                    for (int i = 0; i < theStudents.size(); i++) {

                        if (theStudents.get(i).rollNum == rollno) {
                            if (theStudents.get(i).borrowedBooks.contains(b)) {
                                System.out.println("Already issued the book!!!!");
                            } else {
                                theStudents.get(i).borrowedBooks.add(b);
                                System.out.println("Book with title: " + b.bookName + " has been issued to Student : " + theStudents.get(i).studentName);
                            }

                        }
                    }
                } 
                else {
                    System.out.println("No such book found.");
                }
            }
        }
    }
    public class Book {

    public int isbnNo;
    public String bookName;
    public String authorName;

    public Book(int isbnNo, String bookName, String authorName) {
        this.isbnNo = isbnNo;
        this.bookName = bookName;
        this.authorName = authorName;
    }

    public void print() {
        System.out.println(isbnNo + "\t\t" + bookName + "\t\t" + authorName);
    }
}

class Books {

    List<Book> theBooks = new ArrayList<>();


    Scanner input = new Scanner(System.in);

    Book findByTitle(String title) {
        for (int i = 0; i < theBooks.size(); i++) {
            if (theBooks.get(i).bookName.equalsIgnoreCase(title)) {
                return theBooks.get(i);
            }
        }
        return null;
    }

    Book findBySerialNo(int no) {
        for (int i = 0; i < theBooks.size(); i++) {
            if (theBooks.get(i).isbnNo == no) {
                return theBooks.get(i);
            }
        }
        return null;
    }

    Book findByAuthorName(String authorName) {
        for (int i = 0; i < theBooks.size(); i++) {
            if (theBooks.get(i).authorName.equalsIgnoreCase(authorName)) {
                return theBooks.get(i);
            }
        }
        return null;
    }

    public void addBook(Book b) {
        if (findByTitle(b.bookName) != null) {
            System.out.println("Book of this Name Already Exists.");
            return;
        }
        if (findBySerialNo(b.isbnNo) != null) {
            System.out.println("Book of this Serial No Already Exists.");
            return;
        }
        theBooks.add(b);
    }

    public void showAllBooks() {

        System.out.println("\t\t\t\tSHOWING ALL BOOKS\n");
        System.out.println("S.No\t\tName\t\tAuthor");
        for (int i = 0; i < theBooks.size(); i++) {
            Book book = theBooks.get(i);
            book.print();
        }
    }

    public boolean areBooksAvailableForBorrow() {
        return theBooks.size() > 0;
    }

    public void upgradeBookQty() {

        System.out.println("\t\t\t\tUPGRADE QUANTITY OF A BOOK\n");
        System.out.println("Enter Serial No of Book");
        int isbnNo = input.nextInt();
        for (int i = 0; i < theBooks.size(); i++) {

            if (isbnNo == theBooks.get(i).isbnNo) {

                System.out.println("Enter No of Books to be Added:");

                return;

            }

        }

    }

    public int isAvailable(int isbnNo) {

        //returns the index number if available


        for (int i = 0; i < theBooks.size(); i++) {

            if (isbnNo == theBooks.get(i).isbnNo) {
                System.out.println("Book is Unavailable");
                return -1;

            }

        }

        System.out.println("No Book of Serial Number " + " Available in Library.");
        return -1;


    }

    public void deleteBookWithIsbnNo(int deleteIsnoNo) {
        for (int i = 0; i < theBooks.size(); i++) {
            if (theBooks.get(i).isbnNo == deleteIsnoNo) {
                theBooks.remove(i);
                System.out.println("Book deleted with id: " + deleteIsnoNo);
            }
        }
    }
}


