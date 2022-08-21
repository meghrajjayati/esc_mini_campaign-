import java.io.File;

import static org.junit.Assert.*;

public class Data_ReconciliationTest {
    @org.junit.Test
    public void equal_file() throws Exception  {
        boolean express = Data_Reconciliation.EqualFileContent("sample_file_1.csv", "sample_file_1.csv");
        assertTrue(express);
    }

    @org.junit.Test
    public void diff_equal_file() throws Exception  {
        boolean express = Data_Reconciliation.EqualFileContent("sample_file_1.csv", "sample_file_3.csv");
        assertFalse(express);
    }

    @org.junit.Test
    public void empty_equal_file() throws Exception  {
        boolean express = Data_Reconciliation.EqualFileContent("empty.csv", "empty.csv");
        assertTrue(express);
    }

    @org.junit.Test
    public void exceptions() throws Exception  {
        int count=Data_Reconciliation.recordExceptions("sample_file_1.csv", "sample_file_2.csv");
        assertEquals(1000,count);
        System.out.println(count);
    }
    @org.junit.Test
    public void no_exceptions() throws Exception  {
        int count=Data_Reconciliation.recordExceptions("sample_file_2.csv", "sample_file_2.csv");
        assertEquals(0,count);
        System.out.println(count);
    }

    @org.junit.Test
    public void emptyfileType() throws Exception  {

        int express = Data_Reconciliation.recordExceptions("sample_file_1.csv", "empty.csv");
        assertEquals(express,1001);

    }
    @org.junit.Test
    public void nofileType() throws Exception  {
        File file = new File("homework/sample_file_1.csv");
        File file2 = new File("homework/emptycsv.csv");
        int express = Data_Reconciliation.recordExceptions("sample_file_1.csv", "emptyss.csv");
        assertEquals(express,-1);

    }

    @org.junit.Test
    public void invalid_headers() throws Exception  {
        int express = Data_Reconciliation.recordExceptions("invalidheaders.csv", "sample_file_1.csv");
        System.out.println(express);
        assertEquals(express,1001);

    }





}