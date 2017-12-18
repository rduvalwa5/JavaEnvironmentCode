package system_src;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class system_properties_examples {	
	static Map get_sys_properties() 
	/*
	 * https://docs.oracle.com/javase/8/docs/api/java/util/Properties.html
	 * https://stackoverflow.com/questions/1066589/iterate-through-a-hashmap
	 * https://stackoverflow.com/questions/17209260/converting-java-util-properties-to-hashmapstring-string
	 */
	{		
		Properties props = java.lang.System.getProperties();
		Map<String, String> propMap = new HashMap<String, String>((Map) props);
//		System.out.println(propMap.keySet());
//		System.out.println(propMap.values());
		return propMap;		
	}
	
	static String get_sys_property(String key) {
		String output;
		try
			{ output = System.getProperty(key);
			  output = key.concat("=").concat(output);
			}
        catch (java.lang.NullPointerException exception) 
			{
//        		System.out.println(exception);
        		output = key.concat("=").concat("java.lang.NullPointerException");
        		}
		return output;
	}

	static void set_sys_property(String key ,String value ) 
	/*
	 * public Object setProperty(String key,String value)
	 * Calls the Hashtable method put. Provided for parallelism with the getProperty method. Enforces 
	 * use of strings for property keys and values. The value returned is the result of the Hashtable 
	 * call to put.
	 */
	{
		System.setProperty(key, value);
	}

//For test    
public static void main(String[] args) {
	system_properties_examples ex = new system_properties_examples();
	ex.get_sys_properties();
	Map<String,String> mProps = ex.get_sys_properties();
//	System.out.println(mProps.keySet());
	for (String key : mProps.keySet()) {
		System.out.println("Key: " + key + ", Value: " + mProps.get(key));
	}
	System.out.println("Properties size " + mProps.size());
	System.out.println(ex.get_sys_property("user.name"));
	System.out.println(ex.get_sys_property("user"));
	ex.set_sys_property("me", "reddog");
	System.out.println(ex.get_sys_property("me"));
	
}}
