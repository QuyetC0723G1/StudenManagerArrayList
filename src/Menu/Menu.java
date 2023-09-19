package Menu;

import manager.Manager;
import model.Student;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    Manager manager = new Manager();
    Scanner inputNumber = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);

    public void showMainMenu() {


        addTest();
        int choice;
        do {
            try {
                System.out.println("\n======== Menu =========");
                System.out.println("1 : Add new Student");
                System.out.println("2 : Remove Student");
                System.out.println("3 : Update Student");
                System.out.println("4 : Find Student by ID");
                System.out.println("5 : List Student Find By Name ");
                System.out.println("6 : The best score avg of Student ");
                System.out.println("7 : List Student");
                System.out.println("8 : Exit");
                System.out.println("Enter your choice : ");
                choice = inputNumber.nextInt();
                switch (choice) {
                    case 1:
                        showAdd();
                        break;
                    case 2:
                        showDelete();
                        break;
                    case 3:
                        showUpdate();
                        break;
                    case 4:
                        showFindID();
                        break;
                    case 5:
                        showFindName();
                        break;
                    case 6:
                        showMaxAvg();
                        break;
                    case 7:
                        showAll();
                        break;
                    case 8:
                        System.exit(0);
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("vui long nhap lai");
                inputNumber.nextLine();
            }

        } while (true);
    }
    public void showAdd() {
        Student newstudent = new Student();
        System.out.println("========= Menu add new Student ========");
        System.out.println("Enter Student name : ");
        String name = inputString.nextLine();
        newstudent.setName(name);
        System.out.println("Enter Student gender : ");
        String gender = inputString.nextLine();
        newstudent.setGender(gender);
        for (int i = 0; i < 3; i++) {
            switch (i) {
                case 0:
                    System.out.println("Math Score : ");
                    break;
                case 1:
                    System.out.println("Literature Score : ");
                    break;
                case 2:
                    System.out.println("English Score : ");
                    break;
            }
            double score = inputNumber.nextDouble();
            newstudent.getScore()[i] = score;
        }
        manager.add(newstudent);
        System.out.println("====== Student added successfully ======");
    }

    public void showUpdate() {
        System.out.println("Enter the id Student : ");
        int id = inputNumber.nextInt();
        if (manager.findByIdToInfo(id) == null) {
            System.out.println("======= Not Found =======");
        } else {
            Student studentEdit = new Student();
            System.out.println("Enter Student name : ");
            String name = inputString.nextLine();
            studentEdit.setName(name);
            System.out.println("Enter Student gender : ");
            String gender = inputString.nextLine();
            studentEdit.setGender(gender);
            for (int i = 0; i < 3; i++) {
                switch (i) {
                    case 0:
                        System.out.println("Math Score : ");
                        break;
                    case 1:
                        System.out.println("Literature Score : ");
                        break;
                    case 2:
                        System.out.println("English Score : ");
                        break;
                }
                double score = inputNumber.nextDouble();
                studentEdit.getScore()[i] = score;
            }
            manager.edit(id, studentEdit);
            System.out.println("======= Update has completed ========");
        }
    }

    public void showDelete() {
        System.out.println("Enter the id Student : ");
        int id = inputNumber.nextInt();
        manager.remove(id);
    }

    public void showFindID() {
        System.out.println("Enter the id Student : ");
        int id = inputNumber.nextInt();
        manager.findByID(id);
    }

    public void showFindName() {
        System.out.println("Enter the name Student : ");
        String name = inputString.nextLine();
        manager.getStudentByName(name);
    }

    public void showMaxAvg() {
        manager.maxAvgStudent();
    }

    public void showAll() {
        System.out.println("List Student is : ");
        ArrayList<Student> list = manager.findAll();
        for (Student student : list) {
            System.out.println(student);
        }
    }
    public void addTest(){
        Student student1 = new Student("Quyet","Nam",new double[]{8,8,8});
        Student student2 = new Student("Trang","Nu",new double[]{7,7,7});
        Student student3 = new Student("Minh","Nu",new double[]{9,9,8});
        manager.add(student1);
        manager.add(student2);
        manager.add(student3);
    }

}
