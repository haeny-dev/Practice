package copy;

import java.time.LocalDateTime;

public class Copy {
    public static void main(String[] args) {
        People people1 = new People("people1");
        People friend1 = new People("friend1");
        people1.getFriends().add(friend1);
        people1.getFriends().forEach(f -> System.out.println(f.getName()));

        friend1.setName("renameFriend1");
        people1.getFriends().forEach(f -> System.out.println(f.getName()));

        People friend2 = new People("friend2");
        people1.addFriend(friend2);
        friend2.setName("renameFriend2");
        people1.getFriends().forEach(f -> System.out.println(f.getName()));
    }
}
