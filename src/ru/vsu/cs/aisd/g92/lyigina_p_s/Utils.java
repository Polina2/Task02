package ru.vsu.cs.aisd.g92.lyigina_p_s;

import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.JTableUtils;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Objects;

public class Utils {
    public static MyLinkedList<Student> fileToList(String fileName) {
        MyLinkedList<Student> students = new MyLinkedList<>();
        try {
            String[] strs = ArrayUtils.readLinesFromFile(fileName);
            for (String str : strs) {
                students.addLast(Student.toStudent(str));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void listToTable(MyLinkedList<Student> list, JTable table) {
        String[][] array = new String[list.getSize()][1];
        int i = 0;
        for (Student s : list) {
            array[i][0] = s.toString();
            i++;
        }
        JTableUtils.writeArrayToJTable(table, array);
    }

    public static MyLinkedList<Student> tableToList(JTable table) {
        MyLinkedList<Student> list = new MyLinkedList<>();
        String[][] stringArray = Objects.requireNonNull(JTableUtils.readStringMatrixFromJTable(table));
        for (String[] s : stringArray) {
            list.addLast(Student.toStudent(s[0]));
        }
        return list;
    }

    public static void listToFile(MyLinkedList<Student> list, String fileName) {
        try {
            PrintWriter out = new PrintWriter(fileName);
            for (Student s : list) {
                out.println(s.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static MyLinkedList<Student> solution(MyLinkedList<Student> students) {
        MyLinkedList<Student>[] courses = new MyLinkedList[6];
        for (int i = 0; i < 6; i++)
            courses[i] = new MyLinkedList<>();
        for (Student student : students) {
            courses[student.getCourse()-1].addLast(student);
        }
        MyLinkedList<Student> ans = new MyLinkedList<>();
        for (MyLinkedList<Student> course : courses) {
            if (!course.isEmpty()) {
                for (Student student : course) {
                    ans.addLast(student);
                }
            }
        }
        return ans;
    }
}
