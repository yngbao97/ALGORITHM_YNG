package Java_Study;

public class Person {
	
	private String name;
	private int birth;
	
	public Person(String name, int birth) {
		this.name = name;
		this.birth = birth;
	}
	
	public int hashCode() {
		return name.length()*birth;
	}
	
	public boolean equals(Object o) {
		Person p = (Person) o;
		return p.name.equals(name);
	}
	
}
