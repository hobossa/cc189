package CH09_SystemDesignAndScalability.SocialNetwork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class SocialNetwork_v1 {
    public static LinkedList<Person> findPathBFS(HashMap<Integer, Person> people, int source, int destination) {
        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));

        while (!sourceData.isFinished() && !destData.isFinished()) {
            // Search out from source
            Person collision = searchLevel(people, sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }
            // search out from destination
            collision = searchLevel(people, destData, sourceData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }
        }
        return null;
    }


    // search one level and return collision, if any
    private static Person searchLevel(HashMap<Integer, Person> people, BFSData bfs1, BFSData bfs2) {
        // we only want to search one level at a time. Count how many nodes are currently in  the primary's
        // level and only to that many nodes. We'll continue to add nodes to the end
        int count = bfs1.toVisit.size();
        for (int i = 0; i < count; i++) {
            // Pull out first node
            PathNode pathNode = bfs1.toVisit.poll();
            int personId = pathNode.getPerson().getID();
            // check if it's already been visited
            if (bfs2.visited.containsKey(personId)) {
                return pathNode.getPerson();
            }

            // add friends to queue
            Person person = pathNode.getPerson();
            ArrayList<Integer> friends = person.getFriends();
            for (int friendId : friends) {
                if (!bfs1.visited.containsKey(friendId)) {
                    Person friend = people.get(friendId);
                    PathNode next = new PathNode(friend, pathNode);
                    bfs1.visited.put(friendId, next);
                    bfs1.toVisit.add(next);
                }
            }
        }
        return null;
    }

    private static LinkedList<Person> mergePaths(BFSData sourceData, BFSData destData, int id) {
        PathNode end1 = sourceData.visited.get(id); // end1 -> source
        PathNode end2 = destData.visited.get(id);   // end2 -> destination
        LinkedList<Person> path1 = end1.collapse(false);
        LinkedList<Person> path2 = end2.collapse(true); // reverse
        path2.removeFirst();    // remove connection
        path1.addAll(path2);
        return path1;
    }
}
