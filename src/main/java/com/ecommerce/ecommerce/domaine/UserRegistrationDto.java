package com.ecommerce.ecommerce.domaine;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotEmpty;

import com.ecommerce.ecommerce.utils.FieldMatch;


@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmPassword", message = "Les champs du mot de passe doivent correspondre"),
    @FieldMatch(first = "email", second = "confirmEmail", message = "Les champs d'e-mail doivent correspondre")
})
public class UserRegistrationDto {
	

	@NotEmpty
	private String username;
	  
    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String password;

    @NotEmpty
    private String confirmPassword;

    
    @NotEmpty
    private String email;

 
    @NotEmpty
    private String confirmEmail;

    @AssertTrue
    private Boolean terms;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmEmail() {
        return confirmEmail;
    }

    public void setConfirmEmail(String confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    public Boolean getTerms() {
        return terms;
    }

    public void setTerms(Boolean terms) {
        this.terms = terms;
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    
}