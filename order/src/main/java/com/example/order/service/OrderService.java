package com.example.order.service;

import com.example.order.domain.dao.ItemDAO;
import com.example.order.domain.dao.OrderDAO;
import com.example.order.domain.vo.ItemVO;
import com.example.order.domain.vo.OrderDTO;
import com.example.order.domain.vo.OrderVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final ItemDAO itemDAO;
    private final OrderDAO orderDAO;
//    결제
    public void order(OrderDTO orderDTO, ItemVO itemVO){
        orderDAO.save(orderDTO);
        itemDAO.setItem(itemVO);
    }
//    취소
    public void cancel(String orderId){
        orderDAO.deleteById(orderId);
    }
//    조회
    public List<OrderVO> show(Long itemNumber){
        return orderDAO.findByItemNumber(itemNumber);
    }


//    주문 번호 조회
    public String findOrderId(){
        return orderDAO.findId();
    }
//    주문 번호 증가
    public void updateOrderSeq(){
        orderDAO.setOrderSequence();
    }
}
