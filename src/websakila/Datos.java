package websakila;

import java.io.IOException;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Datos
 */
@WebServlet("/Datos")
public class Datos extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Datos() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DatosBEAN dbj=new DatosBEAN();
		String nombre=request.getParameter("nombre");
		String password=request.getParameter("pass");		
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sakila?user=root&password=root");			
			ps = con.prepareStatement("SELECT COUNT(*) FROM users WHERE (login=?) AND (password=?)");			
			ps.setString(1, nombre);			
			ps.setString(2, password);
			rs = ps.executeQuery();
			while(rs.next()){				
				if(rs.getInt(1)==1){
					dbj.setNombre(nombre);					
					request.setAttribute("DatosBEAN", dbj);
					request.getRequestDispatcher("acceso.jsp").forward(request,response);
				}else{
					dbj.setNombre(nombre);					
					request.setAttribute("DatosBEAN", dbj);
					request.getRequestDispatcher("loginnook.jsp").forward(request,response);
				}
			}		
		con.close();
		}catch(SQLException sqlex){
			System.out.println(sqlex);
		}catch(ClassNotFoundException clex){
			System.out.println(clex);
		}
	
	}

}
