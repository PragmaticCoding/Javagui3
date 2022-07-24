package com.javagui.mvc;

import com.javagui.mvc.view.ViewBuilder;
import javafx.scene.layout.Region;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.Optional;

public class Controller {

    private final ViewBuilder viewBuilder;
    private final Model model = new Model();
    private final Interactor interactor;
    private Stage stage;
    private final FileChooser fileChooser = new FileChooser();

    public Controller(Stage stage) {
        interactor = new Interactor(model);
        viewBuilder = new ViewBuilder(model, this::getExcelSheet, interactor::saveExcel, interactor::readExcel, interactor::addComponent);

    }

    public void getExcelSheet() {
        File chosenFile = new FileChooser().showOpenDialog(stage);
        model.setExcelFilePath(Optional.ofNullable(chosenFile).map(File::getAbsolutePath).orElse(""));
    }

    public Region getView() {
        return viewBuilder.build();
    }
}
