package com.Bank.creditcard.banking.controller;

import com.Bank.creditcard.banking.dto.CustomerPerPageResponse;
import com.Bank.creditcard.banking.entity.Customer;
import com.Bank.creditcard.banking.exceptions.RecordExistsException;
import com.Bank.creditcard.banking.exceptions.RecordNotFoundException;
import com.Bank.creditcard.banking.service.CustomerService;
import com.Bank.creditcard.banking.utility.StatusMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Controller // If using @Controller then @ResponseBody is used to create REST API
@RestController
/**
 * If the /customers is common across the mappings then there can be 1 root mapping as follows:
 * Remove the /customers mappings from other annotations
 */
@RequestMapping("/customers")
// @Tag is used to display name on swagger UI, ONLY IF SWAGGER ADDED AS DEPENDENCY
@Tag(name="CUSTOMER-CONTROLLER")
public class CreditCardController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get")
    public List<Customer> getAllCustomers()
    {
        return this.customerService.getAllCustomers();
    }

    //get customers by id
    @GetMapping("/get/{customerId}")
    public List<Customer> getCustomerById(@PathVariable long customerId)
    {
        return this.customerService.getCustomerByCustomerId(customerId);
    }


//    @GetMapping
//    public List<Customer> getAllCustomersByJob(@RequestParam(required = false) String job)
//    {
//        if(job == null)
//            return customerService.getAllCustomers();
//        return customerService.getAllCustomersByJob(job);
//    }
//
//    /**
//     * Path variable is used to map the value passed in the path of url
//     * http://localhost:8080/customers/10 => so 10 is mapped with customerId
//     * @param _Id
//     * @return
//     */
//    @GetMapping("/{customer_id}")
//    public Customer getcustomerById(@PathVariable long _Id)
//    {
//        try {
//            return this.customerService.getCustomerById(_Id);
//        } catch (RecordNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    @GetMapping("/resp/{customerId}")
//    public ResponseEntity<Object> getcustomerByIdResponse(@PathVariable long _Id)
//    {
//        try {
//            Customer customer = this.customerService.getCustomerById(_Id);
//            return ResponseEntity.status(HttpStatus.FOUND).body(customer);
//        } catch (RecordNotFoundException e) {
//            // throw new RuntimeException(e);
//            return ResponseEntity.noContent().build();
//        }
//    }
//    //@RequestMapping("/customers/post")
//    // @RequestMapping(path = "/customers/post", method = RequestMethod.POST)
//    //@PostMapping("/customers/post")
//    @PostMapping
//    public ResponseEntity<Object> addCustomer(@RequestBody Customer customer)
//    {
//        try {
//            Customer customer1 = this.customerService.insertCustomer(customer);
//            return ResponseEntity.status(HttpStatus.CREATED).body(customer1);
//        } catch (RecordExistsException e) {
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
//        }
//    }
//    @PutMapping
//    public ResponseEntity<Object> updatecustomer(@RequestBody Customer customer)
//    {
//        Map<StatusMessages, String> map = new HashMap<>();
//        try {
//            this.customerService.updateCustomer(customer);
//            map.put(StatusMessages.SUCCESS, "customer updated successfully");
//            return ResponseEntity.status(HttpStatus.ACCEPTED).body(map);
//        } catch (RecordNotFoundException e) {
//            map.put(StatusMessages.FAILURE, e.getMessage());
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(map);
//        }
//    }
//    @DeleteMapping("/{customerId}")
//    public ResponseEntity<Object> deletecustomerById(@PathVariable long _Id)
//    {
//        Map<StatusMessages , String> map = new HashMap<>();
//        try {
//            map.put(StatusMessages.SUCCESS, "customer deleted successfully");
//            this.customerService.deleteCustomer(_Id);
//            return ResponseEntity.status(HttpStatus.ACCEPTED).body(map);
//        } catch (RecordNotFoundException e) {
//            map.put(StatusMessages.FAILURE, e.getMessage());
//            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(map);
//        }
//    }
//    @GetMapping("/pages")
//    public CustomerPerPageResponse getcustomersByPage(@RequestParam(required = false, defaultValue = "0") int pageno,
//                                                      @RequestParam(required = false, defaultValue = "5") int size)
//    {
//        return this.customerService.getCustomersByPagination(pageno, size);
//    }
}