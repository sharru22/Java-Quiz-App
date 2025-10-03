import java.util.*;

class Question {
    private String question;
    private List<String> options;
    private int correctOption;

    public Question(String question, List<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }

    public void displayQuestion() {
        System.out.println(question);
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
    }

    public boolean checkAnswer(int answer) {
        return answer == correctOption;
    }

    public String getCorrectAnswer() {
        return options.get(correctOption - 1);
    }

    public String getOption(int optionNumber) {
        if(optionNumber >= 1 && optionNumber <= options.size()) {
            return options.get(optionNumber - 1);
        }
        return "Invalid Option";
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Question> questions = new ArrayList<>();
        questions.add(new Question(
            "What are Java loops?",
            Arrays.asList("Control structures to repeat code", "Data types", "Classes", "Exceptions"),
            1
        ));
        questions.add(new Question(
            "What is enhanced for-loop?",
            Arrays.asList("Traditional for loop", "For-each loop", "While loop", "Do-while loop"),
            2
        ));
        questions.add(new Question(
            "How do you handle multiple user inputs?",
            Arrays.asList("Using Scanner", "Using If", "Using Map", "Using Array"),
            1
        ));
        questions.add(new Question(
            "How is a switch-case different from if-else?",
            Arrays.asList("Switch is faster", "Switch only works with integers and enums", "If-else cannot compare strings", "Switch cannot be nested"),
            2
        ));
        questions.add(new Question(
            "What are collections in Java?",
            Arrays.asList("Data structures like List, Set, Map", "Primitive types", "Operators", "Exceptions"),
            1
        ));
        questions.add(new Question(
            "What is ArrayList?",
            Arrays.asList("A resizable array", "A fixed array", "A type of exception", "A primitive data type"),
            1
        ));
        questions.add(new Question(
            "How to iterate using iterators?",
            Arrays.asList("Using for loop", "Using while loop with iterator.hasNext()", "Using switch", "Using if-else"),
            2
        ));
        questions.add(new Question(
            "What is a Map?",
            Arrays.asList("Key-Value data structure", "Array", "Loop type", "Class"),
            1
        ));
        questions.add(new Question(
            "How to sort a list?",
            Arrays.asList("Collections.sort(list)", "list.sort()", "Both A and B", "None of the above"),
            3
        ));
        questions.add(new Question(
            "How to shuffle elements?",
            Arrays.asList("Collections.shuffle(list)", "list.shuffle()", "Randomize(list)", "None"),
            1
        ));

        int score = 0;
        Map<Question, Integer> userAnswers = new LinkedHashMap<>();

        System.out.println("Welcome to Java Quiz App!");
        System.out.println("-------------------------");

        for (int i = 0; i < questions.size(); i++) {
            System.out.println("\nQuestion " + (i + 1) + ":");
            questions.get(i).displayQuestion();
            System.out.print("Enter your answer (1-4): ");
            int answer = scanner.nextInt();

            userAnswers.put(questions.get(i), answer);

            if (questions.get(i).checkAnswer(answer)) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect!");
            }
        }

        System.out.println("\nQuiz Finished!");
        System.out.println("Your total score: " + score + "/" + questions.size());

        System.out.println("\nDetailed Results:");
        int qNo = 1;
        for (Question q : questions) {
            int userAnswer = userAnswers.get(q);
            String status = q.checkAnswer(userAnswer) ? "Correct" : "Incorrect";
            System.out.println("\nQuestion " + qNo + ": " + q.getOption(userAnswer) + " --> " + status);
            System.out.println("Correct Answer: " + q.getCorrectAnswer());
            qNo++;
        }

        scanner.close();
    }
}

