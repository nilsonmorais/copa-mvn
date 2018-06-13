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
package br.estacio.prii.copa.fxcontrollers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GroupController implements Initializable {

    @FXML
    private ImageView imgLogo;
    @FXML
    private Label lblTitle;
    private final String labelTextProperty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblTitle.setText(this.labelTextProperty);
    }

//    @FXML
//    protected void btnSearchAction(ActionEvent event) throws IOException {
//        openSearchDialog();
//    }
    private void setLogoURI(String uri) {
        try {
            String imgUrl = "https://www.google.com/logos/doodles/2018/dia-dos-namorados-2018-5894886078283776.3-l.png";
            Image img = new Image(imgUrl);
            imgLogo.setImage(img);
        } catch (Exception e) {
            File file = new File("@../default-image.jpg");
            Image image = new Image(file.toURI().toString());
            imgLogo.setImage(image);

        }
    }

    public GroupController(String imgURI, String labelText) {
//        setLogoURI(imgURI);
        this.labelTextProperty = labelText;
    }

    private void setLabel(String labelText) {
        lblTitle.setText(labelText);
    }

}
