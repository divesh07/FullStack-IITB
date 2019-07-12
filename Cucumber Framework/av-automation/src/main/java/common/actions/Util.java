package common.actions;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class Util {

    private static final Logger LOG = LoggerFactory.getLogger(Util.class);

    private static final int SSH_CONNECT_TIMEOUT = 2000;

    private static final int VM_REACHABLE_RETRY_INTERVAL = 30000;

    public static final Client JERSEYCLIENT;

    static {
        JERSEYCLIENT = InsecureClient.createClient();
    }

    /**
     * GET Request
     *
     * @param url
     * @param jwt
     * @return
     * @throws IOException
     * @throws KeyManagementException
     * @throws NoSuchAlgorithmException
     */
    public static Response sendGetRequest(String url, String jwt) throws IOException, KeyManagementException,
            NoSuchAlgorithmException {
        return sendGetRequest(url, jwt, MediaType.APPLICATION_JSON);
    }

    public static Response sendGetRequest(String url, String jwt, String... mediaTypeStrings) throws IOException, KeyManagementException,
            NoSuchAlgorithmException {
        WebTarget target = JERSEYCLIENT.target(url);
        LOG.info("Sending GET REQUEST URL = {}", url);
        LOG.debug("Sending GET REQUEST JWT = {}", jwt);
        Response getResponse = target.request(mediaTypeStrings).header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt)
                .get(Response.class);
        LOG.info("GET request response = {}", getResponse);
        return getResponse;
    }

    public static Response sendGetRequestWithParams(String url, String jwt, Map<String, Object> queryParam) throws IOException, KeyManagementException,
            NoSuchAlgorithmException {
        url = url + "?filter=";
        WebTarget target = JERSEYCLIENT.target(url);
        for (Map.Entry<String, Object> entry : queryParam.entrySet()) {
            target = target.queryParam(entry.getKey(), entry.getValue());
        }
        LOG.info("Sending get request with Query Param {}", target.toString());
        LOG.info("Sending GET REQUEST URL = {}", url);
        LOG.debug("Sending GET REQUEST JWT = {}", jwt);
        Response getResponse = target.request(MediaType.APPLICATION_JSON).header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt)
                .get(Response.class);
        LOG.info("GET request response = {}", getResponse);
        return getResponse;
    }

    /**
     * POST Request without JSON Web Token(jwt)
     *
     * @param url
     * @param input
     * @return response
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static Response sendPostRequest(String url, String input) throws IOException, NoSuchAlgorithmException,
            KeyManagementException {
        WebTarget target = JERSEYCLIENT.target(url);
        LOG.info("Sending POST REQUEST URL = {}", url);
        LOG.info("Sending POST REQUEST INPUT = {}", input);
        Response postResponse = target.request(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON).post(Entity.json(input));
        LOG.info("POST request response = {}", postResponse);
        return postResponse;
    }

    /**
     * POST Request using JSON Web Token(jwt)
     *
     * @param url
     * @param jwt
     * @param input
     * @return response
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static Response sendPostRequest(String url, String jwt, String input) throws IOException, KeyManagementException,
            NoSuchAlgorithmException {
        WebTarget target = JERSEYCLIENT.target(url);
        LOG.info("Sending POST REQUEST URL = {}", url);
        LOG.info("Sending POST REQUEST INPUT = {}", input);
        Response postResponse = target.request(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt).post(Entity.json(input));
        LOG.info("POST request response = {}", postResponse);
        return postResponse;
    }

    /**
     * PUT Request using JSON Web Token(jwt)
     *
     * @param url
     * @param jwt
     * @param input
     * @return response
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static Response sendPutRequest(String url, String jwt, String input) throws IOException, KeyManagementException,
            NoSuchAlgorithmException {
        WebTarget target = JERSEYCLIENT.target(url);
        LOG.info("Sending PUT REQUEST URL = {}", url);
        LOG.info("Sending PUT REQUEST INPUT = {}", input);
        Response putResponse = target.request(MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt).put(Entity.json(input));
        LOG.info("POST request response = {}", putResponse);
        return putResponse;
    }

    /**
     * DELETE Request
     *
     * @param url
     * @param jwt
     * @return response
     * @throws IOException
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     */
    public static Response sendDeleteRequest(String url, String jwt) throws IOException, KeyManagementException,
            NoSuchAlgorithmException {
        WebTarget target = JERSEYCLIENT.target(url);
        LOG.info("Sending DELETE REQUEST URL = {}", url);
        LOG.debug("Sending DELETE REQUEST JWT = {}", jwt);
        Response deleteResponse = target.request(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + jwt).delete();
        LOG.info("DELETE request response = {}", deleteResponse);
        return deleteResponse;
    }

    /**
     * Read JSON response
     */
    public static String readResponse(Response response) throws IOException {
        return response.readEntity(String.class);
    }

    /**
     * Verify expected response
     */
    public static void verifyExpectedResponse(Response response, Status expectedStatus) throws Exception {
        if (response.getStatus() != expectedStatus.getStatusCode()) {
            throw new Exception("Expected response code: " + expectedStatus.getStatusCode() + " Actual response code: "
                    + response.getStatus() + " Reason: " + response.getStatusInfo().getReasonPhrase() + "\n Response: "
                    + readResponse(response));
        } else {
            LOG.info("RESPONSE OK EXPECTED {} ACTUAL {}", expectedStatus.getStatusCode(), response.getStatus());
        }
    }
}