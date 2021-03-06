package tests.mfc;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import configuration.DataProviders;
import configuration.MFC_testConfig;

import static site.Data.WebElements.JobMenu_WebElements.Job_Operations_button;
import static site.Data.WebElements.Operation_CV.New_Operation_button;
import static site.Data.WebElements.Operation_CV.WarehouseOutload_button;

/**
 * Created by Lena on 22.10.2019.
 */
public class WarehouseOutload implements MFC_testConfig {



    @Test(priority=1,dataProviderClass = DataProviders.class, dataProvider = "createFileForNewClient")
    public void init(By locatorlanguage, String bookingType, String source, String jobType,
                     String mode, String serviceType, String serviceLevel,
                     String firstName, String lastName, String email, String phone,
                     String country1, String country2, String city1, String city2,
                     String street1, String street2, String zip1, String zip2) {

        appMFC.getUserMenu_Metods().changeLanguage(locatorlanguage);
        appMFC.getMainMenu_Metods().Job_GridScreen_Open();
        String client = firstName + " " + lastName;
        appMFC.getJobGrid_Metods().openJobByClientName(client);
        appMFC.getJobGrid_Metods().OpenPage(Job_Operations_button, "Transaction/ClientFileGrid");
        appMFC.getJobGrid_Metods().click(New_Operation_button);
        appMFC.getJobGrid_Metods().click(WarehouseOutload_button);
        appMFC.getJobGrid_Metods().waitForElementByNOTvisibility(By.xpath("//span[@class='spinner']"));
        appMFC.getWarehouseOutload_Metods().clickOnAddStaff_button();
        appMFC.getWarehouseOutload_Metods().selectStaffFromDropdownInPopup();
        appMFC.getWarehouseOutload_Metods().clickOnAddButtonOnAddStaffPopup();
        appMFC.getWarehouseOutload_Metods().selectStaffInStaffGrid();
        appMFC.getWarehouseOutload_Metods().clickOnStaffTime_button();
        appMFC.getWarehouseOutload_Metods().clickOnAddTimeSheetButtonInTimesSheetWindow();
        appMFC.getWarehouseOutload_Metods().clickCloseButtonOnTimesSheetWindow();
        appMFC.getWarehouseOutload_Metods().clickOnStaffImportToExpenseButton();
    }




}
