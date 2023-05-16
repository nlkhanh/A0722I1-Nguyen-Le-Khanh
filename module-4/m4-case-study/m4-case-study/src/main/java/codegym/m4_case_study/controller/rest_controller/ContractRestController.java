package codegym.m4_case_study.controller.rest_controller;

import codegym.m4_case_study.dto.ContractDto;
import codegym.m4_case_study.model.Contract;
import codegym.m4_case_study.model.ContractDetail;
import codegym.m4_case_study.service.AttachFacilityService;
import codegym.m4_case_study.service.ContractDetailService;
import codegym.m4_case_study.service.ContractService;
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
@RequestMapping("/api/contracts")
public class ContractRestController {
    @Autowired
    private ContractService contractService;
    @Autowired
    private ContractDetailService contractDetailService;
    @Autowired
    private AttachFacilityService attachFacilityService;

    @GetMapping("/detail/attach-facilities")
    public ResponseEntity<?> getAttachFacilities() {
        return new ResponseEntity<>(attachFacilityService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/detail/attach-facility/{id}")
    public ResponseEntity<?> getAttachFacilities(@PathVariable("id") Long id) {
        return new ResponseEntity<>(attachFacilityService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/detail")
    public ResponseEntity<?> createContractDetail(@RequestBody ContractDetail contractDetail) {
        return new ResponseEntity<>(contractDetailService.save(contractDetail), HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> getContractDetailsByContractId(@PathVariable("id") Long contractId) {
        return new ResponseEntity<>(contractDetailService.findAllByContractId(contractId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> list(@RequestParam("page") Optional<Integer> page,
                                               @RequestParam("size")Optional<Integer> size,
                                               @RequestParam("sort")Optional<String> sort,
                                               @RequestParam("search")Optional<String> search) {
        int curPage = page.orElse(0);
        int pageSize = size.orElse(5);
        String sortField = sort.orElse("id");
        Pageable pageable = PageRequest.of(curPage, pageSize, Sort.by(sortField));
        String searchValue = search.orElse("");
        Page<ContractDto> contractDtos = contractService.findAllContractDto(pageable);
        return new ResponseEntity<>(contractDtos, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody ContractDto contractDto) {
        Contract contract = contractService.save(contractDto.dtoToEntity());
        return new ResponseEntity<>(contract, HttpStatus.OK);
    }

    @PostMapping("/details")
    private ResponseEntity<?> createContractDetails (@RequestBody List<ContractDetail> contractDetails) {
        for (ContractDetail contractDetail : contractDetails) {
            contractDetailService.save(contractDetail);
        }
        return new ResponseEntity<>(contractDetails, HttpStatus.OK);
    }
}
