import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
public class Control{
    private Model model;
    private View view;

    public Control(Model model){
        this.model = model;
        model.initMap();
        view = new View(model);
        view.DrawGUI();
        view.addBoardListener(new BoardControlListener());
    }

    class BoardControlListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
			int row = (int) btn.getClientProperty("row");
			int col = (int) btn.getClientProperty("col");
            System.out.println(row + " " + col);
            
            if(model.gameProcess(row,col)){
                view.setButtonText(model.getPlayer(),row,col);
                model.changePlayer();
            }else{
                view.setLabelMessage("That one is already used you dickhead");
            }
            
        }
    }

}