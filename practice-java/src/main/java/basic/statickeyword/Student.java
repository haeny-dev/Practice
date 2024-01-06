package basic.statickeyword;

public class Student extends Human{

    public static int count;
    private String name;

    public Student(String name) {
        this.name = name;
        addCount();
    }

    private void addCount() {
        count++;
    }

    public static void main(String[] args) {
        Student student1 = new Student("홍길동");
        Student student2 = new Student("아무개");
        Student student3 = new Student("이판서");

        System.out.println("전체 학생 수는 " + Student.count + "명 입니다.");
    }
}
