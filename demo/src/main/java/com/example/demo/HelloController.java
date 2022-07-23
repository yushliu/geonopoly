package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.IOException;
import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class HelloController {
    @FXML
    void click_launch(ActionEvent event) {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.close();

        Text roll_text = new Text("                                         Touch the card to roll");
        roll_text.setFill(Color.BLACK);
        roll_text.setFont(new Font("Verdana", 25));
        Scene show_page;
        {
            File file_cover = new File("src/main/resources/com/example/demo/card/card_cover.png");
            Image image_cover = new Image(file_cover.toURI().toString());
            ImageView imageView_cover = new ImageView(image_cover);
            imageView_cover.setOnMouseClicked(e -> {
                Text return_text = new Text("                                        Touch the card to return");
                return_text.setFill(Color.BLACK);
                return_text.setFont(new Font("Verdana", 25));

                ImageView imageView_card_info = new ImageView(All_Card_Data.image_all_card.get(ThreadLocalRandom.current().nextInt(0, All_Card_Data.image_all_card.size())));
                imageView_card_info.setOnMouseClicked(e2 -> {
                    stage.close();
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        stage.setScene(scene);
                    } catch (IOException e3) {
                        System.out.println("error");
                    }
                    stage.show();
                });
                Scene scene_card_content = new Scene(new VBox(return_text, imageView_card_info));
                stage.close();
                stage.setScene(scene_card_content);
                stage.show();
            });
            show_page= new Scene(new VBox(roll_text, imageView_cover));
        }
        stage.setScene(show_page);
        stage.show();
    }
}