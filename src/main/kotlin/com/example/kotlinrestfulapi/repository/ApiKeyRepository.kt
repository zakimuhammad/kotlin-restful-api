package com.example.kotlinrestfulapi.repository

import com.example.kotlinrestfulapi.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository: JpaRepository<ApiKey, String> {
}