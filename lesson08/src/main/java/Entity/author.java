package Entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String Code;
    private String Name;
    private String Description;
    private String ImgUrl;
    private String Email;
    private String Phone;
    private String Address;
    private Boolean Active;

    @ManyToMany(mappedBy = "authors")
    @ToString.Exclude
    private List<book> books;
}
