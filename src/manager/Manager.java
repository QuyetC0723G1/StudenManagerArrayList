package manager;

import model.Student;

import java.util.ArrayList;

public class Manager implements IManager<Student> {
    ArrayList<Student> listStudent;

    public Manager() {
        listStudent = new ArrayList<>();
    }

    @Override
    public void add(Student student) {
        listStudent.add(student);
    }

    @Override
    public void remove(int id) {
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId() == id) {
                listStudent.remove(i);
                System.out.println("====== Remove successfully =======");
                return;
            }
        }

    }

    @Override
    public void edit(int id, Student student) {
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId() == id) {
                listStudent.set(i, student);
            }
        }

    }

    @Override
    public ArrayList<Student> findAll() {
        return listStudent;
    }


    public Student maxAvgStudent() {
        Student studentMax = new Student();
        double max = listStudent.get(0).getAvg();
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getAvg() > max) {
                max = listStudent.get(i).getAvg();
                studentMax = listStudent.get(i);
            }
        }
        System.out.println(" Student has MaxAvg in class is : " + "\n" + studentMax + " , AvgScore : " + (double)Math.round(max*100)/100);
        return studentMax;
    }


    @Override
    public void findByID(int id) {
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId() == id) {
                System.out.println("\nSearch Result : ");
                System.out.println(listStudent.get(i));
                return;
            }
        }
        System.out.println("====== not found ======");
    }

    public Student findByIdToInfo(int id) {
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId() == id) {
                System.out.println("Result : ");
                return listStudent.get(i);
            }
        }
        return null;
    }

    public void getStudentByName(String name) {
        ArrayList<Student> students = new ArrayList<>();
        for (Student value : listStudent) {
            if (value.getName().toLowerCase().contains(name.toLowerCase())) {
                students.add(value);
            }
        }
        if (students.isEmpty()) {
            System.out.println("This student could not be found");
        } else {
            System.out.println("Search Results : ");
            for (Student student : students) {
                System.out.println(student);
            }

        }
    }


}
