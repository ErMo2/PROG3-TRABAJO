using MySql.Data.MySqlClient;
using SoftProgDBManager;
using SoftProgRHHController.DAO;
using SoftProgRRHHModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgRHHController.MySQL
{
    public class ProductoMySQL : ProductoDAO
    {
        private MySqlConnection con;
        private MySqlCommand cmd;
        //private MySqlDataReader reader;

        public int insertarProducto(Producto producto, int opcion)
        {
            int resultado = 0;
            try
            {
                con = DBManager.Instance.Connection;
                con.Open();
                cmd = new MySqlCommand();
                cmd.Connection = con;
                if (opcion == 0)
                {
                    cmd.CommandText = "InsertarRopa";
                    cmd.CommandType = System.Data.CommandType.StoredProcedure;
                    cmd.Parameters.Add("_id_producto", MySqlDbType.Int32).Direction =
                        System.Data.ParameterDirection.Output;
                    cmd.Parameters.AddWithValue("_Nombre", producto.NombreProducto);
                    cmd.Parameters.AddWithValue("_Descripcion", producto.Descripcion);
                    cmd.Parameters.AddWithValue("_Temporada", ((RopaProd)producto).Temporada);
                    cmd.Parameters.AddWithValue("_Material", ((RopaProd)producto).Material);
                    cmd.Parameters.AddWithValue("_TipoRopa", ((RopaProd)producto).Tipo.ToString());
                    cmd.ExecuteNonQuery();
                    producto.IdProducto = Int32.Parse(cmd.Parameters["id_producto"].Value.ToString());
                    resultado = producto.IdProducto;
                }
                else if (opcion == 1)
                {
                    cmd.CommandText = "InsertarElectrodomesticos";
                    cmd.CommandType = System.Data.CommandType.StoredProcedure;
                    cmd.Parameters.Add("_id_producto",MySqlDbType.Int32).Direction=
                        System.Data.ParameterDirection.Output;
                    cmd.Parameters.AddWithValue("_Nombre", producto.NombreProducto);
                    cmd.Parameters.AddWithValue("_Descripcion", producto.Descripcion);
                    cmd.Parameters.AddWithValue("_Modelo", ((ElectrodomesticoProd)producto).Modelo);
                    cmd.Parameters.AddWithValue("_TiempoGarantia", ((ElectrodomesticoProd)producto).FechaVencimiento);
                    cmd.Parameters.AddWithValue("_TieneGarantia", ((ElectrodomesticoProd)producto).TieneGarantia1);
                    cmd.ExecuteNonQuery();
                    producto.IdProducto = Int32.Parse(cmd.Parameters["_id_producto"].Value.ToString());
                    resultado = producto.IdProducto;
                }
                else if (opcion == 2)
                {
                    cmd.CommandText = "InsertarProductosParaElCuidadoPersonalYDelHogar";
                    cmd.CommandType = System.Data.CommandType.StoredProcedure;

                }
                else
                {
                    cmd.CommandText = "InsertarProductoPerecible";
                    cmd.CommandType = System.Data.CommandType.StoredProcedure;

                }
            }
            catch (Exception ex) { throw new Exception(ex.Message); }
            finally
            {
                try { con.Close(); }
                catch (Exception ex) { throw new Exception(ex.Message); }
            }
            return resultado;
        }
    }
}
