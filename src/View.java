import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
public class View implements Observer{

    Model model;
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JLabel gameStateLabel;
    private JButton[][] board;

    public View(Model model){
        this.model = model;
        model.resgisterObserver((Observer)this);
    }
    public void DrawGUI(){
        frame = new JFrame("Tic Tac Toe");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainPanel.setSize(500,300);
        mainPanel.setBackground(Color.lightGray);
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3,3));
        gameStateLabel = new JLabel("------");
        gameStateLabel.setText("Now is " + model.getPlayer() + "'s turn");
        board = new JButton[3][3];
        for(int row = 0; row < 3; row++){
            for(int col = 0; col < 3; col++){
                board[row][col] = new JButton("_");
                board[row][col].putClientProperty("row",row);
                board[row][col].putClientProperty("col",col);
                buttonPanel.add(board[row][col]);
            }
        }
        mainPanel.add(gameStateLabel);
        buttonPanel.setPreferredSize(new Dimension(250,250));
        frame.add(mainPanel,BorderLayout.NORTH);
        frame.add(buttonPanel);
        frame.pack();
        frame.setVisible(true);
    }
    public void addBoardListener(ActionListener BoardControlListener) {
		for (int row = 0; row < 3; row++) {
			for (int col = 0; col < 3; col++)
				board[row][col].addActionListener(BoardControlListener);
		}
	}
    public void setButtonText(String BTNtext, int row, int col){
        board[row][col].setText(BTNtext);
    }
    public void setLabelMessage(String LabelMessage){
        gameStateLabel.setText(LabelMessage);
    }
    @Override
    public void updateText() {
        String gameStates = model.getGameStates();
        gameStateLabel.setText(gameStates);

    }

}