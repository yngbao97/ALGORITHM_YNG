package JavaStudy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Test {
	public static void main(String[] args) {
		
		Student s1 = new Student(1, "육예진", 50);
		Student s2 = new Student(2, "육민우", 50);
		Student s3 = new Student(2, "송창용", 50);
		
		Set<Student> hash = new HashSet<>();
		
		hash.add(s1);
		hash.add(s2);
		hash.add(s3);
		System.out.println(hash.toString());
		// 결과: [Student [id=2, name=육민우, score=50], Student [id=1, name=육예진, score=50], Student [id=2, name=송창용, score=50]]
		
		Set<Student> tree = new TreeSet<>();
		
		tree.add(s1);
		tree.add(s2);
		tree.add(s3);
		System.out.println(tree.toString());
		// 결과: [Student [id=1, name=육예진, score=50], Student [id=2, name=육민우, score=50]]
		
	}
}

class Student implements Comparable<Student>{
	int id;
	String name;
	int score;
	
	public Student(int id, String name, int score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return id == other.id && Objects.equals(name, other.name) && score == other.score;
	}

	@Override
	public int compareTo(Student o) {
		int result = Integer.compare(this.score, o.score);
		if (result == 0) {
			result = Integer.compare(this.id, o.id);
		}
		return result;
	}
	
	

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + "]";
	}
}