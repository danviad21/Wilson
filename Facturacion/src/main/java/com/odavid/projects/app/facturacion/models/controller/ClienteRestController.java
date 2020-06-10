package com.odavid.projects.app.facturacion.models.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.odavid.projects.app.facturacion.models.entity.Cliente;
import com.odavid.projects.app.facturacion.models.entity.Region;
import com.odavid.projects.app.facturacion.models.services.IClienteService;
import com.odavid.projects.app.facturacion.models.services.IUploadFileServices;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://192.168.1.7:4200")
public class ClienteRestController {

	@Autowired
	private IClienteService clienteService;

	@Autowired
	private IUploadFileServices uploadService;

	@GetMapping("/clientes")
	public List<Cliente> index() {
		return this.clienteService.findAllByStatusCliente(1);
	}

	@GetMapping("/clientes/page/{page}")
	public Page<Cliente> index(@PathVariable Integer page) {
		return this.clienteService.findAllByStatusCliente(1, PageRequest.of(page, 4, Sort.by("idCliente").ascending()));
	}
	
	@GetMapping("/clientes/regiones")
	public List<Region> listaRegiones() {
		return this.clienteService.findAllRegiones();
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {

		Cliente cliente = null;
		Map<String, Object> response = new HashMap<>();

		try {
			cliente = this.clienteService.findByIdClienteAndStatusCliente(id, 1);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al ejecutar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(e.getLocalizedMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (cliente == null) {
			response.put("mensaje", "EL ID ".concat(id.toString()).concat(" no existe en la base de datos!"));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}

//	List<String> errors = new ArrayList<>() JKD 8;
//	for(FieldError fe : result.getFieldErrors()) {		
//		errors.add("El campo '" + fe.getField() + "' " + fe.getDefaultMessage());
//	}

	@PostMapping("/clientes")
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) throws SQLException {

		Cliente clienteNuevo = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {
			clienteNuevo = this.clienteService.create(cliente);

		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar el insert el registro en la base de datos");
			response.put("error", e.getMessage() + ": -> " + e.getMostSpecificCause().getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente " + clienteNuevo.getNombreCliente() + " ha sido creado");
		response.put("cliente", clienteNuevo);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody Cliente clienteNuevo, BindingResult result,
			@PathVariable Long id) {

		Map<String, Object> response = new HashMap<String, Object>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			response.put("errors", errors);

			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		Cliente clienteActual = null;

		try {

			clienteActual = this.clienteService.findByIdClienteAndStatusCliente(id, 1);
			clienteActual.setNombreCliente(clienteNuevo.getNombreCliente());
			clienteActual.setApellidoCliente(clienteNuevo.getApellidoCliente());
			clienteActual.setEmailCliente(clienteNuevo.getEmailCliente());
			clienteActual.setFechaNacimientoCliente(clienteNuevo.getFechaNacimientoCliente());
			clienteActual.setUpdateAt(new Date());
			clienteActual.setRegion(clienteNuevo.getRegion());
			System.out.println(clienteActual);
			clienteActual = this.clienteService.update(id, clienteActual);

		} catch (NullPointerException eN) {
			response.put("mensaje", "EL ID ".concat(id.toString()).concat(" no existe en la base de datos!"));
			response.put("error", eN.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar registro. Existen Datos Nulos o Existentes");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente " + clienteActual.getNombreCliente() + " ha sido actualizado");
		response.put("cliente", clienteActual);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PutMapping("/clientes/dl/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Cliente clienteActual = null;
		Map<String, Object> response = new HashMap<String, Object>();

		try {

			clienteActual = this.clienteService.findByIdClienteAndStatusCliente(id, 1);

			String nombreFotoAnterior = clienteActual.getFotoCliente();

//			if (nombreFotoAnterior != null) {
//				Path rutaFotoAnterior = Paths.get("uploads").resolve(nombreFotoAnterior).toAbsolutePath();
//				File archivoFotoAnterior = rutaFotoAnterior.toFile();
//
//				if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
//					archivoFotoAnterior.delete();
//				}
//			}
			this.uploadService.eliminar(nombreFotoAnterior);
			clienteActual.setStatusCliente(0);
			clienteActual.setFotoCliente("");
			clienteActual.setUpdateAt(new Date());
			clienteActual = this.clienteService.delete(clienteActual);

		} catch (NullPointerException eN) {
			response.put("mensaje", "EL ID ".concat(id.toString()).concat(" no existe en la base de datos!"));
			response.put("error", eN.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el registro.");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El cliente " + clienteActual.getNombreCliente() + " ha sido eliminado");

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NO_CONTENT);
	}

	@PostMapping("/clientes/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("id") Long id) {

		Map<String, Object> response = new HashMap<String, Object>();
		Cliente cliente = null;
		String nombreArchivo = null;

		try {

			cliente = this.clienteService.findByIdClienteAndStatusCliente(id, 1);
			if (!archivo.isEmpty()) {
				try {
					nombreArchivo = this.uploadService.copiar(archivo);

				} catch (IOException e) {
					response.put("mensaje", "Error al subir la imagen de perfil");
					response.put("error", e.getMessage().concat(e.getCause().getMessage()));
					return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			String nombreFotoAnterior = cliente.getFotoCliente();
			this.uploadService.eliminar(nombreFotoAnterior);

			cliente.setFotoCliente(nombreArchivo);
			cliente = this.clienteService.create(cliente);
			response.put("cliente", cliente);
			response.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar registro. Existen Datos Nulos o Existentes");
			response.put("error", e.getMessage().concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}

	@GetMapping("/uploads/img/{nombreFoto:.+}")
	public ResponseEntity<Resource> verFoto(@PathVariable String nombreFoto) {

		Resource recurso = null;
		try {
			recurso = this.uploadService.cargar(nombreFoto);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + recurso.getFilename() + "\"");

		return new ResponseEntity<Resource>(recurso, httpHeader, HttpStatus.OK);
	}
}
