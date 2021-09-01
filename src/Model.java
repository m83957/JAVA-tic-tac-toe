import java.util.ArrayList;

public class Model {
    static ArrayList<Observer> observer = new ArrayList<Observer>();
    static String turn = "O";
    static String[][] map = new String[3][3];
    static String gameStates;

    public boolean gameProcess(int row, int col){
        if(DrawOnMap(row, col)){
            gameStates = whoisWinner();
            NotifyObserverToView();
            return true;
        }
        return false;
    }

    private boolean DrawOnMap(int row, int col){  
        if(map[row][col] == "_"){
            map[row][col] = turn;
            return true;
        }
        return false;
    }

    private String whoisWinner(){
        String winner = new GameStateChecker(map).getWinner();
        switch(winner){
            case "O":
                return "Winner is O!!!";
            case "X":
                return "Winner is X!!!";
            case "Tie":
                return "Tie(Draw)";
            case "_":
                return "Now is " + turn + "'s turn";
            default:
                System.out.println("Something is wrong");
                return "Something is wrong";
        }

    }

    public void initMap(){
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                map[row][col] = "_";
            }
        }
    }

    public String changePlayer(){
        System.out.println("is " + turn + "'s turn");
        turn = turn == "X" ? "O":"X";
        return turn;
    }

    public void resgisterObserver(Observer OBS){
        observer.add(OBS);
    }
    public void NotifyObserverToView(){
        for(int i = 0; i < observer.size(); i++){
            Observer OBS = observer.get(i);
            OBS.updateText();
        }
    }

    public String getPlayer(){
        return turn;
    }
    public String getGameStates(){
        return gameStates;
    }

}
