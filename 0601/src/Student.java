public class Student {
    private String name;
    public int age;
    public Student() {

    }
    private Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    private void function(String ss) {

    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
