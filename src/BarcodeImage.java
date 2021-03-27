/**
 * Lab 4: Write A Java Program: Optical Barcode
 * CST 338: Software Design (Spring B 2021)
 *
 * Create a BarcodeImage that implements a Cloneable image
 * Contains a constructor and BarcodeImage string.
 * Uses a clone method to display the Cloneable interface.
 */
class BarcodeImage implements Cloneable
{
   public static final int MAX_HEIGHT = 30;
   public static final int MAX_WIDTH = 65;
   private boolean[][] imageData;
   public BarcodeImage()
   {
      imageData = new boolean[MAX_HEIGHT][MAX_WIDTH];
      for (boolean data[] : imageData)
         for (boolean value : data)
            value = false;
   }
   //Initiate the string to get the data
   public BarcodeImage(String[] strData)
   {
      if (checkSize(strData))
      {
         imageData = new boolean[MAX_HEIGHT][MAX_WIDTH];
         int row, col;
         for (row = 0; row < strData.length; row++)
         {
            for (col = 0; col < strData[row].length(); col++)
               if (strData[row].charAt(col) == '*')
                  setPixel(row, col, true);
         }
      }
   }
   //getPixel to get the return value of the data
   public boolean getPixel(int row, int col)
   {
      if (imageData != null || row < MAX_HEIGHT && col < MAX_WIDTH)
         return imageData[row][col];
      return false;
   }
   //setPixel to set the row and col for the data
   public boolean setPixel(int row, int col, boolean value)
   {
      if (row < MAX_HEIGHT && col < MAX_WIDTH)
      {
         imageData[row][col] = value;
         return true;
      }
      return false;
   }
 //checkSize to make sure that the Max height and width aren't more than the max height and width
   private boolean checkSize(String[] data)
   {
      if (data != null)
         return data.length < MAX_HEIGHT && data[0].length() < MAX_WIDTH;
      return false;
   }
   //Display the data to the console
   public void displayToConsole()
   {
      for (int i = 0; i < MAX_HEIGHT; i++)
      {
         for (int j = 0; j < MAX_WIDTH; j++)
         {
            if (imageData[i][j])
            {
               System.out.print('*');
            } else
            {
               System.out.print(' ');
            }
         }
         System.out.println();
      }
   }
   //Clones the objective of the Barcode Image
   public Object clone()
   {
      try
      {
         BarcodeImage copy = (BarcodeImage) super.clone();
         copy.imageData = imageData.clone();
         for (int i = 0; i < MAX_HEIGHT; i++)
         {
            copy.imageData[i] = imageData[i];
         }
         return copy;
      }
      catch (CloneNotSupportedException e)
      {
         return null;
      }
   }
}