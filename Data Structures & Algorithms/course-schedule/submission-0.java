class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // map of course to all prerequesites
        Map<Integer, List<Integer>> map = new HashMap<>();
        // set containing all courses on current dfs path
        Set<Integer> visiting = new HashSet<>();

        // start by creating a new ArrayList for each course
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new ArrayList<>());
        }

        // initialize each course's ArrayList with prereq
        for (int[] prereq : prerequisites) {
            map.get(prereq[0]).add(prereq[1]); 
        }

        for (int c = 0; c < numCourses; c++) {
            if (!dfs(c, visiting, map)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, Set<Integer> visiting, Map<Integer, List<Integer>> map) {
        // if there is a cycle
        if (visiting.contains(course)) {
            return false;
        }
        
        // if no prereqs, can take course
        if (map.get(course).isEmpty()) {
            return true;
        }

        // mark course as visited
        visiting.add(course);

        // for every prereq, see if can take
        // if there's a prereq that can't be taken, cannot take course
        for (int prereq : map.get(course)) {
            if (!dfs(prereq, visiting, map)) {
                return false;
            }
        }

        // at this point, know course can be taken

        // remove course from path
        visiting.remove(course);

        // map course to empty ArrayList so don't have to iterate through
        // prereqs again
        map.put(course, new ArrayList<>());
        return true;
    }
}
