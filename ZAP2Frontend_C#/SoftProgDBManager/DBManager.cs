using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgDBManager
{
    public class DBManager
    {
        private MySqlConnection con;

        private static DBManager dbManager;
        //private string url = "server=localhost;";
        //private string usuario = "user=Rodrigo;";
        //private string password = "password=Sanemi_2024;";
        //private string puerto = "port=;";
        //private string basedatos = "database=basededatos;";
        private static string connectionString = "server=localhost;user=Rodrigo;password=Sanemi_2024;database=basededatos;";

        public MySqlConnection Connection
        {
            get
            {
                //string cadena = url + usuario + password /*+ puerto */+ basedatos;
                con = new MySqlConnection(connectionString);
                return con;
            }
        }

        public static DBManager Instance
        {
            get
            {
                if (dbManager == null)
                {
                    createInstance();
                }
                return dbManager;
            }
        }

        private static void createInstance()
        {
            if (dbManager == null)
            {
                dbManager = new DBManager();
            }
        }
    }
}
