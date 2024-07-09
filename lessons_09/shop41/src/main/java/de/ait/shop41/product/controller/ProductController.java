package de.ait.shop41.product.controller;

import de.ait.shop41.product.entity.Product;
import de.ait.shop41.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor // Spring lombok генерирует конструктор
@RequestMapping("/products")
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
    @GetMapping
    public List<Product> getProducts(@RequestParam(name = "active", required = false, defaultValue = "all") String active) {
        if (active.equals("false")) {
            return service.getAllNotAktiveProducts();
        } else if (active.equals("true")) {
            return service.getAllAktiveProducts();
        }
        return service.getAllProducts();
    }

//    добавление записи - post запрос
    @PostMapping
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product) {
        Product saved = service.save(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    //    метод для изменения продукта
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product updated = service.update(id, product);
        return updated;
    }
}
