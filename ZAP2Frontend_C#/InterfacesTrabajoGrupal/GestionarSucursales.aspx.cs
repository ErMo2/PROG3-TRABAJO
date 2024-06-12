using SoftProgRHHController.DAO;
using SoftProgRHHController.MySQL;
using SoftProgRRHHModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class GestionarSucursales : System.Web.UI.Page
    {
        private SucursalDAO sucursalDao;
        private Sucursal sucursal;
        protected void Page_Load(object sender, EventArgs e)
        {
            
        }
        protected void PageInit(object sender, EventArgs e)
        {
          
        }
 
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            sucursal = new Sucursal();
            sucursalDao = new SucursalMySQL();
            sucursal.NombreSucursal = txtUbicacionSucursal.Text;
            sucursal.MetrosCuadrados = double.Parse(txtTamanio.Text);
            sucursalDao.insertar(sucursal);
            Response.Redirect("ListarSucursales.aspx");
        }
        protected void btnRegresar_Click(object senmder, EventArgs e)
        {

            Response.Redirect("ListarSucursales.aspx");
        }
    }
}