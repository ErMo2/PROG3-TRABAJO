using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class ProductoPersonalYHogar : System.Web.UI.Page
    {
        private ProductosParaElCuidadoPersonalYDelHogarWSClient productoDao;
        private productosParaElCuidadoPersonalYDelHogar producto;
        protected void Page_Load(object sender, EventArgs e)
        {

        }
        protected void Page_Init(object sender, EventArgs e)
        {

        }
        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("SeleccionarTipoDeProducto.aspx");
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            productoDao = new ProductosParaElCuidadoPersonalYDelHogarWSClient();
            producto = new productosParaElCuidadoPersonalYDelHogar();
            producto.descripcion = txtDescripcionProducto.Text;
            producto.nombre = txtNombreProducto.Text;

            if (ddlUnidadMedida.SelectedValue == "Unidad")
            {
                producto.unidadMedida = unidadDeMedida.unidad;
            }
            else if (ddlUnidadMedida.SelectedValue == "Paquete")
            {
                producto.unidadMedida = unidadDeMedida.paquete;
            }
            else if (ddlUnidadMedida.SelectedValue == "KG")
            {
                producto.unidadMedida = unidadDeMedida.KG;
            }
            else if (ddlUnidadMedida.SelectedValue == "LT")
            {
                producto.unidadMedida = unidadDeMedida.LT;
            }
            else
            {
                producto.unidadMedida = unidadDeMedida.NA;
            }
            producto.unidadMedidaSpecified = true;
            producto.idProducto = productoDao.insertarPCH(producto);
            Response.Redirect("SeleccionarTipoDeProducto.aspx");
        }
    }
}