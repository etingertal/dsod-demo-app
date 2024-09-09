package io.github.anantharajuc.sbmwa.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.github.anantharajuc.sbmwa.domain.model.common.AuditEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="movies")
@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@FieldDefaults(level=AccessLevel.PRIVATE)
public class Movie extends AuditEntity
{
	private static final long serialVersionUID = 1L;
	
	@Column(name="movie_details", nullable = false)
	String movieDetails;
	
	//Bi-directional relationship
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	Person person;
}
