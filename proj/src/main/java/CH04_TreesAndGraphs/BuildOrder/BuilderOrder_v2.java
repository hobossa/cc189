package CH04_TreesAndGraphs.BuildOrder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class BuilderOrder_v2 {
    private static class Project {
        // class from https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2004.%20Trees%20and%20Graphs/Q4_07_Build_Order/DFS/Project.java
        public enum State {COMPLETE, PARTIAL, BLANK}

        ;
        private ArrayList<Project> children = new ArrayList<>();
        // in my opinion the above children is unnecessary. this map is enough
        private HashMap<String, Project> map = new HashMap<>();
        private String name;
        private State state = State.BLANK;

        public Project(String name) {
            this.name = name;
        }

        public ArrayList<Project> getChildren() {
            return children;
        }

        public String getName() {
            return name;
        }

        public State getState() {
            return state;
        }

        public void setState(State state) {
            this.state = state;
        }

        public void addNeighbor(Project node) {
            if (!map.containsKey(node.getName())) {
                children.add(node);
                map.put(node.getName(), node);
            }
        }
    }

    private static class Graph {
        // class from https://github.com/careercup/CtCI-6th-Edition/blob/master/Java/Ch%2004.%20Trees%20and%20Graphs/Q4_07_Build_Order/DFS/Graph.java
        private ArrayList<Project> nodes = new ArrayList<>();
        private HashMap<String, Project> map = new HashMap<>();

        public void createNode(String name) {
            assert (!map.containsKey(name));
            Project node = new Project(name);
            nodes.add(node);
            map.put(name, node);
        }

        private Project getNode(String name) {
            assert (map.containsKey(name));
            return map.get(name);
        }

        public void addEdge(String startName, String endName) {
            Project start = getNode(startName);
            Project end = getNode(endName);
            start.addNeighbor(end);
        }

        public ArrayList<Project> getNodes() {
            return nodes;
        }
    }

    public static boolean doDFS(Project proj, Stack<Project> stack) {
        if (proj.state == Project.State.PARTIAL) {
            return false;   // this node is visited, there is a circle.
        }

        if (proj.state == Project.State.BLANK) {
            // go for children.
            proj.setState(Project.State.PARTIAL);   // this step is very important to prevent circle
            for (Project child : proj.getChildren()) {
                if (!doDFS(child, stack)) {
                    return false;
                }
            }
            // all children done
            proj.state = Project.State.COMPLETE;
            stack.push(proj);
        }

        return true;
    }

    public static String[] buildOrder(String[] projects, String[][] dependencies) {
        String[] ret = new String[projects.length];

        // build a graph
        Graph graph = new Graph();
        //
        for (String proj : projects) {
            graph.createNode(proj);
        }

        for (String[] dependency : dependencies) {
            graph.addEdge(dependency[0], dependency[1]);
        }

        Stack<Project> stack = new Stack<>();
        for (Project proj : graph.getNodes()) {
            if (proj.getState() == Project.State.BLANK) {
                if (!doDFS(proj, stack)) {
                    ret[0] = "error: there is no valid build order.";
                    return ret;
                }
            }
        }

        int i = 0;
        while (!stack.isEmpty()) {
            ret[i++] = stack.pop().getName();
        }

        return ret;
    }
}
