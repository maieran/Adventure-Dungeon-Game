package de.game.modules.model.player;

import java.awt.*;

public class Bag {
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    private Image image;


    public Bag(int size, Image image) {
        this.size = size;
        this.image = image;
    }
}
