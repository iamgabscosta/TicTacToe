import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class GameController implements Initializable {

    @FXML
    private Button buttonOne;
    @FXML
    private Button buttonTwo;
    @FXML
    private Button buttonThree;
    @FXML
    private Button buttonFour;
    @FXML
    private Button buttonFive;
    @FXML
    private Button buttonSix;
    @FXML
    private Button buttonSeven;
    @FXML
    private Button buttonEight;
    @FXML
    private Button buttonNine;
    @FXML
    private Text winnerGame;

    private int yourTurn = 0;

    ArrayList<Button> buttons;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new ArrayList<>(Arrays.asList(buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine));
        buttons.forEach(button -> {
            setupButton(button);
            button.setFocusTraversable(false);
        });
    }
    
    @FXML
    void restartButton(ActionEvent event) {
       buttons.forEach(this::resetButton);
       winnerGame.setText("Tic Tac Toe");
    }

    private void resetButton(Button button) {
        button.setDisable(false);
        button.setText("");
    }
    
    @FXML
    void closeButton(ActionEvent event) {
        System.exit(0);
    }

    private void setupButton(Button button) {
        button.setOnMouseClicked(mouseEvent -> {
            setPlayerSymbol(button);
            button.setDisable(false);
            checkGameOver();
        });
    }

    
    private void setPlayerSymbol(Button button) {
        if(yourTurn % 2 == 0){
            button.setText("X");
            yourTurn = 1;
        }else{
            button.setText("O");
            yourTurn = 0;
        }
    }
    
    private void checkGameOver() {
        for(int a =0; a < 8; a++) {
            String line = switch (a) {
                case 0 -> buttonOne.getText() + buttonTwo.getText() + buttonThree.getText();
                case 1 -> buttonFour.getText() + buttonFive.getText() + buttonSix.getText();
                case 2 -> buttonSeven.getText() + buttonEight.getText() + buttonNine.getText();
                case 3 -> buttonOne.getText() + buttonFive.getText() + buttonNine.getText();
                case 4 -> buttonThree.getText() + buttonFive.getText() + buttonSeven.getText();
                case 5 -> buttonOne.getText() + buttonFour.getText() + buttonSeven.getText();
                case 6 -> buttonTwo.getText() + buttonFive.getText() + buttonEight.getText();
                case 7 -> buttonThree.getText() + buttonSix.getText() + buttonNine.getText();
                default -> null;
            };

            if (line.equals("XXX")) {
                winnerGame.setText("X Wins !");
            } else if(line.equals("OOO")) {
                winnerGame.setText("O Wins!");
            }
        }
    }
}
