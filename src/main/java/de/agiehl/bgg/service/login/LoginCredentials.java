package de.agiehl.bgg.service.login;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
public class LoginCredentials {

	private final String username;

	@ToString.Exclude
	private final String password;
}
