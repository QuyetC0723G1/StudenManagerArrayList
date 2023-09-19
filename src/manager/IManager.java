package manager;

import model.Student;

import java.util.ArrayList;

public interface IManager<E> {
    void add(E e);
    void remove(int id);
    void edit(int id,E e);
    ArrayList<E> findAll();

    void findByID(int id);

}
