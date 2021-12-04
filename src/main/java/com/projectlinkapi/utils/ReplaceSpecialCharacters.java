package com.projectlinkapi.utils;

public class ReplaceSpecialCharacters {


	public String replaceAll(String string) {
		
		String comAcentos = "ÄÅÁÂÀÃäáâàãÉÊËÈéêëèÍÎÏÌíîïìÖÓÔÒÕöóôòõÜÚÛüúûùÇç";
		String semAcentos = "AAAAAAaaaaaEEEEeeeeIIIIiiiiOOOOOoooooUUUuuuuCc";
		
		/*
		 * REMOVE ACENTOS
		 * */
		for (int i = 0; i < comAcentos.length(); i++)
	    {
			string = string.replace(comAcentos.charAt(i), semAcentos.charAt(i));
	    }
		
		/*
		 * CAIXA BAIXA
		 * */
		string = string.toLowerCase();
		

		/*
		 * SUBSTITUI ESPAÇOS POR "-"
		 * */
		string = string.replaceAll(" ", "-");

		/*
		 * REMOVER CARACTERS ESPECIAIS, EXETO O "-"
		 * */
		string = string.replaceAll("[^a-z\\-0-9]","");

		return string;
	}	
}
