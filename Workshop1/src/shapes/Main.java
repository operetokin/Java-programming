package shapes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		double min_p = Double.MAX_VALUE;
		double max_p = 0.0;
		int n = 0;
		
		File file = new File("ws1_shapes.txt");
		Shapes[] array = new Shapes[100];
		System.out.println("------->JAC 444 Assignment 1<-------\r\n" + 
				"------->Task 1 ... <-------\n");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String s;
			int i = 0;

			while ((s = br.readLine()) != null) {
				String[] tokens = s.split(",");
				switch (tokens[0]) {

				case "Circle":  if(Double.parseDouble(tokens[1]) >= 0 && tokens.length == 2) {
					array[i] = new Circle(Double.parseDouble(tokens[1]));
				
					if(array[i].perimeter() > max_p)
						max_p = array[i].perimeter();
				}
				else {
					System.out.println("Invalid Circle!");
					i--;
				}
				break;

				case "Square":  if(Double.parseDouble(tokens[1]) >= 0 && tokens.length == 2) 
					array[i] = new Square(Double.parseDouble(tokens[1]));
				else {
					System.out.println("Invalid Square!");  
					i--;
				}
				break;

				case "Rectangle":  if(Double.parseDouble(tokens[1]) >= 0 && Double.parseDouble(tokens[2]) >= 0 && tokens.length == 3)
					array[i] = new Rectangle(Double.parseDouble(tokens[1]),Double.parseDouble(tokens[2]));
				else
				{
					System.out.println("Invalid Rectangle!"); 
					i--;
				}
				break;

				case "Parallelogram":  
					if(Double.parseDouble(tokens[1]) >= 0 && Double.parseDouble(tokens[2]) >= 0 && tokens.length == 3)						
						array[i] = new Parallelogram(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
					else
					{
						System.out.println("Invalid Parrallelogram!"); 
						i--;
					}
					break;

				case "Triangle": 
					
					double a = Double.parseDouble(tokens[1]);
					double b = Double.parseDouble(tokens[2]);
					double c = Double.parseDouble(tokens[3]);
					try {
						array[i] = new Triangle(a, b, c);
						if(array[i].perimeter() < min_p)
							min_p = array[i].perimeter();
					} catch (TriangleException e) {
						System.out.println(e.getMessage());
						i--;
					}
					break;

				default: System.out.println("Invalid shape!");
				i--;
				break;        
				}

				i++;
				n = i;
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("\n" + n + " shapes were created:\n");

		for (int i = 0; i < n; i++) {
			System.out.println(array[i].toString() + "\n");
		}

		System.out.println("\n------->Task 2 ... <-------\n");
		System.out.println("Maximum circle perimeter = " + max_p);
		System.out.println("\nMinimum triangle perimeter = " + min_p);

		int k=0;

		for (int i = 0; i < n; i++) {
			//array[i].perimeter() == min_p;
			//array[i].perimeter()==max_p;
			//Double.valueOf(array[i].perimeter()).equals(Double.valueOf(min_p));
			if(array[i] instanceof Triangle && Double.valueOf(array[i].perimeter()).equals(Double.valueOf(min_p))) //to dangerous to use == for doubles
				System.out.println("\nTriangle with Minimum perimeter is removed\n");
			else if((array[i] instanceof Circle) &&  Double.valueOf(array[i].perimeter()).equals(Double.valueOf(max_p)))
				System.out.println("\nCircle with Maximum perimeter is removed\n\n");
			else {
				array[k] = array[i];
				k++;
			}

		}

		double total_parall = 0;
		double total_triang = 0;

		for (int i = 0; i < k; i++) {
			System.out.println(array[i].toString() + "\n");
			if(array[i] instanceof Triangle)
				total_triang +=array[i].perimeter();
			else if(array[i].getClass() == Parallelogram.class)
				total_parall +=array[i].perimeter();
		}

		System.out.println("\n------->Task 3 ... <-------");
		System.out.println("\nTotal perimeter of Parallelogram is: " + total_parall);
		System.out.println("\nTotal perimeter of Triangle is: " + total_triang);
	     
	}

}
