import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
public class parseCSVTest {


//both files valid
    @org.junit.Test
    public void csvValid() throws Exception  {
        File file = new File("homework/sample_file_1.csv");
        File file2 = new File("homework/sample_file_3.csv");
        boolean express = parseCSV.checkcsv(file, file2);
        assertTrue(express);

    }
    //one file valid, one invalid type
    @org.junit.Test
    public void fileInvalidType() throws Exception  {
        File file = new File("homework/sample_file_1.csv");
        File file2 = new File("homework/esc_week9.pdf");
        boolean express = parseCSV.checkcsv(file, file2);
        assertFalse(express);

    }
    //empty csv
    @org.junit.Test
    public void emptyfileType() throws Exception  {
        File file = new File("homework/sample_file_1.csv");
        File file2 = new File("homework/emptycsv.csv");
        boolean express = parseCSV.checkcsv(file, file2);
        assertTrue(express);

    }
    //empty csv
    @org.junit.Test
    public void nofileType() throws Exception  {
        File file = new File("homework/sample_file_1.csv");
        File file2 = new File("");
        boolean express = parseCSV.checkcsv(file, file2);
        assertFalse(express);

    }



    //incorrect spacing - arguments not file
    @org.junit.Test

    public void incorrect_arguments() throws Exception  {
        File file = new File("hello");
        File file2 = new File("homework/sample_ file_3.csv");
        boolean express = parseCSV.checkcsv(file, file2);
        assertFalse(express);
    }


//check if file exists or not
    @org.junit.Test(expected = Exception.class)
    public void invalid_arguments() throws Exception {
        File file = new File("homework/balance.csv");
        File file2 = new File("homework/balance.csv");
        parseCSV.parsefiles(file, file2);
    }

    @org.junit.Test
    public void valid_headers() throws Exception  {
        File file = new File("homework/sample_file_1.csv");
        File file2 = new File("homework/sample_file_3.csv");
        boolean exp = true;
        List[] header_list = parseCSV.parsefiles(file, file2);
        if (header_list[0] == null || header_list[1] == null) {
            exp = false;
        }
        assertTrue(exp);
    }


    @org.junit.Test
    public void invalid_headers() throws Exception {
        File file = new File("homework/invalidheaders.csv");
        File file2 = new File("homework/sample_file_3.csv");
        boolean exp = true;
        List[] header_list = parseCSV.parsefiles(file, file2);
        if (header_list[0] == null || header_list[1] == null) {
            exp = false;
        }
        assertFalse(exp);
    }
    @org.junit.Test
    public void allincorrect_headers() throws Exception {
        File file = new File("homework/allwrongheaders.csv");
        File file2 = new File("homework/sample_file_3.csv");
        boolean exp = true;
        List[] header_list = parseCSV.parsefiles(file, file2);
        if (header_list[0] == null || header_list[1] == null) {
            exp = false;
        }
        assertFalse(exp);
    }
    @org.junit.Test
    public void missing_headers() throws Exception {
        File file = new File("homework/missing_header.csv");
        File file2 = new File("homework/sample_file_3.csv");
        boolean exp = true;
        List[] header_list = parseCSV.parsefiles(file, file2);
        if (header_list[0] == null || header_list[1] == null) {
            exp = false;
        }
        assertFalse(exp);
    }

    @org.junit.Test
    public void jumbled_headers() throws Exception  {
        File file = new File("homework/jumbledheaders.csv");
        File file2 = new File("homework/sample_file_3.csv");
        boolean exp = true;
        List[] header_list = parseCSV.parsefiles(file, file2);
        if (header_list[0] == null || header_list[1] == null) {
            exp = false;
        }
        assertFalse(exp);
    }

//SYSTEM TEST- csv where every row is exception/mismatch- boundary value
    @org.junit.Test
    public void writedoublefiletest() throws Exception {
        File file = new File("homework/sample_file_1.csv");
        File file2 = new File("homework/sample_file_2.csv");
        boolean exp = true;
        List[] header_list = parseCSV.parsefiles(file, file2);
        ArrayList<List> exceptions= parseCSV.writefiles((ArrayList<List>) header_list[0], (ArrayList<List>) header_list[1]);
        int len_array_list= header_list[0].size();
        int len_array_list2= header_list[1].size();
         //header lengths subtracted - need to subtract-2
        assertEquals(len_array_list+len_array_list2-2,exceptions.size());

    }
    //SYSTEM TEST- csv where no row is exception/mismatch- boundary value since both files identicial
    @org.junit.Test
    public void writeemptyfiletest() throws Exception {
        File file = new File("homework/sample_file_1.csv");
        File file2 = new File("homework/sample_file_1.csv");
        boolean exp = true;
        List[] header_list = parseCSV.parsefiles(file, file2);
        ArrayList<List> exceptions= parseCSV.writefiles((ArrayList<List>) header_list[0], (ArrayList<List>) header_list[1]);
        assertEquals(0,exceptions.size());

    }




    //SYSTEM TEST- middle value
    @org.junit.Test
    public void writemiddlefiletest() throws Exception {
        File file = new File("homework/sample_file_1.csv");
        File file2 = new File("homework/sample_file_3.csv");
        boolean exp = true;
        List[] header_list = parseCSV.parsefiles(file, file2);
        ArrayList<List> exceptions= parseCSV.writefiles((ArrayList<List>) header_list[0], (ArrayList<List>) header_list[1]);
        assertEquals(6,exceptions.size());

    }


}
