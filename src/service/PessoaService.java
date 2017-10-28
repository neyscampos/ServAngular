package service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;

import entity.Pessoa;
import persistence.PessoaDao;

@Path("/pessoa")
public class PessoaService {

	@GET
	@Path("/gravar/{nome}/{sexo}/{idade}")
	@Produces("text/plain")
	public String gravar(@PathParam("nome") String nome, @PathParam("sexo") String sexo,
			@PathParam("idade") String idade) {

		try {
			Pessoa p = new Pessoa(null, nome, sexo, Integer.parseInt(idade));
			PessoaDao dao = new PessoaDao();

			dao.create(p);

			return "Dados gravados...";

		} catch (Exception e) {
			return "Error: " + e.getMessage();

		}
	}

	@GET
	@Path("/listar")
	@Produces("Application/json")
	public String listar() {

		try {
			String json = new Gson().toJson(new PessoaDao().findAll());

			return json;

		} catch (Exception e) {
			return "Error: " + e.getMessage();

		}
	}
	
	@GET
	@Path("/listar/{codigo}")
	@Produces("Application/json")
	public String listar(@PathParam("codigo") String codigo) {

		try {
			String json = new Gson().toJson(new PessoaDao().findByCode(Integer.parseInt(codigo)));

			return json;

		} catch (Exception e) {
			return "Error: " + e.getMessage();

		}
	}

	@GET
	@Path("/excluir/{codigo}")
	@Produces("text/plain")
	public String excluir(@PathParam("codigo") String codigo) {

		try {
			new PessoaDao().Delete(Integer.parseInt(codigo));

			return "Dados excluídos com sucesso";

		} catch (Exception e) {
			return "Error: " + e.getMessage();

		}
	}
}
