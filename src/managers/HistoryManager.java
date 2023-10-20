/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managers;

import entity.Book;
import entity.History;
import entity.Reader;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author pupil
 */
public class HistoryManager {
private Scanner scanner;
private ReaderManager readerManager;
private BookManager bookManager;



    public HistoryManager(Scanner scanner,BookManager bookManager, ReaderManager readerManager) {
        this.scanner = scanner;
        this.readerManager = new ReaderManager (scanner);
        this.bookManager = new BookManager (scanner);
    }
    public History giveOutBook(Book[] books, Reader[] readers){
        History history = new History();
 //       System.out.println("List readers: ");
 //       for (int i = 0; i < readers.length; i++) {
 //           System.out.printf("%d. %s %s %s%n",i+i,readers[i].getFirstname(),readers[i].getLastname(),readers[i].getPhone());
 //     }
        
       // int selectedReaderNumber = scanner.nextInt(); scanner.nextLine();
       // history.setReader(readers[selectedReaderNumber-1]);
        
       //         System.out.println("List books: ");
       // for (int i = 0; i < readers.length; i++) {
        //    System.out.printf("%d. %s %s %s%n",i+i,books[i].getTitle(),books[i].getPublishedYear(),Arrays.toString(books[i].getAuthors()));
       // }
        
        readerManager.printListReaders(readers);
        int selectedReaderNumber = scanner.nextInt();scanner.nextLine();
        history.setReader(readers[selectedReaderNumber-1]);
        BookManager bookManager = new BookManager(scanner);
        bookManager.printListBooks(books);
        int selectedBookNumber = scanner.nextInt();scanner.nextLine();
        history.setBook(books[selectedBookNumber-1]);
        
        history.setDateOnHand(new GregorianCalendar().getTime());
        
        return history;
        
    }

    public void printListReturnBooks(History[] histories) {
       BookManager bookManager = new BookManager(scanner);
       bookManager.printListGiveOutBooks(histories);
       System.out.print("Select book for return; ");
       int historyNumber = scanner.nextInt(); scanner.nextLine();
       histories[historyNumber-1].setDateBack(new GregorianCalendar().getTime());
       System.out.printf("Book \"%s\" returned%n",
               histories[historyNumber-1].getBook().getTitle()
       );
    }
    
}
