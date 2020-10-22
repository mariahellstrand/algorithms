import java.util.*;

public class MatchMaker {
    private Map<Integer, Man> couples;

    //the matching algorithm that creates the couples
    public void makeMatch(Set<Integer> men, Set<Integer> women, List<Man> listOfMen){
        couples = new HashMap<>();
       
       //loops until all men and women has been matched
        while (listOfMen.size() != 0){
            Man man = listOfMen.remove(0);
            int woman = 1;

            //returns the next woman in line to be matched with the man
            for(int i = 0; i < women.size(); i++){
                woman = man.getMyPreference()[i];
                if(!man.isRejected(woman)){
                    break;
                }
            }

            //if the woman does not have a man, a couple is created
            if(!couples.containsKey(woman)){
                couples.put(woman, man);
            }

            //if the woman is matched with a man allready, the old man is compared
            //with the new possible man to get the best match
            else if(man.getWomenPrefForMe(woman) < couples.get(woman).getWomenPrefForMe(woman)){
                Man manRejected = couples.get(woman);
                manRejected.addReject(woman);
                listOfMen.add(couples.put(woman, man));
            }

            //if no match was found
            else {
                listOfMen.add(man);
                man.addReject(woman);
            }
        }
    }

    //prints the resulting couples
    public void printToTerminal(){
        for(int woman = 1; woman <= couples.keySet().size(); woman++){
            System.out.println("Woman: " + woman + " was matched with man: " + couples.get(woman).getId());
        }
    }

}
