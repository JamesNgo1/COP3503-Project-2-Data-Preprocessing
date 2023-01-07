/* 
 * Author:    James Ngo
 * Course:    COP3503 
 * Project #: 2
 * Title  :   Data Preprocessing
 * Due Date:  7/4/2022
 * 
 * Calculates the area of a rectangle. 
 */ 
 
//import of java classes
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Date;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;
import java.text.SimpleDateFormat;



public class Project2_n01471175 {

	//Declaration of array list for project.
	public static ArrayList<String> dates = new ArrayList<String>();
	public static ArrayList<String> times = new ArrayList<String>();
	public static ArrayList<Double> sensor2278 = new ArrayList<Double>();
	public static ArrayList<Double> sensor3276 = new ArrayList<Double>();
	public static ArrayList<Double> sensor4689 = new ArrayList<Double>();
	public static ArrayList<Double> sensor5032 = new ArrayList<Double>();
	public static ArrayList<Double> section1Diff = new ArrayList<Double>();
	public static ArrayList<Double> section2Diff = new ArrayList<Double>();
	public static ArrayList<Double> totalAvg = new ArrayList<Double>();

	/**
	 * The purpose of the method is to change the current date form take from csv to a new format
	 * From MM/dd/yyyy to  yyyy/MM/dd
	 * @param dateString
	 * @return the dateString
	 * @throws ParseException
	 */

	 public static String formatDate(String dateString) throws ParseException
	 {
		 
		 //Reading in the current format it is in. Which is currently in month , day , and year
		 SimpleDateFormat currentFormat = new SimpleDateFormat("MM/dd/yyyy");
		 //	The desire date format of year , month , and date
		 SimpleDateFormat newFormat = new SimpleDateFormat("yyyy/MM/dd");
		 
		 // valid date object and convert to new format 
		 Date dateObject = currentFormat.parse(dateString);
		 dateString = newFormat.format(dateObject);
		 
		 // return statement
		 return dateString;
		 
	 }
	 
	 /**
	  * The purpose of this method is to subtract one array list element from another.
	  * It will return the value after subtraction.
	  * @param two
	  * @param one
	  * @return
	  */
	 public static double subtraction(double two, double one ) 
	 {
		 //Subtraction calculation and return variable.
		 double number = (two - one) ;
		 return number;
		 
	 }
	 
	 /**
	  * The purpose of this method is to add up all the array list element and divide by the total count.
	  * This would return the average for each row.
	  * @param one
	  * @param two
	  * @param three
	  * @param four
	  * @return
	  */
	 public static double average(double one , double two , double three , double four)
	 {
		 //Average calculation and return variable.
		 double count = 4.0;
		 double average = ((one + two + three + four) / count);
		 return average;
	 }
	 
	 
	 
	 public static void writeData(String writeInput)throws IOException
	 {
		 
		 String outputFile = writeInput.replace(".csv", "_Difference.csv");
		 
		 
		 FileWriter fw = new FileWriter(outputFile);
		 System.out.println("Writing data to file "+ outputFile);
			 
		 //Writing the headers of the CSV file.
		 fw.write("Date,Time,Sensor_2278,Sensor_3276,Sensor_4689,Sensor_5032,Section1_Diff,Section2_Diff,Total_Avg \n");
			 
		 for(int i = 0; i < dates.size();i++)
		 {
			 fw.write(dates.get(i) + ",");
			 fw.write(times.get(i) + ",");
			 fw.write(sensor2278.get(i) + ",");
			 fw.write(sensor3276.get(i) + ",");
			 fw.write(sensor4689.get(i) + ",");
			 fw.write(sensor5032.get(i) + ",");
			 fw.write(section1Diff.get(i) + ",");
			 fw.write(section2Diff.get(i) +",");
			  fw.write(totalAvg.get(i) +",\n");
		 }
			 
			 System.out.println("Done! Exiting Program");
			 System.out.println(dates.get(0));
			 fw.close();
			 System.exit(0);
			 
	 }
	 /**
	  * A method for the buffer reader
	  * @param input
	  * @return
	  * @throws FileNotFoundException
	  */
	 public static BufferedReader readData(String input) throws FileNotFoundException {
		 //Initialize a a Buffer reader and returns it.
		 BufferedReader br = new BufferedReader(new FileReader(input));
		 return br;
	 }
			 
 
	 /**
	  * The main method
	  * @param args
	  * @throws IOException
	  */
	public static void main(String[] args) throws IOException 
	{
		Scanner scnr = new Scanner(System.in);
		
		//Display project title follow by new line.
		System.out.println("Project 2 Data Preprocessing");
		System.out.println();
		
		boolean running = true;// variable indicator of when to stop while loop.
		
		do {
			//boolean variable indicators for error exception.
			boolean dateError = false;
			boolean numError = false;
			
			System.out.println("Enter file name & location.");
			String userInput = scnr.nextLine();
			
			try {
				//print statements and use of method to create br.
				System.out.println("Reading in Data from the file " + userInput);
				BufferedReader br = readData(userInput);
				System.out.println("Converting Dates from MM/DD/YYYY to YYYY/MM/DD");
				
				//purpose of readline to avoid reading in the first line (first line consist of headers).
				String s = "";
				s = br.readLine();
				
				//while loop reading through each line.
				while((s = br.readLine()) != null) 
				{
					String[] stringArray = s.split(",");
					
					//try catch block for the date format
					try {
						dates.add(formatDate(stringArray[0]));
						//running = false;
						
					}catch(IllegalArgumentException | ParseException e) {
			    		  System.out.println("*Bad Date Data in CSV File.*");
			    		  System.out.println("Check CSV file data and try again.");
			    		  dateError = true;
					}//end of date format try catch
					
					
			    	//try catch block for number exception  
					try {
						//adding to appropriate array list.
						times.add(stringArray[1]);
						sensor2278.add(Double.parseDouble(stringArray[2]));
						sensor3276.add(Double.parseDouble(stringArray[3]));
						sensor4689.add(Double.parseDouble(stringArray[4]));
						sensor5032.add(Double.parseDouble(stringArray[5]));
						section1Diff.add(subtraction(Double.parseDouble(stringArray[2]),Double.parseDouble(stringArray[3])));
						section2Diff.add(subtraction(Double.parseDouble(stringArray[4]),Double.parseDouble(stringArray[5])));
						totalAvg.add(average(Double.parseDouble(stringArray[2]),Double.parseDouble(stringArray[3]),Double.parseDouble(stringArray[4]),Double.parseDouble(stringArray[5])));
					}catch(NumberFormatException e) {
						System.out.println("*Bad Number Data in CSV File.*");
						System.out.println("Check CSV file data and try again.");
						numError = true;
					}//end of number format exception.	
				}//end while loop
				
			
			//catch block for the case of file not being found.
			}catch(FileNotFoundException e) {
				System.out.println("*File does not exist or path was entered incorrectly.*");
				System.out.println("Please try again.");
				System.out.println();
				running = true;
			
			}
			//final condition to meet to print statement and writing to a new file.
			if(dateError == false && numError == false)
			{
				System.out.println("Calculating Speed Difference");
				System.out.println("Calculating Speed Average");
				writeData(userInput);
				running = false;
			}
				
		}while(running); // condition remains running till user enter a correct file.
		
		scnr.close();
		
	}//end of main

}
