package ArrayStackQueue;

public class HanoiStack {
    public static void process(int N, String from, String help, String to) {
        if (N == 1) {
            System.out.println("move 1 from " + from + " to " + to);
        } else {
            process(N - 1, from, to, help);
            System.out.println("move " + N + " from " + from + " to " + to);
            process(N - 1, help, from, to);
        }
    }

    public static void main(String[] args) {
        process(3, "左", "中", "右");
    }
}
