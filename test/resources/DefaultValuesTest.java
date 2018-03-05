/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jefal
 */
public class DefaultValuesTest {
    
    public DefaultValuesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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

    /**
     * Test of daysBetween method, of class DefaultValues.
     */
    @Test
    public void testDaysBetween() throws ParseException {
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");

        Date date = sdf.parse("01012018");
        cal1.setTime(date);
        date = sdf.parse("01022018");
        cal2.setTime(date);

        System.out.println("Days= " + DefaultValues.daysBetween(cal1.getTime(), cal2.getTime()));
    }
    
    /**
     * Test of daysBetween method, of class DefaultValues.
     */
    @Test
    public void testSaveSettings() {
        DefaultValues.saveSetting("password", "12345");
    }
    
}
