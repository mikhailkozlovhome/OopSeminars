

public class Student<T extends Comparable<T>, V> extends Person<T, V> implements Comparable<Student<T, V>> {
    private V studId;

    public Student(T firstName, T secondName, V age, V id) {
        super(firstName, secondName, age);
        this.studId = id;
    }

    public Student(T firstName, V age, V id) {
        super(firstName, age);
        this.studId = id;
    }

    public V getId() {
        return studId;
    }

    public void setId(V id) {
        this.studId = id;
    }

    @Override
    public String toString() {
        return "Student [firstName=" + super.getFirstName() + ", secondName=" + super.getSecondName() + ", age="
                + super.getAge() + ", id=" + studId + "]";
    }

    @Override
    public int compareTo(Student<T, V> o) {
        return super.getFirstName().compareTo(o.getFirstName());
        // System.out.println(super.getFirstName() + " - " + o.getFirstName());
        // if (super.getAge() == o.getAge()) {
        //     if (this.studId == o.studId) {
        //         return 0;
        //     }
        //     if (this.studId < o.studId) {
        //         return -1;
        //     }
        //     return 1;
        // }
        // if (super.getAge() < o.getAge()) {
        //     return -1;
        // }
        // return 1;
    }
}
