package com.json.rest.sample.controller;

import com.json.rest.sample.model.Address;
import com.json.rest.sample.model.Customer;
import com.json.rest.sample.util.HibernateUtil;
import com.json.rest.sample.convertor.JsonToCsv;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Praneeth
 */

@RestController
@RequestMapping("/api")
public class CustomerController {
    private static final Logger logger = Logger.getLogger(JsonToCsv.class);

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable String id) {
        Customer customer = new Customer();
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createSQLQuery("SELECT * FROM Customer");
            List<Object[]> dataList = query.list();
            customer = getCustomerObj(dataList, id, null);
        } catch (Exception e) {
            logger.error("Error getCustomerById() : " + e.getMessage(), e);
        } finally {
            session.close();
        }

        return customer;
    }

    @RequestMapping(value = "/customer_name/{name}", method = RequestMethod.GET)
    public Customer getCustomerByName(@PathVariable String name) {
        Customer customer = new Customer();
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createSQLQuery("SELECT * FROM Customer");
            List<Object[]> dataList = query.list();
            customer = getCustomerObj(dataList, null, name);
        } catch (Exception e) {
            logger.error("Error getCustomerById() : " + e.getMessage(), e);
        } finally {
            session.close();
        }

        return customer;
    }

    @RequestMapping(value = "/customer/zipcode", method = RequestMethod.GET)
    public Map<String, List<Customer>> getCustomerGroupByZipCode() {
        Map<String, List<Customer>> resultMap = new HashMap<>();
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();
            Query query = session.createSQLQuery("SELECT * FROM Customer");
            List<Object[]> dataList = query.list();
            List<Customer> resultList = new ArrayList<>();
            for (Object[] item : dataList) {
                Customer customer = new Customer();
                customer.set_id(item[0].toString());
                customer.setIndex(item[1].toString());
                customer.setAge(item[2].toString());
                customer.setEyeColor(item[3].toString());
                customer.setName(item[4].toString());
                customer.setGender(item[5].toString());
                customer.setCompany(item[6].toString());
                customer.setEmail(item[7].toString());
                customer.setPhone(item[8].toString());
                customer.setAbout(item[9].toString());
                customer.setRegistered(item[10].toString());
                customer.setLatitude(item[11].toString());
                customer.setLongitude(item[12].toString());

                Address address = new Address();
                address.setNumber(item[13].toString());
                address.setStreet(item[14].toString());
                address.setCity(item[15].toString());
                address.setState(item[16].toString());
                address.setZipcode(item[17].toString());
                customer.setAddress(address);

                customer.setTags(new String[]{item[18].toString(), item[19].toString(), item[20].toString(), item[21].toString(), item[22].toString(), item[23].toString(), item[24].toString()});
                resultList.add(customer);
            }
            resultMap = resultList.stream().collect(Collectors.groupingBy(item -> item.getAddress().getZipcode()));

        } catch (Exception e) {
            logger.error("Error getCustomerGroupByZipCode() : " + e.getMessage(), e);
        }

        return resultMap;
    }

    // get Customer Obj By Filters
    private Customer getCustomerObj(List<Object[]> dataList, String id, String name) {
        Customer customer = new Customer();
        for (Object[] item : dataList) {
            if (item != null && item[0].equals(id)) {
                customer.set_id(item[0].toString());
                customer.setIndex(item[1].toString());
                customer.setAge(item[2].toString());
                customer.setEyeColor(item[3].toString());
                customer.setName(item[4].toString());
                customer.setGender(item[5].toString());
                customer.setCompany(item[6].toString());
                customer.setEmail(item[7].toString());
                customer.setPhone(item[8].toString());
                customer.setAbout(item[9].toString());
                customer.setRegistered(item[10].toString());
                customer.setLatitude(item[11].toString());
                customer.setLongitude(item[12].toString());

                Address address = new Address();
                address.setNumber(item[13].toString());
                address.setStreet(item[14].toString());
                address.setCity(item[15].toString());
                address.setState(item[16].toString());
                address.setZipcode(item[17].toString());
                customer.setAddress(address);

                customer.setTags(new String[]{item[18].toString(), item[19].toString(), item[20].toString(), item[21].toString(), item[22].toString(), item[23].toString(), item[24].toString()});

            } else if (item != null && item[4].equals(name)) {
                customer.set_id(item[0].toString());
                customer.setIndex(item[1].toString());
                customer.setAge(item[2].toString());
                customer.setEyeColor(item[3].toString());
                customer.setName(item[4].toString());
                customer.setGender(item[5].toString());
                customer.setCompany(item[6].toString());
                customer.setEmail(item[7].toString());
                customer.setPhone(item[8].toString());
                customer.setAbout(item[9].toString());
                customer.setRegistered(item[10].toString());
                customer.setLatitude(item[11].toString());
                customer.setLongitude(item[12].toString());

                Address address = new Address();
                address.setNumber(item[13].toString());
                address.setStreet(item[14].toString());
                address.setCity(item[15].toString());
                address.setState(item[16].toString());
                address.setZipcode(item[17].toString());
                customer.setAddress(address);

                customer.setTags(new String[]{item[18].toString(), item[19].toString(), item[20].toString(), item[21].toString(), item[22].toString(), item[23].toString(), item[24].toString()});

            }
        }

        return customer;
    }
}

