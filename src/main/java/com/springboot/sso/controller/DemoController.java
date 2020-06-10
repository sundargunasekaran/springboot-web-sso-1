package com.springboot.sso.controller;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.springboot.sso.config.AccessToken;
import com.springboot.sso.model.Customer;

@Controller
@EnableOAuth2Sso
@RequestMapping("/")
public class DemoController extends WebSecurityConfigurerAdapter {

    @Autowired
    RestTemplate restTemplate;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated();
    }



    @RequestMapping(value = "/")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/home")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/customers")
    public String customersList(Model model) {

    	List<Customer> customers = new ArrayList<Customer>();
    	Customer s1=new Customer("AL12345","Raj","lucknow");  
    	Customer s2=new Customer("BV5678","Vijay","ghaziabad");  
    	customers.add(s1);
    	customers.add(s2);
    	Map<String,List<Customer>> m = new HashMap<String,List<Customer>>();
    	m.put("customers", customers);
    	Gson gson = new Gson();
    	System.out.println("-->"+customers);
    	System.out.println(gson.toJson(m));
    	System.out.println("-->"+AccessToken.getAccessToken());
    	 model.addAttribute("customers", customers);
    	
        /*HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<Customer> customerHttpEntity = new HttpEntity<>(httpHeaders);
        try {
            ResponseEntity<Customer[]> responseEntity = restTemplate.exchange("http://localhost:8181/services/customers", HttpMethod.GET, customerHttpEntity, Customer[].class);
            model.addAttribute("customers", responseEntity.getBody());
        } catch (HttpStatusCodeException e) {
            ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error", responseEntity);
        }*/

        return "home";
    }


}
