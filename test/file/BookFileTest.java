/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.Book;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import resources.DefaultValues;

/**
 *
 * @author jefal
 */
public class BookFileTest {
    
    public static BookFile bookFile;
    
    public BookFileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        
        File fileBook = new File(DefaultValues.BOOK_FILE_PATH);
        bookFile = new BookFile(fileBook);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllRecords() throws Exception {
        List<Book> books = bookFile.getAllRecords();
        
        for(Book currentBook: books){
            System.out.println(currentBook.toString());
        }
    }
}
