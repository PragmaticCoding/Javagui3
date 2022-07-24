package com.javagui.mvc;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class Model {
    private final StringProperty xta = new SimpleStringProperty("");
    private final StringProperty projectName = new SimpleStringProperty("");
    private final StringProperty robot = new SimpleStringProperty("");
    private final StringProperty toolNumber = new SimpleStringProperty("");
    private final StringProperty zone = new SimpleStringProperty("");
    private final StringProperty sheet = new SimpleStringProperty("");
    private final StringProperty name = new SimpleStringProperty("");
    private final StringProperty station = new SimpleStringProperty("");
    private final StringProperty customerName = new SimpleStringProperty("");
    private final StringProperty machineDescription = new SimpleStringProperty("");
    private final StringProperty function = new SimpleStringProperty("");
    private final StringProperty partNo = new SimpleStringProperty("");
    private final StringProperty manufacturer = new SimpleStringProperty("");
    private final StringProperty startCondition = new SimpleStringProperty("");
    private final StringProperty addFunction = new SimpleStringProperty("");
    private final StringProperty yourName = new SimpleStringProperty("");
    private final StringProperty company = new SimpleStringProperty("");
    private final StringProperty date = new SimpleStringProperty("");
    private final StringProperty changeLevel = new SimpleStringProperty("");
    private final StringProperty changeDescription = new SimpleStringProperty("");
    private final StringProperty unitNo = new SimpleStringProperty("");
    private final StringProperty functionDesc = new SimpleStringProperty("");
    private final StringProperty addPartNo = new SimpleStringProperty("");
    private final StringProperty panelRef = new SimpleStringProperty("");
    private final StringProperty cylinderBore = new SimpleStringProperty("");
    private final StringProperty openAngle = new SimpleStringProperty("");
    private final StringProperty toolManufacturer = new SimpleStringProperty("");
    private final StringProperty sensorType = new SimpleStringProperty("");
    private final StringProperty switchNumber = new SimpleStringProperty("");
    private final StringProperty integralBrake = new SimpleStringProperty("");

    private final StringProperty excelFilePath = new SimpleStringProperty("");

    private final IntegerProperty selectedComponentIndex = new SimpleIntegerProperty(0);
    private final StringProperty selectedComponent = new SimpleStringProperty("");
    private final StringProperty selectedComponentInfo1 = new SimpleStringProperty("");
    private final StringProperty selectedComponentInfo2 = new SimpleStringProperty("");
    private final StringProperty selectedComponentInfo3 = new SimpleStringProperty("");
    private final ObservableList<String> userComponents = FXCollections.observableArrayList();
    private final ObservableList<String> componentStates = FXCollections.observableArrayList();
    private final StringProperty selectedState = new SimpleStringProperty("");

    public String getXta() {
        return xta.get();
    }

    public StringProperty xtaProperty() {
        return xta;
    }

    public void setXta(String xta) {
        this.xta.set(xta);
    }

    public String getProjectName() {
        return projectName.get();
    }

    public StringProperty projectNameProperty() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName.set(projectName);
    }

    public String getRobot() {
        return robot.get();
    }

    public StringProperty robotProperty() {
        return robot;
    }

    public void setRobot(String robot) {
        this.robot.set(robot);
    }

    public String getToolNumber() {
        return toolNumber.get();
    }

    public StringProperty toolNumberProperty() {
        return toolNumber;
    }

    public void setToolNumber(String toolNumber) {
        this.toolNumber.set(toolNumber);
    }

    public String getZone() {
        return zone.get();
    }

    public StringProperty zoneProperty() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone.set(zone);
    }

    public String getSheet() {
        return sheet.get();
    }

    public StringProperty sheetProperty() {
        return sheet;
    }

    public void setSheet(String sheet) {
        this.sheet.set(sheet);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getStation() {
        return station.get();
    }

    public StringProperty stationProperty() {
        return station;
    }

    public void setStation(String station) {
        this.station.set(station);
    }

    public String getCustomerName() {
        return customerName.get();
    }

    public StringProperty customerNameProperty() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName.set(customerName);
    }

    public String getMachineDescription() {
        return machineDescription.get();
    }

    public StringProperty machineDescriptionProperty() {
        return machineDescription;
    }

    public void setMachineDescription(String machineDescription) {
        this.machineDescription.set(machineDescription);
    }

    public String getFunction() {
        return function.get();
    }

    public StringProperty functionProperty() {
        return function;
    }

    public void setFunction(String function) {
        this.function.set(function);
    }

    public String getPartNo() {
        return partNo.get();
    }

    public StringProperty partNoProperty() {
        return partNo;
    }

    public void setPartNo(String partNo) {
        this.partNo.set(partNo);
    }

    public String getManufacturer() {
        return manufacturer.get();
    }

    public StringProperty manufacturerProperty() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer.set(manufacturer);
    }

    public String getStartCondition() {
        return startCondition.get();
    }

    public StringProperty startConditionProperty() {
        return startCondition;
    }

    public void setStartCondition(String startCondition) {
        this.startCondition.set(startCondition);
    }

    public String getAddFunction() {
        return addFunction.get();
    }

    public StringProperty addFunctionProperty() {
        return addFunction;
    }

    public void setAddFunction(String addFunction) {
        this.addFunction.set(addFunction);
    }

    public String getYourName() {
        return yourName.get();
    }

    public StringProperty yourNameProperty() {
        return yourName;
    }

    public void setYourName(String yourName) {
        this.yourName.set(yourName);
    }

    public String getCompany() {
        return company.get();
    }

    public StringProperty companyProperty() {
        return company;
    }

    public void setCompany(String company) {
        this.company.set(company);
    }

    public String getDate() {
        return date.get();
    }

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getChangeLevel() {
        return changeLevel.get();
    }

    public StringProperty changeLevelProperty() {
        return changeLevel;
    }

    public void setChangeLevel(String changeLevel) {
        this.changeLevel.set(changeLevel);
    }

    public String getUnitNo() {
        return unitNo.get();
    }

    public StringProperty unitNoProperty() {
        return unitNo;
    }

    public void setUnitNo(String unitNo) {
        this.unitNo.set(unitNo);
    }

    public String getFunctionDesc() {
        return functionDesc.get();
    }

    public StringProperty functionDescProperty() {
        return functionDesc;
    }

    public void setFunctionDesc(String functionDesc) {
        this.functionDesc.set(functionDesc);
    }

    public String getAddPartNo() {
        return addPartNo.get();
    }

    public StringProperty addPartNoProperty() {
        return addPartNo;
    }

    public void setAddPartNo(String addPartNo) {
        this.addPartNo.set(addPartNo);
    }

    public String getPanelRef() {
        return panelRef.get();
    }

    public StringProperty panelRefProperty() {
        return panelRef;
    }

    public void setPanelRef(String panelRef) {
        this.panelRef.set(panelRef);
    }

    public String getCylinderBore() {
        return cylinderBore.get();
    }

    public StringProperty cylinderBoreProperty() {
        return cylinderBore;
    }

    public void setCylinderBore(String cylinderBore) {
        this.cylinderBore.set(cylinderBore);
    }

    public String getOpenAngle() {
        return openAngle.get();
    }

    public StringProperty openAngleProperty() {
        return openAngle;
    }

    public void setOpenAngle(String openAngle) {
        this.openAngle.set(openAngle);
    }

    public String getToolManufacturer() {
        return toolManufacturer.get();
    }

    public StringProperty toolManufacturerProperty() {
        return toolManufacturer;
    }

    public void setToolManufacturer(String toolManufacturer) {
        this.toolManufacturer.set(toolManufacturer);
    }

    public String getSensorType() {
        return sensorType.get();
    }

    public StringProperty sensorTypeProperty() {
        return sensorType;
    }

    public void setSensorType(String sensorType) {
        this.sensorType.set(sensorType);
    }

    public String getSwitchNumber() {
        return switchNumber.get();
    }

    public StringProperty switchNumberProperty() {
        return switchNumber;
    }

    public void setSwitchNumber(String switchNumber) {
        this.switchNumber.set(switchNumber);
    }

    public String getIntegralBrake() {
        return integralBrake.get();
    }

    public StringProperty integralBrakeProperty() {
        return integralBrake;
    }

    public void setIntegralBrake(String integralBrake) {
        this.integralBrake.set(integralBrake);
    }

    public String getChangeDescription() {
        return changeDescription.get();
    }

    public StringProperty changeDescriptionProperty() {
        return changeDescription;
    }

    public void setChangeDescription(String changeDescription) {
        this.changeDescription.set(changeDescription);
    }

    public String getExcelFilePath() {
        return excelFilePath.get();
    }

    public StringProperty excelFilePathProperty() {
        return excelFilePath;
    }

    public void setExcelFilePath(String excelFilePath) {
        this.excelFilePath.set(excelFilePath);
    }

    public ObservableList<String> getUserComponents() {
        return userComponents;
    }

    public void setUserComponents(List<String> userComponents) {
        this.userComponents.setAll(userComponents);
    }

    public ObservableList<String> getComponentStates() {
        return componentStates;
    }

    public void setComponentStates(List<String> states) {
        this.componentStates.setAll(states);
    }

    public int getSelectedComponentIndex() {
        return selectedComponentIndex.get();
    }

    public IntegerProperty selectedComponentIndexProperty() {
        return selectedComponentIndex;
    }

    public void setSelectedComponentIndex(int selectedComponentIndex) {
        this.selectedComponentIndex.set(selectedComponentIndex);
    }

    public String getSelectedComponent() {
        return selectedComponent.get();
    }

    public StringProperty selectedComponentProperty() {
        return selectedComponent;
    }

    public void setSelectedComponent(String selectedComponent) {
        this.selectedComponent.set(selectedComponent);
    }

    public String getSelectedComponentInfo1() {
        return selectedComponentInfo1.get();
    }

    public StringProperty selectedComponentInfo1Property() {
        return selectedComponentInfo1;
    }

    public void setSelectedComponentInfo1(String selectedComponentInfo1) {
        this.selectedComponentInfo1.set(selectedComponentInfo1);
    }

    public String getSelectedComponentInfo2() {
        return selectedComponentInfo2.get();
    }

    public StringProperty selectedComponentInfo2Property() {
        return selectedComponentInfo2;
    }

    public void setSelectedComponentInfo2(String selectedComponentInfo2) {
        this.selectedComponentInfo2.set(selectedComponentInfo2);
    }

    public String getSelectedComponentInfo3() {
        return selectedComponentInfo3.get();
    }

    public StringProperty selectedComponentInfo3Property() {
        return selectedComponentInfo3;
    }

    public void setSelectedComponentInfo3(String selectedComponentInfo3) {
        this.selectedComponentInfo3.set(selectedComponentInfo3);
    }

    public String getSelectedState() {
        return selectedState.get();
    }

    public StringProperty selectedStateProperty() {
        return selectedState;
    }

    public void setSelectedState(String selectedState) {
        this.selectedState.set(selectedState);
    }
}
