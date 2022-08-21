import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Check_Files {
    public static final String CWD = "C:\\Users\\jayatiparwani\\Desktop\\week_12_buzzer";
    public String path_1, path_2;

    public Check_Files(String path_1, String path_2) {
        this.path_1 = path_1;
        this.path_2 = path_2;
    }


    public int recordExceptions() {
        int count = 0;
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(path_1));
            BufferedReader br2 = new BufferedReader(new FileReader(path_2));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.csv"));
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
}