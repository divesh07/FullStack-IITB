package common.actions;

import com.google.common.net.HttpHeaders;
import org.glassfish.jersey.jsonp.JsonProcessingFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import javax.json.stream.JsonGenerator;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Jersey client utility methods to be used for tooling and test code only.
 */
public class RestClient {
    /**
     * Create a create builder using a client that performs no SSL validation
     *
     * @param c                  The client instance
     * @param path
     * @param queryParams        Allows lists for multiple values per param
     * @param acceptedMediaTypes
     * @param authToken
     * @return javax.ws.rs.client.Invocation.Builder
     */
    public static Invocation.Builder createRequestBuilder(Client c,
                                                          String path,
                                                          Map<String, ?> queryParams,
                                                          List<MediaType> acceptedMediaTypes,
                                                          String authToken) {
        WebTarget target = c.target(path);

        if (queryParams != null) {
            for (Map.Entry<String, ?> qp : queryParams.entrySet()) {
                if (qp.getValue() instanceof Collection<?>) {
                    for (Object v : (Collection<?>) qp.getValue()) {
                        target = target.queryParam(qp.getKey(), v);
                    }
                } else {
                    target = target.queryParam(qp.getKey(), qp.getValue());
                }
            }
        }

        Invocation.Builder builder = target.request();

        if (acceptedMediaTypes != null) {
            for (MediaType mediaType : acceptedMediaTypes) {
                builder.accept(mediaType);
            }
        }

        if (authToken != null) {
            builder.header(HttpHeaders.AUTHORIZATION, "Bearer " + authToken);
        }

        return builder;
    }

    protected static ClientBuilder getBuilder() {
        return ClientBuilder.newBuilder()
                .register(JsonProcessingFeature.class)
                .register(MultiPartFeature.class)
                .property(JsonGenerator.PRETTY_PRINTING, true);
    }

    /**
     * Jersey client instance
     *
     * @return javax.ws.rs.client.Client
     */
    public static Client createClient() {
        return getBuilder().build();
    }
}

