import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.Optional;

public class StudentProcess extends Student {

	public StudentProcess(String firstName, String lastName, double grade, String department) {
		super(firstName, lastName, grade, department);
	}

	public static void main(String[] args) {
		Student[] students = {
				new Student("Jack", "Smith", 50.0, "IT"),
				new Student("Aaron", "Johnson", 76.0, "IT"),
				new Student("Maaria", "White", 35.8, "Business"),
				new Student("John", "White", 47.0, "Media"),
				new Student("Laney", "White", 62.0, "IT"),
				new Student("Jack", "Jones", 32.9, "Business"),
				new Student("Wesley", "Jones", 42.89, "Media")};
	
	List<Student> list = Arrays.asList(students);
		
	//Task1
	System.out.println("Task 1:\n");
	System.out.println("Complete Student list:");
	list.forEach((Student) -> System.out.println(Student.toString()));
	
	
	//Task2
	System.out.println("\nTask 2:\n");
	System.out.println("Students who got 50.0-100.0 sorted by grade:");
	list.stream()
		.filter((Student) -> Student.getGrade() >= 50)
		.sorted((student_1, student_2) -> (Double.compare(student_1.getGrade(), student_2.getGrade())))
		.forEach((Student) -> System.out.println(Student.toString()));
	
	//Task3
	System.out.println("\nTask 3:\n");
	System.out.println("First Student who got 50.0-100.0:");
	System.out.println(list.stream()
		.filter((Student) -> Student.getGrade() >= 50)
		.findFirst().orElse(null).toString());
		
	//Task4
	System.out.println("\nTask 4:\n");
	System.out.println("Students in ascending order by last name then first:");
	
	list.stream()
		.sorted(Comparator.comparing(Student::getLastName)
		.thenComparing(Comparator.comparing(Student::getFirstName)))
		.forEach((Student) -> System.out.println(Student.toString()));
	
	System.out.println("\nStudents in descending order by last name then first:");
	list.stream()
		.sorted(Comparator.comparing(Student::getLastName)
		.thenComparing(Comparator.comparing(Student::getFirstName))
		.reversed())
		.forEach((Student) -> System.out.println(Student.toString()));
	
	//Task5
	System.out.println("\nTask 5:\n");
	System.out.println("Unique Student last names:");
	list.stream()
		.map(lastNames -> lastNames.getLastName())
		.distinct()
		.sorted()
		.forEach((lastNames) -> System.out.println(lastNames));
	
	//Task6
	System.out.println("\nTask 6:\n");
	System.out.println("Student names in order by last name then first name:");
	list.stream()
			.sorted(Comparator.comparing(Student::getLastName)
			.thenComparing(Comparator.comparing(Student::getFirstName)))
			.forEach((Student) -> System.out.println(Student.getName()));
	
	//Task7
	System.out.println("\nTask 7:\n");
	System.out.println("Students by department:");
	Map<String, List<Student>> byDept1 = list.stream()
               .collect(Collectors.groupingBy(Student::getDepartment));
	byDept1.forEach((key, value)-> {
		System.out.println("\n " + key);
		value.forEach(System.out::println);
	});
	
	//Task8
	System.out.println("\nTask 8:\n");
	System.out.println("Count of Students by department:\n");
	Map<String, List<Student>> byDept2 = list.stream()
			.collect(Collectors.groupingBy(Student::getDepartment));
	byDept1.forEach((key, value)-> {
		System.out.print(key + " has " + value.size() + " Student(s)");
		System.out.println();
	});
	
	//Task9
	System.out.println("\nTask 9:\n");
	System.out.println("Sum of Students' grades:");
	Double sum = list.stream()
			.mapToDouble(grades -> grades.getGrade())
			.sum();
	System.out.println(sum);
	
	//Task10
	System.out.println("\nTask 10:\n");
	System.out.println("Average of Students' grades:");
	Double average = sum/list.size();
	System.out.printf("%.2f", average);
	
	}
}
