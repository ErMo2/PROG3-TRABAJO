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
        private RopaWSClient productoDao;
        private ropa producto;
        private ProductoPrecioWSClient productoPrecioDao;
        private productoPrecio productoPrecio;
        protected void Page_Load(object sender, EventArgs e)
        {
            int idRopa;
            productoDao = new RopaWSClient();
            if (Session["idRopa"] != null)
            {
                idRopa = (int)Session["idRopa"];
                Session["idRopa"] = null;
                producto = productoDao.buscarRopa(idRopa);
                if (!IsPostBack)
                {
                    cargarDatos();
                }
                Session["idModificarRopa"] = idRopa;
            }
        }
        protected void cargarDatos()
        {
            txtIdProducto.Text = producto.idProducto.ToString();
            txtNombreProducto.Text = producto.nombre;
            txtDescripcionProducto.Text = producto.descripcion.ToString();
            ddlTemporada.SelectedValue = producto.temporada;
            txtMaterial.Text = producto.material;
            ddlTipoRopa.SelectedValue = producto.tipo.ToString();
        }
        protected void btnRegresar_Click(object sender, EventArgs e) {

            if (Session["idModificarRopa"] != null)
            {
                Response.Redirect("ListarProductos.aspx");
            }
            else
            {
                Response.Redirect("SeleccionarTipoDeProducto.aspx");
            }
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            productoDao = new RopaWSClient();
            producto = new ropa();
            producto.nombre = txtNombreProducto.Text;
            producto.descripcion = txtDescripcionProducto.Text;
            producto.temporada = ddlTemporada.SelectedValue;
            producto.material = txtMaterial.Text;


            if (ddlTipoRopa.SelectedValue == "RopaHombre")
                producto.tipo = tipoRopa.RopaHombre;
            else if (ddlTipoRopa.SelectedValue == "RopaMujer")
                producto.tipo = tipoRopa.RopaMujer;
            else
                producto.tipo = tipoRopa.Calzado;
            producto.tipoSpecified = true;

            if (Session["idModificarRopa"] != null)
            {
                producto.idProducto = (int)Session["idModificarRopa"];
                int resultado = productoDao.modificarRopa(producto);
            }
            else
            {
                producto.idProducto = productoDao.insertarRopa(producto);
            }
            Response.Redirect("ListarProductos.aspx");
        }

    }
}