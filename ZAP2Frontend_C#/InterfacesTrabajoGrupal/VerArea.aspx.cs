﻿using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class VerArea : System.Web.UI.Page
    {
        private AreaWSClient daoArea;
        private area Area;
        private SucursalWSClient sucursalDao;
        private sucursal SUCURSAL;
        private BindingList<producto> productos;
        private producto Producto;
        private ProductoWSClient productosDao;
        private ProductoPrecioWSClient prodPreDao;
        protected void Page_Load(object sender, EventArgs e)
        {
            int idArea;
                
            if (int.TryParse(Request.QueryString["id"], out idArea))
            {
                 CargarArea(idArea);
            }
            
            sucursalDao = new SucursalWSClient();
            var sucursales = sucursalDao.listarSucursal();
            ddlSucursal.Items.Clear();
            foreach (var sucursal in sucursales)
            {
                ddlSucursal.Items.Add(new ListItem(sucursal.nombre, sucursal.id_sucursal.ToString()));

            }

            daoArea = new AreaWSClient();
            Area = daoArea.ListarProductosDelArea(idArea);
            producto[] Arregloproductos = Area.productos;
            if (Arregloproductos != null)
            {
                productos = new BindingList<producto>(Arregloproductos);
            }
            gvSucursales.DataSource = productos;
            gvSucursales.DataBind();
        }
        private void CargarArea(int idArea)
        {
            daoArea = new AreaWSClient();
            Area = daoArea.buscarArea(idArea);
            if (Area != null)
            {
                txtIdArea.Text = Area.idArea.ToString();
                txtNombreArea.Text = Area.nombre;

            }
            prodPreDao = new ProductoPrecioWSClient();
            sucursal Sucur = daoArea.BuscarSucursalPorElIDAREA(idArea);
            var Productos = prodPreDao.listarProductoPrecioProductoDeUnaSucursal(Sucur.id_sucursal);
            ddlSucursal.Items.Clear();
            foreach (var productoAux in Productos)
            {
                //if (sucursal.id_sucursal?)
                //{
                //    ddlSucursal.Items.Add(new ListItem(sucursal.nombre, sucursal.id_sucursal.ToString()));
                //}
                ddlProductos.Items.Add(new ListItem(productoAux.producto.nombre, productoAux.producto.idProducto.ToString()));

            }

        }
        protected void btnEliminar_Click(object sender, EventArgs e)
        {
            daoArea = new AreaWSClient();
            int idProducto = Int32.Parse(((LinkButton)sender).CommandArgument);
            daoArea.eliminarAreaProducto(idProducto);
            Response.Redirect(Request.RawUrl);
        }
        protected void gvSucursales_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvSucursales.PageIndex = e.NewPageIndex;
            gvSucursales.DataBind();
        }
        protected void gvSucursales_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[0].Text = DataBinder.Eval(e.Row.DataItem, "IdAreaProducto").ToString();
                e.Row.Cells[1].Text = DataBinder.Eval(e.Row.DataItem, "nombre").ToString();
                e.Row.Cells[2].Text = DataBinder.Eval(e.Row.DataItem, "prodPrecio.precio").ToString();

            }
        }

        protected void btnRegistrarProductoPrecio_Click(object sender, EventArgs e)
        {

            int idProd = Int32.Parse(ddlProductos.SelectedValue);
            daoArea.insertarAreaProducto(Int32.Parse(txtIdArea.Text),idProd);
            gvSucursales.DataBind();

            Response.Redirect(Request.RawUrl);
        }
        protected void Page_Init(object sender, EventArgs e)
        {

        }
        protected void btnRegresar_Click(object senmder, EventArgs e)
        {
            Response.Redirect("ListarAreas.aspx");
        }
    }
}