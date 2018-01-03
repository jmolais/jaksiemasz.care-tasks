import com.google.gson.Gson;

public class Person implements Comparable<Person> {
    final Name name;
    private final String email;
    private final Sex sex;
    private final Country countryOfOrigin;

    Person() {
        this.name = new Name("N/A", "N/A");
        this.email = "N/A";
        this.countryOfOrigin = new Country("N/A");
        this.sex = Sex.UNDISCLOSED;
    }

    Person(String name, String surname, String email, Country country, Sex sex) {
        this.name = new Name(
                Name.validateName(name),
                Name.validateName(surname)
        );
        this.email = Email.validateEmail(email);
        this.countryOfOrigin = country;
        this.sex = sex;
    }

    Person (Name name, String email,  Country country, Sex sex) {
        this.name = name;
        this.email = Email.validateEmail(email);
        this.countryOfOrigin = country;
        this.sex = sex;
    }

    public Name getName() {
        return name;
    }

    public String getFirstName() {
        return name.getFirstName();
    }

    public String getSurname() {
        return name.getSurname();
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @Override
    public int compareTo(Person o) {
        int nameCompared = name.getFirstName().compareTo(o.name.getFirstName());
        int surnameCompared = name.getSurname().compareTo(o.name.getSurname());
        if (nameCompared == 0) {
            return name.getSurname().compareTo(o.name.getSurname());
        } else if (surnameCompared == 0) {
            return email.compareTo(o.email);
        } else {
            return nameCompared;
        }
    }
}
