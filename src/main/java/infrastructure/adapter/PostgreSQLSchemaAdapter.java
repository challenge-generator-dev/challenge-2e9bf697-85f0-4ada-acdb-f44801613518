// TODO(reto): archivo stubbeado; implementa los cuerpos.
package infrastructure.adapter;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PostgreSQLSchemaAdapter {

    private final Connection connection;

    public PostgreSQLSchemaAdapter(Connection connection) {
        this.connection = connection;
    }

    public void createSchema() {
      throw new UnsupportedOperationException("TODO(reto): createSchema");
    }

    public void createLoanTable() {
      throw new UnsupportedOperationException("TODO(reto): createLoanTable");
    }

    public void createPaymentTable() {
      throw new UnsupportedOperationException("TODO(reto): createPaymentTable");
    }

    public void createClientTable() {
      throw new UnsupportedOperationException("TODO(reto): createClientTable");
    }

    public void applyNormalization() {
      throw new UnsupportedOperationException("TODO(reto): applyNormalization");
    }

    private void executeSql(String sql) {
      throw new UnsupportedOperationException("TODO(reto): executeSql");
    }

    public String generateSchemaScript() {
      throw new UnsupportedOperationException("TODO(reto): generateSchemaScript");
    }
}