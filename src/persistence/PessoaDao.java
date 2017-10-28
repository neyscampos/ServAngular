package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Pessoa;

public class PessoaDao extends Dao {

	public void create(Pessoa p) throws Exception {
		open();
		try {
			stmt = con.prepareStatement("insert into pessoa values(null,?,?,?)");
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getSexo());
			stmt.setInt(3, p.getIdade());
			stmt.execute();

		} finally {
			close();
		}

	}

	public List<Pessoa> findAll() throws Exception {
		open();
		List<Pessoa> lst = new ArrayList<Pessoa>();
		try {
			stmt = con.prepareStatement("select * from pessoa");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Pessoa p = new Pessoa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				lst.add(p);
			}

		} finally {
			close();
		}

		return lst;

	}

	public Pessoa findByCode(Integer codigo) throws Exception {
		open();
		Pessoa p = null;
		try {
			stmt = con.prepareStatement("select * from pessoa where codigo = ?");
			stmt.setInt(1, codigo);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				p = new Pessoa(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			}

		} finally {
			close();
		}

		return p;
	}
	
	public void Delete(Pessoa p) throws Exception {
		open();
		try {
			stmt = con.prepareStatement("delete from pessoa where codigo = ?");
			stmt.setInt(1, p.getCodigo());
			stmt.execute();

		} finally {
			close();
		}

	}
	
	public void Delete(Integer codigo) throws Exception {
		open();
		try {
			stmt = con.prepareStatement("delete from pessoa where codigo = ?");
			stmt.setInt(1, codigo);
			stmt.execute();

		} finally {
			close();
		}

	}
}
