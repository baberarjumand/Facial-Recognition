/**
 * This project perform facial recognition on provided images
 * using the OpenIMAJ library.
 *
 * This project is the fifth project of the Java Code Clinic (by Carlos Rivas) on Lynda.com.
 *
 * This is the main class for this project.
 *
 * Author: Baber Arjumand
 * Date:   Jul 24 2019
 * Time:   2:03 PM
 */

package personal;

public class App {
    public static void main( String[] args ) {

//        Tutorials.driverFunction();

        String inputImage;
        if(args.length==1){
            inputImage = args[0];
        } else {
            // Uncomment the image you wish to perform facial detection on
            // or feel free to add your own images.
//            inputImage = "images/testImage1.jpeg";
            inputImage = "images/testImage2.jpeg";
//            inputImage = "images/testImage3.jpg";
        }
        FaceDetector.detectAndDisplayFacesInImageUsingHaarCascadeDetector(inputImage);
        FaceDetector.detectAndDisplayFacesInImageUsingSandeepFaceDetector(inputImage);
        FaceDetector.detectAndDisplayFacesInImageUsingCLMFaceDetector(inputImage);
    }
}
