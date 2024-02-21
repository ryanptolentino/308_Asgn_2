import java.util.List;
import java.util.Map;

public class CalculateIn {
    public static int GetIn(Map<Info, List<List<Info>>> inputMap, Info classOfInterest) {
        List<List<Info>> infoArray = inputMap.get(classOfInterest);
        if (infoArray != null && !infoArray.isEmpty()) {
            List<Info> localVarList = infoArray.get(2); // Get the 3rd element from infoArray in the table
            return localVarList.size(); // Return the size of localVarList
        } else {
            return 0; // Return 0 if infoArray is null or empty
        }
    }
}