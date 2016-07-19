package decodificador;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Decodificador {

	
	public static void decodificar(byte[] base64, String nomeDoArquivoSemExtensao) {

		byte[] bytes = org.apache.commons.codec.binary.Base64
				.decodeBase64(base64);

		// FileUtils.writeByteArrayToFile(file, data);

		try (OutputStream stream = new FileOutputStream(
				"C:/Users/iduarteb/Pictures/bandeirasCliente/" + nomeDoArquivoSemExtensao + ".jpg")) {
			stream.write(bytes);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
