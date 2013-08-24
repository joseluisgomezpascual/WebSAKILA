package websakila;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class DatosBEAN
 */
@Stateless
@LocalBean
public class DatosBEAN {
	
	private String nombre;
	private String password;
    /**
     * Default constructor. 
     */
    public DatosBEAN() {
        // TODO Auto-generated constructor stub
    }
    
    public void setNombre(String nombre){
    	this.nombre=nombre;
    }
    
    public void setPassword(String password){
    	this.password=password;
    }

    public String getNombre(){
    	return nombre;
    }
    
    public String getPassword(){
    	return password;
    }
}
