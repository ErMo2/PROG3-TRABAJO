﻿using InterfacesTrabajoGrupal.ServicioWS;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Diagnostics.Eventing.Reader;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace InterfacesTrabajoGrupal
{
    public partial class GestionarAreas : System.Web.UI.Page
    {
        private AreaWSClient daoArea;
        private area area;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                int idArea;
                if (int.TryParse(Request.QueryString["id"], out idArea))
                {
                    CargarArea(idArea);
                }
            }
        }
        private void CargarArea(int idArea)
        {
            daoArea = new AreaWSClient();

            area = daoArea.buscarArea(idArea);
            if (area != null)
            {
                txtIdAmbiente.Text = area.idArea.ToString();
                txtNombreAmbiente.Text = area.nombre;
                txtSucursal.Text = area.sucursal.id_sucursal.ToString();
            }
            
        }
        protected void Page_Init(object sender, EventArgs e)
        {

        }
        protected void btnRegistrar_Click(object sender, EventArgs e)
        {
            Response.Redirect("ListarAreas.aspx");
        }
        protected void btnRegresar_Click(object senmder,EventArgs e)
        {
            Response.Redirect("ListarAreas.aspx");
        }
    }
}