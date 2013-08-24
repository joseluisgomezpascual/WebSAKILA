package websakila;

import java.util.ArrayList;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class BusquedaBEAN
 */
@Stateless
@LocalBean
public class BusquedaBEAN {

	private ArrayList<String> first_name=new ArrayList<String>();
	private ArrayList<String> last_name=new ArrayList<String>();
	private ArrayList<String> title=new ArrayList<String>();
	private ArrayList<String> description=new ArrayList<String>();
    /**
     * Default constructor. 
     */
    public BusquedaBEAN() {
        // TODO Auto-generated constructor stub
    }
    
    public void setFirstName(ArrayList<String> first_name){
    	this.first_name=first_name;
    }
    
    public void setLastName(ArrayList<String> last_name){
    	this.last_name=last_name;
    }
    
    public void setTitle(ArrayList<String> title){
    	this.title=title;
    }
    
    public void setDescription(ArrayList<String> description){
    	this.description=description;
    }
    
    public ArrayList<String> getFirstName(){
    	return first_name;
    }

    public ArrayList<String> getLastName(){
    	return last_name;
    }
    
    public ArrayList<String> getTitle(){
    	return title;
    }
    
    public ArrayList<String> getDescription(){
    	return description;
    }
}
