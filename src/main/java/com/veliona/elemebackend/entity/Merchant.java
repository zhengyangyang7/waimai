package com.veliona.elemebackend.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

@Setter
@Getter
@Data
@TableName("business")
public class Merchant {
    @TableId("businessID")
    private String businessID;

    @TableField("businessName")
    private String businessName;
    @TableField("businessAddress")
    private String businessAddress;
    @TableField("businessExplain")
    private String businessExplain;
    @TableField("businessAvatar")
    private String businessAvatar;
    @TableField("orderTypeID")
    private String orderTypeID;
    @TableField("startPrice")
    private String startPrice;
    @TableField("deliveryPrice")
    private String deliveryPrice;
    @TableField("remarks")
    private String remarks;
}
