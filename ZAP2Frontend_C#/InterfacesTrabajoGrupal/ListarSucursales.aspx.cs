using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class ListarSucursales : System.Web.UI.Page
    {

        private SucursalWSClient daoSucursal;
        private BindingList<sucursal> sucursales;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarSucursales();
            }

        }

        protected void lbRegistrarSucursal_Click(Object sender, EventArgs e)
        {
            Response.Redirect("GestionarSucursales.aspx");
        }
        protected void gvSucursales_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvSucursales.PageIndex = e.NewPageIndex;
            CargarSucursales();
        }

        protected void gvSucursales_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            daoSucursal = new SucursalWSClient();
            int idSucursal = Convert.ToInt32(e.CommandArgument);
            if (e.CommandName == "Modificar")
            {
                Response.Redirect($"GestionarSucursales.aspx?id={idSucursal}");
            }
            else if (e.CommandName == "Eliminar")
            {
                daoSucursal.eliminarSucursal(idSucursal);
                CargarSucursales();
            }
        }
        private void CargarSucursales()
        {
            daoSucursal = new SucursalWSClient();
            sucursal[] arregloSucursales = daoSucursal.listarSucursal();
            if (arregloSucursales != null)
            {
                sucursales = new BindingList<sucursal>(arregloSucursales);
                gvSucursales.DataSource = sucursales;
                gvSucursales.DataBind();
            }
        }
        private void BindGridView()
        {
            // Aquí deberías llamar a tu lógica para obtener los datos y enlazarlos al GridView
            gvSucursales.DataBind();
        }

        protected void lbBusquedaProdPerecible_Click(Object sender, EventArgs e)
        {
            
        }
    }
}