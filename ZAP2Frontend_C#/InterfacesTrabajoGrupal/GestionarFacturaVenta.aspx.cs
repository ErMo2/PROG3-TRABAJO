using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing.Printing;
using System.Linq;
using System.ServiceModel.Channels;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class FacturaVenta : System.Web.UI.Page
    {
        private FacturaVenta facturaVenta;
        private Factura_VentaWSClient facturaVentaDAO;
        private PersonaJuridicaWSClient personaJuridicaDAO;
        private SucursalWSClient sucursalDAO;
        private ProductoPrecioWSClient productoPrecioDAO;

        private BindingList<personaJuridica> listaPersonasJuridicas;
        private BindingList<producto> listaProductos;
        private BindingList<sucursal> listaSucursales;
        private BindingList<producto> productosSeleccionados;
        private productoPrecio[] arregloProductoPrecios;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                productosSeleccionados = new BindingList<producto>();
                Session["ProductosSeleccionados"] = productosSeleccionados;

                CargarPersonasJuridicas();
                CargarSucursales();
            }
            else
            {
                productosSeleccionados = Session["ProductosSeleccionados"] as BindingList<producto>;
            }
        }

        private void CargarPersonasJuridicas()
        {
            personaJuridicaDAO = new PersonaJuridicaWSClient();
            personaJuridica[] arregloPersonasJuridicas = personaJuridicaDAO.listarPersonasJuridicas();
            listaPersonasJuridicas = new BindingList<personaJuridica>(arregloPersonasJuridicas);
            ddlPersonaJuridica.DataSource = listaPersonasJuridicas;
            ddlPersonaJuridica.DataTextField = "nombre";
            ddlPersonaJuridica.DataValueField = "id_persona";
            ddlPersonaJuridica.DataBind();
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

            listaProductos = new BindingList<producto>(
                arregloProductoPrecios.Select(pp => pp.producto).Where(p => p != null).ToList()
            );

            ddlProducto.DataSource = listaProductos;
            ddlProducto.DataTextField = "nombre";
            ddlProducto.DataValueField = "idProducto";
            ddlProducto.DataBind();
        }

        protected void ddlSucursal_SelectedIndexChanged(object sender, EventArgs e)
        {
            CargarProductosPorSucursal();
        }

        protected void btnAgregarProducto_Click(object sender, EventArgs e)
        {
            int idProducto = int.Parse(ddlProducto.SelectedValue);
            int cantidad = int.Parse(txtCantidad.Text);
            int idSucursal = int.Parse(ddlSucursal.SelectedValue);
            productoPrecioDAO = new ProductoPrecioWSClient();
            arregloProductoPrecios = productoPrecioDAO.listarProductoPrecioProductoDeUnaSucursal(idSucursal);

            productoPrecio prodPrecio = arregloProductoPrecios.FirstOrDefault(pp => pp.producto.idProducto == idProducto);
            producto prod = prodPrecio.producto;

            if (prod != null)
            {
                producto prodSel = new producto
                {
                    idProducto = prod.idProducto,
                    descripcion=prod.descripcion,
                    prodPrecio = new productoPrecio { precio = prodPrecio.precio },
                    cantidadComprada = cantidad
                };

                productosSeleccionados.Add(prodSel);

                gvProductosSeleccionados.DataSource = productosSeleccionados;
                gvProductosSeleccionados.DataBind();

                CalcularTotal();
            }
        }

        protected void btnEliminarProducto_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            int index = int.Parse(btn.CommandArgument);
            productosSeleccionados.RemoveAt(index);

            gvProductosSeleccionados.DataSource = productosSeleccionados;
            gvProductosSeleccionados.DataBind();

            CalcularTotal();
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("GestionarDocumentoDeVenta.aspx");
        }

        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
           /* facturaVenta = new FacturaVenta
            {
                NumeroFactura = txtNumeroFactura.Text,
                FechaEmision = DateTime.Parse(dtpFechaEmision.Text),
                RUC = txtRUC.Text,
                PersonaJuridica = ddlPersonaJuridica.SelectedValue,
                Productos = productosSeleccionados.ToList(),
                Total = decimal.Parse(lblTotal.Text, System.Globalization.NumberStyles.Currency)
            };

            facturaVentaDAO = new Factura_VentaWSClient();
            facturaVentaDAO.RegistrarFacturaVenta(facturaVenta);
           */
            // Limpiar la sesión y redirigir a la página de listado
            Session["ProductosSeleccionados"] = null;
            Response.Redirect("ListarDocumentoDeVenta.aspx");
        }

        private void CalcularTotal()
        {
            double total = productosSeleccionados.Sum(p => p.prodPrecio.precio * p.cantidadComprada);
            lblTotal.Text = total.ToString("C");
        }
    }
}