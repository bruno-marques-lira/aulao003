package entities;

public class Employee {
	
	// Properties Employee Class
	private Integer id;
	private String name;
	private Double salary;
	
	// Constructor Class Employee
	public Employee() {
	}

	// Constructor Using Fields Class Employee
	public Employee(Integer id, String name, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	// Getter and Setter Employee Class
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public void increaseSalary(Double percentage) {
		salary += salary * percentage / 100.0;
	}
	
	@Override
	public String toString() {
		return id + ", " + name + ", " + String.format("%.2f", salary);
	}
}
