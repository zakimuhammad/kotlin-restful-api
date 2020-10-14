package com.example.kotlinrestfulapi.repository

import com.example.kotlinrestfulapi.entity.Product
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, String> {
}