package com.example.product.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @Qualifier("community") @Primary
@RequiredArgsConstructor
public class CommunityService implements ProductService {


}
