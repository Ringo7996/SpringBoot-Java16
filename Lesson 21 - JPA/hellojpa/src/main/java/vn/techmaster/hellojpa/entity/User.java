package vn.techmaster.hellojpa.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import vn.techmaster.hellojpa.dto.UserDTO;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "USERS")
@Builder(toBuilder = true)
@NamedNativeQuery(
        name = "getUserInfo",
        query = "SELECT * FROM users WHERE id = ?1",
        resultClass = User.class)

// cách 1 projection
// step 1: Khai bao Result set mapping với tên là UserInfo
@SqlResultSetMappings(value = {
        @SqlResultSetMapping(
                name = "userInfo",
                classes = @ConstructorResult(
                        targetClass = UserDTO.class,
                        columns = {
                                @ColumnResult(name = "id", type = Integer.class),
                                @ColumnResult(name = "name", type = String.class),
                                @ColumnResult(name = "email", type = String.class)
                        }
                )
        )
})

//Step 2: Khai báo câu query sử dụng userInfo resultSetMapping đã khai báo ở step `
@NamedNativeQuery(
        name = "getUserDTOUsingNativeQuery",
        resultSetMapping = "userInfo",
        query = "select u.id, u.name, u.email from users u"
)
public class User {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", columnDefinition = "TEXT")
    private String name;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;
}
