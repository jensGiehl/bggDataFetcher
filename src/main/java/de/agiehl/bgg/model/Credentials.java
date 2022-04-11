package de.agiehl.bgg.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Credentials {

	private final String username;

	private final String password;
}
