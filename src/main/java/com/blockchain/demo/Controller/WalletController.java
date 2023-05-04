package com.blockchain.demo.Controller;

import com.blockchain.demo.Entity.User;
import com.blockchain.demo.Mapper.UserMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author conanlee
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/user")
public class WalletController {
    @Resource
    UserMapper userMapper;
    @RequestMapping("/query")
    public List<User> walletInfoQuery(HttpServletRequest request) {
        //Integer id = (Integer) request.getAttribute("id");
        //String pwd = request.getAttribute("pwd").toString();
        String userName = request.getAttribute("userName").toString();
        return userMapper.findByWalletByUserName(userName);
    }
}
