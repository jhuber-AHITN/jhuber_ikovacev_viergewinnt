package com.example.viergewinntv7.view;

import com.example.viergewinntv7.HelloController;
import javafx.scene.control.Label;

public class EventViewGUI implements EventView{

    @Override
    public void PrintEvent(String event) {
        HelloController.eventLabel.setText(event);
    }
}
