package com.gtf.customers.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gtf.customers.models.GtfResponse;
import com.gtf.customers.repository.IGtfMock;

@Service
public class GtfService {

    @Autowired
    IGtfMock mock;

    public List<GtfResponse> execute(String customerId) {

        return mock.returnResponse().stream()
            .filter(object -> validate(object, customerId))
            .collect(Collectors.toList());

    }

    public boolean validate(GtfResponse response, String customerId) {

        return response.getCustomerId().equals(customerId);
    }
}
