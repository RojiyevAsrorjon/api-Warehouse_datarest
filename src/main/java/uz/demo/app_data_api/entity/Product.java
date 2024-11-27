package uz.demo.app_data_api.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne(optional = false)
    private Category category;

    @OneToOne(cascade = CascadeType.ALL)
    private Attachment attachment;

    private String code;

    @OneToOne
    private Measurement measurement;

    private Boolean active;
}
