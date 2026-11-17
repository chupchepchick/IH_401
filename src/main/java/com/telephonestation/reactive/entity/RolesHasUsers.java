package com.telephonestation.reactive.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "roles_has_users")
public class RolesHasUsers {

    @Id
    private Long id;
    private Long role_id;
    private Long user_id;

    public RolesHasUsers(Long role_id, Long user_id) {
        this.role_id = role_id;
        this.user_id = user_id;
    }
}