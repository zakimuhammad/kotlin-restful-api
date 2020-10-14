package com.example.kotlinrestfulapi.controller

import com.example.kotlinrestfulapi.model.*
import com.example.kotlinrestfulapi.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
class ProductController(val productService: ProductService) {

    @PostMapping(
            value = ["/api/products"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.create(body)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

    @GetMapping(
            value = ["/api/products/{idProduct}"],
            produces = ["application/json"]
    )
    fun getProduct(@PathVariable("idProduct") id: String): WebResponse<ProductResponse> {
        val productResponse = productService.get(id)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

    @PutMapping(
            value = ["/api/products/{idProduct}"],
            produces = ["application/json"],
            consumes = ["application/json"]
    )
    fun updateProduct(@PathVariable("idProduct") id: String,
                      @RequestBody updateProductRequest: UpdateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.update(id, updateProductRequest)
        return WebResponse(
                code = 200,
                status = "OK",
                data = productResponse
        )
    }

    @DeleteMapping(
            value = ["/api/products/{idProduct}"],
            produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable("idProduct") id: String): WebResponse<String> {
        productService.delete(id)
        return WebResponse(
                code = 200,
                status = "OK",
                data = "$id Deleted"
        )
    }

    @GetMapping(
            value = ["/api/products"],
            produces = ["application/json"]
    )
    fun listProducts(@RequestParam(value = "page", defaultValue = "0") page: Int,
                     @RequestParam(value = "size", defaultValue = "10") size: Int
    ): WebResponse<List<ProductResponse>> {
        val request = ListProductRequest(page, size)
        val response = productService.list(request)
        return WebResponse(
                code = 200,
                status = "OK",
                data = response
        )
    }
}