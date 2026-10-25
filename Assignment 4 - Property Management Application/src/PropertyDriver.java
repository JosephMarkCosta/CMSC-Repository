/*
 * Class: CMSC203 23011
 * Instructor: Dr. Huseyin Aygun
 * Description: This is the driver class for the property manager app. It contains the code for JavaFX as well as the console driver.
 * Due: 10/26/2026
 * Platform/compiler: Eclipse IDE for Java
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source. 
 * I have not given my code to another student.
 * Name and Signature: Joseph Mark Costa
 */
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PropertyDriver extends Application{
	
	static ManagementCompany company;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		company = new ManagementCompany("Joseph's Company", "123-456-789", 0);
		
		launch(args);
		
		
		Scanner scan = new Scanner(System.in);
		
		boolean runApplication = true;
		
		do {
			int choice;
			System.out.println(
					"============================================================="
					+ "\nAssignment 4 - Property Manager - Made By Joseph Mark Costa"
					+ "\n============================================================="
					+ "\n1 - Add Property"
					+ "\n2 - Display All Properties"
					+ "\n3 - Show Total Rent"
					+ "\n4 - Exit Program"
					+ "\nEnter Your Choice: "
					);
			choice = scan.nextInt();
			
			switch(choice) {
				case 1: {
					scan.nextLine();
					Property p = new Property();
					System.out.println("Enter Name: ");
					p.setPropertyName(scan.nextLine());
					System.out.println("Enter City: ");
					p.setCity(scan.nextLine());
					System.out.println("Enter Rent Amount: ");
					p.setRentAmount(scan.nextDouble());
					scan.nextLine();
					System.out.println("Enter Owner Name: ");
					p.setOwner(scan.nextLine());
					System.out.println("Property Added at Index: " + company.addProperty(p));
					break;
				}
				case 2: {
					System.out.println("\n" + company.toString() + "\n");
					break;
				}
				case 3: {
					System.out.println("Total Rent of All Properties: $" + company.totalRent());
					break;
				}
				case 4: {
					runApplication = false;
					break;
				}
				default: {
					System.out.println("Invalid Choice. Starting program again.");
					break;
				}
			}
			
		}while(runApplication);
		
		System.out.println("Program has ended.");
		scan.close();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		Button button1 = new Button("Add Property");
		button1.setOnAction(new AddButtonHandler());
		Button button2 = new Button("Display All Properties");
		button2.setOnAction(new DisplayAllPropertiesButtonHandler());
		Button button3 = new Button("Show Total Rent");
		button3.setOnAction(new ShowTotalRentButtonHandler());
		Button button4 = new Button("Exit");
		button4.setOnAction(new ExitButtonHandler());
		
		VBox box = new VBox(20, button1, button2, button3, button4);
		box.setAlignment(Pos.CENTER);
		box.setPadding(new Insets(20));
		primaryStage.setScene(new Scene(box, 400, 200));
		primaryStage.setTitle("Property Manager Application");
		primaryStage.show();
		
	}
	
	class ExitButtonHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			Platform.exit();
		}
	}
	
	class AddButtonHandler implements EventHandler<ActionEvent>{		
		TextField field1, field2, field3, field4;	
		Stage addPropertyStage;
		@Override
		public void handle(ActionEvent event) {
			addPropertyStage = new Stage();
			
			Label label1 = new Label("Name:");
			Label label2 = new Label("City:");
			Label label3 = new Label("Rent:");
			Label label4 = new Label("Owner:");
			
			field1 = new TextField();
			field2 = new TextField();
			field3 = new TextField();
			field4 = new TextField();
			
			Button button = new Button("Enter Property");
			button.setOnAction(new EnterPropertyEventHandler());
			
			HBox hbox1 = new HBox(10, label1, field1);
			HBox hbox2 = new HBox(10, label2, field2);
			HBox hbox3 = new HBox(10, label3, field3);
			HBox hbox4 = new HBox(10, label4, field4);
			HBox hbox5 = new HBox(button);
			
			VBox vbox = new VBox(20, hbox1, hbox2, hbox3, hbox4, hbox5);
			vbox.setPadding(new Insets(20));
			
			Scene scene = new Scene(vbox);
			addPropertyStage.setScene(scene);
			
			addPropertyStage.show();	
		}
		class EnterPropertyEventHandler implements EventHandler<ActionEvent>{
			@Override
			public void handle(ActionEvent arg0) {
				String name = field1.getText();
				String city = field2.getText();
				double rent = Double.parseDouble(field3.getText());
				String owner = field4.getText();
	
				System.out.println("Property Added at Index: " + company.addProperty(new Property(name, city, rent, owner)));
				
				addPropertyStage.close();		
			}			
		}
	}
	
	class DisplayAllPropertiesButtonHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent arg0) {
			String message = company.toString();
			Label label = new Label(message);
			HBox hbox = new HBox(label);
			hbox.setPadding(new Insets(20));
			Scene scene = new Scene(hbox);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		}
	}
	
	class ShowTotalRentButtonHandler implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent event) {
			String message = String.format("Total Rent of All Properties: $%,.2f", company.totalRent());
			Label label = new Label(message);
			HBox hbox = new HBox(label);
			hbox.setPadding(new Insets(20));
			Scene scene = new Scene(hbox);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		}
	}

}
