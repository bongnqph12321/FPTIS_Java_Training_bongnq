package vn.fis.training.ordermanagement.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.fis.training.ordermanagement.model.Customer;
import vn.fis.training.ordermanagement.repository.CustomerRepository;
import vn.fis.training.ordermanagement.service.CustomerService;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @Autowired
    CustomerRepository customerRepository;
    @GetMapping("{id}")
    public Customer getById( @PathVariable Long id){
        return  this.customerService.findById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer customer1 = this.customerService.createCustomer(customer);
        return ResponseEntity.ok(customer1);
    }

   @GetMapping("/page")
   public Page<Customer> listCustomer(
           @RequestParam Optional<Integer> page,
           @RequestParam Optional<String> sortBy
   ){
        return customerRepository.findAll(
            PageRequest.of(
                    page.orElse(0),
                    5,
                    Sort.Direction.ASC,sortBy.orElse("id")
            )
        );
   }
    @PutMapping
    public Customer updateCustomer(@Valid @RequestBody Customer customer){
        return this.customerService.updateCustomer(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        this.customerService.deleteCustomerById(id);
    }
}
