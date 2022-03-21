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
}
