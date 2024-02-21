import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

    public static void main(String[] args) {

        Info classA = new Info();
        Info classB = new Info();
        Info classC = new Info();
        Info classD = new Info();
        Info classE = new Info();

        classA.setClassName("A");
        classB.setClassName("B");
        classC.setClassName("C");
        classD.setClassName("D");

        classA.setParentClass(classB.getClassName());
        classA.addGlobalVariable("C");
        classA.addGlobalVariable("D");

        ////// this is all for the A class


        List<Info> localVarList = new ArrayList<>(); // Create a list to hold local variable
        localVarList.add(classB);
        localVarList.add(classC);
        localVarList.add(classD);
        localVarList.add(classE);

        List<Info> parentList = new ArrayList<>(); // Create a list to hold parent classes
        parentList.add(classD);
        
        List<Info> globalVarList = new ArrayList<>(); // create a list to hold global vars
        globalVarList.add(classB);
        globalVarList.add(classC);

        List<List<Info>> ArrayA = new ArrayList<>(); // Create a list to hold localVarList
        ArrayA.add(parentList); // Add parent to ArrayA
        ArrayA.add(globalVarList); // Add parent to ArrayA
        ArrayA.add(localVarList);

        Map<Info, List<List<Info>>> classMap = new HashMap<>();
        classMap.put(classA, ArrayA);


        ///// this going to be for the b class

        List<Info> localVarList02 = new ArrayList<>(); // Create a list to hold local variable
        localVarList02.add(classC);
        localVarList02.add(classD);

        List<Info> parentList02 = new ArrayList<>(); // Create a list to hold parent classes
        parentList02.add(classA);
        
        List<Info> globalVarList02 = new ArrayList<>(); // create a list to hold global vars
        globalVarList02.add(classC);
        globalVarList02.add(classE);

        List<List<Info>> ArrayB = new ArrayList<>(); // Create a list to hold localVarList
        ArrayB.add(parentList02); // Add parent to ArrayA
        ArrayB.add(globalVarList02); // Add parent to ArrayA
        ArrayB.add(localVarList02);

        classMap.put(classA, ArrayA);
        classMap.put(classB, ArrayB);

        Map<Info, List<Integer>> resultMap = new HashMap<>();

        resultMap = MapGenerator.generateMap(classMap);
        printMap(resultMap);

        
    }

    public static void printMap(Map<Info, List<Integer>> inputMap) {
        for (Map.Entry<Info, List<Integer>> entry : inputMap.entrySet()) {
            Info currentClass = entry.getKey();

            System.out.println("Class name: " + currentClass.getClassName());
            System.out.println("In: "+ entry.getValue().get(0));
            System.out.println("Out: "+ entry.getValue().get(1) + "\n");
        }
    }
}