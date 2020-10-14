package com.example.kotlinrestfulapi.service

import com.example.kotlinrestfulapi.model.CreateProductRequest
import com.example.kotlinrestfulapi.model.ListProductRequest
import com.example.kotlinrestfulapi.model.ProductResponse
import com.example.kotlinrestfulapi.model.UpdateProductRequest

interface ProductService {

    fun create(createProductRequest: CreateProductRequest): ProductResponse

    fun get(id: String): ProductResponse

    fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse

    fun delete(id: String)

    fun list(listProductRequest: ListProductRequest): List<ProductResponse>

}