package com.example.order.controller;

import com.example.order.domain.vo.OrderVO;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order/*")
public class OrderController {
    private final OrderService orderService;

//    결제
    @GetMapping("add")
    public void add(OrderVO order){
        orderService.addOrder(order.getOrders());
    }

//    취소
    @GetMapping("cancel")
    public void cancel(String orderId){
        orderService.cancel(orderId);
    }

//    전체 조회
    @GetMapping("list")
    public void list(Model model){
        model.addAttribute("orders", orderService.showAll());
    }

//    상품 번호로 주문 조회
    @GetMapping("item/list")
    public void list(Long itemNumber, Model model){
        model.addAttribute("orders", orderService.show(itemNumber));
    }
}
















