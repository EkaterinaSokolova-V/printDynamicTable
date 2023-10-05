import base.BaseTest;
import model.WebPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;

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

    @Test
    public void printDemoWebTables() {
        WebPage webTable = new WebPage(getDriver());
        List<List<String>> table = webTable.getRows();

        for (List<String> row : table) {
            StringBuilder builder = new StringBuilder();
            for (String value : row) {
                builder.append(value).append(" ");
            }
            System.out.println(builder);
            System.out.println();
        }

        assertFalse(table.isEmpty());
    }
}
