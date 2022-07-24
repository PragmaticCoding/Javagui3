package com.javagui;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableStringValue;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class Widgets {
    public static Region promptField(String prompt, StringProperty boundProperty) {
        TextField textField = new TextField();
        textField.setMaxWidth(200);
        textField.textProperty().bindBidirectional(boundProperty);
        VBox results = new VBox(2, new Label(prompt), textField);
        results.setAlignment(Pos.CENTER);
        return results;
    }

    public static Region promptCombo(String prompt, ObservableList<String> choices, StringProperty boundProperty) {
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.setItems(choices);
        boundProperty.bind(comboBox.valueProperty());
        comboBox.setMinWidth(140);
        VBox results = new VBox(2, new Label(prompt), comboBox);
        results.setAlignment(Pos.CENTER);
        return results;
    }

    public static Region boundHidingLabel(ObservableStringValue boundValue) {
        Label label = new Label();
        label.textProperty().bind(boundValue);
        label.visibleProperty().bind(label.textProperty().isNotEmpty());
        return label;
    }

    public static Region column(Node... contents) {
        VBox results = new VBox(10, contents);
        results.setAlignment(Pos.TOP_CENTER);
        return results;
    }
}
