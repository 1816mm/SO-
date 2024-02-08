package lab2;


public class HardPoint {
    static boolean[][] knows;
    public int solution;
    public CustomStack stack;

    public HardPoint(int N, boolean[][] knowsData) {
        stack = new CustomStack(knowsData.length);
        knows = knowsData;
        int celebrity = findCelebrity(N);
        if (celebrity != -1) {
            this.solution = celebrity;
        }
    }

    public boolean knows(int person1, int person2) {
        return HardPoint.knows[person1][person2];
    }

    public int findCelebrity(int N) {
        for (int i = 0; i < N; i++) {
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int person1 = stack.pop();
            if (stack.isEmpty()) {
                return person1;
            }
            int person2 = stack.pop();

            if (knows(person1, person2)) {
                stack.push(person2);
            } else {
                stack.push(person1);
            }
        }

        return -1;
    }
}
