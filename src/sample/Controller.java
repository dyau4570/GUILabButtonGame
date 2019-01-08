package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable
{
    public Label Score;
    public Label txt;
    public Label time;
    static String name;
    static int score = 0;
    public TextField field;
    private boolean counting = false;
    private boolean done = false;

    public void pressButton(ActionEvent event)
    {
        if(!counting && !done)
        {
            long step = System.nanoTime() + 10000000000L;
            new AnimationTimer() {
                public void handle(long now) {
                    if(now > step)
                    {
                        Score.setText("You ended with " + score + ", " + name);
                        counting = false;
                        done = true;
                        time.setText("Time Left: 0");
                    }
                    if (now < step) {
                        long time2 = now - step;
                        time.setText("Time Left: " + -time2);
                    }
                }
            }.start();
            counting = true;
        }
        if(counting) {
            name = field.getText();
            field.setVisible(false);
            score++;
            Score.setText("Score: " + String.valueOf(score));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        {
            field.setPromptText("Name");
        }
    }

}
