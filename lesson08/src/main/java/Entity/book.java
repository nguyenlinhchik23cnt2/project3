package Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Code;
    private String Title;
    private String Description;
    private String ImgUrl;
    private Double Price;
    private Integer Quantity;
    private Boolean Active;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "book_author",   // ❗ XÓA khoảng trắng để tránh lỗi
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    @ToString.Exclude
    private List<author> authors;   // <-- ĐỔI ĐÚNG TÊN TRƯỜNG
}
