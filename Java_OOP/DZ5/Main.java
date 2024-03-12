package DZ5;

//— Создать класс УчебнаяГруппа, содержащий в себе поля Преподаватель и список Студентов;
//— Создать класс УчебнаяГруппаСервис, в котором реализована функция
//(входные параметры - (Teacher, List<Strudent>)) формирования из Студентов и Преподавателя УчебнойГруппы и возвращения его;
//— Создать метод в Контроллере, в котором агрегируются функции получения списка студентов (их id)
//и преподавателя (его id) и формирования учебной группы, путём вызова метода из сервиса;

import java.util.List;
import java.util.ArrayList;

class Teacher{
    private int teacherId;
    private String name;

    public Teacher(int teacherId, String name) {
        this.teacherId = teacherId;
        this.name = name;
    }
    public int getTeacherId() {
        return teacherId;
    }
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class Student{
    private int studentId;
    private String name;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }
    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
class StudyGroup{
    private Teacher teacher;
    private List<Student> students;

    public StudyGroup(Teacher teacher, List<Student> students) {
        this.teacher = teacher;
        this.students = students;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
    public List<Student> getStudents() {
        return students;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
class StudyGroupService{
    public StudyGroup formStudyGroup(Teacher teacher,List<Student> students){
        return new StudyGroup(teacher, students);
    }
}
class Controller{
    private StudyGroupService studyGroupService;
    public Controller(StudyGroupService studyGroupService){
        this.studyGroupService = studyGroupService;
    }
    public StudyGroup aggregateAndFormGroup(Teacher teacher, List<Student> students){
        return studyGroupService.formStudyGroup(teacher, students);
    }
}
public class Main {
    public static void main(String[] args) {
        Teacher teacher = new Teacher(1, "Петр Петрович");
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(101, "Иван"));
        students.add(new Student(102, "Сергей"));
        students.add(new Student(103, "Игорь"));

        StudyGroupService studyGroupService = new StudyGroupService();
        Controller controller = new Controller(new StudyGroupService());
        StudyGroup studyGroup = controller.aggregateAndFormGroup(teacher, students);

        printStudyGroupInfo(studyGroup);
    }
    private static void printStudyGroupInfo(StudyGroup studyGroup){
        System.out.println("Учебная Группа:");
        System.out.println("Учитель: " + studyGroup.getTeacher().getName());
        System.out.println("Ученики: " );
        for (Student student : studyGroup.getStudents()) {
            System.out.println(student.getName());
        }
    }
}