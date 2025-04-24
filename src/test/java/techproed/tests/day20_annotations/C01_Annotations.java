package techproed.tests.day20_annotations;

import org.testng.annotations.*;

public class C01_Annotations {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Herseyden önce @BeforeSuite notasyonuna sahip method 1 kez calisir");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Herseyden sonra @AfterSuite notasyonuna sahip method 1 kez calisir");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Testlerden önce @BeforeTest notasyonuna sahip method 1 kez calisir");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Testlerden sonra @AfterTest notasyonuna sahip method 1 kez calisir");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Her class tan önce @BeforeClass notasyonuna sahip method 1 kez calisir");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Her class tan sonra @AfterClass notasyonuna sahip method 1 kez calisir");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("@BeforeMethod notasyonuna sahip method her test methodundan önce 1 kez calisir");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("@AfterMethod notasyonuna sahip method her test methodundan sonra 1 kez calisir");
    }

    @Test
    public void test01() {
        System.out.println("test01 methodu calisti");
    }

    @Test
    public void test02() {
        System.out.println("test02 methodu calisti");
    }

    @Test
    public void test03() {
        System.out.println("test03 methodu calisti");
    }


}