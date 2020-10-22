import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        //creates data from input
        CreateData input = new CreateData(args[0]);
        input.readFromIO();
        input.createList();
        List<Man> men = new ArrayList<>();

        //creates and adds a new Man with the data needed for the
        //matchmaking algorithm
        for(Integer man: input.SetOfMen()){
            men.add(new Man(man, input.getManPref(man), input.getArray(man)));
        }

        //doing the matchmaking
        MatchMaker matchMaker = new MatchMaker();
        matchMaker.makeMatch(input.SetOfMen(), input.SetOfWomen(), men);
        matchMaker.printToTerminal();
    }
}
