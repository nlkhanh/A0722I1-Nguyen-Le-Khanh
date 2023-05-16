package codegym.phone_management.controller;

import codegym.phone_management.model.Phone;
import codegym.phone_management.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.HTML;
import java.util.List;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @GetMapping
    public ResponseEntity<List<Phone>> getPhones() {
        List<Phone> phones = phoneService.findAll();
        if (phones.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(phones, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Phone> createPhone(@RequestBody Phone phone) {
        return new ResponseEntity<>(phoneService.save(phone), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable("id") Long id) {
        Phone phone = phoneService.findById(id);
        if (phone == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        phoneService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Phone> editPhone(@RequestBody Phone phone) {
        return new ResponseEntity<>(phoneService.save(phone), HttpStatus.OK);
    }
}
