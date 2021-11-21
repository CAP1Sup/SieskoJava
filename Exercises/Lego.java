/**
 * @author Christian Piper
 * @since 9/24/21
 */
package Exercises;

public class Lego {

  // Instance variables
  int studs, height;
  String color, shape;

  Lego() {
    studs = 0;
    height = 0;
    color = "";
    shape = "";
  }

  Lego(int ns, int h, String c, String s) {
    studs = ns;
    height = h;
    color = c;
    s = shape;
  }

  int getStuds() {
    return studs;
  }

  int getHeight() {
    return height;
  }

  String getColor() {
    return color;
  }

  String getShape() {
    return shape;
  }

  void setStuds(int s) {
    studs = s;
  }

  void setHeight(int h) {
    height = h;
  }

  void setColor(String c) {
    color = c;
  }

  void setShape(String s) {
    shape = s;
  }

  public String toString() {
    return ("Studs: "
        + studs
        + " | Height: "
        + height
        + " | Color: "
        + color
        + " | Shape: "
        + shape);
  }
}
