using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class Electrodomestico : System.Web.UI.Page
    {
        private ElectrodomesticosWSClient productoDao;
        private electrodomesticos producto;
        protected void Page_Load(object sender, EventArgs e)
        {
            int idProducto;
            productoDao = new ElectrodomesticosWSClient();
            if (Session["idElectrodomestico"] != null)
            {
                idProducto = (int)Session["idElectrodomestico"];
                Session["idElectrodomestico"] = null;
                producto = productoDao.buscarElectrodomestico(idProducto);
                if (!IsPostBack)
                {
                    cargarDatos();
                }
                Session["idModificarElectrodomestico"] = idProducto;
            }

        }
        protected void cargarDatos()
        {
            txtIdProducto.Text = producto.idProducto.ToString();
            txtNombreProducto.Text = producto.nombre;
            txtDescripcionProducto.Text = producto.descripcion.ToString();
            txtModelo.Text = producto.modelo.ToString();
            rblGarantia.SelectedValue = producto.tieneGarantia.ToString();
            if (producto.tieneGarantia.ToString() == "True")
            {
                dtpTiempoGarantia.Value = producto.tiempoGarantia.ToString("yyyy-MM-dd");
            }
            else
            {
                dtpTiempoGarantia.Value = new DateTime(1, 1, 1).ToString();
            }
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            productoDao = new ElectrodomesticosWSClient();
            producto = new electrodomesticos();
            producto.descripcion = txtDescripcionProducto.Text;
            producto.nombre = txtNombreProducto.Text;
            producto.modelo = txtModelo.Text;
            DateTime fechaGarantia;
            if (DateTime.TryParse(dtpTiempoGarantia.Value, out fechaGarantia))
            {
                producto.tiempoGarantia = fechaGarantia;
            }
            if(rblGarantia.SelectedValue == "True"){
                producto.tieneGarantia = true;
            }
            else
            {
                producto.tieneGarantia = false;
            }
            producto.tiempoGarantiaSpecified = true;
            if (Session["idModificarElectrodomestico"] != null)
            {
                producto.idProducto = (int)Session["idModificarElectrodomestico"];
                int resultado = productoDao.modificarElectrodomestico(producto);
            }
            else
            {
                producto.idProducto = productoDao.insertarElectrodomestico(producto);
            }

            Response.Redirect("listarProductos.aspx");
        }
        protected void btnRegresar_Click(object sender, EventArgs e)
        {

            if (Session["idModificarElectrodomestico"] != null)
            {
                Response.Redirect("ListarProductos.aspx");
            }
            else
            {
                Response.Redirect("SeleccionarTipoDeProducto.aspx");
            }
        }
    }
}