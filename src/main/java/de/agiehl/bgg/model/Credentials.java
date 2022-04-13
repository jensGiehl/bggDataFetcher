package de.agiehl.bgg.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Credentials {

	private final String username;

	private final String password;
}
