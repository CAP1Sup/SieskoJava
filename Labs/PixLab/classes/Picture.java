import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
// resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and allows the student
 * to add functionality to the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
    ///////////////////// constructors //////////////////////////////////

    /** Constructor that takes no arguments */
    public Picture() {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     *
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width) {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a copy of that picture
     *
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     *
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image) {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     *
     * @return a string with information about the picture such as fileName, height and width.
     */
    public String toString() {
        String output =
                "Picture, filename "
                        + getFileName()
                        + " height "
                        + getHeight()
                        + " width "
                        + getWidth();
        return output;
    }

    /** Method to set the blue to 0 */
    public void zeroBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setBlue(0);
            }
        }
    }

    /** Zeroes the red and green values, leaving only the blue values for the pixels */
    public void keepOnlyBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }

    /** Negates all pixel colors, inverting the image */
    public void negate() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }

    /** Converts the image to grayscale */
    public void grayscale() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                int value = (pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3;
                pixelObj.setRed(value);
                pixelObj.setGreen(value);
                pixelObj.setBlue(value);
            }
        }
    }

    /** Adjusts an image so that objects in the water are more clearly shown */
    public void fixUnderwater() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                if (pixelObj.getRed() > 20) {
                    pixelObj.setRed(0);
                    pixelObj.setGreen(0);
                    pixelObj.setBlue(0);
                }
            }
        }
    }

    /**
     * Method that mirrors the picture around a vertical mirror in the center of the picture from
     * left to right
     */
    public void mirrorVertical() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a vertical mirror in the center of the picture from
     * right to left
     */
    public void mirrorVerticalRightToLeft() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                leftPixel.setColor(rightPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a horizontal mirror in the center of the picture from
     * top to bottom
     */
    public void mirrorHorizontal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel upperPixel = null;
        Pixel lowerPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length / 2; row++) {
            for (int col = 0; col < width; col++) {
                upperPixel = pixels[row][col];
                lowerPixel = pixels[pixels.length - 1 - row][col];
                lowerPixel.setColor(upperPixel.getColor());
            }
        }
    }

    /**
     * Method that mirrors the picture around a horizontal mirror in the center of the picture from
     * top to bottom
     */
    public void mirrorHorizontalBotToTop() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel upperPixel = null;
        Pixel lowerPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length / 2; row++) {
            for (int col = 0; col < width; col++) {
                upperPixel = pixels[row][col];
                lowerPixel = pixels[pixels.length - 1 - row][col];
                upperPixel.setColor(lowerPixel.getColor());
            }
        }
    }

    /** Method that mirrors the picture around a diagonal mirror around the line y=x */
    public void mirrorDiagonal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel oldPixel = null;
        Pixel newPixel = null;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < row; col++) {
                oldPixel = pixels[col][row];
                newPixel = pixels[row][col];
                oldPixel.setColor(newPixel.getColor());
            }
        }
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple() {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++) {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++) {

                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
                count++;
            }
        }

        System.out.println(count);
    }

    /**
     * copy from the passed fromPic to the specified startRow and startCol in the current picture
     *
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, int startRow, int startCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow;
                fromRow < fromPixels.length && toRow < toPixels.length;
                fromRow++, toRow++) {
            for (int fromCol = 0, toCol = startCol;
                    fromCol < fromPixels[0].length && toCol < toPixels[0].length;
                    fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    /**
     * Copy from a from picture to a destination picture
     *
     * @param fromPic the picture to copy from
     * @param dStartPt the start point to copy to
     * @param fStartPt the start point to copy from
     * @param fEndPt the end point to copy from
     */
    public void copy(Picture fromPic, int[] dStartPt, int[] fStartPt, int[] fEndPt) {

        // Get the arrays for the pictures to be used
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();

        // Start the copying process
        for (int rowCounter = 0;
                rowCounter < (fEndPt[0] - fStartPt[0])
                        && dStartPt[0] + rowCounter < toPixels.length
                        && fStartPt[0] + rowCounter < fromPixels.length;
                rowCounter++) {
            for (int colCounter = 0;
                    colCounter < (fEndPt[1] - fStartPt[0])
                            && dStartPt[1] + colCounter < toPixels[0].length
                            && fStartPt[1] + colCounter < fromPixels[0].length;
                    colCounter++) {
                toPixels[dStartPt[0] + rowCounter][dStartPt[1] + colCounter].setColor(
                        fromPixels[fStartPt[0] + rowCounter][fStartPt[1] + colCounter].getColor());
            }
        }
    }

    public void mirrorSection(int[] oldPixelStartPt, int[] oldPixelEndPt, int[] newPixelStartPt) {
        Pixel[][] pixels = this.getPixels2D();
        for (int rowCount = 0; rowCount <= oldPixelEndPt[0] - oldPixelStartPt[0]; rowCount++) {
            for (int colCount = 0; colCount <= oldPixelEndPt[1] - oldPixelStartPt[1]; colCount++) {
                pixels[newPixelStartPt[0] + rowCount][newPixelStartPt[1] + colCount].setColor(
                        pixels[oldPixelStartPt[0] + rowCount][oldPixelStartPt[1] + colCount]
                                .getColor());
            }
        }
    }

    public void mirrorArms() {
        mirrorSection(new int[] {156, 103}, new int[] {193, 169}, new int[] {230, 96});
        mirrorSection(new int[] {170, 240}, new int[] {198, 294}, new int[] {245, 245});
    }

    public void mirrorGull() {
        mirrorSection(new int[] {233, 232}, new int[] {334, 346}, new int[] {250, 431});
    }

    /** Method to create a collage of several pictures */
    public void createCollage() {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1, 0, 0);
        this.copy(flower2, 100, 0);
        this.copy(flower1, 200, 0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue, 300, 0);
        this.copy(flower1, 400, 0);
        this.copy(flower2, 500, 0);
        this.mirrorVertical();
        this.write("collage.jpg");
    }

    /** Method to create a 2nd collage of several pictures */
    public void createCollage2() {
        Picture flower1 = new Picture("Labs/PixLab/images/flower1.jpg");
        Picture flower2 = new Picture("Labs/PixLab/images/flower2.jpg");
        Picture flower3 = new Picture("Labs/PixLab/images/flower3.jpg");
        Picture smiley = new Picture("Labs/PixLab/images/smiley.jpg");

        Picture[] pics = new Picture[] {flower1, flower2, flower3, smiley};

        for (int index = 0; index < pics.length; index++) {
            Picture zeroedPic = new Picture(pics[index]);
            zeroedPic.zeroBlue();

            Picture grayscale = new Picture(pics[index]);
            grayscale.grayscale();

            Picture vMirrored = new Picture(pics[index]);
            vMirrored.mirrorVertical();

            Picture hMirrored = new Picture(pics[index]);
            hMirrored.mirrorHorizontal();

            Picture blue = new Picture(pics[index]);
            blue.keepOnlyBlue();

            this.copy(
                    pics[index],
                    new int[] {index * 100, 0},
                    new int[] {0, 0},
                    new int[] {100, 100});
            this.copy(
                    zeroedPic,
                    new int[] {index * 100, 100},
                    new int[] {0, 0},
                    new int[] {100, 100});
            this.copy(
                    grayscale,
                    new int[] {index * 100, 200},
                    new int[] {0, 0},
                    new int[] {100, 100});
            this.copy(
                    vMirrored,
                    new int[] {index * 100, 300},
                    new int[] {0, 0},
                    new int[] {100, 100});
            this.copy(
                    hMirrored,
                    new int[] {index * 100, 400},
                    new int[] {0, 0},
                    new int[] {100, 100});
            this.copy(blue, new int[] {index * 100, 500}, new int[] {0, 0}, new int[] {100, 100});
        }
    }

    /**
     * Method to show large changes in color
     *
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist) {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length - 1; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor) > edgeDist) leftPixel.setColor(Color.BLACK);
                else leftPixel.setColor(Color.WHITE);
            }
        }
    }

    /* Main method for testing - each class in Java can have a main
     * method
     */
    public static void main(String[] args) {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }
} // this } is the end of class Picture, put all new methods before this
