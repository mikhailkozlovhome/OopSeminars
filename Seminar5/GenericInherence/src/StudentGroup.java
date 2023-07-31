

import java.util.Iterator;
import java.util.List;

public class StudentGroup<T extends Comparable<T>, V extends Comparable<V>> implements Iterable<Student<T, V>>, Comparable<StudentGroup<T, V>> {
    private List<Student<T, V>> students;
    private T groupNumber;
    private V grpId;

    public StudentGroup(List<Student<T, V>> students, T groupNumber, V grpId) {
        this.students = students;
        this.groupNumber = groupNumber;
        this.grpId = grpId;
    }

    public StudentGroup(List<Student<T, V>> students, T groupNumber) {
        this.students = students;
        this.groupNumber = groupNumber;
    }

    public StudentGroup(List<Student<T, V>> students) {
        this.students = students;
    }

    public List<Student<T, V>> getStudents() {
        return students;
    }

    public void setStudents(List<Student<T, V>> students) {
        this.students = students;
    }

    // @Override
    // public Iterator<Student> iterator() {
    // return new StudentGroupIterator(students);
    // }

    @Override
    public Iterator<Student<T, V>> iterator() {
        return new Iterator<Student<T, V>>() {
            private int counter;

            @Override
            public boolean hasNext() {
                return counter < students.size();
            }

            @Override
            public Student<T, V> next() {
                if (!hasNext()) {
                    return null;
                }
                return students.get(counter++);
            }

        };

    }

    public T getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(T groupNumber) {
        this.groupNumber = groupNumber;
    }
    /**
     * Т.к. имплементирован интерфейс Comparable, для того чтобы можно было
     * использовать сортировку класса StudentSteams по группам, переопределяем метод compareTo.
     */
    @Override
    public int compareTo(StudentGroup<T, V> o) {
        if (this.students.size() == o.students.size()) {
            if (this.grpId == o.grpId) {
                return 0;
            }
            if (this.grpId.compareTo(o.grpId) < 0) {
                return -1;
            }
            return 1;
        }
        if (this.students.size() < o.students.size()) {
            return -1;
        }
        return 1;
    }

    public V getGrpId() {
        return grpId;
    }

    public void setGrpId(V grpId) {
        this.grpId = grpId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Group Id: ");
        sb.append(this.grpId);
        sb.append("; Group number: ");
        sb.append(this.groupNumber);
        sb.append("; Number of students: ");
        sb.append(this.students.size());
        sb.append("\n");
        for (Student<T, V> stud : this) {
            sb.append(stud);
            sb.append("\n");
        }
        return sb.toString();
    }
}
