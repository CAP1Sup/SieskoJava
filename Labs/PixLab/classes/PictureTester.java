/**
 * This class contains class (static) methods that will help you test the Picture class methods.
 * Uncomment the methods and the code in the main to test.
 *
 * @author Barbara Ericson
 */
public class PictureTester {
    /** Method to test zeroBlue */
    public static void testZeroBlue() {
        Picture beach = new Picture("Labs/PixLab/images/beach.jpg");
        beach.zeroBlue();
        beach.explore();
    }

    /** Method to test keepOnlyBlue */
    public static void testKeepOnlyBlue() {
        Picture beach = new Picture("Labs/PixLab/images/beach.jpg");
        beach.keepOnlyBlue();
        beach.explore();
    }

    /** Method to test negate */
    public static void testNegate() {
        Picture beach = new Picture("Labs/PixLab/images/beach.jpg");
        beach.negate();
        beach.explore();
    }

    /** Method to test grayscale */
    public static void testGrayscale() {
        Picture beach = new Picture("Labs/PixLab/images/beach.jpg");
        beach.grayscale();
        beach.explore();
    }

    /** Method to test fixUnderwater */
    public static void testFixUnderwater() {
        Picture water = new Picture("Labs/PixLab/images/water.jpg");
        water.fixUnderwater();
        water.explore();
    }

    /** Method to test mirrorVertical */
    public static void testMirrorVertical() {
        Picture caterpillar = new Picture("Labs/PixLab/images/caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }

    /** Method to test mirrorDiagonal */
    public static void testMirrorDiagonal() {
        Picture beach = new Picture("Labs/PixLab/images/beach.jpg");
        beach.mirrorDiagonal();
        beach.explore();
    }

    /** Method to test mirrorTemple */
    public static void testMirrorTemple() {
        Picture temple = new Picture("Labs/PixLab/images/temple.jpg");
        temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }

    public static void testMirrorArms() {
        Picture snowman = new Picture("Labs/PixLab/images/snowman.jpg");
        snowman.mirrorArms();
        snowman.explore();
    }

    public static void testMirrorGull() {
        Picture gull = new Picture("Labs/PixLab/images/seagull.jpg");
        gull.mirrorGull();
        gull.explore();
    }

    /** Method to test the collage method */
    public static void testCollage() {
        Picture canvas = new Picture("Labs/PixLab/images/640x480.jpg");
        canvas.createCollage2();
        canvas.explore();
    }

    /** Method to test edgeDetection */
    public static void testEdgeDetection() {
        Picture swan = new Picture("Labs/PixLab/images/swan.jpg");
        swan.edgeDetection(10);
        swan.explore();
    }

    /** Main method for testing. Every class can have a main method in Java */
    public static void main(String[] args) {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run
        // testZeroBlue();
        // testKeepOnlyBlue();
        // testKeepOnlyRed();
        // testKeepOnlyGreen();
        // testNegate();
        // testGrayscale();
        // new Picture("Labs/PixLab/images/water.jpg").explore();
        // testFixUnderwater();
        // testMirrorDiagonal();
        // testMirrorVertical();
        // testMirrorTemple();
        //testMirrorArms();
        //testMirrorGull();
        // testMirrorDiagonal();
        testCollage();
        // testCopy();
        // testEdgeDetection();
        // testEdgeDetection2();
        // testChromakey();
        // testEncodeAndDecode();
        // testGetCountRedOverValue(250);
        // testSetRedToHalfValueInTopHalf();
        // testClearBlueOverValue(200);
        // testGetAverageForColumn(0);
    }
}
