package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProvidersSignUp {




        @DataProvider(name ="SignUpData")
        public String [][] getData() throws IOException
        {
            String path =".\\testdata\\LoginData.xlsx";//taking xl file from testdata
            ExcelUtility xlutil = new ExcelUtility(path); //creating an object for XLUtility

            int totalrows= xlutil.getRowCount("Sheet2");
            int totalcols = xlutil.getCellCount("Sheet2",1);

            String SignUpData[][] = new String[totalrows][totalcols]; //created two dimension array which can stored

            for(int i=1;i<=totalrows;i++)
            {
                for(int j=0;j<totalcols;j++)
                {
                    SignUpData[i-1][j]=xlutil.getCellData("Sheet2",i,j);
                }
            }
            return SignUpData;

        }
    }


