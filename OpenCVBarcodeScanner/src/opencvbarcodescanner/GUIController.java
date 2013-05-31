/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opencvbarcodescanner;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

/**
 *
 * @author daniel
 */
public class GUIController implements Initializable {
    
    @FXML
    private ImageView imageView;
    
    @FXML
    private TextArea textArea;
    
    VideoThread videoThread;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.loadLibrary("opencv_java245");
        videoThread = new VideoThread(imageView, textArea);
        videoThread.setDaemon(true);
        videoThread.start();
    }    
}
