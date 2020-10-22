import java.util.*;
import java.io.File;

public class CreateData {
    Map<Integer, int[]> men;
    Map<Integer, int[]> women;
    Map<Integer, int[]> prefs;
    int count;
    String filename;

    public CreateData(String filename){
        this.filename = filename;
        prefs = new HashMap<>();
        men = new HashMap<>();
        women = new HashMap<>();
    }

    //creates two hashmaps (men and women) from input file
    //each element in the hashmaps contains the man/woman and their preferences
    public void readFromIO() {
      try {
        File file = new File(filename);
        Scanner scan = new Scanner(file);
        count = Integer.parseInt(scan.nextLine());
        int current = 0;
        int[] temp = new int[count];
        int id = 0;
        
        while (scan.hasNext()){
            String[] str = scan.nextLine().split(" ");

            for (int i = 0; i < str.length; i++){
                if(current == 0){
                    current++;
                    id = Integer.parseInt(str[i]);
                    temp = new int[count];
                }
                else if(current < count){
                    temp[current-1] = Integer.parseInt(str[i]);
                    current++;
                }
                else if(current == count){
                    temp[current-1] = Integer.parseInt(str[i]);
                    current = 0;
                    if (women.containsKey(id)) {
                        men.put(id, temp);
                    } else women.put(id, temp);
                }
            }
        }
      } catch (Exception e) {
          System.out.print("Input error");
      }
    }

    public Set<Integer> SetOfWomen(){
        return women.keySet();
    }
    public Set<Integer> SetOfMen(){
        return men.keySet();
    }

    public int[] getArray(Integer id){
        return prefs.get(id);
    }

    public int[] getManPref(Integer id){
        return men.get(id);
    }

    //creates a hashmap "prefs" which contains the women preferences of a man
    //index i contains the preference of woman i+1
    public void createList() {
        for (int i = 1; i < women.size()+1; i++) {
            for (int j = 0; j < women.get(i).length; j++) {
                Integer man = women.get(i)[j];
                if (prefs.containsKey(man)) {
                    prefs.get(man)[i-1] = j;
                } else {
                    prefs.put(man, new int[women.size()]);
                    prefs.get(man)[i-1] = j;
                }
            }
        }

    }
}
