import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.video.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Averagecolor extends PApplet {


Capture video;


public void setup() {
  
  video = new Capture(this, 640, 480, 30);
  video.start();
}

public void mousePressed(){
  video.read();
}

public void draw() {
  background(0);
  image(video, 0, 0, width, height);
  loadPixels();
  // Since we are going to access the image's pixels too
  video.loadPixels();
  for (int y = 0; y < height; y++) {
    for (int x = 0; x < width; x++) {
      int loc = x + y*width;

      // The functions red(), green(), and blue() pull out the 3 color components from a pixel.
      float r = red(video.pixels[loc]);
      float g = green(video.pixels[loc]);
      float b = blue(video.pixels[loc]);

      // Image Processing would go here
      // If we were to change the RGB values, we would do it here,
      // before setting the pixel in the display window.

      // Set the display pixel to the image pixel
      pixels[loc] =  color(r,g,b);


fill(r,g,b);
rect(25, 25, 50, 50);
    }
  }

}
  public void settings() {  size (600, 400); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Averagecolor" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
