package com.example.order.controller;

import com.example.order.domain.vo.OrderVO;
import com.example.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order/*")
@Slf4j
public class OrderController {
    private final OrderService orderService;

    //    결제
    @GetMapping("add")
    public RedirectView add(OrderVO order){
        orderService.addOrder(order.getOrders());
        return new RedirectView("/order/list");
    }

    //    취소
//    @GetMapping("cancel")
//    public void cancel(String orderId){
//        orderService.cancel(orderId);
//    }
    @PostMapping("cancel")
    public RedirectView cancel(@RequestParam("orderId") List<String> orderIds){
        orderIds.forEach(orderId -> orderService.cancel(orderId));
        return new RedirectView("/item/list");
    }

    //    전체 조회
    @GetMapping("list")
    public void list(Model model){
        model.addAttribute("orders", orderService.showAll());
    }

    //    상품 번호로 주문 조회
//    @GetMapping("item/list")
//    public void list(Long itemNumber, Model model){
//        model.addAttribute("orders", orderService.show(itemNumber));
//    }
    //    상품명으로 주문 개수 조회
    @GetMapping("search")
    public String search(@ModelAttribute("itemName") String itemName, Model model){
        model.addAttribute("total", orderService.show(itemName).stream().map(order -> order.getItemCount()).reduce(0, (count1, count2) -> count1 + count2));
        return "/order/result";
    }

}
