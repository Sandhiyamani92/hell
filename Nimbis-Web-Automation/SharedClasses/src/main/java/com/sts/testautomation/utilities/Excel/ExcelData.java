package com.sts.testautomation.utilities.Excel;

import com.poiji.annotation.ExcelRow;
import com.poiji.annotation.ExcelUnknownCells;

import java.util.Map;

public class ExcelData {
    @ExcelRow
    public int rowIndex;

    @ExcelUnknownCells // gets all columns
    public Map<String, String> cell;

    @Override
    public String toString() {
        return "Data{" +
                "rowIndex=" + rowIndex +
                ", cells=" + cell +
                '}';
    }
}
