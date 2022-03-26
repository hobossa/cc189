package CH09_SystemDesignAndScalability.SocialNetwork;

import java.util.ArrayList;

public class Person {
    private ArrayList<Integer> friends = new ArrayList<>();
    private int ID;
    private String info;

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<Integer> getFriends() {
        return friends;
    }

    public int getID() {
        return ID;
    }

    public void addFriend(int id) {
        friends.add(id);
    }

    public Person(int personID) {
        this.ID = personID;
    }
}
