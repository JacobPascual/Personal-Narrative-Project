import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus{

public ImageFilter(String filename){
  super(filename);
}


  /*
   * Applies a pixelate filter to each Pixel object by dividing the image into a grid
   * of equal-sized rectangular regions and setting the color of each Pixel object in
   * a region to the color of the first Pixel object in the region
   */
public void pixelate(int gridSize) {
    Pixel[][] temp = getPixelsFromImage();
    
    //Outer loop
    for(int r = 0; r < temp.length; r += gridSize){
      int startRow = r;
      int endRow = r + gridSize;
      
      if(endRow > temp.length){
        endRow = Math.min(endRow, temp.length);
      }
      //Inner loop
      for(int c = 0; c < temp[0].length; c += gridSize){
        int startCol = c;
        int endCol = c + gridSize;
        
        if(endCol > temp[0].length){
          endCol = Math.min(endCol, temp[0].length);
        }

        int totalRed = 0;
        int totalGreen = 0;
        int totalBlue = 0;
        
        /*Second outer loop
        * Traverses the given region to recieve the sum of each pixel's RGB
        */
        for(int r2 = startRow; r2 < endRow; r2++){
          //Second inner loop
          for(int c2 = startCol; c2 < endCol; c2++){
            totalRed += temp[r2][c2].getRed();
            totalGreen += temp[r2][c2].getGreen();
            totalBlue += temp[r2][c2].getBlue();

            
          }
        }
        int avgRed = totalRed / (int)(Math.pow(gridSize, 2));
        int avgGreen = totalGreen / (int)(Math.pow(gridSize, 2));
        int avgBlue = totalBlue / (int)(Math.pow(gridSize, 2));

        
        for(int r3 = startRow; r3 < endRow; r3++){
          for(int c3 = startCol; c3 < endCol; c3++){
            temp[r3][c3].setRed(avgRed);
            temp[r3][c3].setGreen(avgGreen);
            temp[r3][c3].setBlue(avgBlue);
          }
        }
        
      }
    }
  }


  /*
   * This method finds and sets the average RGB across a 
   * given number of pixels in a given direction
   */
  public void motionBlur(int length, String direction) {
    /*
    * Initializes the pixels from the image into temporary 2D array
    */ 
    Pixel[][] temp = getPixelsFromImage();

    //Traverses the temp array of pixels
    for(int r = 0; r < temp.length; r++){
      for(int c = 0; c < temp[0].length; c++){
        // Current pixel object
        Pixel curPix = temp[r][c];

        // Represents the total RGB of all counted pixels
        int totalRed = 0;
        int totalGreen = 0;
        int totalBlue = 0;


        //CONTROL VARIABLES
        
        /*
        * Used to make sure the while loop doesn't try to
        * reference pixels outside of the image's width/length
        */
        int x = c;
        int y = r;
        
        // Used to keep the while loop within the range of the length parameter
        int count = 0;
        
        //Traverses the given number of pixels to get their total RGB
        while(count < length && x < temp[0].length && y < temp.length){
          // adds the current pixel's RGB to the total
          totalRed += temp[y][x].getRed();
          totalGreen += temp[y][x].getGreen();
          totalBlue += temp[y][x].getBlue();

          /*
          * Based on the given direction, either the x, y, or both 
          * will increase to create the correct blur
          */
          if(direction.equals("horizontal")){
            // x increases because it references the pixel to the right
            x++;
          }else if(direction.equals("vertical")){
            // y increases because it references the pixel above
            y++;
          }else if(direction.equals("diagonal")){
            // x and y increases because it references the pixel to the top right
            x++;
            y++;
          }
          count++;
        
        }
        /*
        * Finds the average RGB across the given amount of pixels
        * by dividing the total RGB by the count
        */
        int avgRed = totalRed / count;
        int avgGreen = totalGreen / count;
        int avgBlue = totalBlue / count;
        
        curPix.setRed(avgRed);
        curPix.setGreen(avgGreen);
        curPix.setBlue(avgBlue);
      }
    }
  }
  /*
   * Applies a threshold filter to an image
   */
  public void threshold(int value) {
    Pixel[][] temp = getPixelsFromImage();
    for(int r = 0; r < temp.length; r++){
      for(int c = 0; c < temp[0].length; c++){
        Pixel curPix = temp[r][c];
        int avgRGB = (curPix.getRed() + curPix.getGreen() + curPix.getBlue()) / 3;
        if(avgRGB < value){
          curPix.setRed(0);
          curPix.setGreen(0);
          curPix.setBlue(0);
        }else{
          curPix.setRed(255);
          curPix.setGreen(255);
          curPix.setBlue(255);
        }
        
      }
    }
  }

  //STUDENT CREATED filter
  /*
  * Traverses the pixels of the image and
  * changes their rgb values to their
  * values subtracted by the parameter
  * num
  */
  public void explodeSpike(int num){
    Pixel[][] temp = getPixelsFromImage();
    for(int r = 0; r < temp.length; r++){
      for(int c = 0; c < temp[0].length; c++){
        Pixel curPix = temp[r][c];
        int re = curPix.getRed();
        int gr = curPix.getGreen();
        int bl = curPix.getBlue();

        int newRe = re-(num+24);
        int newGr = gr-(num+15);
        int newBl = bl-(num+20);

        boolean red;
        boolean green;
        boolean blue;
        if(newRe < 0){
          curPix.setRed(0);
          red = true;
        }if(newGr < 0){
          curPix.setGreen(0);
          green = true;
        }if(newBl < 0){
          curPix.setBlue(0);
          blue = true;
        }

        if(red = false){
          curPix.setRed(newRe);
        }
        if(green = false){
          curPix.setGreen(newGr);
        }
        if(blue = false){
          curPix.setBlue(newBl);
        }

        
      }
    }
  }



  
}