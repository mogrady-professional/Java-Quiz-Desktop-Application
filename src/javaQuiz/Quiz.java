package javaQuiz;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener{
// Global Variables
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
			{ " print (\"Hello World\");", " Console.WriteLine(\"Hello World\");", " echo(\"Hello World\");",
					" System.out.println(\"Hello World\");" }, // Question 1
			{ "False", "True", "Sometimes", "Possibly" }, // Question 2
			{ " // This is a comment", " /* This is a comment", " # This is a comment", "> This is a comment" }, // Question
																													// 3
			{ "string", "String", "Txt", "myString" }, // Question 4
			{ " num x = 5", " int x = 5;", " float x = 5;", " x = 5;" }, // Question 5
			{ " byte x = 2.8f", " x = 2.8f;", " float x = 2.8f;", " int x = 2.8f;" }, // Question 6
			{ " length()", " len()", " getSize()", " getLength()" }, // Question 7
			{ " The + sign", " The * sign", " The & sign", " The x sign" }, // Question 8
			{ "True", "False", "Maybe", "Pass" }, // Question 9
			{ " tuc()", " upperCase()", " toUpperCase()", " touppercase()" }, // Question 10
			{ " ><", "=", "==", "<>" }, // Question 11
			{ "{}", "[]", "()", "<>" }, // Question 12
			{ "0", "1", "2", "3" }, // Question 13
			{ " methodName()", " (methodName)", " methodName[]", " methodName." }, // Question 14
			{ " (methodName);", " methodName;", " methodName[];", " methodName();" }, // Question 15
			{ " MyClass", " className", "class", "class()" }, // Question 16
			{ " new myObj = MyClass();", " class MyClass = new myObj();", " class myObj = new MyClass();",
					" MyClass myObj = new MyClass();" }, // Question 17
			{ "True", "False", "Maybe", "Pass" }, // Question 18
			{ " Math.max(x,y)", " Math.maximum(x,y)", " Math.maxNum(x,y)", " Math.largest(x,y)" }, // Question 19
			{ "*", "%", "#", "x" }, // Question 20
			{ " import", "package", "lib", "gitlib" }, // Question 21
			{ " if x > y then:", " if (x > y)", " if x > y:", " if< w + 1>" }, // Question 22
			{ " x > y while {", " while (x > y)", " while x > y:", " while x > y {" }, // Question 23
			{ "return", "void", "get", "break" }, // Question 24
			{ "break", "stop", "exit", "return" }, // Question 25

	};

