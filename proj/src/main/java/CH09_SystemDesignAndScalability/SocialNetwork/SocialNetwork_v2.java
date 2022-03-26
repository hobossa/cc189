package CH09_SystemDesignAndScalability.SocialNetwork;


// When we deal with a service the size of LinkedIn or Facebook, we cannot possibly keep all of our data on one
// machine. That means that our simple Person data structure from SocialNetwork_v1 doesn't quite work -- our
// friends may not live on the same machine as we do. Instead, we can replace our list of friends with a list of
// their IDs, and traverse as follows
// 1. For each friend ID: int machine index = getMachineIDForUser( person ID);
// 2. Go to machine #machine_index
// 3. On that machine, do: Person friend = getPersonWi th ID( person_id);

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class SocialNetwork_v2 {

    public static LinkedList<Person> findPathBFS(Server server, int source, int destination) {
        BFSData sourceData = new BFSData(server.getPersonWithID(source));
        BFSData destData = new BFSData(server.getPersonWithID(destination));

        while (!sourceData.isFinished() && !destData.isFinished()) {
            // Search out from source
            Person collision = searchLevel(server, sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }
            // search out from destination
            collision = searchLevel(server, destData, sourceData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.getID());
            }
        }
        return null;

    }

    // search one level and return collision, if any
    private static Person searchLevel(Server server, BFSData bfs1, BFSData bfs2) {
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
                    Person friend = server.getPersonWithID(friendId);
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
