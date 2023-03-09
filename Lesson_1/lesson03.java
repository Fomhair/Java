import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class lesson03 {

  public static void changeValues(String str, ArrayList<String> list) {
    for (int i = 0; i < list.size(); i++) {
      String item = list.get(i) + str;
      list.set(i, item);
    }
  }

  public static void printList(ArrayList<String> list, String description) {
    System.out.println(description);
    list.forEach(item -> System.out.printf("%s ", item));
    System.out.println("\n---------------");
  }

  public static String searchByString(ArrayList<String> list, String value) {
    for(String item : list) {
      if(item.contains(value)) {
        return item;
      }
    }
    return null;
  }

  public static void manyReps(List<String> list) {
    long m = System.currentTimeMillis();
    for (int i = 0; i < 100000; i++) {
      list.add(0, "chocolate");
    }
    System.out.println((double) (System.currentTimeMillis() - m) + "ms");
  }

  public static void main(String[] args) {
    
    ArrayList<String> colors = new ArrayList<String>();
    colors.add("red");
    colors.add("green");
    colors.add("blue");
    colors.add("yellow");
    colors.add("black");
    colors.add("white");
    printList(colors, "New list");

    changeValues("!", colors);
    printList(colors, "Iteration with changing");

    colors.add(0, "violet");
    printList(colors, "Insert an item in the list in the first position.");

    String removedElement = colors.remove(5);
    System.out.println(removedElement);
    printList(colors, "Element extracting");

    colors.set(3, "indigo");
    printList(colors, "Refresh a specific list item by the given index.");
    
    colors.remove(2);
    printList(colors, "Remove element");

    System.out.println("Search for an item in the list by row.");
    System.out.println(searchByString(colors, "red"));
    System.out.println("---------------");

    ArrayList<String> colors2 = new ArrayList<String>();
    colors2.add("cyan");
    colors2.add("magenta");
    colors2.add("purple");
    colors2.add("yellow!");
    colors2.add("black!");
    colors2.add("white!");
    printList(colors2, "Second list");

    colors.retainAll(colors2);
    printList(colors, "Remove from the first list all items missing from the second list");

    Collections.sort(colors2);
    printList(colors2, "Sorting the list");

    System.out.println("Array list time:");
    manyReps(colors);
    LinkedList<String> colorsL = new LinkedList<String>();
    System.out.println("Linked list time:");
    manyReps(colorsL);

  }
}
