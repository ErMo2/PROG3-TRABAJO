using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics.Eventing.Reader;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class GestionarAreas : System.Web.UI.Page
    {
        private AreaWSClient daoArea;
        private area area;
        private SucursalWSClient sucursalDao;
        private sucursal SUCURSAL;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                int idArea;
                if (int.TryParse(Request.QueryString["id"], out idArea))
                {
                    CargarArea(idArea);
                }
            }
            sucursalDao = new SucursalWSClient();
            var sucursales = sucursalDao.listarSucursal();
            ddlSucursal.Items.Clear();
            foreach (var sucursal in sucursales)
            {
                ddlSucursal.Items.Add(new ListItem(sucursal.nombre, sucursal.id_sucursal.ToString()));

            }
        }
        private void CargarArea(int idArea)
        {
            daoArea = new AreaWSClient();
            area = daoArea.buscarArea(idArea);
            if (area != null)
            {
                txtIdArea.Text = area.idArea.ToString();
                txtNombreArea.Text = area.nombre;
               
            }
            

        }
        protected void Page_Init(object sender, EventArgs e)
        {

        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            daoArea = new AreaWSClient();
            area = new area();
            if (!string.IsNullOrEmpty(txtIdArea.Text))
            {
                area.idArea = int.Parse(txtIdArea.Text);
            }
            area.nombre = txtNombreArea.Text;
            area.sucursal = new sucursal();
            area.sucursal.id_sucursal = int.Parse(ddlSucursal.SelectedValue);
            if (area.idArea > 0)
            {
                // Actualizar sucursal existente
                daoArea.modificarArea(area);
            }
            else
            {
                // Insertar nueva sucursal
                area.idArea = daoArea.insertarArea(area);
            }
            Response.Redirect("ListarAreas.aspx");
        }
        protected void btnRegresar_Click(object senmder,EventArgs e)
        {
            Response.Redirect("ListarAreas.aspx");
        }
    }
}