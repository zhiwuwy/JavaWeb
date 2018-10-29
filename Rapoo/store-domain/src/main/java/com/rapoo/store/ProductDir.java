package com.rapoo.store;

import lombok.Data;

@Data
public class ProductDir {
    private Long did;
    private String dirName;
    private Long parent_id;
}
