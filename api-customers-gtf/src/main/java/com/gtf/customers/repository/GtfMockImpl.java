package com.gtf.customers.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.gtf.customers.models.GtfResponse;

@Component
public class GtfMockImpl implements IGtfMock{

    public List<GtfResponse> returnResponse() {

        GtfResponse response = new GtfResponse();
        List<GtfResponse> list = new ArrayList<>();

        response.setCustomerId("00021244");
        response.setOriginChannel("BANCA SERFIN");
        response.setFullName("ACEVES GONZALEZ ADOLFO");
        response.setCondition("CLIENTE");
        response.setSegment("PREMIER");
        response.setAddress("LOMA BONITA 1839");
        response.setCustomerCategory("FISICA");

        list.add(response);

        response = new GtfResponse();
        response.setCustomerId("00003254");
        response.setOriginChannel("BANCO PASTOR");
        response.setFullName("RODRIGUEZ VAZQUEZ ALBERTO");
        response.setCondition("PROVEEDOR");
        response.setSegment("BASIC");
        response.setAddress("ESTENOGRAFOS 589");
        response.setCustomerCategory("FISICA");

        list.add(response);

        response = new GtfResponse();
        response.setCustomerId("00034689");
        response.setOriginChannel("BBVA COMPASS");
        response.setFullName("GUTIERREZ GONZALEZ ANA");
        response.setCondition("CLIENTE");
        response.setSegment("PREMIER");
        response.setAddress("REFORMA 123");
        response.setCustomerCategory("MORAL");

        list.add(response);

        return list;
    }
}
