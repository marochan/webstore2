package com.store.service.customer;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.store.entity.Customer;
import com.store.entity.Role;
import com.store.repo.CustomerRepo;
import com.store.repo.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
public class CustomerServiceImpl implements CustomerService, UserDetailsService {

    @Autowired
    CustomerRepo customerRepo;
    @Autowired
    RoleRepo roleRepo;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public Customer registerNewCustomer(Map<String, String> credentials) throws Exception{
        String email = credentials.get("email");
        String password = credentials.get("password");
        if(customerRepo.findByEmail(email)!=null){
            throw new Exception("Email already exists in the database!");
        } else {
            Customer newCustomer = new Customer(null, email, bCryptPasswordEncoder.encode(password));
            newCustomer.addRole(roleRepo.findByName("ROLE_USER"));
            customerRepo.save(newCustomer);
            return newCustomer;
        }
    }

    @Override
    @Transactional
    public Customer saveCustomer(Customer customer) {
        Role role = roleRepo.findByName("ROLE_USER");
        customer.addRole(role);
        customer.setPassword(bCryptPasswordEncoder.encode(customer.getPassword()));
        return customerRepo.save(customer);
    }
    @Override
    public Customer findCustomerByEmail(String email){
        return customerRepo.findByEmail(email);
    }

    @Override
    public void resetPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String authorizationHeader = request.getHeader("Authorization");
        String newPassword = request.getParameter("newPassword");
        if(authorizationHeader != null && authorizationHeader.startsWith("Reset ")){
            try {
                String token = authorizationHeader.substring("Reset ".length());
                Algorithm algorithm = Algorithm.HMAC256("resetpass".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(token);
                String email = decodedJWT.getSubject();
                Customer customer = customerRepo.findByEmail(email);
                customer.setPassword(bCryptPasswordEncoder.encode(newPassword));
                customerRepo.save(customer);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(),"Success!");
            } catch (Exception e) {
                System.err.println(e.getMessage());
                response.setHeader("error", e.getMessage());
                response.setStatus(FORBIDDEN.value());
                Map<String, String> error = new HashMap<>();
                e.printStackTrace();
                error.put("error_message", e.getStackTrace().toString());
                error.put("error_stacktrace", e.getStackTrace().toString());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), error);
            }

        } else {
            throw new Exception("Reseting token is missing");
        }
    }

    @Override
    public List<Customer> findAllUsers() {
        return (List<Customer>) customerRepo.findAll();
    }

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepo.findByEmail(email);
        if (customer == null) {
            throw new UsernameNotFoundException("Customer with provided email has not been found");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        customer.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(roleRepo.findNameByRoleId(role.getRoles()).getName()));
        });
        authorities.forEach(System.out::println);
        return new org.springframework.security.core.userdetails.User(customer.getEmail(), customer.getPassword(), authorities);
    }
}
