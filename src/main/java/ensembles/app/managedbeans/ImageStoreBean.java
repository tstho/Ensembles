package ensembles.app.managedbeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.file.UploadedFile;

@ManagedBean
@RequestScoped
public class ImageStoreBean {
	
	private UploadedFile uploadedFile;

	public UploadedFile getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(UploadedFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public void storeImage() {
		
		
		try {
			
			String typeFile = uploadedFile.getContentType();
			
			System.out.println("typeFile : " + typeFile);
			
			String extension;
			
			if (typeFile.equals("image/png")) {
				
				extension= ".png";
				
			} else if(typeFile.equals("image/jpeg"))  {
				
				extension= ".jpg";
				
			} else if(typeFile.equals("image/gif"))  {
				
				extension= ".gif";
			} else {
				
				throw new IllegalArgumentException("Format d'image non accepté");
			}
			
			byte[] byteFile =uploadedFile.getContent();
			
			File file = new File("/Users/aitcheou/Desktop/EnvJEE/IDE/workspaceJEE/ensembles-app/miracle"+ extension);
			
			FileOutputStream foS = new FileOutputStream(file);
			
			foS.write(byteFile);
			
			//Cette ligne ne larche que si le nom de fichier est "simple" donc sans caractère spécial
			
			//uploadedFile.write("/Users/aitcheou/Desktop/EnvJEE/IDE/workspaceJEE/ensembles-app");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Upload success", uploadedFile.getFileName()+ "is uploaded");
		FacesContext.getCurrentInstance().addMessage(null,msg);
	}
}
