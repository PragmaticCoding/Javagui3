package com.javagui.mvc;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class Interactor {

    private final Model model;

    String[][] userComponentInputs;
    private String alphabetLetter;
    private int currentComponentIndex = 1;
    private char alphabet;

    public Interactor(Model model) {
        this.model = model;
    }

    public void readExcel() {
        FileInputStream fis = null;
        XSSFWorkbook workBook = null;
        try {
            fis = new FileInputStream(model.getExcelFilePath());
            workBook = new XSSFWorkbook(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        XSSFSheet contentSheet = workBook.getSheetAt(0);
        userComponentInputs = new String[contentSheet.getLastRowNum() + 1][12];
        for (int componentRows = 4; componentRows <= contentSheet.getLastRowNum(); componentRows++) {
            XSSFRow iteratedRow = contentSheet.getRow(componentRows);
            Iterator<Cell> cellIterator = iteratedRow.cellIterator();
            while (cellIterator.hasNext()) {
                XSSFCell chosenCell = (XSSFCell) cellIterator.next();
                switch (chosenCell.getCellType()) {
                    case STRING:
                        userComponentInputs[iteratedRow.getRowNum()][chosenCell.getColumnIndex()] = chosenCell.getStringCellValue();
                        System.out.print(userComponentInputs[iteratedRow.getRowNum()][chosenCell.getColumnIndex()]);
                        break;
                    case BOOLEAN:
                        //System.out.print(chosenCell.getBooleanCellValue());
                        break;
                    case NUMERIC:
                        //System.out.print(chosenCell.getNumericCellValue());
                        break;
                    case BLANK:
                        System.out.print(" ");
                        break;
                    default:
                        break;
                }
                System.out.print(" | ");
            }
            System.out.println(" ");
        }

        try {
            fis.close();
            workBook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int iterate = 4; iterate < userComponentInputs.length; iterate++) {
            model.getUserComponents().add(userComponentInputs[iterate][2]);
        }
        System.out.println();
    }

    public void saveExcel() {
        try {
            Object[] columnHeaderNames = {model.getCustomerName(), model.getXta(), model.getZone(), model.getStation(),
                    model.getToolNumber(), model.getSheet(), model.getProjectName(),
                    model.getMachineDescription(), model.getRobot()};
            FileInputStream fis = new FileInputStream(model.getExcelFilePath());
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            for (int n = 0; n < 3; n++) {
                XSSFSheet sheet = workBook.getSheetAt(n);
                Iterator<Row> rowIterator = sheet.iterator();
                model.setSheet(workBook.getSheetIndex(sheet.getSheetName()) + "Out of" + workBook.getNumberOfSheets());
                while (rowIterator.hasNext()) {
                    XSSFRow currentRow = (XSSFRow) rowIterator.next();
                    if (currentRow.getFirstCellNum() != -1 && currentRow.getRowNum() == 2) {
                        System.out.println("im populating the correct row");
                        for (int i = 0; i < 9; i++) {
                            XSSFCell currentCell = currentRow.getCell(i);
                            if (currentCell != null) {
                                if (currentCell.getStringCellValue().contains("Out of")) {
                                    i++;
                                } else {
                                    currentCell.setCellValue((String) columnHeaderNames[i]);
                                }
                            } else {
                                i = 9;
                            }
                        }
                    } else {
                        System.out.println(currentRow.getRowNum());
                    }
                }
            }
            FileOutputStream fos = new FileOutputStream(model.getExcelFilePath());
            workBook.write(fos);
            fos.close();
            workBook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void addComponent() {
        try {
            FileInputStream fis = new FileInputStream(model.getExcelFilePath());
            XSSFWorkbook workBook = new XSSFWorkbook(fis);

            XSSFSheet sheet = workBook.getSheet("Content");
            XSSFSheet sheet2 = workBook.getSheet("Sequence");

            int rowCount = sheet.getLastRowNum() + 1;
            int rowCountSequence = sheet2.getLastRowNum() + 1;
            currentComponentIndex++;
            if (rowCount <= 5) {
                alphabet = 'A';
            } else if (alphabetLetter == null) {
                alphabet = 'A';
                alphabet += sheet.getLastRowNum() - 5;
                currentComponentIndex = sheet.getLastRowNum() - 5;
            }

            int alphabetInt = rowCount - sheet.getLastRowNum();
            alphabet += alphabetInt;
            alphabetLetter = Character.toString(alphabet);
            System.out.println(alphabetLetter);

            Object[] componentInputs = {alphabetLetter, Integer.toString(currentComponentIndex), model.getFunctionDesc(), model.getAddPartNo(), "NULL", "NULL", "NULL",
                    model.getToolManufacturer(), "NULL", "NULL", "NULL", model.getStartCondition(),};

            Object[] sequenceInputs = {alphabetLetter, Integer.toString(currentComponentIndex), "NULL", "NULL", "NULL", "NULL", "NULL"};

            XSSFRow currentRow = sheet.getRow(rowCount);
            XSSFRow currentSequenceRow = sheet2.getRow(rowCountSequence);
            if (currentRow == null) {
                currentRow = sheet.createRow(rowCount);
                currentSequenceRow = sheet2.createRow(rowCountSequence);
            }
            System.out.println(currentRow.getRowNum());
            System.out.println("im populating correctly");

            for (int i = 0; i < 12; i++) {
                XSSFCell currentCell = currentRow.getCell(i);
                if (currentCell == null) {
                    currentCell = currentRow.createCell(i);
                }
                currentCell.setCellValue((String) componentInputs[i]);
            }

            for (int i = 0; i < 7; i++) {
                XSSFCell currentSequenceCell = currentSequenceRow.getCell(i);
                if (currentSequenceCell == null) {
                    currentSequenceCell = currentSequenceRow.createCell(i);
                }
                currentSequenceCell.setCellValue((String) sequenceInputs[i]);
            }
            FileOutputStream fos = new FileOutputStream(model.getExcelFilePath());
            workBook.write(fos);
            fos.close();
            workBook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void chooseComponent() throws IOException {
        String selectedComponent = model.getSelectedComponent();
        int selectedComponentIndex = model.getSelectedComponentIndex() + 4;
        model.setSelectedComponentInfo1("Selected Component: " + selectedComponent);
        String result = String.join(" , \n", userComponentInputs[selectedComponentIndex]);
        model.setSelectedComponentInfo1(result);

        if (model.getSelectedState().isEmpty()) {
            model.setComponentStates(Arrays.asList("POS 1", "POS 2"));
        }
    }

}
