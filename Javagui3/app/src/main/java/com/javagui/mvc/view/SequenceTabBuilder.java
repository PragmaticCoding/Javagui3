package com.javagui.mvc.view;

import com.javagui.Widgets;
import com.javagui.mvc.Model;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.util.Builder;

public class SequenceTabBuilder implements Builder<Region> {

    private final Model model;
    private final Runnable componentPopulator;

    public SequenceTabBuilder(Model model, Runnable componentPopulator) {
        this.model = model;
        this.componentPopulator = componentPopulator;
    }

    @Override
    public Region build() {
        HBox hBox = new HBox(30, componentBox(), sequenceBox());
        hBox.setPadding(new Insets(40));
        return hBox;
    }

    private Region componentBox() {
        return Widgets.column(choicesBox(),
                Widgets.boundHidingLabel(model.selectedComponentInfo1Property()),
                Widgets.boundHidingLabel(model.selectedComponentInfo2Property()));
    }

    private Region choicesBox() {
        ComboBox<String> componentsListBox = new ComboBox<>();
        componentsListBox.setMinWidth(140);
        componentsListBox.setItems(model.getUserComponents());
        model.selectedComponentIndexProperty().bind(componentsListBox.getSelectionModel().selectedIndexProperty());
        model.selectedComponentProperty().bind(componentsListBox.getSelectionModel().selectedItemProperty());
        return new HBox(20, componentsListBox, Widgets.column(populateButton(), chooseButton()));
    }

    private Region populateButton() {
        Button button = new Button("Populate Components List");
        button.setOnAction(evt -> componentPopulator.run());
        button.disableProperty().bind(model.excelFilePathProperty().isEmpty());
        return button;
    }

    private Region chooseButton() {
        return new Button("Choose Component");
    }

    private Region sequenceBox() {
        return Widgets.column(new Label("Add a Sequence Event"),
                Widgets.promptField("Function Description", model.addFunctionProperty()),
                Widgets.promptCombo("State Of Component", model.getComponentStates(), model.selectedStateProperty()),
                eventButton());
    }

    private Node eventButton() {
        return new Button("Add Event");
    }
}
