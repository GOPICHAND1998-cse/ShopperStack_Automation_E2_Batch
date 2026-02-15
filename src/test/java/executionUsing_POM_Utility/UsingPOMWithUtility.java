package executionUsing_POM_Utility;

import pomPackage.HomePagePOM;
import pomPackage.LogInPagePOM;
import utilityPackage.ActionsUtility;
import utilityPackage.BrowserUtility;
import utilityPackage.PropertyFileutility;

public class UsingPOMWithUtility
{
    public static String browser;
    public static String email;
    public static String password;
    public static String url;

    PropertyFileutility property;
    BrowserUtility browserUtil;
    ActionsUtility actionUtil;

    HomePagePOM home;
    LogInPagePOM login;

    public static void main(String[] args) {

        try
        {

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
