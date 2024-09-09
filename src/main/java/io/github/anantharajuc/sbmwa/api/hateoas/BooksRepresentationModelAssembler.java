package io.github.anantharajuc.sbmwa.api.hateoas;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

import io.github.anantharajuc.sbmwa.api.controller.book.BookQueryController;
import io.github.anantharajuc.sbmwa.api.hateoas.common.SimpleIdentifiableRepresentationModelAssembler;
import io.github.anantharajuc.sbmwa.domain.model.Books;

@Component
public class BooksRepresentationModelAssembler extends SimpleIdentifiableRepresentationModelAssembler<Books>
{
	public BooksRepresentationModelAssembler() 
	{
		super(BookQueryController.class);
	}
	
	@Override
	public void addLinks(EntityModel<Books> resource)
	{
		super.addLinks(resource);
	}
	
	@Override
	public void addLinks(CollectionModel<EntityModel<Books>> resources) 
	{
		super.addLinks(resources);
		
		resources.add(linkTo(methodOn(RootController.class).root()).withRel("root"));
	}
}
