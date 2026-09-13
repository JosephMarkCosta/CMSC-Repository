/* 
 * Class: CMSC203
 * Instructor: Dr. Huseyin Aygun
 * Description: The Implementation of Assignment 1. 
 *              It is a grade calculator and only contains one class.
 * Due: 09/14/2026
 * Platform/Compiler - Eclipse IDE
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student
 * Name and Signature: Joseph Mark Costa
 */

import java.io.*;
import java.util.Scanner;

public class GradeCalculator {

	public static void main(String[] args) throws IOException{
		
		System.out.println("=========================================================");
		System.out.println("CMSC203 Project 1 Implementation - Grade Calculator");
		System.out.println("=========================================================\n");
		
		System.out.println("Loading Configuration from Provided Configuration File...");
		
		// This file object represents the grade configuration file.
		// It's presence is validated in the if-else statements below
		File file = new File("gradeconfig.txt");
		
		// This PrintWriter object opens a file called "grades_report.txt" and prints all information there.
		// It is closed before the program finishes.
		PrintWriter out = new PrintWriter("grades_report.txt");
		
		String courseName;
		int courses;
		String category1;		
		int category1Weight;
		String category2;		
		int category2Weight;
		String category3;		
		int category3Weight;
		String configType;
		
		/*
		 * This if-else statement is used to determine which configuration to use.
		 * If the file doesn't exist, use the default configuration and alert user;
		 * If file does exist, read values and check if the weights add up to 100. If they don't, use default configuration.
		 * Else just use the file provided.
		 * Type of Configuration used is printed in grades_report.txt
		 */
		System.out.println("Validating Configuration File...");
		
		if(!file.exists()) {	
			 courseName = "CMSC203 Computer Science I";
			 courses = 3;
			 category1 = "Projects";		
			 category1Weight = 40;
			 category2 = "Quizzes";		
			 category2Weight = 30;
			 category3 = "Exams";		
			 category3Weight = 30;
			 configType = "Default Configuration Was Used. The Provided Config File was Missing";
			System.out.println("WARNING - Configuration File Missing - Default Config was Used\n");
		}else {	
			try(Scanner configFile = new Scanner(file)){
					 courseName = configFile.nextLine();
					 courses = configFile.nextInt();
					 category1 = configFile.next();		
					 category1Weight = configFile.nextInt();
					 category2 = configFile.next();		
					 category2Weight = configFile.nextInt();
					 category3 = configFile.next();		
					 category3Weight = configFile.nextInt();
				 }	 
			 if((category1Weight + category2Weight + category3Weight) != 100) {
				 courseName = "CMSC203 Computer Science I";
				 courses = 3;
				 category1 = "Projects";		
				 category1Weight = 40;
				 category2 = "Quizzes";		
				 category2Weight = 30;
				 category3 = "Exams";		
				 category3Weight = 30;
				 configType = "Default Configuration Was Used. The Provided Config File was Invalid";
				 System.out.println("WARNING - Configuration File Invalid - Default Config was Used\n");
			 } else {
				 configType = "Configuration is Valid and was Used";
				 System.out.println("Configuration Loaded Successfully\n");
			 }
		}
		
		System.out.println("Using Input File: grades_input.txt");
		System.out.println("Using Output File: grades_report.txt");
		
		
		out.println(courseName);

		
		System.out.println("\nReading Student Scores...");
		// This file represents the student grades.
		// It is validated to check if the category name matches.
		// If it doesn't, it skips that category in grade calculation.
		File file2 = new File("grades_input.txt");
		Scanner inputFile = new Scanner(file2);
		
		String firstName = inputFile.nextLine();
		String lastName = inputFile.nextLine();
		
		out.println(firstName + " " + lastName);
		
		System.out.println("\n" + firstName + " " + lastName);
		System.out.println("Course: " + courseName);
		
		// These double values represent the student's calculated scores.
		// One for standard average, the other for weighted.
		// They are initialized as zero as default if the category is skipped.
		double category1Score = 0,
			   category2Score = 0,
			   category3Score = 0,
			   category1Weighted = 0,
			   category2Weighted = 0,
			   category3Weighted = 0;
		
		// This big for-loop in combination with the switch statement and another for-loop does the following - 
		// 1. It stores the category name and uses that to check whether the categories match.
		// 2. If it does, it stores the # of scores to sum, else category is skipped.
		// 3. The smaller for-loop calculates the sum needed for the average.
		// 4. Switch statement is used to determine which weight to use to calculate weighted scores
		// 5. Repeat for all categories.
		System.out.println("\nCategory Results: ");
		for(int i = 0; i < courses; i++) {
			String categoryName = inputFile.nextLine();
			int numOfScores;
			double sum = 0;		
			int caseNum = 0;
			if(categoryName.equals(category1)) {
				numOfScores = inputFile.nextInt();
				caseNum = 1;
			}else if(categoryName.equals(category2)) {
				numOfScores = inputFile.nextInt();
				caseNum = 2;
			}else if(categoryName.equals(category3)) {
				numOfScores = inputFile.nextInt();
				caseNum = 3;
			}else {
				numOfScores = 0;
				inputFile.nextLine();
				inputFile.nextLine();
				out.println("Category Skipped Due to Error. Average and Weighted Score are Both 0.0");
				System.out.println("Category Skipped Due to Error: Score is 0.0");
				continue;
			}
			for(int j = 0; j < numOfScores; j++) {
				sum += inputFile.nextDouble();
			}
			double average = sum / numOfScores;
			switch(caseNum) {
			case 1:
				category1Score = average;
				category1Weighted = category1Score * ((double)category1Weight/100);
				out.printf("%s (%d%%): Average = %.2f Weighted = %.2f\n", categoryName, category1Weight, average, category1Weighted);
				System.out.printf("%s (%d%%): Average = %.2f Weighted = %.2f\n", categoryName, category1Weight, average, category1Weighted);
				break;
			case 2:
				category2Score = average;
				category2Weighted = category2Score * ((double)category2Weight/100);
				out.printf("%s (%d%%): Average = %.2f Weighted = %.2f\n", categoryName, category2Weight, average, category2Weighted);
				System.out.printf("%s (%d%%): Average = %.2f Weighted = %.2f\n", categoryName, category2Weight, average, category2Weighted);
				break;
			case 3: 
				category3Score = average;
				category3Weighted = category3Score * ((double)category3Weight/100);
				out.printf("%s (%d%%): Average = %.2f Weighted = %.2f\n", categoryName, category3Weight, average, category3Weighted);
				System.out.printf("%s (%d%%): Average = %.2f Weighted = %.2f\n", categoryName, category3Weight, average, category3Weighted);
				break;
			default: 
				average = 0;
				break;
			}
			inputFile.nextLine();
		}
		System.out.println();
		
		
		// This code prompts the user to enter whether or not they want +/- Grading.
		// If invalid answer is entered, the loop asks for input again.
		// If input is valid, stores the users answer and uses that to calculate the Letter Grade.
		char plusMinusGrade = ' ';
		Scanner scan = new Scanner(System.in);
		char applyPlusMinus = 'F';
		while(applyPlusMinus != 'Y' && applyPlusMinus != 'N') {
			System.out.println("Apply +/- grading? (Y/N)");
			applyPlusMinus = scan.nextLine().toUpperCase().charAt(0);
		}
		scan.close();
		
		
		// Calculates overall average using weighted scores
		double overallAverage = category1Weighted + category2Weighted + category3Weighted;
		out.printf("Overall Numeric Average: %.2f\n", overallAverage);
		System.out.printf("\nOverall Numeric Average: %.2f\n", overallAverage);
		
		// Letter Grade
		// The following if-else statement is used to calculate the letter grade using the overall average.
		char grade = 'F';
		
		if(overallAverage >= 90.00) {
			grade = 'A';
		}else if(overallAverage >= 80.00 && overallAverage < 90.00) {
			grade = 'B';
		}else if(overallAverage >= 70.00 && overallAverage < 80.00) {
			grade = 'C';
		}else if(overallAverage >= 60.00 && overallAverage < 70.00) {
			grade = 'D';
		} else{
			grade = 'F';
		} 
		
		out.println("Base Letter Grade: " + grade);
		System.out.println("Base Letter Grade: " + grade);
		
		
		
		// If the user wants +/- grades, uses this if-else statement to generate final letter grade
		if(applyPlusMinus == 'Y') {
			if(overallAverage <= 100.00 && overallAverage >= 98.00) {
				plusMinusGrade = '+';
			} else if(overallAverage <= 92.00 && overallAverage >= 90.00) {
				plusMinusGrade = '-';
			} else if(overallAverage < 90.00 && overallAverage >= 88.00) {
				plusMinusGrade = '+';
			} else if(overallAverage <= 82.00 && overallAverage >= 80.00) {
				plusMinusGrade = '-';
			} else if(overallAverage < 80.00 && overallAverage >= 78.00) {
				plusMinusGrade = '+';
			} else if(overallAverage <= 72.00 && overallAverage >= 70.00) {
				plusMinusGrade = '-';
			} else if(overallAverage < 70.00 && overallAverage >= 68.00) {
				plusMinusGrade = '+';
			} else if(overallAverage <= 62.00 && overallAverage >= 60.00) {
				plusMinusGrade = '-';
			}
			out.println("Final Letter Grade: " + grade + plusMinusGrade);
			System.out.println("Final Letter Grade: " + grade + plusMinusGrade);
		}
		
		out.println(configType);
		
		
		
		System.out.println("\nSummary Written To grades_report.txt");
		System.out.println("Program Has Finished!");
		out.close();
		inputFile.close();
	}

}
