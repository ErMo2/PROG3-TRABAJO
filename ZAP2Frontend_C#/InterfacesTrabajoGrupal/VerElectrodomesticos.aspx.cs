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
    public partial class VerElectrodomesticos : System.Web.UI.Page
    {
        private ElectrodomesticosWSClient productoDao;
        private electrodomesticos producto;
        //private DescuentoWSClient descuentoDao;
        private ProductoPrecioWSClient productoPrecioDao;
        private BindingList<productoPrecio> prodPred;
        private productoPrecio Producto;
        private SucursalWSClient sucursalDao;
        protected void Page_Load(object sender, EventArgs e)
        {
            int idElectrodomestico;
            productoDao = new ElectrodomesticosWSClient();

            if (Session["idElectrodomesticoVisualizar"] != null)
            {
                idElectrodomestico = (int)Session["idElectrodomesticoVisualizar"];
                producto = productoDao.buscarElectrodomestico(idElectrodomestico);
                if (!IsPostBack)
                {
                    cargarDatos(idElectrodomestico);
                }
                productoPrecioDao = new ProductoPrecioWSClient();
                productoPrecio[] ArregloProdPre = productoPrecioDao.listarProductoPrecioProducto(idElectrodomestico);
                if (ArregloProdPre != null)
                {
                    prodPred = new BindingList<productoPrecio>(ArregloProdPre);
                }

                gvSucursales.DataSource = prodPred;
                gvSucursales.DataBind();
            }
        }
        protected void cargarDatos(int idElectrodomestico)
        {
            txtIdProducto.Text = producto.idProducto.ToString();
            txtNombreProducto.Text = producto.nombre;
            txtDescripcionProducto.Text = producto.descripcion.ToString();
            txtModelo.Text = producto.modelo.ToString();
            rblGarantia.SelectedValue = producto.tieneGarantia.ToString();
            dtpTiempoGarantia2.Text = producto.tiempoGarantia.ToString("yyyy-MM-dd");
            sucursalDao = new SucursalWSClient();
            var sucursales = sucursalDao.listarSucursalesDeUnProductoSinPrecio(idElectrodomestico);
            ddlSucursal.Items.Clear();
            foreach (var sucursal in sucursales)
            {
                ddlSucursal.Items.Add(new ListItem(sucursal.nombre, sucursal.id_sucursal.ToString()));

            }
        }
        protected void gvSucursales_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[0].Text = DataBinder.Eval(e.Row.DataItem, "idProductoPrecio").ToString();
                e.Row.Cells[1].Text = DataBinder.Eval(e.Row.DataItem, "sucursal.nombre").ToString();
                e.Row.Cells[2].Text = DataBinder.Eval(e.Row.DataItem, "precio").ToString();

            }
        }
        protected void gvSucursales_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvSucursales.PageIndex = e.NewPageIndex;
            gvSucursales.DataBind();
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarProductos.aspx");
        }
        
        protected void btnEliminar_Click(object sender, EventArgs e)
        {
            productoPrecioDao = new ProductoPrecioWSClient();
            int idProductoPrecio = Int32.Parse(((LinkButton)sender).CommandArgument);
            productoPrecioDao.eliminarProductoPrecio(idProductoPrecio);
            Response.Redirect(Request.RawUrl);
        }
        protected void btnRegistrarProductoPrecio_Click(object sender, EventArgs e)
        {
            //Producto.sucursal= new sucursal();
            Producto = new productoPrecio();
            Producto.sucursal = new sucursal();
            Producto.sucursal.id_sucursal = int.Parse(ddlSucursal.SelectedValue);

            Producto.precio = double.Parse(txtNuevoPrecio.Text);
            Producto.producto = new producto();
            Producto.producto.idProducto = Int32.Parse(txtIdProducto.Text);
            productoPrecioDao.insertarProductoPrecio(Producto);
            gvSucursales.DataBind();

            Response.Redirect(Request.RawUrl);
        }
    }
}