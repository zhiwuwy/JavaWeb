package com.rapoo.store;

import lombok.Data;

@Data
public class ProductDirQuery{
    private Long did;
    private String dirName;
    private Long parent_id;
}
