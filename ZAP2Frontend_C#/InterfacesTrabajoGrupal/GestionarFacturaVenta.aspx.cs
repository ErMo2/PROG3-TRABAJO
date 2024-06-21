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
        private PersonaJuridicaWSClient personaJuridicaDAO;
        private SucursalWSClient sucursalDAO;
        private ProductoPrecioWSClient productoPrecioDAO;

        private BindingList<personaJuridica> listaPersonasJuridicas;
        private BindingList<producto> listaProductos;
        private BindingList<sucursal> listaSucursales;
        private BindingList<producto> productosSeleccionados;
        private productoPrecio[] arregloProductoPrecios;
        //Listado de monedas
        private MonedaWSClient monedaDAO;
        private BindingList<moneda> listarMonedas;

        //Listar Cajeros
        private CajeroWSClient cajeroDAO;
        private BindingList<cajero> listarCajeros;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                productosSeleccionados = new BindingList<producto>();
                Session["ProductosSeleccionados"] = productosSeleccionados;
                dtpFechaEmision.Text = DateTime.Now.ToString("yyyy-MM-dd");

                CargarMonedas();
                CargarPersonasJuridicas();
                CargarSucursales();
                CargarCajeros();
            }
            else
            {
                productosSeleccionados = Session["ProductosSeleccionados"] as BindingList<producto>;
            }
        }
        private void CargarCajeros()
        {
            cajeroDAO = new CajeroWSClient();
            listarCajeros = new BindingList<cajero>(cajeroDAO.listarCajeros());
            ddlCajeros.DataSource = listarCajeros;
            ddlCajeros.DataTextField = "nombre";
            ddlCajeros.DataValueField = "idEmpleado";
            ddlCajeros.DataBind();
        }
        private void CargarPersonasJuridicas()
        {
            personaJuridicaDAO = new PersonaJuridicaWSClient();
            personaJuridica[] arregloPersonasJuridicas = personaJuridicaDAO.listarPersonasJuridicas();
            listaPersonasJuridicas = new BindingList<personaJuridica>(arregloPersonasJuridicas);

            // Crear una lista temporal para almacenar los datos combinados
            var personasJuridicasConRUC = listaPersonasJuridicas.Select(p => new
            {
                id_persona = p.id_Persona,
                nombreConRUC = $"{p.nombre} - {p.RUC}"
            }).ToList();

            ddlPersonaJuridica.DataSource = personasJuridicasConRUC;
            ddlPersonaJuridica.DataTextField = "nombreConRUC";
            ddlPersonaJuridica.DataValueField = "id_persona";
            ddlPersonaJuridica.DataBind();
        }
        protected void ddlPersonaJuridica_SelectedIndexChanged(object sender, EventArgs e)
        {
            personaJuridicaDAO = new PersonaJuridicaWSClient();
            personaJuridica[] arregloPersonasJuridicas = personaJuridicaDAO.listarPersonasJuridicas();
            listaPersonasJuridicas = new BindingList<personaJuridica>(arregloPersonasJuridicas);
            // Obtener el ID de la persona jurídica seleccionada
            int idPersonaSeleccionada = int.Parse(ddlPersonaJuridica.SelectedValue);

            // Buscar la persona jurídica en la lista para obtener su RUC
            var personaSeleccionada = listaPersonasJuridicas.FirstOrDefault(p => p.id_Persona == idPersonaSeleccionada);

            if (personaSeleccionada != null)
            {
                // Llenar el campo de texto txtRUC con el RUC de la persona seleccionada
                txtRUC.Text = personaSeleccionada.RUC;
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
                    descripcion = prod.descripcion,
                    prodPrecio = new productoPrecio
                    {
                        idProductoPrecio = prodPrecio.idProductoPrecio,
                        precio = prodPrecio.precio
                    },
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
        private void CargarMonedas()
        {
            // Asume que existe un método en monedaDAO para listar las monedas
            monedaDAO = new MonedaWSClient();
            listarMonedas = new BindingList<moneda>(monedaDAO.listarMoneda());
            ddlMonedas.DataSource = listarMonedas;
            ddlMonedas.DataTextField = "nombre";
            ddlMonedas.DataValueField = "idMoneda";
            ddlMonedas.DataBind();
        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {

            Factura_VentaWSClient facturaVentaDAO;
            personaJuridica persona = new personaJuridica();
            persona.id_Persona = Int32.Parse(ddlPersonaJuridica.SelectedValue);

            //Ingresar moneda
            moneda moneda = new moneda();
            moneda.idMoneda = Int32.Parse(ddlMonedas.SelectedValue);
            //Ingresar cajero
            cajero cajero = new cajero();
            cajero.idEmpleado = int.Parse(ddlCajeros.SelectedValue);


            //Llenar linea documento de venta
            // Crear las líneas de documento de venta a partir de los productos seleccionados
            var lineasDocVenta = new BindingList<lineaDoc>();
            foreach (var producto in productosSeleccionados)
            {
                var linea = new lineaDoc
                {
                    producto = new productoPrecio { idProductoPrecio = producto.prodPrecio.idProductoPrecio },
                    documento = new facturaVenta(),
                    precioUnitario = producto.prodPrecio.precio, // Asumiendo que 'precio' es el precio unitario del producto
                    cantidad = producto.cantidadComprada, // Ajusta esto según cómo obtienes la cantidad del producto
                    precioTotal = producto.prodPrecio.precio * producto.cantidadComprada,
                    subTotal = producto.prodPrecio.precio * producto.cantidadComprada, // Puedes ajustar esto si tienes un cálculo diferente para el subtotal
                };
                lineasDocVenta.Add(linea);
            }

            //Llenar factura de Ventas
            facturaVenta facturaVenta = new facturaVenta();

            facturaVenta.fechaVencSpecified = true;
            facturaVenta.fecha_emisionSpecified = true;
            facturaVenta.fecha_emision = DateTime.Parse(dtpFechaEmision.Text);
            facturaVenta.fechaVenc = DateTime.Parse(dtpFechaEmision.Text).AddDays(30);
            facturaVenta.moneda = new moneda { idMoneda = moneda.idMoneda };
            facturaVenta.empleado = new cajero { idEmpleado = cajero.idEmpleado };
            facturaVenta.detalles = "Compra realizada por persona juridica";
            facturaVenta.personaJuridica = persona;
            facturaVenta.lineasDocVenta = lineasDocVenta.ToArray();
            facturaVenta.total = double.Parse(lblTotal.Text, System.Globalization.NumberStyles.Currency);
            facturaVenta.tarjeta = new tarjeta
            {
                idTarjeta = 2,
                tipoTarjeta = tipoTarjeta.CUENTA_CORRIENTE,
                tipoTarjetaSpecified = true,
                banco = new banco() // Configura esto según sea necesario
            };

            facturaVentaDAO = new Factura_VentaWSClient();
            int resultado = facturaVentaDAO.insertarFacturaVenta(facturaVenta);

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