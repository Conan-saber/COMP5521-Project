package com.blockchain.demo.Controller;

import com.blockchain.demo.Entity.User;
import com.blockchain.demo.Mapper.UserMapper;
import com.blockchain.demo.Util.JwtUtil;
import com.blockchain.demo.Util.Response;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

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
    public Response loginUser(@RequestBody Map params) {
        String username = (String) params.get("username");
        String password = (String) params.get("password");
        System.out.println("uname=" + username + "pwd" + password);
        if (username.equals("") || password.equals("")) {
            String token = JwtUtil.createToken(username, password);
            return new Response(100, username, "The user name or password cannot be empty", token);
        } else {
            if (userMapper.login(username, password) != null) {
                String token = JwtUtil.createToken(username, password);
                return new Response(200, username, "Success", token);
            } else {
                String token = JwtUtil.createToken(username, password);
                return new Response(500, username, "User does not exist / password is incorrect", token);
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
    public Response register(@RequestBody Map params) {
        String username = (String) params.get("username");
        String password = (String) params.get("password");
        User user = userMapper.registerByName(username);
        //System.out.println("111111111111111111111"+ user);

        if (username.equals("") || password.equals("")) {
            String token = JwtUtil.createToken(username, password);
            return new Response(100, username,"The user name or password cannot be empty", token);
        } else {
            if (userMapper.registerByName(username) == null) {
                userMapper.register(username, password);
                String token = JwtUtil.createToken(username, password);
                return new Response(200, username,"Success", token);
            } else {
                String token = JwtUtil.createToken(username, password);
                return new Response(500, username,"Registration failed, the user has existed", token);
            }
        }
    }

    @PostMapping("/updatePw")
    public Response updatePw(@RequestBody Map params) {
//        @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("newPassword") String newPassword
        String username = (String) params.get("username");
        String password = (String) params.get("password");
        String newPassword = (String) params.get("newPassword");
        if (username.equals("") || newPassword.equals("")) {
            String token = JwtUtil.createToken(username, password);
            return new Response(100, username,"The user name or password cannot be empty", token);
        } else {
            if (userMapper.registerByName(username) == null) {
                userMapper.updatePwByName(username, newPassword);
                String token = JwtUtil.createToken(username, newPassword);
                return new Response(200, username,"Success", token);
            } else {
                String token = JwtUtil.createToken(username, password);
                return new Response(500, username,"Modify password failed", token);
            }
        }
    }

}
