package ensembles.app.managedbeans;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.file.UploadedFile;

@ManagedBean(name = "uploadBean")
@SessionScoped
public class UploadBean implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Part uploadedFile;

	private String text;

	public Part getUploadedFile() {
		return uploadedFile;
	}

	/*
	 * public StreamedContent getUploadedFileAsStream() {
	 * 
	 * if (uploadedFile != null) { uploadedFile.getInputStream();
	 * 
	 * ByteArrayInputStream bais = new
	 * ByteArrayInputStream(uploadedFile.getInputStream().readAllBytes());
	 * 
	 * return new StreamedContent; } return null;
	 * 
	 * try { return DefaultStreamedContent.builder() .contentType("image/png")
	 * .stream(() -> { try {
	 * 
	 * return new
	 * ByteArrayInputStream(uploadedFile.getInputStream().readAllBytes()); } catch
	 * (Exception e) { e.printStackTrace(); return null; } }) .build(); } catch
	 * (Exception e) { e.printStackTrace(); return null; } }
	 */

	public void uploadFile(/*FileUploadEvent event*/) {

		System.out.println("uploaded file :" + uploadedFile.getContentType());

		if (null != uploadedFile) {
			try {
				InputStream is = uploadedFile.getInputStream();
				
				//text = new Scanner(is).useDelimiter("\\A").next();

				byte[] content = is.readAllBytes();
				
			System.out.println("After upload :" + content);
			
			text = "Contenu, taille" + content.length;
			
			} catch (IOException ex) {
			}
		}


		//System.out.println("uploadFile : event " + event);
		//uploadedFile = event.getFile();

		System.out.println("uploadFile : file " + uploadedFile.getContentType());
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


}
