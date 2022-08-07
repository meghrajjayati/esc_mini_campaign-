<strong>ESC MINI CAMPAIGN WEEK 12

Name: Parwani Jayati 
Student ID: 1005622 


This is my esc mini campaign  files. </strong>

 
  <h2>About and How to Access </h2>
  
  <strong> <p> The code in <code> parseCSV.java</code> has been updated to account for refactoriing and bug fizzing upon mutation fuzzer testing. Please access  <code> parseCSV.java </code> software through week_12_buzzer folder and </strong><i>  Mutation Fuzzer to Create Random CSV Files in the section below in this document</i> <strong>for further instructions </strong>. 
  </strong>
 
  <p>This repo contains the homework folder, with parseCSV.java which implements the main method. The folder also contains sample csvs 1,2,3 and the outputs obtained comapring csv 1 and 2, and csv 1 and 3. These csv files are also in the homework folder.  
 The use case diagram is in the file use_cases. 

    
    String file = "sample_file_1.csv"
    String file2 = "edit to add your own file";
  
  <code>Clone the repo and compile and run parseCSV.java (main method) in your preferred JAVA IDE. Although sample files are provided in the folder,if you wish to modify the files then modify the following lines by adding your desired csv files in line 10 and 11 shown above. <br />
 </p>
 <p> The output after compiling and running parseCSV should be stored in output.csv file which is added to homework folder when you run the code. However, if you wish to modify the file name, simply modify the line 42 shown below </p>
 <p>
 <code> File write = new File("write your desired file name"); </code> <br />
 </p>
 
Access Week 9 report link here: 
https://sutdapac-my.sharepoint.com/:w:/g/personal/jayati_parwani_mymail_sutd_edu_sg/EdVIePC9lG5Oi3EACftrx7oB4POcopP3KMEB5sopGHokgg?e=YAjEji

 
Access week 10 tests
Testing documentation: esc-week10tests.pdf in main branch 
Code: week_10_tests folder, parseCSV.java- updated code to account for tests and exceptions, run as previously described in the above section. 
To access tests go to parseCSVTest.java
Run each test or run all, ensure you have Junit 4, intsalled. 





<h2> Mutation Fuzzer to Create Random CSV Files <h2>


<h3>About</h3>
<p>The files in <code>mutatefuzzing.java</code> provide mutation-based fuzzing testing 
  for  <code>parseCSV.java</code> in week_12_buzzer folder.</p>
<p><code>mutatefuzzing</code> object needs an input  CSV file and generates a csv file of the same dimension and with the same header required by the software. This generated CSV file contains every row of randomly created string whose upper bound can be set by the client. The purpose of both the tests in the functions <code>mutated_fuzzing</code> and <code>mutated_fuzzing_identical</code> in <code>mutatefuzzing.java</code> is to fuzz the two input files required in <code>parseCSV.java</code>. 
<ol>
<li>
<code>mutated_fuzzing</code> fuzzes the code with a csv with random inputs but same dimensions as the csv which is prompted for input by the third party. The test is then run a random number of iterations, in this case the upper bound is set to 10, but can be varied. 
 </li>
 <li>
<code>mutated_fuzzing_identical</code> fuzzes the code with 2 identical csvs, for random number of iterations, in this case the upper bound is set to 10, but can be varied. 
</li>
</ol>
<h3>How to run</h3>
<ul> 
<li>
<p>Upon compiling <code>parseCSV.java</code> you will be prompted to enter two file paths in the week_12_buzzer folder folder. Please do enter valid paths, if you however enter invalid paths or files, excpetions have been handled appropriately and where required to compile and run again. </p>
</li>
<li>
<p>Upon compiling <code>mutatefuzzing.java</code> you will be prompted to enter one file paths in the week_12_buzzer folder folder. Please do enter valid paths, if you however enter invalid paths or files, excpetions have been handled appropriately and where required to compile and run again. </p>
</li>
</ul>

<h3> Results </h3>
<p> Both fuzzing tests have shown that the software serves its purpose aptly identifying matches and mismatches in the comparison of both csv files. 
<ul> 
<li>
<p><code>mutated_fuzzing.java</code> will return mismatches in <code>output.csv</code> for all iterations of tests conducted with any sample csv user promts and the number of rows in <code>output.csv</code> is double the size of the input csv user uploads, since every row is a mismatch in the randomy generated csv and user-input csv. </p>
</li>
<li>
<p><code>mutated_fuzzing_identical.java</code> will return no mismatches in <code>output.csv</code> for all iterations of tests conducted with any sample csv user promts, since both csvs are identical. </p>
</li>
</ul>
<p> The tests have been automated, if updates to upper-bounds are required, for the random length of string, they can be manually set in <code>public static String[] random_string())</code> method. </p> 
<p> To change the upper bound to the number of random iterations, you need to updated <code>public static void mutated_fuzzing(String file1,ArrayList<List> input_list)
 </code>
 


 
