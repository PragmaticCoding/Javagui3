package com.javagui.mvc.view;

import com.javagui.Widgets;
import com.javagui.mvc.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class ContentTabBuilder implements Builder<Region> {

    final Model model;
    final Runnable excelSheetGetter;
    final Runnable excelSheetSaver;
    final Runnable componentAdder;

    public ContentTabBuilder(Model model, Runnable excelSheetGetter, Runnable excelSheetSaver, Runnable componentAdder) {
        this.model = model;
        this.excelSheetGetter = excelSheetGetter;
        this.excelSheetSaver = excelSheetSaver;
        this.componentAdder = componentAdder;
    }

    @Override
    public Region build() {
        HBox results = new HBox(20, basicInfoVBox(), addComponentVBox());
        results.setPadding(new Insets(20));
        return results;
    }

    private Region addComponentVBox() {
        return Widgets.column(new Label("Add Component"),
                Widgets.promptField("Function Description", model.functionDescProperty()),
                Widgets.promptField("Part Number", model.partNoProperty()),
                Widgets.promptField("Manufacturer", model.manufacturerProperty()),
                Widgets.promptField("Start Condition", model.startConditionProperty()),
                Widgets.promptCombo("Choose Component From DataBase", FXCollections.emptyObservableList(), new SimpleStringProperty("")),
                componentButtons()
        );
    }

    private Region basicInfoVBox() {
        VBox results = new VBox(6, new Label("Basic Information"),
                new HBox(6,
                        Widgets.column(Widgets.promptField("XTA", model.xtaProperty()),
                                Widgets.promptField("Robot", model.robotProperty()),
                                Widgets.promptField("Zone", model.zoneProperty()),
                                Widgets.promptField("Name", model.nameProperty()),
                                Widgets.promptField("Customer Name", model.customerNameProperty()),
                                writeButton()
                        ), Widgets.column(Widgets.promptField("Project # or Name", model.projectNameProperty()),
                        Widgets.promptField("Tool Number", model.toolNumberProperty()),
                        Widgets.promptField("Sheet (AutoFills)", model.sheetProperty()),
                        Widgets.promptField("Station", model.stationProperty()),
                        Widgets.promptField("Machine Description", model.machineDescriptionProperty()),
                        chooseSheetButton()
                )));
        results.setAlignment(Pos.TOP_CENTER);
        return results;
    }

    private Region writeButton() {
        Button results = new Button("Write to Sheet");
        results.disableProperty().bind(model.excelFilePathProperty().isEmpty());
        results.setOnAction(evt -> excelSheetSaver.run());
        return results;
    }

    private Region chooseSheetButton() {
        Button results = new Button("Choose Excel Sheet");
        results.setOnAction(evt -> excelSheetGetter.run());
        return results;
    }

    private Region componentButtons() {
        Button addButton = new Button("Add Component");
        addButton.setOnAction(evt -> componentAdder.run());
        addButton.disableProperty().bind(model.excelFilePathProperty().isEmpty());
        Button updateButton = new Button("Update Dropdown");
        return new HBox(2, addButton, updateButton);
    }

}
