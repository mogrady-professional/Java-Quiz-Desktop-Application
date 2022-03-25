package javaQuiz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

// Action listener -> 
public class Quiz implements ActionListener {

//	Data Structure for Quiz Questions
	String[] questions = { "What is a correct syntax to output \"Hello World\" in Java?", // Question 1
			"Java is short for \"JavaScript\".", // Question 2
			"How do you insert COMMENTS in Java code?", // Question 3
			"Which data type is used to create a variable that should store text?", // Question 4
			"How do you create a variable with the numeric value 5?", // Question 5
			"How do you create a variable with the floating number 2.8?", // Question 6
			"Which method can be used to find the length of a string?", // Question 7
			"Which operator is used to add together two values?", // Question 8
			"The value of a string variable can be surrounded by single quotes.", // Question 9
			"Which method can be used to return a string in upper case letters?", // Question 10
			"Which operator can be used to compare two values?", // Question 11
			"To declare an array in Java, define the variable type with:", // Question 12
			"Array indexes start with:", // Question 13
			"How do you create a method in Java?", // Question 14
			"How do you call a method in Java?", // Question 15
			"Which keyword is used to create a class in Java?", // Question 16
			"What is the correct way to create an object called myObj of MyClass?", // Question 17
			"In Java, it is possible to inherit attributes and methods from one class to another.", // Question 18
			"Which method can be used to find the highest value of x and y?", // Question 19
			"Which operator is used to multiply numbers?", // Question 20
			"Which keyword is used to import a package from the Java API library?", // Question 21
			"How do you start writing an if statement in Java?", // Question 22
			"How do you start writing a while loop in Java?", // Question 23
			"Which keyword is used to return a value inside a method?", // Question 24
			"Which statement is used to stop a loop?", // Question 25

	};

//		2D Array of Arrays -> 1) Options of Options 
	String[][] options = {
			{ " print (\"Hello World\");", " Console.WriteLine(\"Hello World\");", " echo(\"Hello World\");", " System.out.println(\"Hello World\");" }, // Question 1
			{ "False", "True", "Sometimes", "Possibly" }, // Question 2
			{ " // This is a comment", " /* This is a comment", " # This is a comment", "> This is a comment" }, // Question 3
			{"string", "String", "Txt", "myString"}, // Question 4
			{" num x = 5", " int x = 5;", " float x = 5;", " x = 5;"}, // Question 5
			{" byte x = 2.8f", " x = 2.8f;", " float x = 2.8f;", " int x = 2.8f;"}, // Question 6
			{" length()", " len()", " getSize()", " getLength()"  }, // Question 7
			{" The + sign", " The * sign", " The & sign", " The x sign"}, // Question 8
			{"True", "False", "Maybe", "Pass"}, // Question 9
			{" tuc()", " upperCase()", " toUpperCase()", " touppercase()"  }, // Question 10
			{" ><", "=", "==", "<>"}, // Question 11
			{"{}", "[]", "()", "<>"}, // Question 12
			{"0", "1", "2", "3"}, // Question 13
			{" methodName()", " (methodName)", " methodName[]", " methodName." }, // Question 14
			{" (methodName);", " methodName;", " methodName[];", " methodName();"}, // Question 15
			{" MyClass", " className", "class", "class()" }, // Question 16
			{" new myObj = MyClass();", " class MyClass = new myObj();", " class myObj = new MyClass();", " MyClass myObj = new MyClass();" }, // Question 17
			{"True", "False", "Maybe", "Pass"}, // Question 18
			{" Math.max(x,y)", " Math.maximum(x,y)", " Math.maxNum(x,y)" , " Math.largest(x,y)"}, // Question 19
			{"*", "%", "#", "x"}, // Question 20
			{" import", "package", "lib", "gitlib"}, // Question 21
			{" if x > y then:", " if (x > y)", " if x > y:", " if< w + 1>" }, // Question 22
			{" x > y while {", " while (x > y)", " while x > y:", " while x > y {" }, // Question 23
			{"return", "void", "get", "break"}, // Question 24
			{"break", "stop", "exit", "return"}, // Question 25

	};

//	Array to hold all Connect Answers
	char[] answers = {

			'D', // Answer 1
			'B', // Answer 2
			'A', // Answer 3
			'B', // Answer 4
			'B', // Answer 5
			'C', // Answer 6
			'A', // Answer 7
			'A', // Answer 8
			'B', // Answer 9
			'C', // Answer 10
			'C', // Answer 11
			'B', // Answer 12
			'A', // Answer 13
			'A', // Answer 14
			'D', // Answer 15
			'C', // Answer 16
			'D', // Answer 17
			'A', // Answer 18
			'A', // Answer 19
			'A', // Answer 20
			'A', // Answer 21
			'B', // Answer 22
			'B', // Answer 23
			'A', // Answer 24
			'A', // Answer 25

	};
	
//	Declare/Assign
	char guess; // Hold guess
	char answer; // Hold answer
	int index; // index
	int correct_guesses = 0; 
	int total_questions = questions.length;
	int result; // hold result
	int seconds = 10; // timer
	
//	GUI Components
	JFrame frame = new JFrame();
//	Hold Current Question
			
	
	
	

//	Constructor
	public Quiz() {

	}

//	Method to move to next qustion
	public void nextQuestion() {

	}

//	Method Button Clicking
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

//	Method for Display answer
	public void displayAnswer() {

	}

//	Method for Final Results
	public void results() {

	}
}
