package de.ait.shop41.role;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "role")
@Schema(description = "Role Entity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Schema(description = "Unique identifier of the role", example = "1")
    private Long id;

    @Column(name = "title")
    @Schema(description = "Title", example = "USER")
    private String title;

    @Override
    public String getAuthority() {
        return title;
    }
}
