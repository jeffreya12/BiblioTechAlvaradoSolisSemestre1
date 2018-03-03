/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.Student;
import static file.MediaPlayerFileTest.mediaFile;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import resources.DefaultValues;

/**
 *
 * @author jefal
 */
public class StudentFileTest {
    
    public static StudentFile studentFile;
    
    public StudentFileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        
        File fileStudent = new File(DefaultValues.STUDENT_FILE_PATH);
        studentFile = new StudentFile(fileStudent);
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
    public void testSearchRecord() throws Exception {      
        int result = studentFile.searchRecord("IC2014120210");
        Student student = studentFile.getRecord(result);
        System.out.println(student.toString());
    }
    
}
