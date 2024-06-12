using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using SoftProgDBManager;


namespace SoftProgRRHHModel
{
    public class AreaMySQL : AreaDAO
    {
        private MySqlConnection con;
        private MySqlCommand comando;
        private MySqlDataReader lector;
        public int insertar(Area area)
        {
            int resultado = 0;
            try
            {
                con = DBManager.Instance.Connection;
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandText = "InsertarArea";
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                comando.Parameters.Add("_id_Area",MySqlDbType.Int32).Direction=
                    System.Data.ParameterDirection.Output;
                comando.Parameters.AddWithValue("_NombreAmbiente", area.Nombre);
                comando.Parameters.AddWithValue("_Sucursal", area.Sucursal);
                area.Activo = true;
                comando.ExecuteNonQuery();
                area.IdArea = Int32.Parse(comando.Parameters["id_area"].Value.ToString());
                resultado = area.IdArea;
            } catch (Exception ex) {
                throw new Exception(ex.Message);
            }
            finally
            {
                try
                {
                    con.Close();
                }
                catch(Exception ex) { throw new Exception(ex.Message); }
            }
            return resultado;
        }

        public BindingList<Area> listarAreas()
        {
            BindingList<Area>areas=new BindingList<Area>();
            try
            {
                con = DBManager.Instance.Connection;
                con.Open();
                comando = new MySqlCommand();
                comando.Connection = con;
                comando.CommandText = "ListarAreasEmpleado";
                comando.CommandType = System.Data.CommandType.StoredProcedure;
                lector = comando.ExecuteReader();
                while (lector.Read())
                {
                    Area area=new Area();
                    area.IdArea = lector.GetInt32("IdAmbiente");
                    area.Nombre = lector.GetString("NombreAmbiente");
                    area.Sucursal = lector.GetString("Sucursal");
                    area.Activo = true;
                    areas.Add(area);
                }

            }
            catch (Exception ex) { throw new Exception(ex.Message); }
            finally {
                try
                {
                    lector.Close();
                }
                catch (Exception ex) { throw new Exception(ex.Message); }
                try
                {
                    con.Close();
                } catch (Exception ex) { throw new Exception(ex.Message); }
            }
            return areas;
        }
    }
}
