package com.example.httpmethods;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class MyController {

    /*
     * get -- supported in HTML form (default) -- @GetMapping -- used to denote
     * query operations
     * post -- supported in HTML form -- @PostMapping -- used to denote record
     * additions
     * put -- not supported in HTML form -- @PutMapping -- used to denote updating a
     * record
     * delete -- not supported in HTML form -- @DeleteMapping -- used to denote
     * deletion of a record
     * 
     * @RequestMapping("/list") -- by default the method used is get
     */

    /* define a get resource / endpoint */
    // @RequestMapping("/get")
    // @RequestMapping(value = "/get", method = RequestMethod.GET)
    @GetMapping("/get")
    public String getMethod(String name) {
        return "Get Method accessed " + name;
    }
    // the data is sent as query parameter visible in the URL
    // the max size of the query parameter can be 8192 bytes

    /* define a post resource / endpoint */
    // @RequestMapping(value = "/post", method = RequestMethod.POST)
    @PostMapping("/post")
    public String postMethod(@RequestParam String name) {
        return "Post Method accessed " + name;
    }
    // the data is sent as request body and not visible in the URL
    // no size limit

    /* define a put resource / endpoint */
    // @RequestMapping(value= "/put", method=RequestMethod.PUT)
    @PutMapping("/put")
    public String putMethod(@RequestParam String name) {
        return "Put Method Accessed " + name;
    }

    /* define a put resource / endpoint */
    // @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @DeleteMapping("/delete")
    public String requestMethodName(@RequestParam String name) {
        return "Delete Method Accessed " + name;
    }

}
