/**
 * This project perform facial recognition on provided images
 * using the OpenIMAJ library.
 *
 * This project is the fifth project of the Java Code Clinic (by Carlos Rivas) on Lynda.com.
 *
 * I used this class as a temporary playground to get familiar with OpenIMAJ library and it's APIs.
 *
 * Author: Baber Arjumand
 * Date:   Jul 24 2019
 * Time:   2:50 PM
 */

package personal;

import org.openimaj.image.FImage;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.processing.face.detection.DetectedFace;
import org.openimaj.image.processing.face.detection.HaarCascadeDetector;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Tutorials {

    public static void driverFunction () {

        /************************************************************/
//        // Hello World
//        //Create an image
//        MBFImage image = new MBFImage(480,70, ColourSpace.RGB);
//        //Fill the image with white
//        image.fill(RGBColour.WHITE);
//        //Render some test into the image
//        image.drawText("Hello There World", 10, 60, HersheyFont.FUTURA_LIGHT, 50, RGBColour.BLACK);
//        //Apply a Gaussian blur
//        image.processInplace(new FGaussianConvolve(2f));
//        //Display the image
//        DisplayUtilities.display(image);

        /***********************************************************/
        // Play with different bands of image
//        MBFImage image = null;
//        try {
//            image = ImageUtilities.readMBF(new URL("http://static.openimaj.org/media/tutorial/sinaface.jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(image.colourSpace);
////        DisplayUtilities.display(image);
////        DisplayUtilities.display(image.getBand(0), "Red Channel");
//        MBFImage clone = image.clone();
////        for (int y=0; y<image.getHeight(); y++) {
////            for(int x=0; x<image.getWidth(); x++) {
////                clone.getBand(1).pixels[y][x] = 0;
////                clone.getBand(2).pixels[y][x] = 0;
////            }
////        }
//        clone.getBand(1).fill(0);
//        clone.getBand(2).fill(0);
//        DisplayUtilities.display(clone);

        /***********************************************************/
        // run canny edge detector on image
//        MBFImage image = null;
//        try {
//            image = ImageUtilities.readMBF(new URL("http://static.openimaj.org/media/tutorial/sinaface.jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        MBFImage cannyImage = image.process(new CannyEdgeDetector());
//        DisplayUtilities.display(cannyImage);

        /***********************************************************/
        // draw shapes on image and open multiple images in same JFrame
//        MBFImage image = null;
//        try {
//            image = ImageUtilities.readMBF(new URL("http://static.openimaj.org/media/tutorial/sinaface.jpg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////        DisplayUtilities.createNamedWindow("defWindow");
////        DisplayUtilities.display(image);
//        DisplayUtilities.displayName(image, "defW");
//        MBFImage drawnImage = image.clone();
//        drawnImage.drawShapeFilled(new Ellipse(700f, 450f, 20f, 10f, 0f), RGBColour.WHITE);
//        drawnImage.drawShape(new Ellipse(700f, 450f, 20f, 10f, 0f), RGBColour.BLACK);
//        drawnImage.drawShapeFilled(new Ellipse(650f, 425f, 25f, 12f, 0f), RGBColour.WHITE);
//        drawnImage.drawShapeFilled(new Ellipse(600f, 380f, 30f, 15f, 0f), RGBColour.WHITE);
//        drawnImage.drawShapeFilled(new Ellipse(500f, 300f, 100f, 70f, 0f), RGBColour.WHITE);
//        drawnImage.drawShape(new Ellipse(500f, 300f, 100f, 70f, 0f), RGBColour.BLACK);
//        drawnImage.drawText("OpenIMAJ is", 425, 300, HersheyFont.ASTROLOGY, 20, RGBColour.BLACK);
//        drawnImage.drawText("Awesome", 425, 330, HersheyFont.ASTROLOGY, 20, RGBColour.BLACK);
//        DisplayUtilities.displayName(drawnImage, "defW");
////        DisplayUtilities.display("", image, drawnImage);

        /***********************************************************/
        // import local image
//        MBFImage image = null;
//        try {
//            image = ImageUtilities.readMBF(new File("images/testImage1.jpeg"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        DisplayUtilities.display(image);

        /***********************************************************/
        // detect faces
        final HaarCascadeDetector detector = new HaarCascadeDetector();
        List<DetectedFace> faces = null;
        try {
            faces = detector.detectFaces(ImageUtilities.readF(new File("images/testImage3.jpg")));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(faces.size());
        JFrame fr = new JFrame("Discovered Faces");
        Iterator< DetectedFace > dfi = faces.iterator();
        while(dfi.hasNext()){
            DetectedFace face = dfi.next();
            FImage image1 = face.getFacePatch();
            ImagePanel p = new ImagePanel(
                    ImageUtilities.createBufferedImage(image1));
            fr.add(p);
        }
        fr.setLayout(new FlowLayout(0));
        fr.setSize(500, 500);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);

    }

}
