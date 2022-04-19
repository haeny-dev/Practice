package copy;

public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        People people1 = new People("people1");
        People people2 = people1;
        People people3 = (People) people1.clone();

        System.out.println("people1.getName() = " + people1.getName());
        System.out.println("people2.getName() = " + people2.getName());
        System.out.println("people3.getName() = " + people3.getName());

        people2.setName("people2");
        people3.setName("people3");

        System.out.println("people1.getName() = " + people1.getName());
        System.out.println("people2.getName() = " + people2.getName());
        System.out.println("people3.getName() = " + people3.getName());

        people1.getFriends().add(new People("friend1"));
        people1.getFriends().add(new People("friend2"));
        people1.getFriends().add(new People("friend3"));

        people1.getFriends().forEach(f -> System.out.println(f.getName()));
        people3.getFriends().forEach(f -> System.out.println(f.getName()));

        System.out.println(people1.getFriends());
        System.out.println(people3.getFriends());
    }
}
