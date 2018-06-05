package br.estacio.prii.copa.gui;

import br.estacio.prii.copa.utils.AlertHelper;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

/**
 * FXML Controller class
 *
 * @author Nilson
 */


public class MainWindowController implements Initializable {
    @FXML
    private MenuItem mnuUsers;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        
     @FXML
    protected void onUsersMenuActionPerformed(ActionEvent event) {
        AlertHelper.showWarning(null, "mnuUsersAction Performed");
    }

}
