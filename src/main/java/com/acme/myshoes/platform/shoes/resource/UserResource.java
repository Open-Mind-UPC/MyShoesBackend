package com.acme.myshoes.platform.shoes.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String address;
}
