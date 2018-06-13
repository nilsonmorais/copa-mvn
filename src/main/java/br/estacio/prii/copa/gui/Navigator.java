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

import br.estacio.prii.copa.utils.ErrorHelper;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Navigator {

    private static Scene scene;

    public static String UsersScene = "/fxml/Users.fxml";
    public static String MainScene = "/fxml/Main.fxml";
    public static String SearchScene = "/fxml/Search.fxml";
    public static String SubMainScene = "/fxml/SubMain.fxml";

    public static void loadMainScene(javafx.stage.Stage stage) throws IOException {
        Parent root;
        root = FXMLLoader.load(Navigator.class.getResource(MainScene));
        scene = new Scene(root, 800, 475);
        stage.setTitle("Copa 2018");
        stage.setScene(scene);
        stage.show();
    }

    public static void loadSubMainScene(javafx.scene.layout.Pane mainPane) {
        loadSceneIntoPane(SubMainScene, mainPane);
    }

    public static void loadUsersScene(Pane mainPane) {
        loadSceneIntoPane(UsersScene, mainPane);
    }

    public static void loadSceneIntoPane(String scene, Pane target) {
        try {
            Pane newLoadedPane = FXMLLoader.load(Navigator.class.getResource(scene));
            target.getChildren().removeAll();
            target.getChildren().add(newLoadedPane);
        } catch (IOException ex) {
            ErrorHelper.showException(ex.getMessage());
        }

    }

    public static void loadSearchScene() {
        loadScene(SearchScene, true, "Pesquisar");

    }

    private static void loadScene(String scene, Boolean isModal, String title) {
        try {
            isModal = isModal == null ? true : isModal;
            title = title == null ? "Window" : title;
            FXMLLoader fxmlLoader = new FXMLLoader(Navigator.class.getResource(scene));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            if (isModal) {
                stage.initModality(Modality.APPLICATION_MODAL);
            }
            stage.setTitle(title);
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            ErrorHelper.showException(ex.getMessage());
        }
    }
}
