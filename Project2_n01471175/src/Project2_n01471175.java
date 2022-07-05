/* 
 * Author:    James Ngo
 * Course:    COP3503 
 * Project #: 2
 * Title  :   Data Preprocessing
 * Due Date:  7/4/2022
 * 
 * Calculates the area of a rectangle. 
 */ 
 
//import java classes
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Project2_n01471175 {
	
	public static ArrayList<String> dates = new ArrayList<String>();
	public static ArrayList<String> times = new ArrayList<String>();
	public static ArrayList<Double> sensor2278 = new ArrayList<Double>();
	public static ArrayList<Double> sensor3276 = new ArrayList<Double>();
	public static ArrayList<Double> sensor4689 = new ArrayList<Double>();
	public static ArrayList<Double> sensor5032 = new ArrayList<Double>();
	public static ArrayList<Double> section1Diff = new ArrayList<Double>();
	public static ArrayList<Double> section2Diff = new ArrayList<Double>();
	public static ArrayList<Double> totalAvg = new ArrayList<Double>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//   //C:\\Users\\james\\Downloads\\Speed_Data.csv
		
		System.out.println("Project 2 Data Preprocessing\n");
		
		String line = "";
		Scanner scnr = new Scanner(System.in);
		boolean running = true;
		

		do
		{
			
			try 
			{
				
				System.out.println("Please enter the file's absolute path: ");
				String fileName = scnr.nextLine();
				File file = new File(fileName);
				
				// now check if the user file exists
			
				if(!file.exists()) 
				{
					throw new FileNotFoundException(fileName);
				}
				
				//then check if can write to file
				if(!file.canWrite()) 
				{
					throw new IOException(fileName);
				}
				
				Scanner scnrFile = new Scanner(file);
				
				while(scnrFile.hasNextLine()) {
					line = scnrFile.nextLine();
					
					System.out.println(line);
				}
				scnrFile.close();
				break;
			
			
			}
			catch (FileNotFoundException e) {
				System.out.println(e + " File does not exist or path is incorrect.");//error message
				running = true;
				
				}
			catch(IOException e) {
				System.out.println(e + " File is not writable, please check permission.");
				running = true;
			}
			catch(Exception e) {//catches everything not listed above
				System.out.println(e);
				running = true;
			}
		}while (running);
		scnr.close();
			
		
	}

}
