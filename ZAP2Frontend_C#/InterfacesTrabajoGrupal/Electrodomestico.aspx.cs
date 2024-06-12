using InterfacesTrabajoGrupal.ServicioWS;
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
    public partial class Electrodomestico : System.Web.UI.Page
    {
        private ElectrodomesticosWSClient productoDao;
        private electrodomesticos producto;
        protected void Page_Load(object sender, EventArgs e)
        {


        }
        
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            ElectrodomesticosWSClient productoDao = new ElectrodomesticosWSClient();
            producto = new electrodomesticos();
            producto.descripcion = txtDescripcionProducto.Text;
            producto.nombre = txtNombreProducto.Text;
            producto.modelo = txtModelo.Text;
            DateTime fechaGarantia;
            if (DateTime.TryParse(dtpTiempoGarantia.Value, out fechaGarantia))
            {
                producto.tiempoGarantia = fechaGarantia;
            }
            producto.tieneGarantia = rblGarantia.SelectedItem != null && rblGarantia.SelectedValue == "True";
            producto.tiempoGarantiaSpecified = true;
            
            producto.idProducto = productoDao.insertarElectrodomestico(producto);

            Response.Redirect("listarProductos.aspx");
        }
        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("listarProductos.aspx");
        }
    }
}