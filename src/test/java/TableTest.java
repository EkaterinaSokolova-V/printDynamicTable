import base.BaseTest;
import model.WebPage;
import org.testng.annotations.Test;

import java.util.List;

public class TableTest extends BaseTest {

    @Test
    public void printGoogleTable() {
        WebPage googlePage = new WebPage(getDriver());
//        List<List<String>> table = googlePage.getRows();
        List<String> table = googlePage.getTable();
        System.out.println(table);

        for (int i = 0; i < table.size(); i++) {
            int ind = table.get(i).lastIndexOf("\n");

            String[] row = table.get(i).substring(0, ind).split("\n");

            for (int j = 0; j < row.length; j++) {
                String s = String.format("%-32s", row[j]);
                System.out.print(s);
            }
            System.out.println();
        }
    }

}
