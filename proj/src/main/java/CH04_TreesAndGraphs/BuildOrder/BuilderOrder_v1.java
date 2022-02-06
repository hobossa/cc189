package CH04_TreesAndGraphs.BuildOrder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class BuilderOrder_v1 {
    private static class Info {
        HashSet<String> from;   // projects that current proj depends on
        HashSet<String> to;     // projects that depend on current proj

        public Info() {
            from = new HashSet<>();
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
                projs.get(dependency[1]).from.add(dependency[0]);
            } else {
                ret[0] = "error: dependencies contains unknown projects.";
                return ret;
            }
        }
        int i = 0;
        while (!projs.isEmpty()) {
            String temp = null;
            for (String proj : projs.keySet()) {
                if (projs.get(proj).from.isEmpty()) {
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
                projs.get(proj).from.remove(temp);
            }
            projs.remove(temp);
        }
        return ret;
    }
}
