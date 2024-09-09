package io.github.anantharajuc.sbmwa.domain.model;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import io.github.anantharajuc.sbmwa.domain.model.common.AuditEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name="person")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@Builder
@FieldDefaults(level=AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"books", "movies","address"}) 
public class Person extends AuditEntity
{
	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "First Name cannot be null")
	@Column(name="name", nullable = false)
	String name;
	
	@Email
	@Column(name="email", nullable = false, unique=true)
	String email;
	
	@Column(name="mobile_number", nullable = true)
	String mobileNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name="gender", nullable=false)
	GenderEnum gender;
	
	@Column(name="age", nullable=true)
	int age;
	
	@JsonFormat(pattern="yyyy-MM-dd", timezone="Asia/Kolkata")
	@Column(name="dob", nullable = true)
	Date dob;
	
	@Column(name = "is_adult", nullable=false, length=1)
	Boolean isAdult;

	@JsonManagedReference
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval=true)
	@JoinColumn(name="address_id")
	Address address;

	@OneToMany(targetEntity = Books.class,cascade = CascadeType.ALL)
    @JoinColumn(name="person_id",referencedColumnName="id")
    private List<Books> books;

	@OneToMany(mappedBy="person")
	private List<Movie> movies;
}
