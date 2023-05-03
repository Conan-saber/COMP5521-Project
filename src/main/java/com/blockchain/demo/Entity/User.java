package com.blockchain.demo.Entity;

import lombok.Data;

/**
 * @author conanlee
 */
@Data
public class User {

    private Integer user_ID;

    private String user_name;

    private String user_email;

    private String user_pw;

    private String user_status;

    private String user_code;

    private Integer btc_wallet_id;

    private double btc_balance;

    private Integer eth_wallet_id;

    private double eth_balance;

    private Integer ltc_wallet_id;

    private double ltc_balance;

    private Integer stellar_wallet_id;

    private double stellar_balance;

    private Integer xrp_wallet_id;

    private double xrp_balance;

    private Integer fiat_wallet_id;

    private double fiat_balance;

}
