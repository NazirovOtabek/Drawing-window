package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    private GraphicsContext gc;
    private String[] colors;
    private Button[] chalks;
    private int size = 10;


    @FXML
    private Button oqrang;

    @FXML
    private Button qizilrang;

    @FXML
    private Button yashilrang;

    @FXML
    private Button sariqrang;

    @FXML
    private Button pushtirang;

    @FXML
    private Button eraser;

    @FXML
    private Canvas canvas;

    @FXML
    private void chalkClicked(ActionEvent event) {

           for(int i =0; i < chalks.length; i ++){
             if(chalks[i].getId ().equals (((Button)event.getSource ()).getId ())){
                  gc.setFill (Color.web (colors[i]));
               size = 10;
                        return;
               }
          }
            gc.setFill (Color.web ("086C3A"));
            size = 100;

          }


        @Override
        public void initialize (URL location, ResourceBundle resources){

               colors = new String[]{"FFFFFF", "CD3F3F","5A9D7B","FFFF80","FF80C0"};
              chalks = new Button[]{oqrang,qizilrang,yashilrang,sariqrang,pushtirang};

            canvas.setWidth (1920);
            canvas.setHeight (1080);
            gc = canvas.getGraphicsContext2D ();
            gc.setFill (Color.web ("086C3A"));
            gc.fillRect (0, 0, canvas.getWidth (), canvas.getHeight ());
            gc.setFill (Color.WHITE);


            canvas.setOnMouseDragged (new EventHandler<MouseEvent> () {
                @Override
                public void handle(MouseEvent event) {
                    gc.fillOval (event.getX (), event.getY (), size, size);
                }
            });
        }
    }

