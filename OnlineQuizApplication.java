import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question 
{
    private String questionText;
    private String[] options;
    private int correctAnswer;

    public Question(String questionText, String[] options, int correctAnswer) 
    {
        this.questionText = questionText;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestionText() 
    {
        return questionText;
    }

    public String[] getOptions() 
    {
        return options;
    }

    public int getCorrectAnswer() 
    {
        return correctAnswer;
    }

    public boolean isCorrect(int userAnswer) 
    {
        return userAnswer == correctAnswer;
    }
}

class Quiz 
{
    private List<Question> questions;
    private int score;

    public Quiz() 
    {
        questions = new ArrayList<>();
        score = 0;
    }

    public void addQuestion(Question question) 
    {
        questions.add(question);
    }

    public void start() 
    {
        Scanner scanner = new Scanner(System.in);
        
        for (int i = 0; i < questions.size(); i++) 
        {
            Question q = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + q.getQuestionText());

            String[] options = q.getOptions();
            for (int j = 0; j < options.length; j++) 
            {
                System.out.println((j + 1) + ". " + options[j]);
            }

            int userAnswer = 0;
            while (true) 
            {
                System.out.print("Your answer (1-" + options.length + "): ");
                if (scanner.hasNextInt()) 
                {
                    userAnswer = scanner.nextInt();
                    if (userAnswer >= 1 && userAnswer <= options.length) 
                    {
                        break;
                    } else 
                    {
                        System.out.println("Please enter a number between 1 and " + options.length + ".");
                    }
                } else 
                {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.next();
                }
            }

            if (q.isCorrect(userAnswer)) 
            {
                System.out.println("Correct!");
                score++;
            } else 
            {
                System.out.println("Wrong. The correct answer was " + q.getOptions()[q.getCorrectAnswer() - 1]);
            }
            System.out.println();
        }

        System.out.println("Quiz Over!");
        System.out.println("Your score: " + score + "/" + questions.size());
        scanner.close();
    }
}

public class OnlineQuizApplication 
{
    public static void main(String[] args) 
    {
        Quiz quiz = new Quiz();

        quiz.addQuestion(new Question("Which keyword is used for accessing the features of a package?", 
                new String[]{"package", "import", "extends", "export"}, 2));
        quiz.addQuestion(new Question("Which of the following is not a Java features?", 
                new String[]{"Dynamic", "Architecture Neutral", "Use of pointers", "Object-oriented"}, 3));
        quiz.addQuestion(new Question(" What is the return type of the hashCode() method in the Object class?", 
                new String[]{"int", "object", "long", "void"}, 1));

        quiz.start();
    }
}
