package de.ait.shop41.product.controller;

import de.ait.shop41.product.entity.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
public class ProductController {

    private static List<Product> list = new ArrayList<>(List.of(
            new Product(1L, "Kefir", new BigDecimal(1.29), true),
            new Product(2L, "Milk", new BigDecimal(0.99), true),
            new Product(3L, "Butter", new BigDecimal(2.45), true),
            new Product(4L, "Broth", new BigDecimal(1.89), true),
            new Product(5L, "Airan", new BigDecimal(2.45), false),
            new Product(6L, "Kumis", new BigDecimal(0.94), false)
    ));

//    "/products" - возвращает json со списком продуктов
//    @GetMapping("/products")
//    public List<Product> getProducts() {
//        return list;
//    }

//    "/products/{id}" - end point - возвращает продукт с заданным id
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return list.stream()
                .filter(p -> p.getId().equals(Long.valueOf(id)))
                .findAny()
                .get();
    }

    // customers/2/orders/10
    // @GetMaping("customers/{customerId}/orders/{orderId}")
    //  public  Order getCustomerOrderById(@PathVariable long customerId, @PathVariable long orderId)

//    удаление продукта с заданным id
    @DeleteMapping("/{id}")
    public Product deliteProduct(@PathVariable Long id) {
        Product product = list.stream()
                .filter(p -> p.getId().equals(Long.valueOf(id)))
                .findAny()
                .get();

        list = list.stream()
                .filter(p -> p.getId().equals(Long.valueOf(id)))
                .collect(Collectors.toList());
        return product;
    }

//    вывести не активные продукты
//    required = false указывает что параметр не обязательный
//    "/products?active=false"
    @GetMapping
    public List<Product> getProducts(@RequestParam(name = "active", required = false, defaultValue = "all") String active) {
        if (active.equals("false")) {
            return list.stream().filter(product -> !product.isAktive()).toList();
        } else if (active.equals("true")) {
            return list.stream().filter(product -> product.isAktive()).toList();
        }
        return list;
    }

//    добавление записи - post запрос
    @PostMapping
    public ResponseEntity<Product> createNewProduct(@RequestBody Product product) {
        product.setId(list.size() + 1L);
        list.add(product);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    //    метод для изменения продукта
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
        for (Product product : list) {
            if (product.getId().equals(id)) {
                product.setTitle(updatedProduct.getTitle());
                product.setPrice(updatedProduct.getPrice());
                product.setAktive(updatedProduct.isAktive());
                return product;
            }
        }
        return null;
    }
}
