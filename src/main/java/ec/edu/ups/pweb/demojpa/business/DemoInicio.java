package ec.edu.ups.pweb.demojpa.business;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.Query;

import ec.edu.ups.pweb.demojpa.Detalle;
import ec.edu.ups.pweb.demojpa.Factura;
import ec.edu.ups.pweb.demojpa.Persona;
import ec.edu.ups.pweb.demojpa.Producto;
import ec.edu.ups.pweb.demojpa.dao.FacturaDAO;
import ec.edu.ups.pweb.demojpa.dao.PersonaDAO;
import ec.edu.ups.pweb.demojpa.dao.ProductoDAO;

@Singleton
@Startup
public class DemoInicio {
	
	@Inject
	private PersonaDAO daoPersona;
	
	@Inject
	private FacturaDAO daoFactura;
	
	@Inject
	private ProductoDAO daoProducto;
	
	@PostConstruct
	public void init() {
		System.out.print("Iniciando... ");
		
		/*Persona p = new Persona();
		p.setCedula("0106840184");
		p.setNombre("John Tenemea");
		p.setAnioNacimiento(1994);
		daoPersona.insert(p);
		
		Persona p1 = new Persona();
		p1.setCedula("0106840185");
		p1.setNombre("Patricio Tenemea");
		p1.setAnioNacimiento(2005);
		
		daoPersona.insert(p1);
		
		System.out.println("todas las personas");
		List<Persona> listado= daoPersona.getList();
		for(Persona aux: listado) {
			System.out.println(aux.getCedula()+ "\t"+aux.getNombre()+"\t"+aux.getAnioNacimiento());
		}
		
		System.out.println("personas con año nacimiento mayor a ");
		List<Persona> listado2= daoPersona.getListXAnio(2000);
		for(Persona aux: listado2) {
			System.out.println(aux.getCedula()+ "\t"+aux.getNombre()+"\t"+aux.getAnioNacimiento());
		}
		
		//Actualizar un registro
		Persona p3 = daoPersona.read("0106840184");
		p3.setNombre("John Patricio Tenemea");
		
		daoPersona.update(p3);
		
		System.out.println("todas las personas actualizadas");
		List<Persona> listado3= daoPersona.getList();
		for(Persona aux: listado3) {
			System.out.println(aux.getCedula()+ "\t"+aux.getNombre()+"\t"+aux.getAnioNacimiento());
		}
		
		daoPersona.delete("0106840184");
		System.out.println("todas las personas desde borrado");
		List<Persona> listado4= daoPersona.getList();
		for(Persona aux: listado4) {
			System.out.println(aux.getCedula()+ "\t"+aux.getNombre()+"\t"+aux.getAnioNacimiento());
		}*/
		
		Producto pro = new Producto();
		pro.setCodigo(1);
		pro.setNombre("pan");
		pro.setPrecio(24.50);
		pro.setStock(20);
		daoProducto.insert(pro);
		
		Producto pro1 = new Producto();
		pro1.setCodigo(2);
		pro1.setNombre("leche");
		pro1.setPrecio(80.05);
		pro1.setStock(10);
		daoProducto.insert(pro1);
		
		Factura f = new Factura();
		f.setNumero("001-001-00089");
		f.setTotal(100.50);
		
		Persona p = new Persona();
		p.setCedula("0106840184");
		p.setNombre("John Tenemea");
		p.setAnioNacimiento(1994);
		
		daoPersona.insert(p);
		
		f.setCliente(p);
		
		Detalle d1=new Detalle();
		d1.setCantidad(1);
		d1.setNombreProducto("leche");
		d1.setPrecioUnitario(1);
		d1.setSusbtotal(1);
		
		f.addDetalle(d1);
		
		Detalle d2=new Detalle();
		d2.setCantidad(3);
		d2.setNombreProducto("carne");
		d2.setPrecioUnitario(3.50);
		d2.setSusbtotal(5);
		
		f.addDetalle(d2);
		
		Detalle d3=new Detalle();
		d3.setCantidad(4);
		d3.setNombreProducto("pan");
		d3.setPrecioUnitario(0.30);
		d3.setSusbtotal(1.20);
		
		f.addDetalle(d3);
		
		daoFactura.insert(f);
		
		List<Producto> productos=daoProducto.getList();
		System.out.println("Lista de Productos");
		for(Producto pr: productos) {
			System.out.println(pr.getCodigo()+"\t"+pr.getNombre()+"\t"+pr.getPrecio()+"\t"+pr.getStock());
		}
		System.out.println("Lista de Detalles");
		
		List<Factura> facturas=daoFactura.getList();
		for(Factura aux: facturas ) {
			System.out.println("FAC: "+aux.getNumero()+"\t"+aux.getTotal());
			System.out.println(aux.getCliente().getNombre()+"\t"+aux.getCliente().getCedula());
				
		}

	}

}
