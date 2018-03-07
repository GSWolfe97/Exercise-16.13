/*
 *  Program:    Exercise 16.13
 *  Date:       3/4/18
 *  Developer:  Garrett Wolfe
 *  Purpose:    (Compare loans with various interest rates) Rewrite Programming Exercise 5.21  
 *              to create a GUI, as shown in Figure 16.41b. Your program should let the user   
 *              enter the loan amount and loan period in the number of years from text fields, 
 *              and it should display the monthly and total payments for each interest rate    
 *              starting from 5 percent to 8 percent, with increments of one-eighth, in a text 
 *              area.  
 */
package exercise.pkg16_13;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Pos;

public class Exercise16_13 extends Application{
    protected TextField tfLoanAmount = new TextField();
    protected TextField tfNumberOfYears = new TextField();
    protected TextArea textArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
	tfNumberOfYears.setPrefColumnCount(2);
	tfLoanAmount.setPrefColumnCount(7);
	textArea.setPrefColumnCount(30);
	Button btShowTable = new Button("Show Table");
	HBox paneForControls = new HBox(10);
	paneForControls.setAlignment(Pos.CENTER);
	paneForControls.getChildren().addAll(new Label("Loan Amount"), tfLoanAmount, new Label("Number of Years"), tfNumberOfYears, btShowTable);
	BorderPane pane = new BorderPane();
	pane.setTop(paneForControls);
	pane.setCenter(textArea);
	btShowTable.setOnAction(e -> {
            print();
	});
	Scene scene = new Scene(pane);
	primaryStage.setTitle("Loan Calculator");
	primaryStage.setScene(scene);
	primaryStage.show();
    }
    private void print() {
	String output = "";
	double monthlyInterestRate;
	double monthlyPayment;		
	output += "Interest Rate       Monthly Payment          Total Payment\n";		
	for (double i = 5.0; i <= 8; i += 0.125) {
            monthlyInterestRate = i / 1200;
            monthlyPayment = Double.parseDouble(tfLoanAmount.getText()) * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, Double.parseDouble(tfNumberOfYears.getText()) * 12));
            output += String.format("%-24.3f%-34.2f%-8.2f\n", i, monthlyPayment, (monthlyPayment * 12) * Double.parseDouble(tfNumberOfYears.getText()));
	}
    textArea.setText(output);
    }
    public static void main(String[] args) {
        Application.launch(args);
    } 
}
