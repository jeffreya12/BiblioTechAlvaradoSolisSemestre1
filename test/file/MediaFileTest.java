/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.Media;
import domain.MediaPlayer;
import java.io.File;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import resources.DefaultValues;
import static file.MediaPlayerFileTest.mediaFile;
import java.io.IOException;

/**
 *
 * @author jefal
 */
public class MediaFileTest {
    
    public static MediaFile mediaFile;
    
    public MediaFileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        File fileMedia = new File(DefaultValues.MEDIA_FILE_PATH);
        mediaFile = new MediaFile(fileMedia);
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
        List<Media> medias = mediaFile.getAllRecords();
        
        for(Media currentMedia: medias){
            System.out.println(currentMedia.toString());
        }
    }
    
}
