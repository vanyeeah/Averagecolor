PImage img;	// Declare a variable of type PImage

void setup() {
  size(1280,720);
  // Make a new instance of a PImage by loading an image file
  img = loadImage("data/image.jpg");
}

void draw() {
  background(0);
  // Draw the image to the screen at coordinate (0,0)
  image(img,0,0);
}
