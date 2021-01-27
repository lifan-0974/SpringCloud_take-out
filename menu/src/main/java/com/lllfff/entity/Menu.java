package com.lllfff.entity;

import lombok.Data;
import com.lllfff.entity.Type;
@Data
public class Menu {
    private long id;
    private String name;
    private double price;
    private String flavor;
    private   Type type;
}