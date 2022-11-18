package db;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver oDriver;

    public HashMapNew dictionary;

    public BasePage(WebDriver oDriver, HashMapNew dictionary) {
        this.oDriver = oDriver;

        this.dictionary = dictionary;
        PageFactory.initElements(oDriver, this);
    }

    DataBase db = new DataBase(dictionary, DataBase.DBType.POSTGRESQL);

    public BasePage() {

    }
}
