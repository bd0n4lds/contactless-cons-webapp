/*
 * Contactless Cons WebApp by Brian Donaldson
 * Copyright (c) 2020.  Brian Donaldson
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.tenderretail.webapp.service;


import com.tenderretail.webapp.domain.Customer;
import com.tenderretail.webapp.domain.CustomerModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CustomerService {
    private static final String GUESTS = "/customers";
    private static final String SLASH = "/";

    @Value("${landon.customer.service.url}")
    private String customerServiceUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Customer> getAllCustomers() {
        String url = customerServiceUrl + GUESTS;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, new ParameterizedTypeReference<List<Customer>>() {
        }).getBody();
    }

    public Customer addCustomer(CustomerModel customerModel) {
        String url = customerServiceUrl + GUESTS;
        HttpEntity<CustomerModel> request = new HttpEntity<>(customerModel, null);
        return this.restTemplate.exchange(url, HttpMethod.POST, request, Customer.class).getBody();
    }

    public Customer getCustomer(long id) {
        String url = customerServiceUrl + GUESTS + SLASH + id;
        HttpEntity<String> request = new HttpEntity<>(null, null);
        return this.restTemplate.exchange(url, HttpMethod.GET, request, Customer.class).getBody();
    }

    public Customer updateCustomer(long id, CustomerModel customerModel) {
        System.out.println(customerModel);
        String url = customerServiceUrl + GUESTS + SLASH + id;
        HttpEntity<CustomerModel> request = new HttpEntity<>(customerModel, null);
        return this.restTemplate.exchange(url, HttpMethod.PUT, request, Customer.class).getBody();
    }
}

