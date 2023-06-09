package com.acme.myshoes.platform.shoes.mapping;

import com.acme.myshoes.platform.shared.mapping.EnhancedModelMapper;
import com.acme.myshoes.platform.shoes.domain.model.Shoe;
import com.acme.myshoes.platform.shoes.resource.CreateShoeResource;
import com.acme.myshoes.platform.shoes.resource.ShoeResource;
import com.acme.myshoes.platform.shoes.resource.UpdateShoeResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoeMapper implements Serializable {
    @Autowired
    EnhancedModelMapper mapper;
    public ShoeResource toResource(Shoe model){
        ShoeResource resource = mapper.map(model, ShoeResource.class);
        resource.setCollection_id(model.getCollection().getId());
        resource.setCategory_id(model.getCategory().getId());
        return resource;
    }

    public Page<ShoeResource> modelListPage(List<Shoe> modelList, Pageable pageable){
        List<ShoeResource> resourceList = new ArrayList<>();
        for (Shoe model : modelList) {
            ShoeResource resource = mapper.map(model, ShoeResource.class);
            resource.setCollection_id(model.getCollection().getId());
            resource.setCategory_id(model.getCategory().getId());
            resourceList.add(resource);
        }
        return new PageImpl<>(resourceList, pageable, modelList.size());
    }

    public Shoe toModel(CreateShoeResource resource){
        return mapper.map(resource, Shoe.class);
    }

    public Shoe toModel(UpdateShoeResource resource){
        return mapper.map(resource, Shoe.class);
    }
}
