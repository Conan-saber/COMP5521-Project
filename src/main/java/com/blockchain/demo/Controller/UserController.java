package com.blockchain.demo.Controller;

import com.blockchain.demo.Entity.User;
import com.blockchain.demo.Mapper.UserMapper;
import com.blockchain.demo.Util.JwtUtil;
import com.blockchain.demo.Util.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author conanlee
 */
@RestController
@CrossOrigin(origins = "*")
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
    public Response loginUser(@RequestParam String username, String password) {
        String uname = username;
        String pwd = password;
        System.out.println("uname=" + uname + "pwd" + pwd);
        if (uname.equals("") || pwd.equals("")) {
            String token = JwtUtil.createToken(username, password);
            return new Response(100, uname, "The user name or password cannot be empty", token);
        } else {
            if (userMapper.login(uname, pwd) != null) {
                String token = JwtUtil.createToken(username, password);
                return new Response(200, uname, "Success", token);
            } else {
                String token = JwtUtil.createToken(username, password);
                return new Response(500, uname, "User does not exist / password is incorrect", token);
            }
        }
    }

    /**
     * Query userInfo after login
     */
    @RequestMapping("/secure/getUserInfo")
    public List<User> login(HttpServletRequest request) {
        //Integer id = (Integer) request.getAttribute("id");
        String pwd = request.getAttribute("pwd").toString();
        String userName = request.getAttribute("userName").toString();
        return userMapper.findByName(userName);
    }
    @PostMapping("/register")
    public Response register(@RequestParam String username, String password) {
        String uname = username;
        String pwd = password;
        User user = userMapper.registerByName(username);
        System.out.println("111111111111111111111"+ user);

        if (uname.equals("") || pwd.equals("")) {
            String token = JwtUtil.createToken(username, password);
            return new Response(100, uname,"The user name or password cannot be empty", token);
        } else {
            if (userMapper.registerByName(username) == null) {
                userMapper.register(username, password);
                String token = JwtUtil.createToken(username, password);
                return new Response(200, uname,"Success", token);
            } else {
                String token = JwtUtil.createToken(username, password);
                return new Response(500, uname,"Registration failed, the user has existed", token);
            }
        }
    }

    @PostMapping("/updatePw")
    public Response updatePw(@RequestParam String username, String password, String newPassword) {
        String uname = username;
        String pwd = password;
        String npwd = newPassword;
        if (uname.equals("") || pwd.equals("")) {
            String token = JwtUtil.createToken(username, password);
            return new Response(100, uname,"The user name or password cannot be empty", token);
        } else {
            if (userMapper.registerByName(username) == null) {
                userMapper.updatePwByName(username, newPassword);
                String token = JwtUtil.createToken(username, newPassword);
                return new Response(200, uname,"Success", token);
            } else {
                String token = JwtUtil.createToken(username, password);
                return new Response(500, uname,"Modify password failed", token);
            }
        }
    }

}
