import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Data_Reconciliation {
    public static final String CWD = "C:\\Users\\jayatiparwani\\Desktop\\week_12_buzzer\\";

    public static void main(String[] args) {
        String file_1 = "invalidheaders.csv";
        String file_2 = "sample_file_1.csv";
        Check_Files Checker = new Check_Files(file_1, file_2);
        int count = Checker.recordExceptions();
        System.out.println(count);
        boolean Isequal = Data_Reconciliation.EqualFileContent("outputs.csv", "empty.csv");
        System.out.println(Isequal);
    }

    // For parametric testing(returns number of mismatched lines)
    public static int recordExceptions(String path_1, String path_2) {
        int count = 0;
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(path_1));
            BufferedReader br2 = new BufferedReader(new FileReader(path_2));
            BufferedWriter bw = new BufferedWriter(new FileWriter("outputs.csv"));
            String line1;
            String line2;
            while (((line1 = br1.readLine()) != null)|((line2 = br2.readLine()) != null)) {
                if(line1 == null){
                    bw.write(line2);
                    bw.write("\n");
                    count++;
                }
                else if(line2 == null){
                    bw.write(line1);
                    bw.write("\n");
                    count++;
                }
                else if(!(line1.equals(line2))){
                    bw.write(line1);
                    bw.write("\n");
                    bw.write(line2);
                    bw.write("\n");
                    count++;
                }
            }
            br1.close();
            br2.close();
            bw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
            count = -1;
        }
        return count;
    }

    public static boolean EqualFileContent(String path_1, String path_2){
        // boolean isEqual;
        File file1 = new File(path_1);
        File file2 = new File(path_2);
        Path firstFile = file1.toPath();
        Path secondFile = file2.toPath();
        try {
            if (Files.size(firstFile) != Files.size(secondFile)) {
                return false;
            }

            byte[] first = Files.readAllBytes(firstFile);
            byte[] second = Files.readAllBytes(secondFile);
            return Arrays.equals(first, second);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;

    }
}