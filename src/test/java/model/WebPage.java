package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class WebPage extends BasePage {

//    @FindBy(css = "section[aria-labelledby='smart-watchlist-title'] .sbnBtf li")
    @FindBy(css = ".rt-table .rt-tr-group > .rt-tr:not(.-padRow)")
    private List<WebElement> listAllRows;

    public WebPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getTable() {
        return listAllRows.stream().map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<List<String>> getRows() {
        return listAllRows.stream().map(row -> row.findElements(By.className("rt-td")))
                .map(list -> list.stream().map(WebElement::getText)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
