# Processing animated 3D rasterizer

This project experiments with 3D rasterization of images.

The implemented algorithm works in the following way:

* Divides the images into tiles by using as parameter the value ```tileSize```, the lower the size of the tile the higher the accuracy of the rasterization.
* Loops on each tile and check the average brightness of the input image in the given position.
* Draws a box for each tail where the attributes of each box are the following:
  * ```x``` is the x value of the analyzed tile.
  * ```y``` is the x value of the analyzed tile.
  * ```z``` Is the value of the brightness normalized in the range between (-```zDepth```, ```zDepth```)
  * ```color``` uses e custom palette of colors defined with class
    ```ch.bisignam.processing.palette.DebussyPalette```.

On top of that the sketch implements what I would call a deformation of the rasterization by cyclically expanding and shrinking the ```z``` value for each cube.
The expansion/shrinking interval is governed by the variable ```zDepthMod```.

Feel free to clone this project and experiment with different input images and configuration parameters. Happy generative coding!
