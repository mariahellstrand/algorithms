import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        CreateData input = new CreateData(args[0]);
        input.readFromIO();
        input.createList();
        List<Man> men = new ArrayList<>();
        for(Integer man: input.SetOfMen()){
            men.add(new Man(man, input.getManPref(man), input.getArray(man)));
        }
        MatchMaker matchMaker = new MatchMaker();
        matchMaker.makeMatch(input.SetOfMen(), input.SetOfWomen(), men);
        matchMaker.printToTerminal();
    }
}
