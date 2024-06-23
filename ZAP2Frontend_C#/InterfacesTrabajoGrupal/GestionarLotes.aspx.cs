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
    public partial class GestionarLotes : System.Web.UI.Page
    {
        private LoteWSClient daoLote;
        private SucursalWSClient daoSucursal;
        private lote lote;
        private AreaWSClient areaDao;
        private SucursalWSClient sucursalDAO;
        private BindingList<sucursal> listaSucursales;
        private BindingList<area> listaAreaxSucursales;
        private ProductoWSClient productoDao;
        private ProductoPrecioWSClient productoPrecioDAO;
        private BindingList<producto> listaProductos;
        private productoPrecio[] arregloProductoPrecios;
        private AlmacenWSClient daoAlmacen;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                int idEmpleadoArea;
                if (int.TryParse(Request.QueryString["id"], out idEmpleadoArea))
                {
                    lblTitulo.Text = "Modificar lote";
                }
                else
                {
                    lblTitulo.Text = "Registrar lote";
                    CargarSucursales();
                    CargarProductosPorSucursal();
                }
            }
        }
        private void CargarSucursales()
        {
            sucursalDAO = new SucursalWSClient();
            sucursal[] arregloSucursales = sucursalDAO.listarSucursal();
            listaSucursales = new BindingList<sucursal>(arregloSucursales);
            ddlSucursal.DataSource = listaSucursales;
            ddlSucursal.DataTextField = "nombre";
            ddlSucursal.DataValueField = "id_sucursal";
            ddlSucursal.DataBind();
        }
        private void CargarProductosPorSucursal()
        {
            int idSucursal = int.Parse(ddlSucursal.SelectedValue);
            productoPrecioDAO = new ProductoPrecioWSClient();
            arregloProductoPrecios = productoPrecioDAO.listarProductoPrecioProductoDeUnaSucursal(idSucursal);
            ddlProducto.Items.Clear();
            if (arregloProductoPrecios != null)
            {
                listaProductos = new BindingList<producto>(
                arregloProductoPrecios.Select(pp => pp.producto).Where(p => p != null).ToList()
            );

                ddlProducto.DataSource = listaProductos;
                ddlProducto.DataTextField = "nombre";
                ddlProducto.DataValueField = "idProducto";
                ddlProducto.DataBind();
            }
            else
            {
                ddlProducto.DataSource = null;
            }
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarLotes.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            daoLote = new LoteWSClient();
            if (Page.IsValid)
            {
                lote = new lote();
                lote.idLote = string.IsNullOrEmpty(txtIdLote.Text) ? 0 : int.Parse(txtIdLote.Text);
                lote.stockInicial = Int32.Parse(txtStockInicial.Text);
                lote.stockActual = 0;
                daoAlmacen = new AlmacenWSClient();
                lote.almacen = new almacen();
                lote.almacen = daoAlmacen.buscarAlmacenDisponible(Int32.Parse(ddlSucursal.SelectedValue), lote.stockInicial);
                lote.producto = new producto();
                lote.producto.idProducto = Int32.Parse(ddlProducto.SelectedValue);
                try
                {
                    if (lote.idLote > 0)
                    {
                        daoLote.modificarLote(lote);
                    }
                    else
                    {
                        lote.idLote = daoLote.insertarLote(lote);
                    }
                    Response.Redirect("ListarLotes.aspx");
                }
                catch (Exception ex)
                {
                    // Manejar la excepción y mostrar un mensaje de error
                    ClientScript.RegisterStartupScript(this.GetType(), "alert", $"alert('Error al guardar el lote: {ex.Message}');", true);
                }
            }
        }

        protected void ddlSucursal_SelectedIndexChanged(object sender, EventArgs e)
        {
            CargarProductosPorSucursal();
        }
    }
}