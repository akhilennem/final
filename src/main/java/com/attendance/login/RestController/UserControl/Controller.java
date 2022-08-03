package com.attendance.login.RestController.UserControl;

import com.attendance.login.RestController.Genarator;
import com.attendance.login.RestController.model.Details;
import com.attendance.login.RestController.model.User1;
import com.attendance.login.RestController.repository.DetailRepository;
import com.attendance.login.RestController.repository.UserRepository1;
import com.attendance.login.RestController.services.DetailsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.net.URI;
import java.time.LocalDate;






@Transactional
@CrossOrigin
@RestController
@RequestMapping("/api/rest")
public class Controller {

    @Autowired
    private DetailRepository detailRepository;

    @Autowired
    public UserRepository1 userRepository1;

    @Autowired
    public Genarator genarator;

    public String i;

   // public String verify = genarator.generateRandom(10);



    @Autowired
    public DetailsServices detailService;
    @GetMapping("/qr-generator")
            public String Test() {
        String verify = genarator.generateRandom(20);
        System.out.println(verify);
        i=verify;
        return verify;
    }

    @PostMapping("/save")
    public ResponseEntity AddUser(@RequestBody User1 user2) {

        System.out.println(i);
        if (i.equals(user2.para)) {

            if(userRepository1.existsByPara(user2.para))
            {


                return new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);}
            else {
                userRepository1.save(user2);

              return new ResponseEntity<>(HttpStatus.OK);

            }
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

       }
       
// //       public ResponseEntity<?>waiter()
// //       {
// //           return ResponseEntity.status(HttpStatus.OK).location(URI.create("http://192.168.1.14:8080/")).build();
// //
// //       }


    @GetMapping("/get-user-details")
    public Iterable<User1> take( @RequestParam String email) {
        return userRepository1.findByEmail(email);
    }

    @GetMapping("/get-by-date")
    public Iterable<User1> findByDate(@RequestParam String date) {
        return userRepository1.getByDate(LocalDate.parse(date));
    }

    @PutMapping("/update-profile")
    public Details profile(@RequestBody Details details) {
        return detailRepository.save(details);
    }

    @GetMapping("/get-profile")
    public Details getProfileByEmail(@RequestParam String email) {
        return detailService.Find(email);
    }

    @GetMapping("/recent")
    public Iterable<User1> find() {
        return userRepository1.getByDate(LocalDate.now());
    }

    @GetMapping("/get-by-month")
    public Iterable<User1> findByMonth(@RequestParam String month,String email) {
        return userRepository1.getByMonthAndEmail(month,email);
    }


    @GetMapping("/delete-by-time")
    public Iterable<User1> delete( @RequestParam String date) {
        return userRepository1.deleteByDate(date);
    }



}
