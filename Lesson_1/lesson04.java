import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class lesson04 {
  public static String readln(String msg) {
    System.out.println(msg);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String result;
    try {
      result = br.readLine();
    } catch (Exception e) {
      // TODO: handle exception
      result = null;
    }
    return result;
  }

  public static void addPerson(ArrayList<String> lastNames, ArrayList<String> firstNames, ArrayList<String> patronymics, ArrayList<Integer> ages, ArrayList<String> genders) {
    String tmp = readln("Input last name");
    lastNames.add(tmp);
    tmp = readln("Input first name");
    firstNames.add(tmp);
    tmp = readln("Input patronymic");
    patronymics.add(tmp);
    tmp = readln("Input age");
    ages.add(Integer.parseInt(tmp));
    tmp = readln("Input gender");
    genders.add(tmp);
  }

  public static void showTable(ArrayList<String> lastNames, ArrayList<String> firstNames, ArrayList<String> patronymics, ArrayList<Integer> ages, ArrayList<String> genders, ArrayList<Integer> ids) {
    for (int index = 0; index < ids.size(); index++) {
      System.out.printf("%s %s %s %d %s\n", lastNames.get(index), firstNames.get(index), patronymics.get(index), ages.get(index), genders.get(index));
    }
  }

  public static void sortByAge(ArrayList<String> lastNames, ArrayList<String> firstNames, ArrayList<String> patronymics, ArrayList<Integer> ages, ArrayList<String> genders, ArrayList<Integer> ids) {
    int n = ages.size();
    int tmpInt;
    String tmpStr;
    for (int i = 0; i < n; i++) {
        for (int j = 1; j < (n - i); j++) {
            if (ages.get(j - 1) > ages.get(j)) {
                tmpInt = ages.get(j - 1);
                ages.set(j - 1, ages.get(j));
                ages.set(j, tmpInt);

                tmpInt = ids.get(j - 1);
                ids.set(j - 1, ids.get(j));
                ids.set(j, tmpInt);

                tmpStr = lastNames.get(j - 1);
                lastNames.set(j - 1, lastNames.get(j));
                lastNames.set(j, tmpStr);

                tmpStr = firstNames.get(j - 1);
                firstNames.set(j - 1, firstNames.get(j));
                firstNames.set(j, tmpStr);

                tmpStr = patronymics.get(j - 1);
                patronymics.set(j - 1, patronymics.get(j));
                patronymics.set(j, tmpStr);

                tmpStr = genders.get(j - 1);
                genders.set(j - 1, genders.get(j));
                genders.set(j, tmpStr);        
            }
        }
    }
  }

  public static void main(String[] args) {
    ArrayList<String> lastNames = new ArrayList<String>();
    ArrayList<String> firstNames = new ArrayList<String>();
    ArrayList<String> patronymics = new ArrayList<String>();
    ArrayList<Integer> ages = new ArrayList<Integer>();
    ArrayList<String> genders = new ArrayList<String>();
    ArrayList<Integer> ids = new ArrayList<Integer>();
    System.out.println("Enter q");
    int i = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String flag = "\n";
    do {
      addPerson(lastNames, firstNames, patronymics, ages, genders);
      ids.add(i++);
      try {
        System.out.println("Press enter to continue or q to stop");
        flag = br.readLine();
      } catch (Exception e) {}
    } while(!flag.contains("q"));

    showTable(lastNames, firstNames, patronymics, ages, genders, ids);
    
    System.out.println("Show the sorted list? Enter y to continue");
    try {
      flag = br.readLine();
      if(flag.contains("y")) {
        sortByAge(lastNames, firstNames, patronymics, ages, genders, ids);
        showTable(lastNames, firstNames, patronymics, ages, genders, ids);
      }
    } catch (Exception e) {
      System.out.println("Error");
    } 
  }
}
