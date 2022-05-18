package ch.bisignam.processing;

import ch.bisignam.processing.palette.ColorPalette;
import ch.bisignam.processing.palette.DebussyPalette;
import processing.core.PApplet;
import processing.core.PImage;

public class DecomposingRasterization extends PApplet {

    private float rotateSketchAngle = 0.0F;
    private PImage img;
    private final float tileSize = 8;
    private int zDepth = 100;
    private int zDepthDelta = 10;
    private final static int zDepthMod = 200;
    private float tilesX;
    private float tilesY;
    private final ColorPalette mainColorPalette = new DebussyPalette();

    public static void main(String[] args) {
        PApplet.main("ch.bisignam.processing.DecomposingRasterization");
    }

    @Override
    public void settings() {
        size(1000, 1000, P3D);
    }

    @Override
    public void setup() {
        img = loadImage("decaying_flower.jpg");
        tilesX = img.width / tileSize;
        tilesY = img.height / tileSize;
        System.out.println("Tiles size: " + tilesX + " " + tilesY);
        //positionsMatrix = new [int(tilesX)][int(tilesY)];
        frameRate(200);
    }

    @Override
    public void draw() {
        if (frameCount % zDepthMod == 0) {
            zDepthDelta = -zDepthDelta; //invert decomposition
        } else {
            zDepthDelta = +zDepthDelta;
        }
        background(100);
        pushMatrix();
        translate(width >> 1, 0, -1000);
        rotateY(rotateSketchAngle);
        for (int i = 0; i < tilesX; i++) {
            for (int j = 0; j < tilesY; j++) {
                int imgColor = img.get((int) (i * tileSize), (int) (j * tileSize));
                //We make z proportional to the brightness in order to give a sense of depth to the rasterization
                float brightness = brightness(imgColor);
                //Let's normalize the brightness
                float z = map(brightness, 0, 255, -zDepth, zDepth);
                pushMatrix();
                //This is needed in order to make only the real interesting image pop up,
                // it basically removes some noise
                if (z != zDepth && z != -zDepth) {
                    //System.out.println("Image pixel : "+(int)(i*tileXSize)+" "+ (int)(j*tileYSize)+", z "+z);
                    fill(mainColorPalette.nextColor());
                    translate((int) (i * tileSize), (int) (j * tileSize), (int) z);
                    box(tileSize);
                }
                popMatrix();
            }
        }
        rotateSketchAngle += 0.01;
        zDepth += zDepthDelta;
        popMatrix();
    }
}
