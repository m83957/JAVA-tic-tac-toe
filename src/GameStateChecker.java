public class GameStateChecker {
    private String[][] map;
    private String winner;
    GameStateChecker(String[][] map){
        this.map= map;
    }

    public String getWinner(){
        //Left to right
        winner = map[0][0];
        for(int row = 0; row < 3; row++){
            if(map[row][row] != winner){
                winner = "_";
            }
        }
        if(winner != "_"){return winner;}
        
        //Right to left
        winner = map[0][2];
        for(int row =  0; row < 3; row++){
            if(map[2 - row][row] != winner){
                winner = "_";
            }
        }
        if(winner != "_"){return winner;}

        //Vertical line
        for(int row = 0; row < 3; row++){
            winner = map[row][0];
            for(int col = 0; col < 3; col++){
                if(winner != map[row][col]){
                    winner = "_";
                    break;
                }
            }
            if(winner != "_"){return winner;}
        }

        //Horizontal line
        for(int row = 0; row < 3; row++){
            winner = map[0][row];
            for(int col = 0; col < 3; col++){
                if(winner != map[row][col]){
                    winner = "_";
                    break;
                }
            }
            if(winner != "_"){return winner;}
        }

        //Tie
        int UnusedBoardNum = 0;
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                if(map[row][col] == "_"){
                    UnusedBoardNum++;
                }
            }
        }
        if(UnusedBoardNum <= 2){
            return "Tie";
        }
        return winner;
    }
}
