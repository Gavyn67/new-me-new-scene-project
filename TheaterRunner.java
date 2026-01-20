import org.code.theater.*;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;

public class TheaterRunner {
  public static void main(String[] args) throws IOException {
    /* 
    ❗❗ READ: Java lab errors [EXCEPTION] java.lang.Readable is not supported by Java Lab.
    So I unfortunately have to hard code the data from the data file.
    Otherwise I would have used the code in the comments below
    */
    
    // FileReader fileReader = new FileReader("data1.txt");
    // Scanner scanner1 = new Scanner(fileReader);

    // int count = 0;
    // while (scanner1.hasNextLine()) {
    //   scanner1.nextLine();
    //   count++;
    // }
    
    // String[] thingsInJanuary = new String[count];
    // Scanner scanner2 = new Scanner(fileReader);
    // for (int i = 0; i < thingsInJanuary.length; i++) {
    //   thingsInJanuary[i] = scanner2.nextLine();
    // }
    
    double[] grades = new double[] {100, 96.26, 97.91, 95.87, 100, 99.54};

    //❗ READ above
    String[] thingsInJanuary = new String[]{"Going to Sixflags", "Focusing on hobbies", "Working harder"};
    
    LastYear lastYear = new LastYear(grades, 6, 5, 5, 3);
    ThisYear thisYear = new ThisYear(thingsInJanuary, 3, 1);

    lastYear.drawScene(lastYear);
    thisYear.drawScene(thisYear);

    Theater.playScenes(lastYear, thisYear);
    
  }
}