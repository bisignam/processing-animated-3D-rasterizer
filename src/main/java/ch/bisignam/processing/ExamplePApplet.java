package ch.bisignam.processing;

import processing.core.PApplet;
import processing.core.PImage;

public class ExamplePApplet extends PApplet {
    private PImage img;

    public static void main(String[] args) {
        PApplet.main("ch.bisignam.processing.ExamplePApplet");
    }

    @Override
    public void settings() {
        size(640, 360);
    }

    @Override
    public void setup() {
        img = loadImage("processing-web.png");
    }

    @Override
    public void draw() {
        if (img != null) {
            for (int i = 0; i < 2; i++) {
                image(img, 0, img.height * i);
            }
        }
    }
}
