package com.acme.myshoes.platform.shoes.mapping;

import com.acme.myshoes.platform.shared.mapping.EnhancedModelMapper;
import com.acme.myshoes.platform.shoes.domain.model.User;
import com.acme.myshoes.platform.shoes.resource.CreateUserResource;
import com.acme.myshoes.platform.shoes.resource.UpdateUserResource;
import com.acme.myshoes.platform.shoes.resource.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {
    @Autowired
    private EnhancedModelMapper mapper;
    public UserResource toResource(User model){
        return mapper.map(model, UserResource.class);
    }
    public User toModel(CreateUserResource resource){
        return mapper.map(resource, User.class);
    }
    public User toModel(UpdateUserResource resource){
        return mapper.map(resource, User.class);
    }
    public Page<UserResource> modelListPage(List<User> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }
}
