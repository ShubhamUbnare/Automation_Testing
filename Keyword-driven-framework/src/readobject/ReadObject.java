package readobject;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadObject 
{
	Properties p = new Properties();                                                                            // predefine class
	public Properties getObjectRepository() throws IOException
	{
		InputStream stream = new FileInputStream(new File(System.getProperty
				("user.dir")+"\\src\\objects\\objects.properties"));                                            //Read object repository file
		p.load(stream);                                                                                          //load all objects
		return p;
	}
}
 