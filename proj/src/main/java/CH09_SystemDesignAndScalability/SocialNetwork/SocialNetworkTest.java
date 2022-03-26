package CH09_SystemDesignAndScalability.SocialNetwork;

// Social Network: How would you design the data structures for a very large social network like Facebook
// or Linked In? Describe how you would design an algorithm to show the shortest path between two people
// (e.g., Me -> Bob -> Susan -> Jason -> You).
// Hints: #270, #285, #304, #321

import java.util.HashMap;
import java.util.LinkedList;

public class SocialNetworkTest {
    public static void main(String[] args) {
        int nPeople = 11;
        Server server = new Server();
        server.addMachine(3);
        HashMap<Integer, Person> people = new HashMap<Integer, Person>();
        for (int i = 0; i < nPeople; i++) {
            Person p = new Person(i);
            people.put(i, p);
            server.addPerson(i, p);
        }


        int[][] edges = {{1, 4}, {1, 2}, {1, 3}, {3, 2}, {4, 6}, {3, 7}, {6, 9}, {9, 10}, {5, 10}, {2, 5}, {3, 7}};
        for (int[] edge : edges) {
            Person source = people.get(edge[0]);
            source.addFriend(edge[1]);

            Person destination = people.get(edge[1]);
            destination.addFriend(edge[0]);
        }

        for (int i = 0; i < nPeople; i++) {
            for (int j = 0; j < nPeople; j++) {
                LinkedList<Person> path1 = SocialNetwork_v1.findPathBFS(people, i, j);
                LinkedList<Person> path2 = SocialNetwork_v2.findPathBFS(server, i, j);
                System.out.println("path "+ i + " to " + j);
                printPeople(path1);
                printPeople(path2);
            }
        }
    }

    private static void printPeople(LinkedList<Person> path) {
        if (path == null) {
            System.out.println("No path");
        } else {
            for (Person p : path) {
                System.out.print(p.getID() + " ");
            }
            System.out.println();
        }
    }
}
