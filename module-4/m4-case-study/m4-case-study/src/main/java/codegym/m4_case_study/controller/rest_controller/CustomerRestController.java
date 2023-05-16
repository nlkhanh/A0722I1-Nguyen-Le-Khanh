package codegym.m4_case_study.controller.rest_controller;

import codegym.m4_case_study.model.Customer;
import codegym.m4_case_study.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/customers")
public class CustomerRestController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Page<Customer>> list(@RequestParam("page")Optional<Integer> page,
                                               @RequestParam("size")Optional<Integer> size,
                                               @RequestParam("sort")Optional<String> sort,
                                               @RequestParam("search")Optional<String> search) {
        int curPage = page.orElse(0);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("id");
        Pageable pageable = PageRequest.of(curPage, pageSize, Sort.by(sortField));
        String searchValue = search.orElse("");
        Page<Customer> customers = customerService.findAllSearch(searchValue, pageable);
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> delete(@RequestBody List<String> deleteIds) {
        for (String id : deleteIds) {
            customerService.deleteById(Long.parseLong(id));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
