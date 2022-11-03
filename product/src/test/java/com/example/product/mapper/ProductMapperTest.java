package com.example.product.mapper;

import com.example.product.domain.vo.ProductVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ProductMapperTest {
    @Autowired
    private ProductMapper productMapper;

//    목록 조회
    @Test
    public void getLiseTest(){
        productMapper.getList().stream().map(ProductVO::toString).forEach(log::info);
    }

//    추가
    @Test
    public void insertTest(){
        ProductVO productVO = new ProductVO();
        productVO.setProductName("banana");
        productVO.setProductPrice(1500);
        productVO.setProductStock(10);
        productVO.setProductBrand("ro_mapper");
        productMapper.insert(productVO);
    }

//    수정
    @Test
    public void updateTest(){
        ProductVO productVO = productMapper.select(2L);
        productVO.setProductPrice(2000);
        productVO.setProductStock(10);
        productVO.setProductBrand("ro_mapper 수정");
        productMapper.update(productVO);
    }

//    삭제
    @Test
    public void deleteTest(){
        productMapper.delete(2L);
    }
}
