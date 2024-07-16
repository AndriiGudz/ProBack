package de.ait.shop41.product.controller;

import de.ait.shop41.exception_handling.ApiExceptionInfo;
import de.ait.shop41.exception_handling.exceptions.ProductNotFoundException;
import de.ait.shop41.product.dto.ProductRequestDTO;
import de.ait.shop41.product.dto.ProductResponseDTO;
import de.ait.shop41.product.entity.Product;
import de.ait.shop41.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor // Spring lombok генерирует конструктор
@RequestMapping("/products")
@Tag(name = "Product controller", description = "Controller for various operation with Products")
public class ProductController {

    private final ProductService service;

//    private static List<Product> list = new ArrayList<>(List.of(
//            new Product(1L, "Kefir", new BigDecimal(1.29), true),
//            new Product(2L, "Milk", new BigDecimal(0.99), true),
//            new Product(3L, "Butter", new BigDecimal(2.45), true),
//            new Product(4L, "Broth", new BigDecimal(1.89), true),
//            new Product(5L, "Airan", new BigDecimal(2.45), false),
//            new Product(6L, "Kumis", new BigDecimal(0.94), false)
//    ));

//    "/products" - возвращает json со списком продуктов
//    @GetMapping("/products")
//    public List<Product> getProducts() {
//        return list;
//    }

//    "/products/{id}" - end point - возвращает продукт с заданным id
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.getById(id);
    }

    // customers/2/orders/10
    // @GetMaping("customers/{customerId}/orders/{orderId}")
    //  public  Order getCustomerOrderById(@PathVariable long customerId, @PathVariable long orderId)

//    удаление продукта с заданным id
    @DeleteMapping("/{id}")
    public Product deliteProduct(@PathVariable Long id) {
        return service.deleteById(id);
    }

//    вывести не активные продукты
//    required = false указывает что параметр не обязательный
//    "/products?active=false"
//    "/products?active=false&sortType=Title" - пример использования нескольких параметров в куэри параметре
    @Operation(summary = "Get list of products", description = "Get all products or get products by aktive value")
    @GetMapping
    public List<ProductResponseDTO> getProducts(
            @RequestParam(name = "active", required = false, defaultValue = "all")
            @Parameter(description = "For getting all active product should be true and should be false for non active products",
            example = "true")
            String active) {
        if (active.equals("false")) {
            return service.getAllNotAktiveProducts();
        } else if (active.equals("true")) {
            return service.getAllAktiveProducts();
        }
        return service.getAllProducts();
    }

//    добавление записи - post запрос
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createNewProduct(@Valid @RequestBody ProductRequestDTO product) {
        ProductResponseDTO saved = service.save(product);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    //    метод для изменения продукта
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updated = service.update(id, product);
        return updated;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    // для возрата объекта / ошибки на фронт
    public ResponseEntity<ApiExceptionInfo> productNotFoundHandler(Exception e) {
        return new ResponseEntity<ApiExceptionInfo>(new ApiExceptionInfo(e.getMessage()), HttpStatus.NOT_FOUND);
    }

}
