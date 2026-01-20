import org.code.theater.*;
import org.code.media.*;
import java.lang.Math.*;

public class LastYear extends Scene {
  // Instance Variables
  private double[] grades;
  private int hoursSleptPerNight;
  private int screenTimeHours;
  private int workoutSessionsPerWeek;
  private int newSkillsLearned;

  /*
  Default Constructor
  */
  public LastYear() {
    grades = new double[] {100, 90, 91};
    hoursSleptPerNight = 10;
    screenTimeHours = 10;
    workoutSessionsPerWeek = 10;
    newSkillsLearned = 10;
  }

  /*
  Parameterized Constructor
  */
  public LastYear(double[] grades, int hoursSleptPerNight, int screenTimeHours, int workoutSessionPerWeek, int newSkillsLearned) {
    this.grades = grades;
    this.hoursSleptPerNight = hoursSleptPerNight;
    this.screenTimeHours = screenTimeHours;
    this.workoutSessionsPerWeek = workoutSessionPerWeek;
    this.newSkillsLearned = newSkillsLearned;
  }

  /*
  Draws scene displaying quantifiable data in amounts of rectangles. Displays text that clarifies what the data is referencing
  Conditions may display extra text based on different instance values
  */
  public void drawScene(LastYear lastYear) {
    lastYear.setTextStyle(Font.SANS, FontStyle.BOLD);
    lastYear.setTextHeight(20);
    lastYear.setTextColor(new Color(165, 1, 4));

    lastYear.drawText("Let's Reminisce Last Year", 0, 200);   
    pause(3);
    clear("white");
    
    lastYear.drawText("Daily Screen Time Hours Visualized", 0, 380);    
    scatterRectangles(lastYear, "purple", screenTimeHours, 20, 20);
    pause(5);
    clear("white");

    lastYear.drawText("Hours Slept Per Night Visualized", 0, 380);    
    scatterRectangles(lastYear, "red", hoursSleptPerNight, 30, 30);
    pause(5);
    clear("white");

    lastYear.drawText("Grades Visualized (Bigger = Higher)", 0, 380);
    double lowestGrade = 100.0;
    for (int i = 0; i < grades.length; i++) {
      int size = (int) (100 * (grades[i]) / 100);
      scatterRectangles(lastYear, "red", 1, size, size);
      if (grades[i] < lowestGrade) {
        lowestGrade = grades[i];
      }
    }
    if (lowestGrade >= 90) {
       lastYear.drawText("Wow! Your lowest grade was an A.", 0, 360);
    } 
    pause(5);
    clear("white");

    lastYear.drawText("Workouts Per Week", 0, 380);
    scatterRectangles(lastYear, "blue", workoutSessionsPerWeek, 50, 50);
    pause(5);
    clear("white");

    lastYear.drawText("New Skills Learned", 0, 380);    
    scatterRectangles(lastYear, "blue", newSkillsLearned, 70, 70);
    if (newSkillsLearned >= 3) {
       lastYear.drawText("You've learned over 3 skills this year!", 0, 300);
      lastYear.drawText("You are truly skillful!", 0, 330);
    } 
    pause(5);
    clear("white");
  }

  /*
  Sets the fill color to whatever color is passed in.
  Quantity refers to the value of the variable, to visualize data
  sizeX and sizeY determine the dimensions of the rectangle
  
  Scatters rectangles across the 400x400 grid.
  */
  public void scatterRectangles(LastYear lastYear, String color, int quantity, int sizeX, int sizeY) {
    lastYear.setFillColor(color);
    for (int i = 0; i < quantity; i++) {
      // Calls local function to get a random integer, to determine the random position of the rectangle.
      int randomPosX = getRandomInt(400 - sizeX);
      int randomPosY = Math.min(getRandomInt(400 - sizeY), 300);

      // Uses inherited scene method to draw the rectangle
      lastYear.drawRectangle(randomPosX, randomPosY, sizeX, sizeY);
    }
  }

  /*
  Returns a random int between 0 and range.
  */
  public int getRandomInt(int range) {
    return (int) (Math.random() * range + 1);
  }
}