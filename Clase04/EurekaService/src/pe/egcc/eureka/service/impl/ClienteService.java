package pe.egcc.eureka.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.eureka.db.AccesoDB;
import pe.egcc.eureka.dto.ClienteDto;
import pe.egcc.eureka.service.espec.ClienteEspec;

public class ClienteService extends AbstractService implements ClienteEspec {

  @Override
  public List<ClienteDto> getClientes(String paterno, String materno, String nombre) {
    List<ClienteDto> lista = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_cliecodigo, vch_cliepaterno, "
              + "vch_cliematerno, vch_clienombre, chr_cliedni, "
              + "vch_clieciudad, vch_cliedireccion, vch_clietelefono, "
              + "vch_clieemail from cliente "
              + "where vch_cliepaterno like ? "
              + "and vch_cliematerno like ? "
              + "and vch_clienombre like ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, paterno);
      pstm.setString(2, materno);
      pstm.setString(3, nombre);
      ResultSet rs = pstm.executeQuery();
      lista = mapper(rs);
      rs.close();
      pstm.close();
      this.setCodigo(1);
    } catch (Exception e) {
      this.setCodigo(-1);
      this.setMensaje(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }

  private List<ClienteDto> mapper(ResultSet rs) throws SQLException {
    List<ClienteDto> lista = new ArrayList<>();
    while(rs.next()){
      ClienteDto dto = new ClienteDto();
      dto.setCodigo(rs.getString("CHR_CLIECODIGO"));
      dto.setCodigo(rs.getString("VCH_CLIEPATERNO"));
      dto.setCodigo(rs.getString("VCH_CLIEMATERNO"));
      dto.setCodigo(rs.getString("VCH_CLIENOMBRE"));
      dto.setCodigo(rs.getString("CHR_CLIEDNI"));
      dto.setCodigo(rs.getString("VCH_CLIECIUDAD"));
      dto.setCodigo(rs.getString("VCH_CLIEDIRECCION"));
      dto.setCodigo(rs.getString("VCH_CLIETELEFONO"));
      dto.setCodigo(rs.getString("VCH_CLIEEMAIL"));
      lista.add(dto);
    }
    return lista;
  }


}
