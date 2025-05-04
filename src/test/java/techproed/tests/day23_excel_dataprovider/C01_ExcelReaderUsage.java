package techproed.tests.day23_excel_dataprovider;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;


public class C01_ExcelReaderUsage {

    @Test(groups ="smoke")
    public void test01() {

        String dosyaYolu="src/test/java/techproed/resources/smoketestdata.xlsx";
        String sayfaIsmi="Sayfa1";

        ExcelReader excelReader = new ExcelReader(dosyaYolu, sayfaIsmi);

        String email = excelReader.getCellData(0, 0);
        String password = excelReader.getCellData(0, 1);

        System.out.println("email = " + email);
        System.out.println("password = " + password);

    }
}