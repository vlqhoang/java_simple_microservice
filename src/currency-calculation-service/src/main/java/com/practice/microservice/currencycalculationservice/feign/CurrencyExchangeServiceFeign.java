package com.practice.microservice.currencycalculationservice.feign;

import com.practice.microservice.currencycalculationservice.dto.CurrencyConversionDTO;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000") // 1. basic config -> giving calling service name + its url
//@FeignClient(name = "currency-exchange-service") // 2. directly call services
@FeignClient(name = "netflix-zuul-api-gateway") // 3. all request go to gateway first,
@RibbonClient(name = "currency-exchange-service") // specifying client load balancing to currency exchange service
public interface CurrencyExchangeServiceFeign {

    // @GetMapping("/currency-exchange/from/{from}/to/{to}") // 2. using uri to service
    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}") // 3. using modified uri for redirection from gateway to service, signature is: gateway_address/application_name/serviceAPI
    CurrencyConversionDTO retrieveExchangeValue(@PathVariable String from,
                                                @PathVariable String to);
}
