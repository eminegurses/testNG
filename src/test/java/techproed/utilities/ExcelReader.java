package techproed.utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;


public class ExcelReader {

    Workbook workbook;
    Sheet sheet;

    //Bu classtan obje olusturulmasinin amaci excel dosyasini okumaktir
    // Bir excel dokümani ni okuyabilmek icin gerekli olan bazi adimlari
    // burada hallederek altyapiyi olusturduk

    public ExcelReader(String dosyaYolu, String sayfaIsmi) {

        try {
            FileInputStream fis = new FileInputStream(dosyaYolu);

            workbook = WorkbookFactory.create(fis);
            sheet = workbook.getSheet(sayfaIsmi);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Satır ve Sütun sayılarını girdiğimizde, hücredeki datayı return eder
    public String getCellData(int satir, int sutun) {
        Cell cell = sheet.getRow(satir).getCell(sutun);
        return cell.toString();
    }


    //Exceldeki son satırin indexini return eder
    public int rowCount() {
        return sheet.getLastRowNum();
    }

}