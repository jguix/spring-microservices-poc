package com.juanguijordan.mspoc.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.juanguijordan.mspoc.order.config.FeignConfig;
import com.juanguijordan.mspoc.order.dto.CustomerDTO;

@FeignClient(name = "customer-service", url = "${feign.client.customer-service}", configuration = FeignConfig.class)
public interface CustomerClient {
    @GetMapping("/{id}")
    CustomerDTO getCustomerById(@PathVariable("id") Long id);
}
