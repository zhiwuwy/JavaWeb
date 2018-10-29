package com.rapoo.store;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;

@Data
public class ProductQuery extends Query{
    private String productName;//模糊产品名
    private BigDecimal minSalePrice;//最低价
    private BigDecimal maxSalePrice;//最高价
    private Long dir_id = -1L;//产品分类id
    private String keyword;//关键字,用于查询产品名或品牌

    @Override
    public void customizedQuery() {
        if(StringUtils.isNotBlank(productName)){
            addQuery("productName Like ?", "%"+productName+"%");
        }
        if(minSalePrice != null){
            addQuery("salePrice >= ?", minSalePrice);
        }
        if(maxSalePrice != null){
            addQuery("salePrice <= ?", maxSalePrice);
        }
        if(StringUtils.isNotBlank(keyword)){
            addQuery("(productName LIKE ? OR brand LIKE ?)", "%"+keyword+"%", "%"+keyword+"%");
        }
        if(dir_id != -1L){
            addQuery("dir_id = ?", dir_id);
        }

    }
}
