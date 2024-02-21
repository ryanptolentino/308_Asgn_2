import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapGenerator {

    public static Map<Info, List<Integer>> generateMap(Map<Info, List<List<Info>>> inputMap) {
        Map<Info, List<Integer>> resultMap = new HashMap<>();

        for (Map.Entry<Info, List<List<Info>>> entry : inputMap.entrySet()) {
            Info currentClass = entry.getKey();


            List<Integer> inOutList = new ArrayList<>();
            int in = CalculateIn.GetIn(inputMap, currentClass);
            int out = CalculateOut.getOut(inputMap, currentClass);
            inOutList.add(in);
            inOutList.add(out);
            
            resultMap.put(currentClass, inOutList);
        }
        return resultMap;
    }
}