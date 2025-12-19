package com.example.api_tools.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "An order made by a user")
public class Order {
    private Long id;
    private Long itemId;
    private Integer count;
    //private Date createdAt;
    private Long userId;
}