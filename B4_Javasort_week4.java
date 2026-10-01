import java.io.*;
import java.util.*;

public class B4_Javasort_week4 {

    static class Student {
        double cgpa;
        String name;
        int id;

        Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        double getCgpa() {
            return cgpa;
        }

        String getName() {
            return name;
        }

        int getId() {
            return id;
        }
    }

    static class StudentComparator implements Comparator<Student> {
        @Override
        public int compare(Student x, Student y) {
            if (x.getCgpa() != y.getCgpa()) {
                return Double.compare(y.getCgpa(), x.getCgpa());
            }

            int nameCompare = x.getName().compareTo(y.getName());
            if (nameCompare != 0) {
                return nameCompare;
            }

            return Integer.compare(x.getId(), y.getId());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        if (!scan.hasNextInt()) return;
        int testCases = scan.nextInt();

        List<Student> studentList = new ArrayList<>();

        while (testCases-- > 0) {
            int id = scan.nextInt();
            String fname = scan.next();
            double cgpa = scan.nextDouble();

            Student st = new Student(id, fname, cgpa);
            studentList.add(st);
        }

        Collections.sort(studentList, new StudentComparator());

        for (Student st : studentList) {
            System.out.println(st.getName());
        }

        scan.close();
    }
}