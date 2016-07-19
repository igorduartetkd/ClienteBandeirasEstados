package com.bean;

import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.webService.TransmissorDeImagemServiceProxy;

import decodificador.Decodificador;

@ManagedBean(name = "MBDecodificador")
@ViewScoped
public class MBDecodificador {
	
	private String nomeDoEstado;
	private String imagePath;
	private ArrayList<String> itens;
	private ArrayList<String> itensFiltrados;
	private byte[] base64;
	
	public String getNomeDoEstado() {
		return nomeDoEstado;
	}

	public void setNomeDoEstado(String nomeDoEstado) {
		this.nomeDoEstado = nomeDoEstado;
	}

	public ArrayList<String> getItens() {
		return itens;
	}

	public void setItens(ArrayList<String> itens) {
		this.itens = itens;
	}

	public ArrayList<String> getItensFiltrados() {
		return itensFiltrados;
	}

	public void setItensFiltrados(ArrayList<String> itensFiltrados) {
		this.itensFiltrados = itensFiltrados;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	@PostConstruct
	public void carregarLista(){
		TransmissorDeImagemServiceProxy transmissor = new TransmissorDeImagemServiceProxy();
		
		itens = new ArrayList<String>();
		try {
			String[] array = transmissor.getListaDeEstados();
			for(String nome : array){
				itens.add(nome.replaceAll(".jpg", ""));
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void carregarImagem(){
		TransmissorDeImagemServiceProxy transmissor = new TransmissorDeImagemServiceProxy();
		//nomeDoEstado = nomeDoEstado.replaceAll(".jpg", "");
		
		try {
			Decodificador.decodificar(transmissor.getBandeiraDoEstado(nomeDoEstado), nomeDoEstado);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void main(String[] args) {
		
		
		MBDecodificador decodificador = new MBDecodificador();
		
		decodificador.carregarLista();
		
		for(String nome : decodificador.getItens()){
			System.out.println(nome);
			String nome2 = nome.replaceAll(".jpg", "");
			decodificador.setNomeDoEstado(nome2);
			decodificador.carregarImagem();
		}
		
		/*
		decodificador = new MBDecodificador();
		
		decodificador.setNomeDoEstado("ac");
		
		decodificador.carregarImagem();
		*/
	}

	public byte[] getBase64() {
		return base64;
	}

	public void setBase64(byte[] base64) {
		this.base64 = base64;
	}

	
}
