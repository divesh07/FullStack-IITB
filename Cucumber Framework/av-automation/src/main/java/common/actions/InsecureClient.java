package common.actions;

import org.apache.log4j.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Jersey client that does not verify SSL certificates.
 * To be used for tooling and test code only.
 */
public class InsecureClient extends RestClient {
    private static final Logger LOG = Logger.getLogger(InsecureClient.class);

    private static final TrustManager[] allTrustingCertManager = new TrustManager[]{new InsecureTrustManager()};

    private static final SSLContext insecureSslContext;

    private InsecureClient() {
    }

    static {
        LOG.warn("Seeing this line in server logs is a coding ERROR");
        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("TLS");
            ctx.init(null, allTrustingCertManager, new SecureRandom());
        } catch (Exception e) {
            LOG.error("Failed to create SSLContext: ", e);
            System.exit(1);
        }
        insecureSslContext = ctx;
    }

    /**
     * Create a create builder using a client that performs no SSL validation
     *
     * @param path
     * @param queryParams        - ordinary Map for backward compatibility
     * @param acceptedMediaTypes
     * @param authToken
     * @return javax.ws.rs.client.Invocation.Builder
     */
    public static Invocation.Builder createRequestBuilder(String path,
                                                          Map<String, String> queryParams,
                                                          List<MediaType> acceptedMediaTypes,
                                                          String authToken) {
        return RestClient.createRequestBuilder(createClient(), path, queryParams, acceptedMediaTypes, authToken);
    }

    /**
     * Create a create builder using a client that performs no SSL validation
     *
     * @param path
     * @param queryParams        - MultiValueMap to allow multiple values per param
     * @param acceptedMediaTypes
     * @param authToken
     * @return javax.ws.rs.client.Invocation.Builder
     */
    public static Invocation.Builder createRequestBuilder(String path,
                                                          MultivaluedMap<String, String> queryParams,
                                                          List<MediaType> acceptedMediaTypes,
                                                          String authToken) {
        return RestClient.createRequestBuilder(createClient(), path, queryParams, acceptedMediaTypes, authToken);
    }

    /**
     * reate a create builder using a client that performs no SSL validation
     *
     * @param path
     * @param acceptedMediaTypes
     * @param authToken
     * @return
     */
    public static Invocation.Builder createRequestBuilder(String path,
                                                          List<MediaType> acceptedMediaTypes,
                                                          String authToken) {
        return RestClient.createRequestBuilder(createClient(), path, Collections.emptyMap(), acceptedMediaTypes, authToken);
    }

    /**
     * Jersey client that performs no SSL validation of hostnames or certificates
     *
     * @return javax.ws.rs.client.Client
     */
    public static Client createClient() {
        return RestClient.getBuilder()
                .sslContext(insecureSslContext)
                .hostnameVerifier((s1, s2) -> true)
                .build();
    }

    /**
     * This should not be copied for anything that might run in production
     */
    private static class InsecureTrustManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }

        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }
    }
}
