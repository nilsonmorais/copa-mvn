/*
This is free and unencumbered software released into the public domain.

Anyone is free to copy, modify, publish, use, compile, sell, or
distribute this software, either in source code form or as a compiled
binary, for any purpose, commercial or non-commercial, and by any
means.

In jurisdictions that recognize copyright laws, the author or authors
of this software dedicate any and all copyright interest in the
software to the public domain. We make this dedication for the benefit
of the public at large and to the detriment of our heirs and
successors. We intend this dedication to be an overt act of
relinquishment in perpetuity of all present and future rights to this
software under copyright law.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
OTHER DEALINGS IN THE SOFTWARE.

For more information, please refer to <http://unlicense.org>
 */
package br.estacio.prii.copa.gui;

import br.estacio.prii.copa.entidade.TimeObject;
import br.estacio.prii.copa.utils.ErrorHelper;
import br.estacio.prii.copa.http.CopaAPI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import org.json.JSONArray;
import org.json.JSONObject;

public class SubMainController implements Initializable {

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loadGames();
        } catch (Exception ex) {
            ErrorHelper.showException(ex.getMessage());
        }
    }

    @FXML
    private Pane paneNextEvents;

    private void loadGames() throws Exception {
        try {
            JSONObject result = CopaAPI.getGames();
            JSONObject grupos = result.getJSONObject("standings");
            ArrayList<TimeObject> timesList = new ArrayList<>();
            for (Iterator iterator = grupos.keys(); iterator.hasNext();) {
                String grupoID = (String) iterator.next();
                JSONArray grupo = (JSONArray) grupos.get(grupoID);
                for (int i = 0; i < grupo.length(); i++) {
                    JSONObject time = (JSONObject) grupo.get(i);
                    TimeObject t = new TimeObject(time);
                    timesList.add(t);
                }

            }

            paneNextEvents.getChildren().removeAll();

            for (TimeObject timeObject : timesList) {
                GroupController g = new GroupController(timeObject.getCrestURI(), timeObject.getTeam());
                FXMLLoader loader = new FXMLLoader(Navigator.class.getResource("/fxml/Group.fxml"));
                loader.setController(g);
                Pane tmpPane = (Pane) loader.load();
                paneNextEvents.getChildren().add(tmpPane);
            }
//            AlertHelper.showAlert(null, null, null, games.toString());
        } catch (Exception exception) {
            ErrorHelper.showException(exception.getMessage());
        }
    }

}
