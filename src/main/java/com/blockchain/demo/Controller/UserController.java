package com.blockchain.demo.Controller;

import com.blockchain.demo.Entity.User;
import com.blockchain.demo.Mapper.UserMapper;
import com.blockchain.demo.Util.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author conanlee
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserMapper userMapper;

    @GetMapping
    public List<User> getUser(){
        return userMapper.findAll();
    }

    @GetMapping("/{user_ID}")
    public List<User> findUserByID(@PathVariable("user_ID") Integer user_ID){
        return userMapper.findByID(user_ID);
    }

    @PostMapping
    public String addUser(@RequestBody User user){
        userMapper.save(user);
        return "success";
    }

    @PutMapping
    public String updateUser(@RequestBody User user){
        userMapper.updateById(user);
        return "success";
    }

    @DeleteMapping("/{user_ID}")
    public String deleteUser(@PathVariable("user_ID") Integer user_ID){
        userMapper.deleteById(user_ID);
        return "success";
    }

    @PostMapping("/login")
    public Response loginUser(@RequestBody User user) {
        String uname = user.getUser_name();
        String pwd = user.getUser_pw();
        System.out.println("uname=" + uname + "pwd" + pwd);
        if (uname.equals("") || pwd.equals("")) {
            return new Response(100, "The user name or password cannot be empty", "");
        } else {
            if (userMapper.login(uname, pwd) != null) {
                return new Response(200, "Success", "");
            } else {
                return new Response(500, "User does not exist / password is incorrect", "");
            }
        }
    }

    @PostMapping("/registration")
    public Response register(@RequestBody User user) {
        String uname = user.getUser_name();
        String pwd = user.getUser_pw();
        if (uname.equals("") || pwd.equals("")) {
            return new Response(100, "The user name or password cannot be empty", "");
        } else {
            if (userMapper.registerByName(user.getUser_name()) == null) {
                userMapper.register(user);

                return new Response(200, "Success", "");
            } else {
                return new Response(500, "Registration failed", "The user has existed ");
            }
        }
    }


}
