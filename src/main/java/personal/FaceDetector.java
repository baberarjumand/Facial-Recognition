/**
 * This project perform facial recognition on provided images
 * using the OpenIMAJ library.
 *
 * This project is the fifth project of the Java Code Clinic (by Carlos Rivas) on Lynda.com.
 *
 * This is the FaceDetector class which utilizes the OpenIMAJ library methods.
 *
 * Author: Baber Arjumand
 * Date:   Jul 24 2019
 * Time:   4:55 PM
 */

package personal;

import org.openimaj.image.FImage;
import org.openimaj.image.ImageUtilities;
import org.openimaj.image.processing.face.detection.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class FaceDetector {

    public static void detectAndDisplayFacesInImageUsingHaarCascadeDetector(String inputImagePath) {
        final HaarCascadeDetector detector = new HaarCascadeDetector();
        List<DetectedFace> faces = null;
        try {
            faces = detector.detectFaces(ImageUtilities.readF(new File(inputImagePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (faces == null )
            System.out.println("No faces found in the captured image");
        else
            displayFacesHaar(faces);
    }

    public static void detectAndDisplayFacesInImageUsingSandeepFaceDetector(String inputImagePath) {
        final SandeepFaceDetector detector = new SandeepFaceDetector();
        List<CCDetectedFace> faces = null;
        try {
            faces = detector.detectFaces(ImageUtilities.readMBF(new File(inputImagePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (faces == null )
            System.out.println("No faces found in the captured image");
        else
            displayFacesCC(faces);
    }

    public static void detectAndDisplayFacesInImageUsingCLMFaceDetector(String inputImagePath) {
        final CLMFaceDetector detector = new CLMFaceDetector();
        List<CLMDetectedFace> faces = null;
        try {
            faces = detector.detectFaces(ImageUtilities.readF(new File(inputImagePath)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (faces == null )
            System.out.println("No faces found in the captured image");
        else
            displayFacesCLM(faces);

    }

    private static void displayFacesCLM(List<CLMDetectedFace> faces) {
        JFrame fr = new JFrame("Discovered Faces using CLMFaceDetector");
        Iterator< CLMDetectedFace > dfi = faces.iterator();
        while(dfi.hasNext()){
            DetectedFace face = dfi.next();
            FImage image1 = face.getFacePatch();
            ImagePanel p = new ImagePanel(
                    ImageUtilities.createBufferedImage(image1));
            fr.add(p);
        }
        fr.setLayout(new FlowLayout(0));
        fr.setSize(500, 900);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }


    private static void displayFacesHaar(List<DetectedFace> faces) {
        JFrame fr = new JFrame("Discovered Faces using HaarCascadeDetector");
        Iterator< DetectedFace > dfi = faces.iterator();
        while(dfi.hasNext()){
            DetectedFace face = dfi.next();
            FImage image1 = face.getFacePatch();
            ImagePanel p = new ImagePanel(
                    ImageUtilities.createBufferedImage(image1));
            fr.add(p);
        }
        fr.setLayout(new FlowLayout(0));
        fr.setSize(500, 900);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }

    private static void displayFacesCC(List<CCDetectedFace> faces) {
        JFrame fr = new JFrame("Discovered Faces using SandeepFaceDetector");
        Iterator< CCDetectedFace > dfi = faces.iterator();
        while(dfi.hasNext()){
            DetectedFace face = dfi.next();
            FImage image1 = face.getFacePatch();
            ImagePanel p = new ImagePanel(
                    ImageUtilities.createBufferedImage(image1));
            fr.add(p);
        }
        fr.setLayout(new FlowLayout(0));
        fr.setSize(500, 900);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setVisible(true);
    }
}
