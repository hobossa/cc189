package CH09_SystemDesignAndScalability.Cache;

// Imagine a web server for a simplified search engine. This system has 100 machines to
// respond to search queries, which may then call out using processSearch (string query) to
// another cluster of machines to actually get the result. The machine which responds to a given query
// is chosen at random, so you cannot guarantee that the same machine will always respond to the
// same request. The method processSearch is very expensive. Design a caching mechanism for
// the most recent queries. Be sure to explain how you would update the cache when data changes.
// Hints: #259, #274, #293, #311

public class CacheTest {

    public static void main(String[] args) {
        Cache cache = new Cache();
        for (int i = 0; i < 20; i++) {
            String query = "query" + i;
            cache.insertResults(query, generateResults(i));
            if (i == 9 || i == 16 || i == 19) {
                cache.getResults("query" + 2);
                cache.getResults("query" + 6);
                cache.getResults("query" + 9);
            }
        }

        for (int i = 0; i < 30; i++) {
            String query = "query" + i;
            String[] results = cache.getResults(query);
            System.out.print(query + ": ");
            if (results == null) {
                System.out.print("null");
            } else {
                for (String s : results) {
                    System.out.print(s + ", ");
                }
            }
            System.out.println("");
        }
    }

    private static String[] generateResults(int i) {
        String[] results =  {"resultA" + i, "resultB" + i, "resultC" + i};
        return results;
    }
}
