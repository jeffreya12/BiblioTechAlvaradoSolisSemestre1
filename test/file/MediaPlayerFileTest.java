/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import domain.MediaPlayer;
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
public class MediaPlayerFileTest {
    
    public static MediaPlayerFile mediaPlayerFile;
    
    public MediaPlayerFileTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        File fileMediaPlayer = new File(DefaultValues.MEDIA_PLAYER_FILE_PATH);
        mediaPlayerFile = new MediaPlayerFile(fileMediaPlayer);
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
        List<MediaPlayer> mediaPlayers = mediaPlayerFile.getAllRecords();
        
        for(MediaPlayer currentMediaPlayer: mediaPlayers){
            System.out.println(currentMediaPlayer.toString());
        }
    }
    
}
