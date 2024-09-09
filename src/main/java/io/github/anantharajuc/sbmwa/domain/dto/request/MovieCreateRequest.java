package io.github.anantharajuc.sbmwa.domain.dto.request;

import io.github.anantharajuc.sbmwa.domain.model.Person;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
public class MovieCreateRequest 
{
	Long id;
	String movieDetails;
	Person person;
}
