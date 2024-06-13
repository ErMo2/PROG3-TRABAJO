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
    public partial class Ropa : System.Web.UI.Page
    {
        private RopaWSClient ropaDao;
        private ropa ropa;
        private SucursalWSClient sucursalDao;
        private BindingList<sucursal> sucursales;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarSucursales();  // Carga las sucursales al cargar la página por primera vez
                ddlTipoRopa_SelectedIndexChanged(sender, e); // Para inicializar el estado dependiente de la selección.
            }
        }

        private void CargarSucursales()
        {
            
            sucursalDao = new SucursalWSClient();
            sucursal[] ArregloSucursales = sucursalDao.listarSucursal(); // Método hipotético para obtener sucursales
            if (ArregloSucursales != null)
                sucursales = new BindingList<sucursal>(ArregloSucursales);
            ddlSucursal.DataSource = sucursales;
            ddlSucursal.DataTextField = "nombre";  // Asumiendo que el objeto sucursal tiene una propiedad 'nombre'
            ddlSucursal.DataValueField = "id_sucursal";     // Asumiendo que el objeto sucursal tiene una propiedad 'id'
            ddlSucursal.DataBind();

            ddlSucursal.Items.Insert(0, new ListItem("-- Seleccionar Sucursal --", "0"));  // Opción predeterminada
        }
        protected void Page_Init(object sender, EventArgs e)
        {
            
        }
        protected void btnRegresar_Click(object sender, EventArgs e) { 
        
            Response.Redirect("SeleccionarTipoDeProducto.aspx");
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            ropa = new ropa();
            ropaDao = new RopaWSClient();
            ropa.nombre = txtNombreProducto.Text;
            ropa.descripcion = txtDescripcionProducto.Text;
            ropa.temporada = ddlTemporada.SelectedValue;
            ropa.material = ddlMaterial.SelectedValue;
            ropa.prodPrecio = new productoPrecio();

            // Asignar el ID de la sucursal seleccionada al productoPrecio
            ropa.prodPrecio.sucursal=new sucursal();
            ropa.prodPrecio.sucursal.id_sucursal = int.Parse(ddlSucursal.SelectedValue);

            if (ddlTipoRopa.SelectedValue == "RopaHombre")
                ropa.tipo = tipoRopa.RopaHombre;
            else if (ddlTipoRopa.SelectedValue == "RopaMujer")
                ropa.tipo = tipoRopa.RopaMujer;
            else
                ropa.tipo = tipoRopa.Calzado;
            ropa.tipoSpecified = true;

            ropa.idProducto = ropaDao.insertarRopa(ropa);
            Response.Redirect("ListarProductos.aspx");
        }

        protected void ddlTipoRopa_SelectedIndexChanged(object sender, EventArgs e)
        {
           

        }
    }
}