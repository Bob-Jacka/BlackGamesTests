package org.example.core
import org.springframework.boot.test.context.TestConfiguration

@Configuration
class Config {
    
}

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration