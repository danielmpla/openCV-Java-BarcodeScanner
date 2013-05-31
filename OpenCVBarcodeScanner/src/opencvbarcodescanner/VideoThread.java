/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opencvbarcodescanner;

import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author daniel
 */
public class VideoThread extends Thread{
    
    ImageView imageView;
    VideoCapturer videoCapturer;
    
    public VideoThread(ImageView imageView, TextArea textArea){
        videoCapturer = new VideoCapturer(textArea);
        this.imageView = imageView;
    }
    
    public void run(){
        while(true){
            Image image = videoCapturer.showImage();
            if(image == null) continue;
            imageView.setImage(image);
        }
    }
}
