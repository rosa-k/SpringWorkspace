package com.example.product.domain.dao;

import com.example.product.domain.vo.ProductVO;
import com.example.product.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ProductDAO {
    private final ProductMapper productMapper;

    //    목록 조회
    public List<ProductVO> findAll(){
        return productMapper.getList();
    };

    //    추가
    public int save(ProductVO productVO){
        return productMapper.insert(productVO);
    };

    //    조회
    public ProductVO findById(Long productNumber){
        return productMapper.select(productNumber);
    };

    //    수정
    public int setProduct(ProductVO productVO){
        return productMapper.update(productVO);
    };

    //    삭제
    public int deleteById(Long productNumber){
        return productMapper.delete(productNumber);
    };


}
