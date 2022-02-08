package CH04_TreesAndGraphs.BuildOrder;

// You are given a list of projects and a list of dependencies (which is a list of pairs of projects, where the
// second project is dependent on the first project). All of a project's dependencies must be built before the
// project is. Find a build order that will allow the projects to be built. If there is no valid build order,
// return an error.
// EXAMPLE
// Input:
//     projects: a, b, c, d, e, f
//     dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
// Output: f, e, a, b, d, c
// Hints: #26, #47, #60, #85, #125, #133

public class BuildOrderTest {
    public static void main(String[] args) {
        // String[] projects = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j"};
        // String[][] dependencies = {
        //         {"a", "b"},
        //         {"b", "c"},
        //         {"a", "c"},
        //         {"d", "e"},
        //         {"b", "d"},
        //         {"e", "f"},
        //         {"a", "f"},
        //         {"h", "i"},
        //         {"h", "j"},
        //         {"i", "j"},
        //         {"g", "j"}
        // };

        String[] projects = {"a", "b", "c", "d", "e", "f"};
        String[][] dependencies = {
                {"a", "d"},
                {"f", "b"},
                {"b", "d"},
                {"f", "a"},
                {"d", "c"}//,
                //{"a", "f"}
        };

        String[] buildOrder = BuilderOrder_v1.buildOrder(projects, dependencies);
        for (String s :buildOrder) {
            System.out.println(s);
        }

        System.out.println();
        String[] buildOrder2 = BuilderOrder_v2.buildOrder(projects, dependencies);
        for (String s :buildOrder2) {
            System.out.println(s);
        }
    }
}
