package codegym.m4_case_study.controller.rest_controller;

import codegym.m4_case_study.model.Facility;
import codegym.m4_case_study.service.FacilityService;
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
@RequestMapping("/api/facilities")
public class FacilityRestController {
    @Autowired
    private FacilityService facilityService;

    @GetMapping
    public ResponseEntity<?> list(@RequestParam("id") Optional<Long> id,
                                  @RequestParam("page") Optional<Integer> page,
                                  @RequestParam("size") Optional<Integer> size,
                                  @RequestParam("sort") Optional<String> sort,
                                  @RequestParam("search") Optional<String> search) {
        if (id.isPresent()) {
            return new ResponseEntity<>(facilityService.findById(id.get()), HttpStatus.OK);
        }
        int curPage = page.orElse(0);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("id");
        Pageable pageable = PageRequest.of(curPage, pageSize, Sort.by(sortField));
        String searchValue = search.orElse("");
        Page<Facility> facilities = facilityService.findAllSearch(searchValue, pageable);
        return new ResponseEntity<>(facilities, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> delete(@RequestBody List<String> deleteIds) {
        for (String id : deleteIds) {
            facilityService.deleteById(Long.parseLong(id));
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
