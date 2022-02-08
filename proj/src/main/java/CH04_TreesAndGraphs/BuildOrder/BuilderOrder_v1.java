package CH04_TreesAndGraphs.BuildOrder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BuilderOrder_v1 {
    private static class Info {
        int dependencies;       // the number of projects that current project depends on.
        HashSet<String> to;     // projects that depend on current proj

        public Info() {
            dependencies = 0;
            to = new HashSet<>();
        }
    }
    public static String[] buildOrder(String[] projects, String[][] dependencies) {
        String[] ret = new String[projects.length];
        HashMap<String, Info> projs = new HashMap<>();
        for (String proj : projects) {
            projs.put(proj, new Info());
        }
        for (String[] dependency : dependencies) {
            if (projs.containsKey(dependency[0]) && projs.containsKey(dependency[1])) {
                projs.get(dependency[0]).to.add(dependency[1]);
                projs.get(dependency[1]).dependencies++;
            } else {
                ret[0] = "error: dependencies contains unknown projects.";
                return ret;
            }
        }
        int i = 0;
        while (!projs.isEmpty()) {
            String temp = null;
            for (String proj : projs.keySet()) {
                if (projs.get(proj).dependencies == 0) {
                    temp = proj;
                    break;
                }
            }
            if (temp == null) {
                ret[0] = "error: there is no valid build order.";
                return ret;
            }
            ret[i++] = temp;
            for (String proj : projs.get(temp).to) {
                projs.get(proj).dependencies--;
            }
            projs.remove(temp);
        }
        return ret;
    }
}
