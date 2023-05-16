package codegym.m4_case_study.controller.rest_controller;

import codegym.m4_case_study.model.*;
import codegym.m4_case_study.service.DivisionService;
import codegym.m4_case_study.service.EducationDegreeService;
import codegym.m4_case_study.service.EmployeeService;
import codegym.m4_case_study.service.PositionService;
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
@RequestMapping("/api/employees")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DivisionService divisionService;

    @Autowired
    private PositionService positionService;

    @Autowired
    private EducationDegreeService educationDegreeService;

    @GetMapping("/divisions")
    public ResponseEntity<List<Division>> getDivisions() {
        return new  ResponseEntity<>(divisionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/positions")
    public ResponseEntity<List<Position>> getPositions() {
        return new  ResponseEntity<>(positionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/education-degrees")
    public ResponseEntity<List<EducationDegree>> getEducationDegrees() {
        return new ResponseEntity<>(educationDegreeService.findAll(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Employee>> list(@RequestParam("page") Optional<Integer> page,
                                               @RequestParam("size")Optional<Integer> size,
                                               @RequestParam("sort")Optional<String> sort,
                                               @RequestParam("search")Optional<String> search) {
        int curPage = page.orElse(0);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("id");
        Pageable pageable = PageRequest.of(curPage, pageSize, Sort.by(sortField));
        String searchValue = search.orElse("");
        Page<Employee> employees = employeeService.findAllSearch(searchValue, pageable);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findById (@PathVariable("id") Long id) {
        System.out.println(id);
        Employee employee = employeeService.findById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.save(employee), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> delete(@RequestBody List<String> deleteIds) {
        for (String id : deleteIds) {
            employeeService.deleteById(Long.parseLong(id));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
