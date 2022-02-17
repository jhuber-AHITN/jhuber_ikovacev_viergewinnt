package com.example.viergewinntv7.view;

import com.example.viergewinntv7.model.Player;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PlayerViewGUI implements PlayerView{
protected Label name;
protected Circle circle;
protected Color color;

    public PlayerViewGUI(Label name, Circle circle) {
        this.name = name;
        this.circle = circle;
        Color color = null;
    }

    @Override
    public void PrintPlay(Player player) {
        name.setText(player.GetName());
        switch (player.GetSymbol()) {
            case 'R':
                color=Color.RED;
                break;
            case 'B':
                color=Color.BLUE;
                break;
            case 'G':
                color=Color.GREEN;
                break;
            case 'Y':
                color=Color.YELLOW;
                break;
            case 'V':
                color=Color.BLUEVIOLET;
                break;
        }
        circle.setFill(color);

    }
}
