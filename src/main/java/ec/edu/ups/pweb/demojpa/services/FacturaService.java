package ec.edu.ups.pweb.demojpa.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.pweb.demojpa.Detalle;
import ec.edu.ups.pweb.demojpa.Factura;
import ec.edu.ups.pweb.demojpa.dao.FacturaDAO;

@Path("factura")
public class FacturaService {
	
	@Inject
	private FacturaDAO daoFactura;
	
	@GET
	@Produces("applicatio/json")
	public List<Factura> getFacturas(){
		List<Factura>facturas=daoFactura.getList();
		List<Factura> aux = new ArrayList<Factura>();
		for(Factura fac : facturas) {
		Factura f = new Factura();
		f.setCodigo(fac.getCodigo());
		f.setNumero(fac.getNumero());
		f.setTotal(fac.getTotal());
		aux.add(f);
		}
		return aux;
			
	}
	
	@GET
	@Path("all")
	@Produces("applicatio/json")
	public List<Factura> getFacturasCompletas(){
		return daoFactura.getListCompleta();
	}
	
	@GET
	@Path("one/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Factura getRa(@PathParam("id") Integer id) {
		if (id != null) {
			try {
				Factura res = daoFactura.read(id);
				return res;
			}catch (Exception e) {
			}
			}else {
			return null;
		}
		return null;
	}
}
