import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Student {
	String name;
	int gook;
	int su;
	int young;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getGook() {
		return gook;
	}
	public void setGook(int gook) {
		this.gook = gook;
	}
	public int getSu() {
		return su;
	}
	public void setSu(int su) {
		this.su = su;
	}
	public int getYoung() {
		return young;
	}
	public void setYoung(int young) {
		this.young = young;
	}
	
	public Student() { }
	public Student(String name, int gook, int young, int su) {
		this.name = name;
		this.gook = gook;
		this.su = su;
		this.young = young;
	}
	
}


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		List<Student> list = new ArrayList<>();
		for(int i=0; i<n; i++) {
			list.add(new Student(sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		list.sort(Comparator.comparing(Student::getGook, Comparator.reverseOrder()).thenComparing(Student::getYoung).thenComparing(Student::getSu, Comparator.reverseOrder()).thenComparing(Student::getName));
		for(Student s : list) {
			System.out.println(s.getName());
		}

		
	}
}
