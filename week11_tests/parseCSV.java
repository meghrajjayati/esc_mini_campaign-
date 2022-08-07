import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class parseCSV {
    public static void main(String[] args) throws Exception {

        String filename1;
        String filename2;
        Scanner user = new Scanner(System.in);

        // prepare the input file

        System.out.print("Input File 1 Path: ");
        filename1 = user.nextLine();
        System.out.print("Input File 2 Path: ");
        filename2 = user.nextLine();
        programflow(filename1,filename2);
        }

    public static ArrayList<List>  programflow(String filename1, String filename2) throws Exception {
        File file = new File(filename1);
        File file2 = new File(filename2);
        ArrayList<List> exceptions = null;

        //File file = new File("sample_file_1.csv");
        //File file2 = new File("sample_file_3.csv");
        boolean express = (boolean) parseCSV.checkcsv(file, file2);
        if (express == false) {
            System.out.println("Incorrect File Type, try again");
        } else {
            List[] header_list = parseCSV.parsefiles(file, file2);
            if (header_list[0] == null || header_list[1] == null) {
                System.out.println(header_list[0]);
                System.out.println("file2"+ header_list[1]);

                System.out.println("Incorrect File Headers, try again");

            } else {
                exceptions = parseCSV.writefiles((ArrayList<List>) header_list[0], (ArrayList<List>) header_list[1]);


            }

        }
        return exceptions;

    }



        public static boolean checkcsv(File file1, File file2) {

            boolean express = false;
            String fileName = file1.getName().toUpperCase();
            fileName = fileName.replaceAll("\\s+", "");
            String file2Name = file2.getName().toUpperCase();
            file2Name = file2Name.replaceAll("\\s+", "");

            if ((fileName.endsWith(".csv") || fileName.endsWith(".CSV") == true) && (file2Name.endsWith(".csv") || file2Name.endsWith(".CSV") == true)) {
                express = true;

            } else {
                express = false;
            }
            return express;
        }

    public static List[] parsefiles(File file1, File file2) throws Exception{
        String delimiter = ",";
        String row;
        String rowT;
        ArrayList<List> listFile1= new ArrayList();
        ArrayList<List> listFile2= new ArrayList();
        List arr;
        List arr2;
        List head;
        List final_list;
        String headers= "\"Customer ID#\",\"Account No.\",\"Currency\",\"Type\",\"Balance\"";
        head= Arrays.asList(headers.split(delimiter));

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            while ((row = br.readLine()) != null) {

                arr = Arrays.asList(row.split(delimiter));

                listFile1.add(arr);

            }
            if (!listFile1.get(0).equals(head))
            {
                 listFile1= null;

            }
        } catch (Exception e){
            throw new FileNotFoundException("MSG_NOT_FOUND" + file1);
        }
        try (BufferedReader br_two =
                     new BufferedReader(new FileReader(file2))) {
            while((rowT = br_two.readLine()) != null){
                 arr2 = Arrays.asList(rowT.split(delimiter));
                listFile2.add(arr2);
            }
            if (!listFile2.get(0).equals(head))
            {
                listFile2= null;

                //System.out.println(head);

            }

        } catch (Exception e){
            throw new FileNotFoundException("MSG_NOT_FOUND" + file2);
        }


        return new List[]{listFile1, listFile2};
    }
    public static ArrayList<List>  writefiles(ArrayList<List> listFile1,ArrayList<List> listFile2 ) throws Exception{

        File write = new File("output.csv");
        FileWriter filewrt = new FileWriter(write);
        BufferedWriter buffwrite= new BufferedWriter(filewrt);
        buffwrite.write("\"Customer ID#\",\"Account No.\",\"Currency\",\"Type\",\"Balance\"");
        buffwrite.newLine();
        ArrayList<List> exceptions= new ArrayList<>();
        for(int i=0; i<listFile1.size();i++) {
            List a=listFile1.get(i);
            List b=listFile2.get(i);
            if (!a.equals(b)){
                System.out.println(a);
                System.out.println(b);

                exceptions.add(a);
                exceptions.add(b);
                buffwrite.write(String.join(",",a));
                buffwrite.newLine();
                buffwrite.write(String.join(",",b));
                buffwrite.newLine();

            }//System.out.println(listFile1);
        }
        buffwrite.close();
        return exceptions;

    }



    }




