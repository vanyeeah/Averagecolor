import processing.video.*;
Capture video;


void setup() {
  size (300, 200);
  video = new Capture(this, 640, 480, 30);
  video.start();
}

void captureEvent(Capture video){
  video.read();
}

void draw() {
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
