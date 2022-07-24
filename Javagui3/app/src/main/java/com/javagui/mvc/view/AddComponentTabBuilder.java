package com.javagui.mvc.view;

import com.javagui.Widgets;
import com.javagui.mvc.Model;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class AddComponentTabBuilder implements Builder<Region> {

    private final Model model;

    public AddComponentTabBuilder(Model model) {
        this.model = model;
    }

    @Override
    public Region build() {
        VBox results = new VBox(10, addComponentButton(), createGridPane());
        results.setAlignment(Pos.TOP_CENTER);
        results.setPadding(new Insets(20));
        return results;
    }

    private Node addComponentButton() {
        return new Button("Add to Component Database");
    }

    private Node createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.add(Widgets.promptField("Change Level", model.changeLevelProperty()), 0, 0);
        gridPane.add(Widgets.promptField("Unit No", model.unitNoProperty()), 1, 0);
        gridPane.add(Widgets.promptField("Function Description", model.functionDescProperty()), 2, 0);
        gridPane.add(Widgets.promptField("Part Number", model.addPartNoProperty()), 0, 1);
        gridPane.add(Widgets.promptField("Panel Reference", model.panelRefProperty()), 1, 1);
        gridPane.add(Widgets.promptField("Cylinder Bore", model.cylinderBoreProperty()), 2, 1);
        gridPane.add(Widgets.promptField("Open Angle", model.openAngleProperty()), 0, 2);
        gridPane.add(Widgets.promptField("Tool Manufacturer", model.toolManufacturerProperty()), 1, 2);
        gridPane.add(Widgets.promptField("Sensor Type", model.sensorTypeProperty()), 2, 2);
        gridPane.add(Widgets.promptField("Switch Number", model.switchNumberProperty()), 0, 3);
        gridPane.add(Widgets.promptField("Integral Brake", model.integralBrakeProperty()), 2, 3);
        gridPane.setVgap(8);
        gridPane.setHgap(30);
        gridPane.setAlignment(Pos.CENTER);
        return gridPane;
    }
}
