package org.example.view;

import org.example.control.BasicControl;
import org.example.control.Control;

public interface BasicView {
    public void start(BasicControl control, String text);

    public BasicControl getControl();
}
