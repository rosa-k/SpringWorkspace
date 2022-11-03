package com.example.product.mapper;

import com.example.product.domain.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {

    //    목록 조회
    public List<ProductVO> getList();

    //    추가
    public int insert(ProductVO productVO);

    //    조회
    public ProductVO select(Long productNumber);

    //    수정
    public int update(ProductVO productVO);

    //    삭제
    public int delete(Long productNumber);
}
