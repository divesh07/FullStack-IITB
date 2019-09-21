package common.actions;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WebElementMappingConstants {
    public static final Map<String, String> uiToTest;
    static {
        Map<String, String> uiToTestTemp = new HashMap<>();
        //Generic
        uiToTestTemp.put("Scan", "//*[contains(text(),'Scan')]");
        uiToTestTemp.put("Pay", "//*[contains(text(),'Pay')]");
        uiToTestTemp.put("Leave", "//*[contains(text(),'Leave')]");
        uiToTestTemp.put("Next", "//button[contains(text(),'')]");
        uiToTestTemp.put("Login", "//button[contains(text(),'')]");
        uiToTestTemp.put("ShowStores", "//button[contains(text(),'')]");
        uiToTestTemp.put("MishipayGlobalStore", "//*[contains(text(),'Mishipay Global Store')]");
        uiToTestTemp.put("StoreLogin", "//button[contains(text(),'')][2]");
        uiToTestTemp.put("StoreRegister", "//button[contains(text(),'')][1]");



        uiToTest = Collections.unmodifiableMap(uiToTestTemp);
    }
}
