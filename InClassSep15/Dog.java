public class Dog {
	private String name;
	private String breed;
	private int age;
	
	public static int noDogs;
	
	public void setName(String name) {
		if (name.equals("")) {
			this.name="Dog";
		}
		else {
			this.name=name;
		}
	}
	public String getName() {
		return this.name;
	}
	public void setBreed(String breed) {
		if (breed.equals("")) {
			this.breed="Mix";
		}
		else {
			this.breed=breed;
		}
		
	}
	public String getBreed() {
		return this.breed;
	}
	public void setAge(int age) {
		if (age < 0 || age >20) {
			this.age=-1; 
		}
		else {
			this.age=age;
		}
	}
	public int getAge() {
		return this.age;
	}
	
	
	public Dog() {
		noDogs++;
		this.setName("");
		this.setAge(1);
		this.setBreed("");
		
	}
	
	public Dog(String name, String breed, int age) {
		this.name = name;
		this.breed = breed;
		this.age = age;
		noDogs++;
	}
	
	public void show() {
		System.out.printf("Name: %s\nBreed: %s\nAge: %s\n", this.name, this.breed, this.age);
	}
	public static void showDogs() {
		System.out.printf("NoDogs: %d\n", noDogs);
	}
}
