import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

public class parseCSV {
    public static void main(String[] args) throws Exception{
        String file = "sample_file_1.csv"; //modify this as per the files tested
        String file2 = "sample_file_2.csv";

        String delimiter = ",";

        String row;
        String rowT;
        ArrayList<List> listFile1= new ArrayList();
        ArrayList<List> listFile2= new ArrayList();
        try (BufferedReader br =
                     new BufferedReader(new FileReader(file))
        ) {
            while((row = br.readLine()) != null){
                List arr = Arrays.asList(row.split(delimiter));
                listFile1.add(arr);
            }
            //System.out.println(listFile1);

        } catch (Exception e){
            System.out.println(e);
        }
        try (BufferedReader br_two =
                     new BufferedReader(new FileReader(file2))) {
            while((rowT = br_two.readLine()) != null){
                List arr2 = Arrays.asList(rowT.split(delimiter));
                listFile2.add(arr2);
            }
            //listFile2.forEach(l -> System.out.println(l));

        } catch (Exception e){
            System.out.println(e);
        }
        //modify this to create your own file. 
        File write = new File("output.csv"); //modify the file name here to create your own file when testing. 
        FileWriter filewrt = new FileWriter(write,true);
        BufferedWriter buffwrite= new BufferedWriter(filewrt);
        buffwrite.write("Account No , Currency , Type ,Balance");
        buffwrite.newLine();
        for(int i=0; i<listFile1.size() ;i++) {
            List a=listFile1.get(i);
            List b=listFile2.get(i);
            if (!a.equals(b)){
                System.out.println(a.toString());
                System.out.println(b.toString());
                buffwrite.write(String.join(",",a));
                buffwrite.newLine();
                buffwrite.write(String.join(",",b));
                buffwrite.newLine();

            }//System.out.println(listFile1);
    }
        buffwrite.close();

    }
    }


    /*public ArrayList<List> compare(ArrayList<List> a,ArrayList<List> b){
        for(int i=0; i<a.size() ;i++){
            for(int j=0; i<a.get(0).size() ;i++){
                List list_element= a.get(i).get(j);

            }





            }

    }


}*/
