package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Main {

	public static void main(String[] args) {
		//System.out.println("HOLA MUNDO");
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("JPA_sesion01");
		EntityManager em = fabrica.createEntityManager();
		
		List<Usuario> lstUsuarios = em.createQuery("Select a From Usuario a", Usuario.class).getResultList();
		System.out.println("==============================================");
		/*Mostrar cantidad de usuarios*/
		System.out.println("nro de usuarios:" +lstUsuarios.size());
		System.out.println("==============================================");
		/*Listar todos los usuarios*/
		for(Usuario u: lstUsuarios){
			System.out.println("usuario: "+u.getNomUsua()+ " " + u.getApeUsua()+ " "+ u.getClaUsua());
		}
		System.out.println("==============================================");
		/*Búsqueda de usuario*/
		Usuario us = em.find(Usuario.class,1);
		System.out.println(us);
		System.out.println("==============================================");
	}

}
