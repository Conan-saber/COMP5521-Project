package com.blockchain.demo.Mapper;

import com.blockchain.demo.Entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author conanlee
 */
public interface UserMapper {
    @Select("select * from user_info")
    List<User> findAll();

    @Select("select * from user_info where user_ID = #{user_ID}")
    List<User> findByID(Integer userID);

    @Update("INSERT INTO user_info(user_ID, user_name, user_email, user_pw, user_status, user_code, btc_wallet_id, btc_balance, eth_wallet_id, eth_balance, ltc_wallet_id, ltc_balance, stellar_wallet_id, stellar_balance, xrp_wallet_id, xrp_balance, fiat_wallet_id, fiat_balance) " +
            "VALUES (#{user_ID},#{user_name},#{user_email},#{user_pw},#{user_status},#{user_code},#{btc_wallet_id},#{btc_balance},#{eth_wallet_id},#{eth_balance},#{ltc_wallet_id},#{ltc_balance},#{stellar_wallet_id},#{stellar_balance},#{xrp_wallet_id},#{xrp_balance},#{fiat_wallet_id},#{fiat_balance})")
    @Transactional(rollbackFor = Exception.class)
    void save(User user);

    @Update("UPDATE user_info SET user_name = #{user_name}, user_email = #{user_email}, user_pw = #{user_pw}, user_status = #{user_status}, user_code = #{user_code}, btc_wallet_id = #{btc_wallet_id}, btc_balance = #{btc_balance}, eth_wallet_id = #{eth_wallet_id}, eth_balance = #{eth_balance}, ltc_wallet_id = #{ltc_wallet_id}, " +
            "ltc_balance = #{ltc_balance}, stellar_wallet_id = #{stellar_wallet_id}, stellar_balance = #{stellar_balance}, xrp_wallet_id = #{xrp_wallet_id}, xrp_balance = #{xrp_balance}, fiat_wallet_id = #{fiat_wallet_id}, fiat_balance = #{fiat_balance}  WHERE user_ID = #{user_ID}")
    @Transactional(rollbackFor = Exception.class)
    void updateById(User user);

    @Delete("DELETE from user_info where user_ID = #{user_ID}")
    @Transactional(rollbackFor = Exception.class)
    void deleteById(Integer userID);

    @Select("select * from user_info where user_name=#{user_name} and user_pw=#{user_pw}")
    User login(@Param("user_name") String userName, @Param("user_pw") String userPw);

    @Select("select* from user_info where user_name=#{user_name}")
    @Transactional(rollbackFor = Exception.class)
    User registerByName(String userName);

    @Update("INSERT INTO user_info(user_ID, user_name, user_email, user_pw, user_status, user_code, btc_wallet_id, btc_balance, eth_wallet_id, eth_balance, ltc_wallet_id, ltc_balance, stellar_wallet_id, stellar_balance, xrp_wallet_id, xrp_balance, fiat_wallet_id, fiat_balance) " +
            "VALUES (#{user_ID},#{user_name},#{user_email},#{user_pw},#{user_status},#{user_code},#{btc_wallet_id},#{btc_balance},#{eth_wallet_id},#{eth_balance},#{ltc_wallet_id},#{ltc_balance},#{stellar_wallet_id},#{stellar_balance},#{xrp_wallet_id},#{xrp_balance},#{fiat_wallet_id},#{fiat_balance})")
    @Transactional(rollbackFor = Exception.class)
    void register(User user);
}
