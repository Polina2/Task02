package ru.vsu.cs.aisd.g92.lyigina_p_s;

public class Student {
    private String fio;
    private int course;

    public Student(String fio, int course) {
        this.fio = fio;
        this.setCourse(course);
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        if (course >= 1 && course <= 6)
            this.course = course;
    }

    @Override
    public String toString() {
        if (course == 0)
            return "";
        return fio + ' ' + course;
    }

    public static Student toStudent(String str) {
        if (str.length() == 0)
            return new Student("", 0);
        String name = str.substring(0, str.lastIndexOf(' '));
        int course = Integer.parseInt(str.substring(str.lastIndexOf(' ')+1));
        return new Student(name, course);
    }
}
