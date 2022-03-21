package ru.vsu.cs.aisd.g92.lyigina_p_s;

import ru.vsu.cs.util.ArrayUtils;

import java.io.FileNotFoundException;

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
}
