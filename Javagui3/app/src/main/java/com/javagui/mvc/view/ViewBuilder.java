package com.javagui.mvc.view;

import com.javagui.Widgets;
import com.javagui.mvc.Model;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.*;
import javafx.util.Builder;

public class ViewBuilder implements Builder<Region> {

    final Model model;
    final Runnable excelSheetGetter;
    final Runnable excelSheetSaver;
    final Runnable componentPopulator;
    final Runnable componentAdder;

    public ViewBuilder(Model model, Runnable excelSheetGetter, Runnable excelSheetSaver, Runnable componentPopulator, Runnable componentAdder) {
        this.model = model;
        this.excelSheetGetter = excelSheetGetter;
        this.excelSheetSaver = excelSheetSaver;
        this.componentPopulator = componentPopulator;
        this.componentAdder = componentAdder;
    }


    @Override
    public Region build() {
        return new TabPane(new Tab("Content", new ContentTabBuilder(model, excelSheetGetter, excelSheetSaver, componentAdder).build()),
                new Tab("Sequence", new SequenceTabBuilder(model, componentPopulator).build()),
                new Tab("Change", changeTabContent()),
                new Tab("Tooling Layout", toolingLayoutContent()),
                new Tab("Add Component to DataBase", new AddComponentTabBuilder(model).build())
        );
    }

    private Region changeTabContent() {
        StackPane results = new StackPane(Widgets.column(Widgets.promptField("Your Name", model.yourNameProperty()),
                Widgets.promptField("Company", model.companyProperty()),
                Widgets.promptField("Date", model.dateProperty()),
                Widgets.promptField("Description of Change", model.changeDescriptionProperty()),
                addChangeButton()
        ));
        results.setPadding(new Insets(20));
        return results;
    }

    private Node addChangeButton() {
        return new Button("Add Change");
    }

    private Node toolingLayoutContent() {
        HBox results = new HBox(10, new VBox(30,
                imageUploadButton(),
                exportLayoutButton(),
                new Label("Selected Component Image:")),
                imagePane());
        results.setPadding(new Insets(20));
        return results;
    }

    private Pane imagePane() {
        Pane results = new Pane();
        results.setStyle("-fx-border-color: black;");
        results.setMinWidth(400);
        return results;
    }

    private Node imageUploadButton() {
        return new Button("Upload Image of Component");
    }

    private Node exportLayoutButton() {
        return new Button("Export Layout to SpreadSheet");
    }
}
