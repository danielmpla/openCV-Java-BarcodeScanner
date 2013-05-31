/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package opencvbarcodescanner;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import org.opencv.highgui.VideoCapture;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.highgui.Highgui;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import javafx.scene.control.TextArea;

/**
 *
 * @author daniel
 */
public class VideoCapturer {

    VideoCapture videoCapture;
    TextArea textArea;

    public VideoCapturer(TextArea textArea) {
        videoCapture = new VideoCapture(0);
        this.textArea = textArea;
    }

    public Image showImage() {
        try {
            Mat image = new Mat();
//            image = Highgui.imread("/home/daniel/Bilder/barcode.jpg");
            videoCapture.read(image);
            MatOfByte out = new MatOfByte();
            Highgui.imencode(".png", image, out);
            byte[] outputImage = out.toArray();
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            outputStream.write(outputImage);
            outputStream.flush();
            byte[] inputImage = outputStream.toByteArray();
            outputStream.close();
            InputStream inputStream = new ByteArrayInputStream(inputImage);
//            BufferedImage bufferedImage = ImageIO.read(inputStream);
//            WritableImage wi = new WritableImage(640, 480);
//            SwingFXUtils.toFXImage(bufferedImage, wi);
            return new Image(inputStream);
        } catch (IOException ex) {
            Logger.getLogger(VideoCapturer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
