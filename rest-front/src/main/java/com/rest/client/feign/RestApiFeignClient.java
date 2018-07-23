package com.rest.client.feign;

import com.rest.api.endpiont.StudentEndpoint;
import com.rest.client.config.FeignClientConfig;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(
        value = "RestAPI",
        url = "localhost:15000",
        configuration = FeignClientConfig.class
)
public interface RestApiFeignClient extends StudentEndpoint{
}
