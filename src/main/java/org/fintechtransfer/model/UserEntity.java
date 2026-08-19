package org.fintechtransfer.model;

import jakarta.persistence.*;
import lombok.*;
import org.fintechtransfer.config.Auditable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "user")
public class UserEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 120)
    private String firstName;
    @Column(length = 120)
    private String lastName;

    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, length = 16)
    private Role role;
    @Column(nullable = false, length = 16)
    private UserStatus status;

    @Column(name = "failed_login_attempts")
    private Integer failedLoginAttempts;
}
