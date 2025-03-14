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
    public partial class ListarEmpleados : System.Web.UI.Page
    {
        private EmpleadoDeAreaWSClient daoEmpleadoArea;
        private CajeroWSClient daoCajero;
        private SupervisorWSClient daoSupervisor;

        private BindingList<empleadoDeArea> empleadosArea;
        private BindingList<cajero> cajeros;
        private BindingList<supervisor> supervisores;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                CargarDatos();
            }
        }

        private void CargarDatos()
        {
            daoEmpleadoArea = new EmpleadoDeAreaWSClient();
            daoCajero = new CajeroWSClient();
            daoSupervisor = new SupervisorWSClient();

            empleadoDeArea[] listaEmpleadosArea = daoEmpleadoArea.listarEmpleadoArea();
            cajero[] listaCajeros = daoCajero.listarCajeros();
            supervisor[] listaSupervisores = daoSupervisor.listarSupervisores();

            if (listaEmpleadosArea != null)
                empleadosArea = new BindingList<empleadoDeArea>(listaEmpleadosArea);
            else
                empleadosArea = new BindingList<empleadoDeArea>(); // Inicializa aunque esté vacío

            if (listaCajeros != null)
                cajeros = new BindingList<cajero>(listaCajeros);
            else
                cajeros = new BindingList<cajero>(); // Inicializa aunque esté vacío

            if (listaSupervisores != null)
                supervisores = new BindingList<supervisor>(listaSupervisores);
            else
                supervisores = new BindingList<supervisor>(); // Inicializa aunque esté vacío

            gvEmpleadosArea.DataSource = empleadosArea;
            gvCajeros.DataSource = cajeros;
            gvSupervisores.DataSource = supervisores;

            gvEmpleadosArea.DataBind();
            gvCajeros.DataBind();
            gvSupervisores.DataBind();

            ViewState["EmpleadosArea"] = empleadosArea;
            ViewState["Cajeros"] = cajeros;
            ViewState["Supervisores"] = supervisores;
        }

        protected void lbRegistrarEmpleado_Click(object sender, EventArgs e)
        {
            Response.Redirect("SeleccionarTipoDeEmpleado.aspx");
        }

        protected void gvEmpleadosArea_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvEmpleadosArea.PageIndex = e.NewPageIndex;
            gvEmpleadosArea.DataSource = ViewState["EmpleadosArea"] as BindingList<empleadoDeArea>;
            gvEmpleadosArea.DataBind();
        }

        protected void gvEmpleadosArea_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            daoEmpleadoArea = new EmpleadoDeAreaWSClient();
            int idEmpleadoArea = Convert.ToInt32(e.CommandArgument);
            if (e.CommandName == "ModificarEmpleadoArea")
            {
                Response.Redirect($"GestionarEmpleadoArea.aspx?id={idEmpleadoArea}");
            }
            else if (e.CommandName == "EliminarEmpleadoArea")
            {
                daoEmpleadoArea.eliminarEmpleadoDeArea(idEmpleadoArea);
                CargarEmpleadosArea();
            }
            else if (e.CommandName == "VerEmpleadoArea")
            {
                VerEmpleadoArea(idEmpleadoArea);
            }
        }

        protected void gvCajeros_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvCajeros.PageIndex = e.NewPageIndex;
            gvCajeros.DataSource = ViewState["Cajeros"] as BindingList<cajero>;
            gvCajeros.DataBind();
        }

        protected void gvCajeros_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            daoCajero = new CajeroWSClient();
            int idCajero = Convert.ToInt32(e.CommandArgument);
            if (e.CommandName == "ModificarCajero")
            {
                Response.Redirect($"GestionarCajero.aspx?id={idCajero}");
            }
            else if (e.CommandName == "EliminarCajero")
            {
                daoCajero.eliminarCajero(idCajero);
                CargarCajeros();
            }
            else if (e.CommandName == "VerCajero")
            {
                VerCajero(idCajero);
            }
        }

        protected void gvSupervisores_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            gvSupervisores.PageIndex = e.NewPageIndex;
            gvSupervisores.DataSource = ViewState["Supervisores"] as BindingList<supervisor>;
            gvSupervisores.DataBind();
        }

        protected void gvSupervisores_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            daoSupervisor = new SupervisorWSClient();
            int idSupervisor = Convert.ToInt32(e.CommandArgument);
            if (e.CommandName == "ModificarSupervisor")
            {
                Response.Redirect($"GestionarSupervisor.aspx?id={idSupervisor}");
            }
            else if (e.CommandName == "EliminarSupervisor")
            {
                daoSupervisor.eliminarSupervisor(idSupervisor);
                CargarSupervisores();
            }
            else if (e.CommandName == "VerSupervisor")
            {
                VerSupervisor(idSupervisor);
            }
        }

        private void VerEmpleadoArea(int idEmpleadoArea)
        {
            BindingList<empleadoDeArea> empleados = ViewState["EmpleadosArea"] as BindingList<empleadoDeArea>;
            var empleado = empleados.FirstOrDefault(x => x.idEmpleado == idEmpleadoArea);
            if (empleado != null)
            {
                lblDetallesEmpleado.Text = $"<strong>Nombre:</strong> {empleado.nombre}<br/>" +
                                           $"<strong>Teléfono:</strong> {empleado.telefono}<br/>" +
                                           $"<strong>Email:</strong> {empleado.email}<br/>" +
                                           $"<strong>Sexo:</strong> {empleado.sexo}<br/>" +
                                           $"<strong>Salario:</strong> {empleado.salario}<br/>" +
                                           $"<strong>Horario:</strong> {empleado.horario}<br/>";
                ScriptManager.RegisterStartupScript(this, this.GetType(), "ShowModal", "$('#verEmpleadoModal').modal('show');", true);
            }
        }

        private void VerCajero(int idCajero)
        {
            BindingList<cajero> empleados = ViewState["Cajeros"] as BindingList<cajero>;
            var empleado = empleados.FirstOrDefault(x => x.idEmpleado == idCajero);
            if (empleado != null)
            {
                lblDetallesEmpleado.Text = $"<strong>Nombre:</strong> {empleado.nombre}<br/>" +
                                           $"<strong>Teléfono:</strong> {empleado.telefono}<br/>" +
                                           $"<strong>Email:</strong> {empleado.email}<br/>" +
                                           $"<strong>Sexo:</strong> {empleado.sexo}<br/>" +
                                           $"<strong>Salario:</strong> {empleado.salario}<br/>" +
                                           $"<strong>Horario:</strong> {empleado.horario}<br/>";
                ScriptManager.RegisterStartupScript(this, this.GetType(), "ShowModal", "$('#verEmpleadoModal').modal('show');", true);
            }
        }

        private void VerSupervisor(int idSupervisor)
        {
            BindingList<supervisor> empleados = ViewState["Supervisores"] as BindingList<supervisor>;
            var empleado = empleados.FirstOrDefault(x => x.idEmpleado == idSupervisor);
            if (empleado != null)
            {
                lblDetallesEmpleado.Text = $"<strong>Nombre:</strong> {empleado.nombre}<br/>" +
                                           $"<strong>Teléfono:</strong> {empleado.telefono}<br/>" +
                                           $"<strong>Email:</strong> {empleado.email}<br/>" +
                                           $"<strong>Sexo:</strong> {empleado.sexo}<br/>" +
                                           $"<strong>Salario:</strong> {empleado.salario}<br/>" +
                                           $"<strong>Horario:</strong> {empleado.horario}<br/>";
                ScriptManager.RegisterStartupScript(this, this.GetType(), "ShowModal", "$('#verEmpleadoModal').modal('show');", true);
            }
        }

        private void CargarEmpleadosArea()
        {
            daoEmpleadoArea = new EmpleadoDeAreaWSClient();
            empleadoDeArea[] arregloEmpleadoAreas = daoEmpleadoArea.listarEmpleadoArea();
            if (arregloEmpleadoAreas != null)
            {
                empleadosArea = new BindingList<empleadoDeArea>(arregloEmpleadoAreas);
                gvEmpleadosArea.DataSource = empleadosArea;
                gvEmpleadosArea.DataBind();
            }
        }

        private void CargarCajeros()
        {
            daoCajero = new CajeroWSClient();
            cajero[] arreglocajeros = daoCajero.listarCajeros();
            if (arreglocajeros != null)
            {
                cajeros = new BindingList<cajero>(arreglocajeros);
                gvCajeros.DataSource = cajeros;
                gvCajeros.DataBind();
            }
        }

        private void CargarSupervisores()
        {
            daoSupervisor = new SupervisorWSClient();
            supervisor[] arregloSupervisores = daoSupervisor.listarSupervisores();
            if (arregloSupervisores != null)
            {
                supervisores = new BindingList<supervisor>(arregloSupervisores);
                gvSupervisores.DataSource = supervisores;
                gvSupervisores.DataBind();
            }
        }

        protected void gvEmpleadosArea_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if(e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[4].Text = Convert.ToChar(DataBinder.Eval(e.Row.DataItem, "sexo")).ToString();
            }
        }

        protected void gvCajeros_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[4].Text = Convert.ToChar(DataBinder.Eval(e.Row.DataItem, "sexo")).ToString();
            }
        }

        protected void gvSupervisores_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            if (e.Row.RowType == DataControlRowType.DataRow)
            {
                e.Row.Cells[4].Text = Convert.ToChar(DataBinder.Eval(e.Row.DataItem, "sexo")).ToString();
            }
        }
    }
}