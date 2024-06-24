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
        private BindingList<lote> listaLote;
        private AreaWSClient areaDao;
        private SucursalWSClient sucursalDAO;
        private BindingList<sucursal> listaSucursales;
        private BindingList<area> listaAreaxSucursales;
        private ProductoWSClient productoDao;
        private ProductoPrecioWSClient productoPrecioDAO;
        private BindingList<producto> listaProductos;
        private productoPrecio[] arregloProductoPrecios;
        private AlmacenWSClient daoAlmacen;
        private PedidoWSClient daoPedido;
        private BindingList<pedido> listaPedidos;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                int id_lote;
                if (int.TryParse(Request.QueryString["id"], out id_lote))
                {
                    lblTitulo.Text = "Modificar lote";
                    CargarLote(id_lote);
                }
                else
                {
                    lblTitulo.Text = "Registrar lote";
                    CargarSucursales();
                    CargarProductosPorSucursal();
                    CargarPedidos();
                }
            }
        }
        private void CargarLote(int id_lote)
        {
            daoLote = new LoteWSClient();
            daoPedido = new PedidoWSClient();
            productoDao = new ProductoWSClient();
            daoSucursal = new SucursalWSClient();
            lote []arregloLotes = daoLote.listarLote();
            listaLote = new BindingList<lote> (arregloLotes);
            foreach (lote lot in listaLote)
                if (lot.idLote == id_lote)
                {
                    lote = lot;
                    break;
                }
                    
            if(lote != null)
            {
                txtIdLote.Text = lote.idLote.ToString();
                txtStockInicial.Text = lote.stockInicial.ToString();
                BindingList<pedido> cargar_pedido = new BindingList<pedido>();
                pedido[] arregloPedidos = daoPedido.listarPedidos();
                foreach (pedido ped in arregloPedidos)
                    if (ped.id_pedido == lote.idPedido)
                    {
                        cargar_pedido.Add(ped);
                        break;
                    }
                ddlPedido.DataSource = cargar_pedido;
                ddlPedido.DataTextField = "nombre";
                ddlPedido.DataValueField = "id_pedido";
                ddlPedido.DataBind();
                BindingList<producto> cargar_producto = new BindingList<producto> ();
                producto []arregloProductos = productoDao.listarProductosBase();
                foreach (producto prod in arregloProductos)
                    if (prod.idProducto == lote.producto.idProducto)
                    {
                        lote.producto = prod;
                        break;
                    }
                cargar_producto.Add(lote.producto);
                ddlProducto.DataSource = cargar_producto;
                ddlProducto.DataTextField = "nombre";
                ddlProducto.DataValueField = "idProducto";
                ddlProducto .DataBind();
                CargarSucursales();
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

        private void CargarPedidos()
        {
            daoPedido = new PedidoWSClient();
            pedido[] arregloPedidos = daoPedido.listarPedidos();
            listaPedidos = new BindingList<pedido>(arregloPedidos);
            ddlPedido.DataSource = listaPedidos;
            ddlPedido.DataTextField = "nombre";
            ddlPedido.DataValueField = "id_pedido";
            ddlPedido.DataBind();
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
                lote.stockInicial = string.IsNullOrEmpty(txtStockInicial.Text) ? 0 : int.Parse(txtStockInicial.Text);
                daoAlmacen = new AlmacenWSClient();
                lote.almacen = new almacen();
                lote.almacen = daoAlmacen.buscarAlmacenDisponible(Int32.Parse(ddlSucursal.SelectedValue), lote.stockInicial);
                lote.producto = new producto();
                lote.producto.idProducto = Int32.Parse(ddlProducto.SelectedValue);
                lote.idPedido = int.Parse(ddlPedido.SelectedValue);
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