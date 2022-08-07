import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class mutatefuzzing {
    public static void main(String[] args) throws Exception {
        String inp1;
        Scanner user = new Scanner(System.in);

        // prepare the input file

        System.out.print("Input File 1 Path: ");
        inp1 = user.nextLine();
        File file = new File(inp1);
        ArrayList<List> list1 = parsefiles(file);
        mutated_fuzzing(inp1,list1);
        mutated_fuzzing_identical( inp1,list1);
    }


    public static ArrayList<List> parsefiles(File file1) throws Exception {
        String delimiter = ",";
        String row;
        ArrayList<List> listFile1 = new ArrayList();
        List arr;
        List arr2;
        List head;
        List final_list;
        String headers = "\"Customer ID#\",\"Account No.\",\"Currency\",\"Type\",\"Balance\"";
        head = Arrays.asList(headers.split(delimiter));

        try (BufferedReader br = new BufferedReader(new FileReader(file1))) {
            while ((row = br.readLine()) != null) {

                arr = Arrays.asList(row.split(delimiter));

                listFile1.add(arr);

            }
        } catch (Exception e) {
            throw new FileNotFoundException("FILE_NOT_FOUND" + file1);
        }
        return listFile1;
    }

    public static void write_random_file(ArrayList<List> list1, String filename) throws Exception {
        Random rn = new Random();
        int case_int = rn.nextInt(10);
        File write = new File(filename);
        FileWriter filewrt = new FileWriter(write);
        BufferedWriter buffwrite = new BufferedWriter(filewrt);
        buffwrite.write("\"Customer ID#\",\"Account No.\",\"Currency\",\"Type\",\"Balance\"");
        buffwrite.newLine();


        ArrayList<List> random_array = new ArrayList<>();
        //-1 to exclude header- both input files same length
        for (int i = 0; i < list1.size() - 1; i++) {
            String[] generatedStrings = random_string();
            List random_string = Arrays.asList(generatedStrings);
            buffwrite.write(String.join(",", random_string));
            buffwrite.newLine();


            //replace each element of list i.e each row with a ranom element
        }
        buffwrite.close();

    }

    public static String[] random_string() {
        Random rn = new Random();
        int case_int = rn.nextInt(10) + 1;
        //ensure no empty strings
        String allCharStringContains = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        int maximum = allCharStringContains.length();

        StringBuffer stringBufferObj;
        String[] stringArray = new String[5];


        Random randomObj = new Random();
        for (int i = 0; i < 5; i++) {

            stringBufferObj = new StringBuffer();

            for (int j = 0; j < case_int; j++) {

                int createdRandomChar = randomObj.nextInt(maximum);

                stringBufferObj.append(allCharStringContains.charAt(createdRandomChar));

            }
            //setting a created string into stringArray in index[i]
            stringArray[i] = stringBufferObj.toString();

        }
        //returning the Array of Strings object
        return stringArray;

    }

    public static void mutated_fuzzing(String file1,ArrayList<List> input_list) throws Exception {
        parseCSV parse_obj = new parseCSV();
        Random rn = new Random();
        write_random_file(input_list, "inputfile2.csv");

        //to avoid 0 iterations, +1 is necessary
        int iterations = rn.nextInt(10) + 1;
        for (int i = 0; i < iterations; i++) {
            ArrayList<List> exceptions = parse_obj.programflow(file1, "inputfile2.csv");
            if (exceptions.size()!=0) {
                System.out.println("Mutation Test (unidentical csv) for iteration " + String.valueOf(i) + " is successfull and returns mismatches in a csv.");
            }
        }
    }

        public static void mutated_fuzzing_identical(String file1,ArrayList<List> input_list) throws Exception {
            parseCSV parse_obj= new parseCSV();
            Random rn = new Random();
            //to avoid 0 iterations, +1 is necessary
            int iterations = rn.nextInt(10) + 1;
            for (int i = 0; i < iterations; i++) {
                ArrayList<List>exceptions= parse_obj.programflow(file1,file1);
                if(exceptions.size()==0){
                    System.out.println("Mutation Test (identical csv) for iteration "+String.valueOf(i)+" is successfull, no mismatch is found.");
                }
                else{
                        System.out.println("Mutation Test (identical csv) for iteration "+String.valueOf(i)+" is failed,  mismatch is found.");

            }
            }


        }
}










/*
                List a=listFile1.get(i);
                List b=listFile2.get(i);
                if (!a.equals(b)){
                    exceptions.add(a);
                    exceptions.add(b);

                    System.out.println(a.toString());
                    System.out.println(b.toString());
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

 */



