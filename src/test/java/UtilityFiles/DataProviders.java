package UtilityFiles;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException {

        String path = ".\\TestData\\Opencart_LoginData.xlsx";
        ExcelUtility xlutil = new ExcelUtility(path);

        int rowcount = xlutil.getRowCount("Sheet1");
        int cellcount = xlutil.getCellCount("Sheet1", 1);

        String logindata[][] = new String[rowcount][cellcount];

        for (int i = 1; i <= rowcount; i++) {
            for (int j = 0; j < cellcount; j++) {
                logindata[i-1][j]=xlutil.getCellData("Sheet1",i,j);
            }
        }
        return logindata;
    }

}
