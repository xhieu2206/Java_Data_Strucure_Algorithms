package funix.assignment;

public class Person {

    private String id;
    private String name;
    private String birthPlace;
    private String dob;

    public Person(String id, String name, String birthPlace, String dob) {
        this.id = id;
        this.name = name;
        this.birthPlace = birthPlace;
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + birthPlace + " | " + dob;
    }
}
