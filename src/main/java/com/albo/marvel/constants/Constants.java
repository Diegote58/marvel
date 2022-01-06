package com.albo.marvel.constants;

import java.util.Arrays;
import java.util.List;

public class Constants {

	public static final String LAST_SYNC_PREFIX = "Fecha de la última sincronización en ";
	public static final String LAST_SYNC_FORMAT_DATE = "dd/MM/yyyy HH:mm:SS";

	public static final String ROLE_EDITOR = "editor";
	public static final String ROLE_WRITER = "writer";
	public static final String ROLE_COLORIST = "colorist";

	public static final List<String> VALID_ROLE_COLABORATORS= Arrays.asList(ROLE_EDITOR, ROLE_WRITER, ROLE_COLORIST);

	public static final int LIMIT = 100;

}
