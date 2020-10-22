import java.util.HashSet;
import java.util.Set;

public class Man {
    private int[] womenPreference;
    private int[] myPreference;
    int id;
    Set<Integer> rejects;

    public Man(int id, int[] myPreference, int[] womenPreference) {
        this.myPreference = myPreference;
        this.womenPreference = womenPreference;
        this.id = id;
        rejects = new HashSet<>();
    }

    public int getId(){
        return id;
    }

    //keeps track if a woman rejects this man in the matchmaking
    public void addReject(Integer woman){
        rejects.add(woman);
    }

    public boolean isRejected(Integer woman){
        return rejects.contains(woman);
    }

    //returns the womens preferences of the man
    public int getWomenPrefForMe(int womenId){
        return womenPreference[womenId-1]+1;
    }
    
    //returns the man's preferences
    public int[] getMyPreference() {
        return myPreference;
    }
    public String toString(){
        return String.valueOf(id);
    }
}
