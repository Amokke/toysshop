package org.example.model;

import org.example.control.BasicControl;
import org.example.control.Control;
import org.example.data.ToysDistributor;
import org.example.view.BasicView;
import org.example.view.View;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Settings extends Mode {
    protected final BasicView view;

    public Settings(BasicView view) {
        super("sett", "настройки программы");
        this.view = view;
    }

    public Settings(String nameMenu, String description, BasicView view) {
        super(nameMenu, description);
        this.view = view;
    }

    @Override
    public void execute(ToysDistributor toys, Scanner scanner) {
        Mode read = new Read();
        Mode save = new Save();
        Mode add = new Add();
        Mode edit = new Edit();
        Mode show = new Show();
        Mode ret = new Return(view);
        Map<String, Mode> menu = new LinkedHashMap<>();
        menu.put(read.getNameMenu(), read);
        menu.put(save.getNameMenu(), save);
        menu.put(add.getNameMenu(), add);
        menu.put(edit.getNameMenu(), edit);
        menu.put(show.getNameMenu(), show);
        menu.put(ret.getNameMenu(), ret);
        BasicControl control = new Control(toys, menu);
        new View(control, "\n" + this.description);
    }
}
