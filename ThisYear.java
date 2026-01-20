import org.code.theater.*;
import org.code.media.*;
import java.lang.Math.*;

public class ThisYear extends Scene {
  // Instance Variables
  private String[] thingsInJanuary;
  private int lateAssignments;
  private int booksRead;

  /*
  Default Constructor
  */
  public ThisYear() {
    thingsInJanuary = new String[0];
    lateAssignments = 5;
    booksRead = 2;
  }

  /*
  Parameterized Constructor
  */
  public ThisYear(String[] thingsInJanuary, int lateAssignments, int booksRead) {
    this.thingsInJanuary = thingsInJanuary;
    this.lateAssignments = lateAssignments;
    this.booksRead = booksRead;
  }

  /*
  Draws scene displaying quantifiable data in amounts of rectangles. Displays text that clarifies what the data is referencing
  Conditions may display extra text based on different instance values
  */
  public void drawScene(ThisYear thisYear) {
    thisYear.drawText("Let's Have a Good Start to This Year", 0, 200);   
    pause(3);
    clear("white");

    thisYear.drawText("Things Done In January", 0, 380);
    for (int i = 0; i < thingsInJanuary.length; i++) {
      thisYear.drawText(thingsInJanuary[i], 0, 50 + (40 * i));
    }
    pause(5);
    clear("white");
    
    thisYear.drawText("Amount of Late Assignments", 0, 380);    
    scatterTriangles(thisYear, lateAssignments, 30);
    pause(5);
    clear("white");

    thisYear.drawText("Amount of Books Read", 0, 380);    
    scatterTriangles(thisYear, booksRead, 50);
    if (booksRead >= 7) {
      thisYear.drawText("Wow! You are truly a bookworm", 0, 200);    
    } 
    pause(5);
    clear("white");
  }
  
  public void scatterTriangles(ThisYear thisYear, int quantity, int radius) {
    thisYear.setFillColor(getRandomColor());
    for (int i = 0; i < quantity; i++) {
      // Calls local function to get a random integer, to determine the random position of the rectangle.
      int randomPosX = getRandomInt(400);
      int randomPosY = Math.min(getRandomInt(300), 300);

      // Uses inherited scene method to draw the polygon with 3 sides (triangle)
      thisYear.drawRegularPolygon(randomPosX, randomPosY, 3, radius);
    }
  }

  /*
  Returns a string color in the hard coded list, to be used in inherited scene methods.
  */
  public String getRandomColor() {
    // List of acceptable colors for scene API
    String[] colors = {"purple", "orange", "blue", "black", "pink", "red", "green"};
    // Returns a random color in the list
    return (colors[(int) (Math.random() * colors.length)]);
  }

  /*
  Returns a random int between 0 and range.
  */
  public int getRandomInt(int range) {
    return (int) (Math.random() * range + 1);
  }
}