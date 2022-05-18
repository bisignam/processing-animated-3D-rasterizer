package ch.bisignam.processing.palette;


import processing.core.PApplet;

public class ColorPalette extends PApplet {

  private final int[] colors;
  private int currentIndex = 0;

  protected ColorPalette(int[] colors) {
    this.colors = colors;
  }
  
  public int currentColor(){
    return colors[currentIndex];   
  }

  public int nextColor(){
    if(currentIndex+1 >= colors.length) {
      reset();
      return currentColor();
    }
    currentIndex++;
    return currentColor(); 
  }

  public int getRandomColor(){
    return colors[(int)random(0, colors.length)];
  }

  public void reset() {
    this.currentIndex = 0;
  }
}