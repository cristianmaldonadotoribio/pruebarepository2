package com.example.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.Sides;

//@SpringBootApplication
public class PruebatecnicaApplication {

	public static void main(String[] args) throws IOException, PrintException {
		
		// Ruta del archivo a imprimir
        String rutaArchivo = "src/main/resources/static/printTrain.ps"; // Reemplaza con la ruta correcta
        
        // Crear un flujo de entrada para el archivo
        FileInputStream inputStream = new FileInputStream(new File(rutaArchivo));
        
        // Crear un arreglo de bytes para el contenido del archivo
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        
        // Crear un documento con el contenido del archivo
        Doc doc = new SimpleDoc(bytes, DocFlavor.BYTE_ARRAY.AUTOSENSE, null);
        
        // Obtener la impresora predeterminada
        PrintService impresora = javax.print.PrintServiceLookup.lookupDefaultPrintService();
        
        // Crear un trabajo de impresión
        DocPrintJob trabajoImpresion = impresora.createPrintJob();
        
        // Configurar opciones de impresión
        PrintRequestAttributeSet atributosImpresion = new HashPrintRequestAttributeSet();
        atributosImpresion.add(new Copies(1)); // Número de copias
        atributosImpresion.add(Sides.ONE_SIDED); // Impresión a una cara
        
        // Enviar el documento a imprimir
        trabajoImpresion.print(doc, atributosImpresion);
        
        // Cerrar el flujo de entrada
        inputStream.close();
		//SpringApplication.run(PruebatecnicaApplication.class, args);
		/*PruebatecnicaApplication app = new PruebatecnicaApplication();
	    //app.stringInvertido();
		
		//app.verifyPalindromo();
		int[] numeros = {1, 5, 3, 2, 4, 6};
		//app.obtenerSumaNumeros(numeros, 10);
		//app.sumas(numeros, 9);
		app.obtenerNumerosDeRomanos();*/
	}
	
	/*private String stringInvertido() {
		String hola = "Hola-mundo*del*programador!!!";
		String textoInvertido;
		StringBuilder builder = new StringBuilder();
		
		for (int i = hola.length()-1; i > -1; i--) {
			
			if(String.valueOf(hola.charAt(i)).matches("[a-zA-Z]")) {
				builder.append(hola.charAt(i));
			}
		}
		for (int e = 0; e < hola.length(); e++) {
			if(!String.valueOf(hola.charAt(e)).matches("[a-zA-Z]")) {
				builder.insert(e, hola.charAt(e));
			}
		}
		textoInvertido = builder.toString();
		System.out.println(textoInvertido);
		
		return builder.toString();
	}*/

	/*private Boolean verifyPalindromo() {
		String palabra = "bob";
		Boolean coinciden = false;
		
		for(int i = 0, j = palabra.length()-1; i<palabra.length(); i++ , j--) {
			if(palabra.charAt(i) == palabra.charAt(j)) {
					coinciden = true;
					System.out.println("estoy aca if");
				}else {
					System.out.println("estoy aca else");
					coinciden = false;
					break;
				}	
		}
		
		System.out.println(coinciden);
		return coinciden;
	}
	
	private String obtenerSumaNumeros(int [] numeross, int numero){
		
		List<List<Integer>> lista = new ArrayList<List<Integer>>();


		for(int e= 0; e<numeross.length; e++) {
			for(int i=e, j=e+1, k=e+2; j<numeross.length-1;j++,k++) {
				//System.out.println("iteraciones xD");
				if(numeross[i] + numeross[j] + numeross[k] == numero ) {
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(numeross[i]);
					temp.add(numeross[j]);
					temp.add(numeross[k]);
					ArrayList<Integer> tempinv = new ArrayList<>(temp);
					Collections.reverse(tempinv);
					boolean contieneListaInterna3 = lista.stream().anyMatch(listaa -> listaa.equals(tempinv));
					if(!contieneListaInterna3) {
						Integer[] array = temp.toArray(new Integer[0]);
						System.out.println(Arrays.toString(array));
						lista.add(temp);
					}
				}
			}
			for(int i=e, j=0; j<numeross.length;j++) {
					if(i==j) {
						continue;
					}
					if(numeross[i] + numeross[j] == numero) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(numeross[i]);
						temp.add(numeross[j]);
						ArrayList<Integer> tempinv = new ArrayList<>(temp);
						Collections.reverse(tempinv);
						boolean contieneListaInterna3 = lista.stream().anyMatch(listaa -> listaa.equals(tempinv));
						if(!contieneListaInterna3) {
							Integer[] array = temp.toArray(new Integer[0]);
							System.out.println(Arrays.toString(array));
							lista.add(temp);
						}
					}
				}	
			
		}
		return "xD";
	}
	
	private String sumas(int [] numeross, int objetivo) {
		List<List<Integer>> lista = new ArrayList<List<Integer>>();
		int [] numero = numeross; 
		Object[] result = null;
		
		for(int i = 0; i<numeross.length; i++) {
			result = iterarArray(numero);
			
			List<Integer> tempora =  (List<Integer>) result[1];
			if((int)result[2] == objetivo) {
				lista.add(tempora);
			}
			int[] nuevoArray = new int[numero.length - 1];
	        
	        for (int e = 0; e < nuevoArray.length; e++) {
	            nuevoArray[e] = numero[e];
	        }
	        numero = nuevoArray;
	        System.out.println("estas son las sumas : "+result[2]+lista);
		}
		
		return "xD";
	}
	
	private Object[] iterarArray(int[] numeross) {
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int suma = 0;
		for(int i=0; i<numeross.length; i++ ) {
			temp.add(numeross[i]);
			suma+= numeross[i];
			
		}
		for(int e=1; e>0; e++) {
			
		}
		return new Object[] {numeross, temp, suma};
	}
	
	private int obtenerNumerosDeRomanos() {
		
		String entrada = "MDCXL";
		Pattern pattern = Pattern.compile("(IV)|(IX)|(XL)|(XC)|(CD)|(CM)|([IXCLVDM])");

        Matcher matcher = pattern.matcher(entrada);
        List<String> resultados = new ArrayList<>();

        while (matcher.find()) {
            resultados.add(matcher.group());
        }
        
        String[] arrayResultados = resultados.toArray(new String[0]);
        for (String parte : arrayResultados) {
            System.out.println(parte);
        }
		
		String [] numRom = {"I", "V", "X", "IV", "IX", "XL", "XC", "C","CD","D","CM","M"};
		int[] rumNor = {1,5,10,4,9,40,90,100,400,500,900,1000};
		//StringBuilder convNum = new StringBuilder();
		int suma = 0;
		
		for(int i = 0; i<arrayResultados.length; i++) {
			for(int e = 0; e<numRom.length; e++) {
				if(arrayResultados[i].equals(numRom[e]) ) {
					System.out.println(rumNor[e]);
					suma += rumNor[e];
				}
			}
			
		}
		//int resultado = Integer.parseInt(convNum.toString());
		System.out.println(suma);
		
		return suma;
	}*/
}
