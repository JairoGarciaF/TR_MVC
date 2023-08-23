package modelo;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Tarea implements Serializable {

	private static final long serialVersionUID = 1L;

	final String SQL_SELECT_ALL = "SELECT * FROM tarea";
	final String SQL_INSERT = "INSERT INTO tarea (nombre, responsable, estado) VALUES (?, ?, ?)";
	final String SQL_UPDATE = "UPDATE tarea SET nombre = ? , responsable = ? , estado = ? WHERE code = ?";
	
	private Integer code;
	private String nombre;
	private String responsable;
	private EstadoTarea estado;

	// private static List<Tarea> tareas = new ArrayList<>();

	// CONSTRUCTORS

	public Tarea() {
	}

	public Tarea(Integer code, String nombre, EstadoTarea estado) {
		super();
		this.code = code;
		this.nombre = nombre;
		this.responsable = "";
		this.estado = estado;
	}

	// GETTERS - SETTERS

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public EstadoTarea getEstado() {
		return estado;
	}

	public void setEstado(EstadoTarea estado) {
		this.estado = estado;
	}

	// BUSINESS RULES

	public List<Tarea> getTareas() {

		List<Tarea> tareas = new ArrayList<>();

		try {
			PreparedStatement pstm = BddConexion.getConnection().prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = pstm.executeQuery();

			while (rs.next()) {

				Tarea tarea = new Tarea();
				tarea.setCode(rs.getInt("code"));
				tarea.setNombre(rs.getString("nombre"));
				tarea.setResponsable(rs.getString("responsable"));
				tarea.setEstado(EstadoTarea.valueOf(rs.getString("estado")));

				tareas.add(tarea);
			}
			BddConexion.cerrar(rs);
			BddConexion.cerrar(pstm);
			BddConexion.cerrar();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return tareas;
	}

	public void crearTarea(Tarea t) {
		/*this.getTareas().add(t);*/
		try {
			PreparedStatement pstm = BddConexion.getConnection().prepareStatement(SQL_INSERT);
			pstm.setString(1, t.getNombre());	
			pstm.setString(2, t.getResponsable());
			pstm.setString(3, t.getEstado().name());
			
			pstm.executeUpdate();
			
			BddConexion.cerrar(pstm);
			BddConexion.cerrar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void update(Tarea t) {
		
		try {
			PreparedStatement pstm = BddConexion.getConnection().prepareStatement(SQL_UPDATE);
			pstm.setString(1, t.getNombre());	
			pstm.setString(2, t.getResponsable());
			pstm.setString(3, t.getEstado().name());
			pstm.setInt(4, t.getCode());
			
			pstm.executeUpdate();
			
			BddConexion.cerrar(pstm);
			BddConexion.cerrar();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
