using MySql.Data.MySqlClient;
using SoftProgDBManager;
using SoftProgRHHController.DAO;
using SoftProgRRHHModel;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgRHHController.MySQL
{
    public class SucursalMySQL : SucursalDAO
    {
        private MySqlConnection con;
        private MySqlCommand cmd;
        private MySqlDataReader reader;
        public int eliminar(int idSucursal)
        {
            throw new NotImplementedException();
        }

        public int insertar(Sucursal sucursal)
        {
            int resultado = 0;
            try
            {
                con = DBManager.Instance.Connection;
                con.Open();
                cmd=new MySqlCommand();
                cmd.Connection = con;
                cmd.CommandText = "InsertarSucursal";
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
            
                cmd.Parameters.AddWithValue("_direccion", sucursal.NombreSucursal);
                cmd.Parameters.AddWithValue("_tam_metros", sucursal.MetrosCuadrados);
                cmd.Parameters.Add("_id_sucursal", MySqlDbType.Int32).Direction =
                System.Data.ParameterDirection.Output;
                cmd.ExecuteNonQuery();
                sucursal.IdSucursal = Int32.Parse(cmd.Parameters["_id_sucursal"].Value.ToString());
                resultado = sucursal.IdSucursal;
            }
            catch (Exception ex)
            {
                throw new Exception(ex.Message);
            }
            finally
            {
                try
                {
                    con.Close();
                }catch(Exception ex) { throw new Exception(ex.Message); }
            }
            return resultado;
        }

        public BindingList<Sucursal> listar()
        {
            BindingList<Sucursal>sucursales = new BindingList<Sucursal>();
            try
            {
                con = DBManager.Instance.Connection;
                con.Open();
                cmd = new MySqlCommand();
                cmd.Connection = con;
                cmd.CommandText = "ListarSucursales";
                cmd.CommandType = System.Data.CommandType.StoredProcedure;
                reader= cmd.ExecuteReader();
                while (reader.Read())
                {
                    Sucursal sucursal = new Sucursal();
                    sucursal.IdSucursal = reader.GetInt32("id_sucursal");
                    sucursal.NombreSucursal = reader.GetString("direccion");
                    sucursal.MetrosCuadrados = reader.GetDouble("tam_metros");
                    
                    sucursales.Add(sucursal);
                }
            }
            catch (Exception e) { throw new Exception(e.Message); }
            finally
            {
                try { con.Close(); reader.Close(); }
                catch (Exception e) { throw new Exception(e.Message); }
            }

            return sucursales;
        }
    }
}
