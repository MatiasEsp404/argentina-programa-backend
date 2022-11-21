package com.argentina.programa.util;

public class RegExpressionUtils {

  public static final String ALPHANUMERIC_CHARACTERS_WITHOUT_BLANK_SPACES = "^[a-zA-Z0-9_]*$";
  public static final String ALPHANUMERIC_CHARACTERS_WITH_BLANK_SPACES = "^[a-zA-Z0-9_ ]*$";
  public static final String NUMERIC_CHARACTERS_WITHOUT_BLANK_SPACES = "^[0-9_]*$";
  public static final String URL =
      "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
  // TODO URL regular expression not working correctly.
  //  It should be fixed and reactivated in Information.java

}
