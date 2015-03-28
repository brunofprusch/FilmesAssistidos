package br.com.filmesAssistidos.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.filmesAssistidos.dao.FilmeDAO;
import br.com.filmesAssistidos.dao.HistoricoFilmeDAO;
import br.com.filmesAssistidos.model.Filme;
import br.com.filmesAssistidos.model.HistoricoFilme;

public class IncludFilmAction {
		
		private Filme filme;
		private HistoricoFilme historicoFilme;
		private File myFile;
		private String myFileContentType;
		private String myFileFileName;	
		private final String destPath = "/opt/imagens/";
		
		@Action(value = "includFilmAction", results = {
				@Result(name = "success", location = "/index.jsp"),
				@Result(name = "error", location = "/error.jsp")
		})
		public String includFilmAction(){
				Session s = null;
				Transaction t = null;
				
				try{
					
					s = FilmeDAO.getInstance().createSession();
					t = s.beginTransaction();
					
					FilmeDAO.getInstance().save(filme, s);
					filme.setPathImagem(saveImage());
					FilmeDAO.getInstance().update(filme, s);
					historicoFilme.setFilme(filme);
					HistoricoFilmeDAO.getInstance().save(historicoFilme, s);
					
					t.commit();
				}catch(HibernateException he){
					he.printStackTrace();
					t.rollback();
					
				}catch(Exception e){
					e.printStackTrace();
					t.rollback();
					
				}finally{
					FilmeDAO.closeSession(s);
				}
			
			
			return "success";
		}

		public String saveImage() throws IOException{
			
			
			String extension = getImageExtension();
			this.setMyFileFileName(filme.getId() + extension);
			
			File destFile  = new File(destPath, this.getMyFileFileName());
	    	FileUtils.copyFile(myFile, destFile);
			
			return destFile.getPath();
		}
		
		public String getImageExtension(){
			
			String extension = "";
			
			if(myFileContentType.contains("jpeg".toLowerCase())){
				extension = ".jpeg";
				
			}else if(myFileContentType.contains("jpg".toLowerCase())){
				extension = ".jpg";
				
			}else if(myFileContentType.contains("png".toLowerCase())){
				extension = ".png";
			}
			
			return extension;
		}
		
		
		public Filme getFilme() {
			return filme;
		}

		public void setFilme(Filme filme) {
			this.filme = filme;
		}

		public HistoricoFilme getHistoricoFilme() {
			return historicoFilme;
		}

		public void setHistoricoFilme(HistoricoFilme historicoFilme) {
			this.historicoFilme = historicoFilme;
		}


		public File getMyFile() {
			return myFile;
		}


		public void setMyFile(File myFile) {
			this.myFile = myFile;
		}


		public String getMyFileContentType() {
			return myFileContentType;
		}


		public void setMyFileContentType(String myFileContentType) {
			this.myFileContentType = myFileContentType;
		}


		public String getMyFileFileName() {
			return myFileFileName;
		}

		
		public void setMyFileFileName(String myFileFileName) {
			this.myFileFileName = myFileFileName;
		}
}
