import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String args[]){

        Main.countNumberOne("C:\\Examples\\task.txt", "C:\\Examples\\taskAnswer.txt");
    }

    public static void countNumberOne(String pathToFileFrom, String pathToFileTo) {

        int countMax = 0;
        int countTemp = 0;

        try(FileReader reader = new FileReader(pathToFileFrom))
        {
            int c;
            while((c=reader.read())!=-1){
                if (c == 49) {
                    countTemp += 1;
                }else if (c == 48){
                    if (countMax < countTemp) {
                        countMax = countTemp;
                    }
                    countTemp = 0;
                }
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }

        try(FileWriter writer = new FileWriter(pathToFileTo, false)) {
            String text = String.valueOf(countMax);
            writer.write(text);
            writer.flush();
        } catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
