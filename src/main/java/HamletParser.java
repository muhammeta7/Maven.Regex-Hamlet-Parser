import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public void changeHamletToLeon(){
        hamletData = replace("Hamlet", "Leon", hamletData);
        hamletData = replace("HAMLET", "LEON", hamletData);
    }

    public void changeHoratioToTariq(){
        hamletData = replace("Horatio", "Tariq", hamletData);
        hamletData = replace("HORATIO", "TARIQ", hamletData);
    }

    public boolean findHamlet(String name){
        Pattern pattern1 = Pattern.compile("Hamlet");
        Pattern pattern2 = Pattern.compile("HAMLET");
        return (pattern1.matcher(name).find() || pattern2.matcher(name).find());
    }

    public boolean findHoratio(String name){
        Pattern pattern1 = Pattern.compile("Horatio");
        Pattern pattern2 = Pattern.compile("HORATIO");
        return (pattern1.matcher(name).find() || pattern2.matcher(name).find());
    }

    public String replace(String original, String replacement, String name){
        Pattern patternToReplace = Pattern.compile(original);
        Matcher matcher = patternToReplace.matcher(name);
        return matcher.replaceAll(replacement);
    }

}
