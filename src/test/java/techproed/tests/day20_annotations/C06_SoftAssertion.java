package techproed.tests.day20_annotations;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class C06_SoftAssertion {

    @Test
    public void test01() {

        SoftAssert softAssert = new SoftAssert();
        System.out.println("1====> kod akısı devam ediyor");
        softAssert.assertEquals(12, 2);
        System.out.println("2====> kod akısı devam ediyor");

        softAssert.assertNotEquals(2, 2);
        System.out.println("3====> kod akısı devam ediyor");

        softAssert.assertTrue(false);
        System.out.println("4====> kod akısı devam ediyor");

        softAssert.assertFalse(true);
        System.out.println("5====> kod akısı devam ediyor");

        softAssert.assertAll();
        System.out.println("BU METNI KONSOLDA GOREMEYECEGİZ CUNKU FAIL OLDUGU İCİN CALİSMAYACAK");

    }


}