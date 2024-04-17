package com.infs.controller;


import com.infs.dto.Property;
import com.infs.repository.PropertyRepo;
import com.infs.service.PropertyService;

//import com.infs.repository.SearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/realestate")
//@CrossOrigin(origins="*")
public class PropertyController {

    @Autowired
    PropertyRepo repo;
//    @Autowired
//    SearchRepo srepo;
    
    @Autowired
    PropertyService propertyService;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/viewall")
    public List<Property> viewAllProperties(){
        return propertyService.viewAllProperties();
    }

    @PostMapping("/post")
    public Property addProperty(@RequestBody Property property){
        return propertyService.addProperty(property);
    }

//    @GetMapping("/search/{text}")
//    public List<Property> search(@PathVariable String text){
//        return srepo.findByText(text);
//    }

    @GetMapping("/view/{id}")
    public Property getPropertyById(@PathVariable int id){
        return propertyService.getPropertyById(id);
    }

    @PutMapping("/property/{id}")
    public Property updateProperty(@PathVariable int id, @RequestBody Property property){
        return propertyService.updateProperty(id, property);
    }


    @DeleteMapping("/remove/{id}")
    public boolean removeProperty(@PathVariable int id){
       return propertyService.removeProperty(id);
    }
}
