package com.blockchain.demo.Entity;

import cn.hutool.core.date.DateTime;
import lombok.Data;

/**
 * @author conanlee
 */

@Data
public class Order {
    private int order_ID;
    private String order_time;
    private String order_type;
    private String order_origin;
    private String order_destination;
    private Double order_amount;
    private Double order_fee;
    private String order_status;

}
