package hu.nye.progtech;

/**
 * Class to manage DATABASE actions.
 */
public class Lessons {

    private int id;
    private String lesson;
    private int start;
    private int finish;
    private String student;
    private int grade;

    public Lessons(int id, String lesson, int start, int finish, String student, int grade) {
        this.id = id;
        this.lesson = lesson;
        this.start = start;
        this.finish = finish;
        this.student = student;
        this.grade = grade;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Lessons{");
        sb.append("id=").append(id);
        sb.append(", lesson='").append(lesson).append('\'');
        sb.append(", start=").append(start);
        sb.append(", finish=").append(finish);
        sb.append(", student='").append(student).append('\'');
        sb.append(", grade=").append(grade);
        sb.append('}');
        return sb.toString();
    }
}
