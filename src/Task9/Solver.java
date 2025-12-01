package Task9;

import java.util.List;

public class Solver {
    public static void solve(List<Integer> lst) {
        for (int i = 0; i < lst.size() / 2; i++) {
            int tmp = lst.get(i);
            lst.set(i, lst.get(lst.size() - 1 - i));
            lst.set(lst.size() - 1 - i, tmp);
        }
    }
}
