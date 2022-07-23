package com.example.demo;

import javafx.scene.image.Image;
import java.io.File;
import java.util.Vector;

public class All_Card_Data {
    static Vector<Image> image_all_card = new Vector<>();
    static {
        for(int i=0; i<=15; i++) image_all_card.add(new Image(new File("src/main/resources/com/example/demo/card/card"+i+".png").toURI().toString()));
    }
}
