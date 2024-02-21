import java.util.List;
import java.util.Map;

public class CalculateOut {
    public static int getOut(Map<Info, List<List<Info>>> inputMap, Info classOfInterest) {
        int totalSize = 0;

        List<List<Info>> infoArray = inputMap.get(classOfInterest);
        if (infoArray != null && !infoArray.isEmpty()) {
            List<Info> parentList = infoArray.get(0);
            totalSize = parentList.size();

            List<Info> globalVarList = infoArray.get(1);
            totalSize += globalVarList.size();
            return totalSize;
        }
        return 0;
    }
}