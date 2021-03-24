package day13;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuizApp {
public static void main(String[] args) {
	
	ArrayList<Questions> questions = QuestionsOperations.createQuestions();
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Enter the number of questions between 1 to " + questions.size() + " to be displayed....");
	int numberOfQuestions = scan.nextInt();
	
	AnswerOperations answerOperations = new AnswerOperations(questions.size());
	
	Timer countDownTimer = new Timer(numberOfQuestions, 5);
	
	ExecutorService es = Executors.newFixedThreadPool(1);
	
	es.execute(()->{
		System.out.println("You have " + countDownTimer.getCountDownTime() + " s\n");
		System.out.println("Your time starts now....\n");
		
		try {
			countDownTimer.CoundownInvoke();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Oooopss.....You ran out of time");
		System.out.println();
		System.out.println("Your Score is : " + answerOperations.computeScore());
		
		System.exit(1);
		
	});
	
	QuestionsOperations.displayQuestions(numberOfQuestions, questions, answerOperations);
	
	System.out.println("Your Score is : " + answerOperations.computeScore());
	
	System.exit(1);
	
}
}
class Timer{
	int countdown;
	public Timer(int numberOfQuestions, int timePerQuestions) {
		// TODO Auto-generated constructor stub
		this.countdown = numberOfQuestions*timePerQuestions;
		
	}
	
	public void CoundownInvoke() throws Exception {
	 while(countdown  > 0) {
		 Thread.sleep(1000);
		 countdown--;
	 }
	}
	
	public int getCountDownTime() {
		 return countdown;
	 }
}

class QuestionsOperations{
	
	public static ArrayList<Questions> createQuestions() {
		ArrayList<Questions> questions = new ArrayList<Questions>();
		
		String options[] = {"op 1", "op 2", "op 3", "op 4"};
		
		questions.add(new ScienceQuestions(1,  3, "This is q1", options ));
		questions.add(new ScienceQuestions(2,  1, "This is q2", options ));
		questions.add(new ScienceQuestions(3,  3, "This is q3", options ));
		questions.add(new ScienceQuestions(4,  2, "This is q4", options ));
		questions.add(new ScienceQuestions(5,  1, "This is q5", options ));
		questions.add(new ScienceQuestions(6,  4, "This is q6", options ));
		
		return questions;
	}
	
	public static void displayQuestions(int numberOfQuestions, ArrayList<Questions> questions, AnswerOperations answerOperations) {
		
		Scanner scan = new Scanner(System.in);
		
		while(numberOfQuestions-- > 0) {
		
			int index = (int) ( questions.size()* Math.random());
			
			if(answerOperations.isQuestionAtIndexAsked(index)) {
				numberOfQuestions++;
				continue;
			}
			
			Questions currentQuestion = questions.get(index);
			currentQuestion.displayQuestionAndOptions();
			
			System.out.println("Please enter your option: ");
			System.out.println();
			int answerGiven = scan.nextInt();
			
			answerOperations.storeAnswer(answerGiven, currentQuestion.getRightOption());
			answerOperations.setQuestionAtIndex(index);
		}
	}
}

class AnswerOperations{
	
	HashMap<Integer , Integer> givenAnswerandCorrectAnswer = new HashMap<Integer, Integer>();
	int numberOfQuestions;
	ArrayList<Boolean> questionsAsked = new ArrayList<Boolean>();
	
	public AnswerOperations(int numberOfQuestions) {
		// TODO Auto-generated constructor stub
		this.numberOfQuestions = numberOfQuestions;
		
		while(numberOfQuestions-->0)
			questionsAsked.add(false);
	}
	
	public void storeAnswer(int answerGiven, int correctAnswer) {
		givenAnswerandCorrectAnswer.put(answerGiven, correctAnswer);
	}
	
	public int computeScore() {
		int score = 0;
		
		for(Map.Entry m : givenAnswerandCorrectAnswer.entrySet()) {
			if(m.getKey() == m.getValue())
				score++;
		}
		
		return score;
	}
	public void setQuestionAtIndex(int i) {
		questionsAsked.set(i, true);
	}
	
	public boolean isQuestionAtIndexAsked(int i) {
		return questionsAsked.get(i);
	}
}

interface Questions{
	public void displayQuestionAndOptions();
	public int getQuestionId();
	public int getRightOption();
}

class ScienceQuestions implements Questions{
	int questionId;
	String[] options;
	int rightOption;
	String question;
	
	public ScienceQuestions(int questionId, int rightOptions, String question, String options[]) {
		// TODO Auto-generated constructor stub
		this.questionId = questionId;
		this.options = options;
		this.rightOption = rightOptions;
		this.question = question;
	}
	
	public void displayQuestionAndOptions() {
		System.out.println(question + "\n");
		
		int i = 1;
		for(String o : options)
			System.out.println( i++ + ") " + o);
		
		System.out.println();
	}
	
	public int getQuestionId() {
		return questionId;
	}
	
	public int getRightOption() {
		return rightOption;
	}
}



