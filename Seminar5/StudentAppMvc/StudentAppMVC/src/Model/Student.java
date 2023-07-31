package Model;

public class Student extends Person implements Comparable<Student> {
    private Long studId;

    public Student(String firstName, String secondName, int age, Long id) {
        super(firstName, secondName, age);
        this.studId = id;
    }

    public Student(String firstName, int age, Long id) {
        super(firstName, age);
        this.studId = id;
    }

    public Long getId() {
        return studId;
    }

    public void setId(Long id) {
        this.studId = id;
    }

    @Override
    public String toString() {
        return "Student [firstName=" + super.getFirstName() + ", secondName=" + super.getSecondName() + ", age="
                + super.getAge() + ", id=" + studId + "]";
    }

    @Override
    public int compareTo(Student o) {
        System.out.println(super.getFirstName() + " - " + o.getFirstName());
        if (super.getAge() == o.getAge()) {
            if (this.studId == o.studId) {
                return 0;
            }
            if (this.studId < o.studId) {
                return -1;
            }
            return 1;
        }
        if (super.getAge() < o.getAge()) {
            return -1;
        }
        return 1;
    }
}
