package com.odavid.projects.app.facturacion.models.services;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileServices {

	public Resource cargar(String nombreFoto) throws MalformedURLException;
	public String copiar(MultipartFile archivo) throws IOException;
	public boolean eliminar(String nombreFoto);
	public Path getPath(String nombreFoto);
}
