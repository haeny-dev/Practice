package basic.copy;

import java.util.ArrayList;
import java.util.List;

public class People implements Cloneable{

    private String name;
    private List<People> friends = new ArrayList<>();

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFriend(People friend) {
        friends.add(new People(friend.getName()));
    }

    public List<People> getFriends() {
        return friends;
    }

    public void setFriends(List<People> friends) {
        this.friends = friends;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
