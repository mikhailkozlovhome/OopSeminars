package Controller;

import View.View;

import java.util.List;
import java.util.ArrayList;

import Model.ModelList;
import Model.Student;

public class Controller {
    private iGetModel model;
    private iGetView view;
    private List<Student> students = new ArrayList<Student>();

    public Controller(iGetModel model, iGetView view) {
        this.model = model;
        this.view = view;
    }

    private boolean testData() {
        if (students.size() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public void update() {
        //MVP
        students = model.getAllStudents();
        if (testData()) {
            view.printAllStudents(students);
        } else {
            System.out.println("Список студентов пуст!");
        }

        //MVC
        // view.printAllStudents(model.getAllStudents());

    }
    
    public void run()
    {
        Command com = Command.NONE;
        boolean getNewIteration = true;
        while(getNewIteration)
        {
            String command = view.prompt("Введите команду:");
            com = Command.valueOf(command.toUpperCase());
            switch(com)
            {
                case EXIT:
                    getNewIteration=false;
                    System.out.println("Выход из программы!");
                    break;
                case LIST:
                    view.printAllStudents(model.getAllStudents());
                    break;
            }

        }
    }

}
