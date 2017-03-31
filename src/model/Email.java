package model;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Email {
      private Map<String,Set<String> > emails;
      public Email(){
    	  emails = new HashMap<String, Set<String> >();
      }
      public Map<String, Set<String> > getEmail(){
      	return emails;
      }
      
}
