package websakila;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Buesqueda
 */
@WebServlet("/Busqueda")
public class Busqueda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Busqueda() {
        super();
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
		BusquedaBEAN bb=new BusquedaBEAN();
		String buscar=request.getParameter("buscar");
		String opciones=request.getParameter("opciones");		
		ArrayList<String> nombre=new ArrayList<String>();
		ArrayList<String> apellidos=new ArrayList<String>();
		ArrayList<String> titulo=new ArrayList<String>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sakila?user=root&password=root"); 
			if(opciones.equals("Actores")){
				ps = con.prepareStatement("SELECT * FROM actor WHERE (first_name like ?) or (last_name like ?)");
				ps.setString(1, "%"+buscar+"%");
				ps.setString(2, "%"+buscar+"%");
				rs = ps.executeQuery();
				while(rs.next()){
					nombre.add(rs.getString("first_name"));
					apellidos.add(rs.getString("last_name"));					
				}
				bb.setFirstName(nombre);
				bb.setLastName(apellidos);
				request.setAttribute("BusquedaBEAN", bb);
				request.getRequestDispatcher("Actores.jsp").forward(request,response);
			}else{
				ps = con.prepareStatement("SELECT * FROM film WHERE title like ?");
				ps.setString(1, "%"+buscar+"%");				
				rs = ps.executeQuery();
				while(rs.next()){
					titulo.add(rs.getString("title"));										
				}
				bb.setTitle(titulo);
				request.setAttribute("BusquedaBEAN", bb);
				request.getRequestDispatcher("Peliculas.jsp").forward(request,response);
			}
		}catch(ClassNotFoundException clex){
			System.out.println(clex);
		}catch(SQLException slex){
			System.out.println(slex);
		}
		
		
	}

}
