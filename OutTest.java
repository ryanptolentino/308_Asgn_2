import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutTest {

    public static void main(String[] args) {

        Info classA = new Info();
        Info classB = new Info();
        Info classC = new Info();
        Info classD = new Info();

        classA.setClassName("A");
        classB.setClassName("B");
        classC.setClassName("C");
        classD.setClassName("D");

        classA.setParentClass(classB.getClassName());
        classA.addGlobalVariable("C");
        classA.addGlobalVariable("D");


        List<Info> localVarList = new ArrayList<>(); // Create a list to hold local variable
        localVarList.add(classB);
        localVarList.add(classC);
        localVarList.add(classD);

        List<Info> parentList = new ArrayList<>(); // Create a list to hold parent classes
        parentList.add(classB);
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

        int inNumber = CalculateOut.getOut(classMap, classA); // should be 3 since only 3 classes in local var list
        System.out.println("The number of classes going out is: " + inNumber);
    }
}