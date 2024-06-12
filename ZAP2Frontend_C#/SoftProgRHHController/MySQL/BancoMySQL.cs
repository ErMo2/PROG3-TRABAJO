using MySql.Data.MySqlClient;
using SoftProgRHHController.DAO;
using SoftProgRRHHModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgRHHController.MySQL
{
    public class BancoMySQL : BancoDAO
    {
        private MySqlConnection con;
        private MySqlCommand cmd;
        private MySqlDataReader reader;
        public int insertar(BancoAfiliado banco)
        {
            int resultado = 0;
            try
            {
                con.Open();
                cmd = new MySqlCommand();
                cmd.Connection = con;
                
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                try { con.Clone(); }
                catch (Exception ex) { throw new Exception(ex.Message); }

            }
            return resultado;
        }
    }
}
