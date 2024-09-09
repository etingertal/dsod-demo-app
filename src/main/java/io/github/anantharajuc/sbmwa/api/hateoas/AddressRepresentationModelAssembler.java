package io.github.anantharajuc.sbmwa.api.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import io.github.anantharajuc.sbmwa.api.controller.address.AddressQueryController;
import io.github.anantharajuc.sbmwa.api.hateoas.common.SimpleIdentifiableRepresentationModelAssembler;
import io.github.anantharajuc.sbmwa.domain.model.Address;

@Component
public class AddressRepresentationModelAssembler extends SimpleIdentifiableRepresentationModelAssembler<Address>
{
	public AddressRepresentationModelAssembler() 
	{
		super(AddressQueryController.class);
	}
	
	@Override
	public void addLinks(EntityModel<Address> resource)
	{
		super.addLinks(resource);
		
		resource.add(linkTo(methodOn(AddressQueryController.class).getPersonByAddressId(resource.getContent().getId())).withRel("person"));
	}
	
	@Override
	public void addLinks(CollectionModel<EntityModel<Address>> resources)  
	{
		super.addLinks(resources);
		
		resources.add(linkTo(methodOn(RootController.class).root()).withRel("root"));
	}
}
