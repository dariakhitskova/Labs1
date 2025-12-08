package Task10;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solver {
    public static Map<String, DistrictRooms> solve(List<Flat> lst) {
        Map<String, DistrictRooms> ans = new HashMap<>();
        for (Flat f : lst) {
            String pattern = f.district + " " + f.numRooms;
            DistrictRooms dr = ans.get(pattern);
            if (dr == null) {
                dr = new DistrictRooms(f.district, f.numRooms);
                ans.put(pattern, dr);
            }
            dr.addFlat(f);
        }
        return ans;
    }
}
