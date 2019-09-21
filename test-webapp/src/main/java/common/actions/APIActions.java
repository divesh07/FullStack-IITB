package common.actions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sun.org.apache.bcel.internal.Const;
import cucumber.api.java.en.Then;
import gherkin.deps.com.google.gson.JsonElement;
import org.json.simple.JSONValue;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class APIActions {
    private static final Logger LOG = LoggerFactory.getLogger(APIActions.class);

    private final WebDriver driver;

    private String access_token;

    private String cust_id;

    private String paymentSession;

    private String order_id;

    private String amount;

    private String payload;

    private String pspReference;

    private String card_number;

    private String card_brand;

    private String saved_card_id;

    private String expiry;

    private String item_category;

    private String item_name;

    private int discount_price;

    private int stock_quantity;

    private int price;


    public APIActions(SharedDriver driver) {
        this.driver = driver;
    }

    @Then("^verify customer login$")
    public void verifyCustomerLogin() throws Exception {
        MultivaluedMap<String, String> formData = new MultivaluedHashMap<String, String>();
        formData.add("email", Constants.CUSTOMER_USERNAME);
        formData.add("password", Constants.CUSTOMER_PASSWORD);

        Map<String, String> params = new HashMap<>();
        params.put("store_id", Constants.STORE_ID);

        Response loginPost = Util.sendPostRequestWithParams(Constants.LOGIN_URL, formData , params);
        Util.verifyExpectedResponse(loginPost, Response.Status.OK);

        JSONParser responseParser = new JSONParser();
        JSONObject responseObject = (JSONObject) responseParser.parse(Util.readResponse(loginPost));
        JSONObject result = (JSONObject) responseObject.get("result");
        cust_id = (String) result.get("cus_id");
        access_token = (String) result.get("access_token");
    }


    @Then("^verify payment session creation$")
    public void verifyGetOrSaveCardAPI() throws Exception {
        MultivaluedMap<String, String> formData = new MultivaluedHashMap<String, String>();
        formData.add("channel", "Web");
        formData.add("psp_type", "adyen");
        formData.add("store_id", "a472977e-24ed-409a-a203-94565637dbc9");
        formData.add("payment_method", "saved_card");
        formData.add("token", "");
        formData.add("returnUrl", "https://webapp.mishipay.com/payment");
        formData.add("sdk_version", "1.9.2");
        formData.add("origin", "https://webapp.mishipay.com");

        Map<String, String> params = new HashMap<>();
        params.put("store_id", Constants.STORE_ID);

        Response response = Util.sendPostRequestWithParamsAndToken(Constants.GET_SAVE_CARD_URL, formData , params, access_token);
        Util.verifyExpectedResponse(response, Response.Status.OK);

        JSONParser responseParser = new JSONParser();
        JSONObject responseObject = (JSONObject) responseParser.parse(Util.readResponse(response));
        JSONObject result = (JSONObject) responseObject.get("data");
        paymentSession = (String) result.get("paymentSession");
        order_id = (String) result.get("order_id");
        amount = (String) result.get("amount");
    }

    @Then("^initialize payment$")
    public void initPaymentAPI() throws Exception {

        Map<String, String> params = new HashMap<>();
        params.put("token", Constants.TOKEN_ID);

        Response response = Util.sendPostRequestWithParams(Constants.PAYMENT_INIT_URL, Constants.PAYMENT_DATA , params);
        Util.verifyExpectedResponse(response, Response.Status.OK);

        JSONParser responseParser = new JSONParser();
        JSONObject responseObject = (JSONObject) responseParser.parse(Util.readResponse(response));
        payload = (String) responseObject.get("payload");

    }

    @Then("^verify payment$")
    public void verifyPaymentAPI() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("store_id", Constants.STORE_ID);

        MultivaluedMap<String, String> formData = new MultivaluedHashMap<String, String>();
        formData.add("channel", "Web");
        formData.add("psp_type", "adyen");
        formData.add("store_id", Constants.STORE_ID);
        formData.add("order_id", order_id);
        formData.add("payment_method", "credit_card");
        formData.add("payload", payload);

        Response response = Util.sendPostRequestWithParamsAndToken(Constants.VERIFY_PAYMENT_URL, formData , params, access_token);
        Util.verifyExpectedResponse(response, Response.Status.OK);

        JSONParser responseParser = new JSONParser();
        JSONObject responseObject = (JSONObject) responseParser.parse(Util.readResponse(response));
        JSONObject result = (JSONObject) responseObject.get("data");
        pspReference = (String) result.get("pspReference");
    }

    @Then("^get card details$")
    public void getCardDetailsAPI() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("store_id", Constants.STORE_ID);

        Response response = Util.sendGetRequestWithParams(Constants.GET_SAVE_CARD_URL, access_token, params);
        Util.verifyExpectedResponse(response, Response.Status.OK);

        JSONParser responseParser = new JSONParser();
        JSONObject responseObject = (JSONObject) responseParser.parse(Util.readResponse(response));
        JSONObject result = (JSONObject) responseObject.get("data");
        JSONArray saved_cards = (JSONArray) result.get("saved_cards");
        JSONObject cardDetails = (JSONObject) saved_cards.get(0);
        card_number = (String) cardDetails.get("card_number");
        card_brand = (String) cardDetails.get("card_brand");
        saved_card_id = (String) cardDetails.get("saved_card_id");
        expiry = (String) cardDetails.get("expiry");
    }

    @Then("^test item scan$")
    public void scanProductsAPI() throws Exception {
        Map<String, String> params = new HashMap<>();
        params.put("store_id", Constants.STORE_ID);
        params.put("customer_id", cust_id);
        params.put("product_identifier", Constants.PRODUCT_IDENTIFIER);
        params.put("product_identifier_type", "qr");

        Response response = Util.sendGetRequestWithParams(Constants.GET_SAVE_CARD_URL, access_token, params);
        Util.verifyExpectedResponse(response, Response.Status.OK);

        JSONParser responseParser = new JSONParser();
        JSONObject responseObject = (JSONObject) responseParser.parse(Util.readResponse(response));
        JSONObject result = (JSONObject) responseObject.get("data");
        item_category = (String) result.get("item_category");
        item_name = (String) result.get("item_name");
        item_name = (String) result.get("item_name");
        discount_price = (int) result.get("discount_price");
        stock_quantity = (int) result.get("stock_quantity");
        price = (int) result.get("price");

    }



}
