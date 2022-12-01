package pl.camp.it.tictactoe.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.camp.it.tictactoe.gui.GUI;

import java.util.ArrayList;
import java.util.List;

@Component
public class Engine {
    @Autowired
    private GUI gui;

    public void start(){
        gui.showStart();
        while (gui.checkIfOver()) {
            gui.addChar();
            gui.showGraph();
        }
    }
}
