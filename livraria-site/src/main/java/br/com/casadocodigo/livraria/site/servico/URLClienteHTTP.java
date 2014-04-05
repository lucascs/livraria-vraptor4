package br.com.casadocodigo.livraria.site.servico;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.common.io.CharStreams;

public class URLClienteHTTP implements ClienteHTTP {

	@Override
	public String get(String url) throws ServidorIndisponivelException {
		try (
			InputStream resposta = new URL(url).openStream();
			Reader reader = new InputStreamReader(resposta)
		) {
			return CharStreams.toString(reader);
		} catch (MalformedURLException e) {
			throw new IllegalArgumentException("A url " + url
					+ " está inválida, corrija-a!", e);
		} catch (IOException e) {
			throw new ServidorIndisponivelException(url, e);
		}
	}

}
