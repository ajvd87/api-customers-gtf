package com.gtf.customers.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GtfResponse {

    private String customerId;

    private String originChannel;

    private String fullName;

    private String condition;

    private String segment;

    private String address;

    private String customerCategory;
}
