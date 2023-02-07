package ec.edu.ups.pweb.demojpa.services;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import ec.edu.ups.pweb.demojpa.Persona;
import ec.edu.ups.pweb.demojpa.Producto;
import ec.edu.ups.pweb.demojpa.dao.ProductoDAO;


@Path("productos")
public class ProductoService {
	
	@Inject
	private ProductoDAO daoProducto;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Producto misDatos(){
		Producto pr=new Producto();
		pr.setCodigo(2);
		pr.setNombre("cafe");
		pr.setPrecio(3.80);
		pr.setStock(15);
		return pr;
	}
	
	public String guardarProducto (int codigo, String nombre, double precio, int stock) {
		Producto pr =new Producto();
		pr.setCodigo(codigo);
		pr.setNombre(nombre);
		pr.setPrecio(precio);
		pr.setStock(stock);
		daoProducto.insert(pr);
		
		return "insertado";
	}
	
	@POST
	@Path("guardar")
	@Produces("application/json")
	@Consumes("application/json")
	public String guardarProductoObjeto(Producto p) {
		try {
			daoProducto.insert(p);
		}catch(Exception e){
			return "{\"resultado\":\"ERROR\"}"; 
		}
		return "{\"resultado\":\"ok\"}";
	}
	
	@GET
	@Path("/lisProductos")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Producto> getListadoProductos(){
		return daoProducto.getList();
	}
}