//	Array to hold all Connect Answers
	char[] answers = {

			'D', // Answer 1
			'A', // Answer 2
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
//	Declare/Assign Variables
	char guess; // Hold guess
	char answer; // Hold answer
	int index; // index
	int correct_guesses = 0;
	int total_questions = questions.length;
	int result; // hold result
	int seconds = 10; // timer
	
//	GUI Components
	JFrame frame = new JFrame();
	JTextField textfield = new JTextField();
	JTextArea textarea = new JTextArea();
//	Buttons
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
//	Labels for Answer	
	JLabel answer_labelA = new JLabel();
	JLabel answer_labelB = new JLabel();
	JLabel answer_labelC = new JLabel();
	JLabel answer_labelD = new JLabel();
//	Timer
	JLabel time_label = new JLabel();
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();
	
//	Timer	
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds<=0) {
				displayAnswer();
			}
			}
		});
	
	public Quiz() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(850,850);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(null);
		frame.setResizable(false);
		 frame.setLocationRelativeTo(null); // Center on Screen
		 
		textfield.setBounds(0,0,850,50);
		textfield.setBackground(new Color(25,25,25));
		textfield.setForeground(new Color(25,255,0));
		textfield.setFont(new Font("Open sans",Font.BOLD,30));
		textfield.setBorder(BorderFactory.createBevelBorder(1));
		textfield.setHorizontalAlignment(JTextField.CENTER);
		textfield.setEditable(false);
		
		textarea.setBounds(0,50,850,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(25,255,0));
		textarea.setFont(new Font("Open sans",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		buttonA.setBounds(0,100,100,100);
		buttonA.setFont(new Font("Open sans",Font.BOLD,35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		buttonB.setBounds(0,200,100,100);
		buttonB.setFont(new Font("Open sans",Font.BOLD,35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");
		
		buttonC.setBounds(0,300,100,100);
		buttonC.setFont(new Font("Open sans",Font.BOLD,35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");
		
		buttonD.setBounds(0,400,100,100);
		buttonD.setFont(new Font("Open sans",Font.BOLD,35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		answer_labelA.setBounds(125,100,500,100);
		answer_labelA.setBackground(new Color(50,50,50));
		answer_labelA.setForeground(new Color(25,255,0));
		answer_labelA.setFont(new Font("Open sans",Font.PLAIN,15));
		
		answer_labelB.setBounds(125,200,500,100);
		answer_labelB.setBackground(new Color(50,50,50));
		answer_labelB.setForeground(new Color(25,255,0));
		answer_labelB.setFont(new Font("Open sans",Font.PLAIN,15));
		
		answer_labelC.setBounds(125,300,500,100);
		answer_labelC.setBackground(new Color(50,50,50));
		answer_labelC.setForeground(new Color(25,255,0));
		answer_labelC.setFont(new Font("Open sans",Font.PLAIN,15));
		
		answer_labelD.setBounds(125,400,500,100);
		answer_labelD.setBackground(new Color(50,50,50));
		answer_labelD.setForeground(new Color(25,255,0));
		answer_labelD.setFont(new Font("Open sans",Font.PLAIN,15));
		
		seconds_left.setBounds(535,510,100,100);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(255,0,0));
		seconds_left.setFont(new Font("Open sans",Font.BOLD,60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		time_label.setBounds(535,475,100,25);
		time_label.setBackground(new Color(50,50,50));
		time_label.setForeground(new Color(255,0,0));
		time_label.setFont(new Font("Open sans",Font.PLAIN,16));
		time_label.setHorizontalAlignment(JTextField.CENTER);
		time_label.setText("timer:");
		
		number_right.setBounds(225,225,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Open sans",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);
		
		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Open sans",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);
		
		frame.add(time_label);
		frame.add(seconds_left);
		frame.add(answer_labelA);
		frame.add(answer_labelB);
		frame.add(answer_labelC);
		frame.add(answer_labelD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(textarea);
		frame.add(textfield);
		frame.setVisible(true);
		
		nextQuestion();
	}
	public void nextQuestion() {
		
		if(index>=total_questions) {
			results();
		}
		else {
			textfield.setText("Question "+(index+1));
			textarea.setText(questions[index]);
			answer_labelA.setText(options[index][0]);
			answer_labelB.setText(options[index][1]);
			answer_labelC.setText(options[index][2]);
			answer_labelD.setText(options[index][3]);
			timer.start();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
			buttonA.setEnabled(false);
			buttonB.setEnabled(false);
			buttonC.setEnabled(false);
			buttonD.setEnabled(false);
			
			if(e.getSource()==buttonA) {
				answer= 'A';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonB) {
				answer= 'B';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonC) {
				answer= 'C';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			if(e.getSource()==buttonD) {
				answer= 'D';
				if(answer == answers[index]) {
					correct_guesses++;
				}
			}
			displayAnswer();
	}
	public void displayAnswer() {
		
		timer.stop();
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] != 'A')
			answer_labelA.setForeground(new Color(255,0,0));
		if(answers[index] != 'B')
			answer_labelB.setForeground(new Color(255,0,0));
		if(answers[index] != 'C')
			answer_labelC.setForeground(new Color(255,0,0));
		if(answers[index] != 'D')
			answer_labelD.setForeground(new Color(255,0,0));
		
		Timer pause = new Timer(2000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				answer_labelA.setForeground(new Color(25,255,0));
				answer_labelB.setForeground(new Color(25,255,0));
				answer_labelC.setForeground(new Color(25,255,0));
				answer_labelD.setForeground(new Color(25,255,0));
				
				answer = ' ';
				seconds=10;
				seconds_left.setText(String.valueOf(seconds));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
	public void results(){
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		result = (int)((correct_guesses/(double)total_questions)*100);
		
		textfield.setText("RESULTS!");
		textarea.setText("");
		answer_labelA.setText("");
		answer_labelB.setText("");
		answer_labelC.setText("");
		answer_labelD.setText("");
		
		number_right.setText("("+correct_guesses+"/"+total_questions+")");
		percentage.setText(result+"%");
		
		frame.add(number_right);
		frame.add(percentage);
		
	}
}