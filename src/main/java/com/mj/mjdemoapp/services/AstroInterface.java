package com.mj.mjdemoapp.services;

import com.mj.mjdemoapp.json.AstroResponse;
import org.springframework.web.service.annotation.GetExchange;

public interface AstroInterface {

    @GetExchange("/astros.json")
    AstroResponse getResponse();
}
