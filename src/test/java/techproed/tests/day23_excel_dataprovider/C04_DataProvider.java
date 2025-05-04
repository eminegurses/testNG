package techproed.tests.day23_excel_dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C04_DataProvider {


    @DataProvider
    public static Object[][] isimler() {
        return new Object[][]{
                {"Ruhin",19,true},
                {"Ayse",16,true},
                {"Seval",13,false},
                {"Tuğberk",17,true}
        };
    }
    @Test(dataProvider = "isimler")
    public void test01(String data,Integer age, Boolean isSuccess) {
        System.out.println(data+" "+age+" "+isSuccess);
    }


}
