using InterfacesTrabajoGrupal.ServicioWS;
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
        private SucursalWSClient sucursalDAO;
        private sucursal sucursal;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                int idSucursal;
                if (int.TryParse(Request.QueryString["id"], out idSucursal))
                {
                    CargarSucursal(idSucursal);
                }
            }
        }

        private void CargarSucursal(int idSucursal)
        {
            sucursalDAO = new SucursalWSClient();
            var listaSucursales = sucursalDAO.listarSucursal();

            if (listaSucursales != null)
            {
                sucursal = listaSucursales.FirstOrDefault(s => s.id_sucursal == idSucursal);
                if (sucursal != null)
                {
                    txtIdSucursal.Text = sucursal.id_sucursal.ToString();
                    txtUbicacionSucursal.Text = sucursal.direccion;
                    txtTamanio.Text = sucursal.tam_metros.ToString();
                }
            }
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            sucursalDAO = new SucursalWSClient();
            sucursal = new sucursal();
            if (!string.IsNullOrEmpty(txtIdSucursal.Text))
            {
                sucursal.id_sucursal = int.Parse(txtIdSucursal.Text);
            }
            sucursal.direccion = txtUbicacionSucursal.Text;
            sucursal.tam_metros = double.Parse(txtTamanio.Text);

            if (sucursal.id_sucursal > 0)
            {
                // Actualizar sucursal existente
                sucursalDAO.modificarSucursal(sucursal);
            }
            else
            {
                // Insertar nueva sucursal
                sucursal.id_sucursal = sucursalDAO.insertarSucursal(sucursal);
            }

            Response.Redirect("ListarSucursales.aspx");
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarSucursales.aspx");
        }
    }
}