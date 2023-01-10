package com.example.order.controller;

import com.example.order.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/order/item/*")
public class ItemController {
    private final ItemService itemService;

    //    전체 조회
    @GetMapping("itemList")
    public void list(Model model){
        model.addAttribute("items", itemService.showAll());
    }
}
