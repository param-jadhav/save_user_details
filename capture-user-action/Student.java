package pack2;

/* subclass Student extending the Person class */
public class Student {
	Student() {
		// invoke or call parent class constructor
		super();

		System.out.println("Student class Constructor");
	}
}

/* Driver program to test */
class Test {
	public static void main(String[] args) {
		Student s = new Student();
	}
}
