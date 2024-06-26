package lessons_03.app.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private Long id;
    private String title;
    private BigDecimal price;
    private String artikle;

    public Product(Long id, String title, BigDecimal price, String artikle) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.artikle = artikle;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getArtikle() {
        return artikle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", artikle='" + artikle + '\'' +
                '}';
    }
}
