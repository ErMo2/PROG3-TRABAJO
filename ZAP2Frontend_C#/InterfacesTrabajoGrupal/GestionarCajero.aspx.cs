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
    public partial class Cajero : System.Web.UI.Page
    {
        private CajeroWSClient daoCajero;
        private cajero empleado;

        private AreaWSClient daoArea;
        private area area;
        private BindingList<area> listaAreaxSucursales;

        private SupervisorWSClient daoSupervisor;
        private supervisor supervisor;
        private BindingList<supervisor> listarSupervisoresXSucursal;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                int idEmpleadoArea;
                if (int.TryParse(Request.QueryString["id"], out idEmpleadoArea))
                {
                    cargarCajeros(idEmpleadoArea);
                }
                else
                {
                    cargarAreasXSucursales();
                    CargarSupervisoresXArea();
                }
                
            }
        }
        private void cargarAreasXSucursales()
        {
            daoArea = new AreaWSClient();
            area[] arregloAreas = daoArea.listarAreaConSucursales();
            listaAreaxSucursales = new BindingList<area>(arregloAreas);
            ddlAreaXSucursal.DataSource = listaAreaxSucursales;
            ddlAreaXSucursal.DataTextField = "nombre";
            ddlAreaXSucursal.DataValueField = "idArea";
            ddlAreaXSucursal.DataBind();
        }
        private void cargarCajeros(int idCajero)
        {
            daoCajero = new CajeroWSClient();

            empleado = daoCajero.buscarCajero(idCajero);

            if (empleado != null)
            {
                txtIdEmpleado.Text = empleado.id_Persona.ToString();
                txtNombre.Text = empleado.nombre;
                txtApellido_Paterno.Text = empleado.apellido_paterno;
                txtApellido_Materno.Text = empleado.apellido_materno;
                txtTelefono.Text = empleado.telefono.ToString();
                txtEmail.Text = empleado.email;
                if (empleado.tipo_documento.ToString() == "DNI")
                    rbDni.Checked = true;
                else
                    rbCarnet_Extranjeria.Checked = true;
                txtNumeroDocumento.Text = empleado.nro_documento.ToString();
                if (empleado.sexo == 'F')
                    rbFemenino.Checked = true;
                else
                    rbMasculino.Checked = true;
                txtDireccion.Text = empleado.direccion.ToString();
                txtSalario.Text = empleado.salario.ToString();
                dtpFechaContratacion.Value = empleado.fechaContratacion.ToString("yyyy-MM-dd");
                if (empleado.horario.ToString() == "MAÑANA")
                    rbMañana.Checked = true;
                else
                    rbNoche.Checked = true;
                if (empleado.tipoContrato.ToString() == "TiempoCompleto")
                    rbTiempoCompleto.Checked = true;
                else
                {
                    if (empleado.tipoContrato.ToString() == "TiempoParcial")
                        rbTiempoParcial.Checked = true;
                    else
                        rbContratoEspecial.Checked = true;
                }
                
                BindingList<area> cargar_area = new BindingList<area>();
                cargar_area.Add(empleado.area);
                ddlAreaXSucursal.DataSource = cargar_area;
                ddlAreaXSucursal.DataTextField = "nombre";
                ddlAreaXSucursal.DataValueField = "idArea";
                ddlAreaXSucursal.DataBind();
                

                supervisor = new supervisor();
                daoSupervisor = new SupervisorWSClient();
                supervisor = daoSupervisor.buscarSupervisor(empleado.supervisor.id_Persona);
                BindingList<supervisor> cargar_supervisor = new BindingList<supervisor>();
                supervisor.nombre = supervisor.nombre + " " +supervisor.apellido_paterno + " " + supervisor.apellido_materno;
                cargar_supervisor.Add(supervisor);
                ddlSupervisor.DataSource = cargar_supervisor;
                ddlSupervisor.DataTextField = "nombre";
                ddlSupervisor.DataValueField = "id_Persona";
                ddlSupervisor.DataBind();
            }

        }
        protected void btnRegresar_Click(object sender,EventArgs e) {
            Response.Redirect("ListarEmpleados.aspx");
        }
        protected void btnRegistrar_Click(object sender,EventArgs e)
        {
            int resultado = 0;
            daoCajero = new ServicioWS.CajeroWSClient();
            cajero cajero = new cajero();
            if (!string.IsNullOrEmpty(txtIdEmpleado.Text))
            {
                cajero.id_Persona = int.Parse(txtIdEmpleado.Text);
                cajero.idEmpleado = int.Parse(txtIdEmpleado.Text);
            }
            cajero.nombre = txtNombre.Text;
            cajero.apellido_paterno = txtApellido_Paterno.Text;
            cajero.apellido_materno = txtApellido_Materno.Text;
            cajero.telefono = int.Parse(txtTelefono.Text);
            cajero.email = txtEmail.Text;
            if (rbDni.Checked)
                cajero.tipo_documento = tipoDocumento.DNI;
            else
                cajero.tipo_documento = tipoDocumento.CARNET_EXTRANJERIA;
            cajero.tipo_documentoSpecified = true;
            cajero.nro_documento = int.Parse(txtNumeroDocumento.Text);
            if (rbFemenino.Checked)
                cajero.sexo = 'F';
            else
                cajero.sexo = 'M';
            cajero.direccion = txtDireccion.Text;
            cajero.salario = Double.Parse(txtSalario.Text);
            cajero.fechaContratacion = DateTime.Parse(dtpFechaContratacion.Value);
            cajero.fechaContratacionSpecified = true;
            if (rbMañana.Checked == true)
                cajero.horario = turnosHorario.MAÑANA;
            else
                cajero.horario = turnosHorario.NOCHE;
            cajero.horarioSpecified = true;
            if (rbTiempoCompleto.Checked == true)
                cajero.tipoContrato = tipoContrato.TiempoCompleto;
            else
            {
                if (rbTiempoParcial.Checked == true)
                    cajero.tipoContrato = tipoContrato.TiempoParcial;
                else
                    cajero.tipoContrato = tipoContrato.ContratoEspecial;
            }
            cajero.tipoContratoSpecified = true;
            area area_ = new area();
            area_.idArea = int.Parse(ddlAreaXSucursal.SelectedValue);
            cajero.area = area_;
            cajero.numeroCaja = 0;
            cajero.cantidadCaja = 0;
            supervisor superv = new supervisor();
            superv.idEmpleado = int.Parse(ddlSupervisor.SelectedValue);
            superv.id_Persona = int.Parse(ddlSupervisor.SelectedValue);
            cajero.supervisor = superv;
            if (cajero.id_Persona > 0)
            {
                resultado = daoCajero.modificarCajero(cajero);
            }
            else
            {
                resultado = daoCajero.insertarCajero(cajero);
            }
            if (resultado != 0)
            {
                Response.Redirect("ListarEmpleados.aspx");
                Response.Write("Se ha registrado con exito...");
            }
        }
        protected void CargarSupervisoresXArea()
        {
            area = new area();
            daoArea = new AreaWSClient();
            int idArea = int.Parse(ddlAreaXSucursal.SelectedValue);
            area = daoArea.buscarArea(idArea);
            int idSucursal = area.sucursal.id_sucursal;
            daoSupervisor = new SupervisorWSClient();
            supervisor[] arregloSupervisores = daoSupervisor.listarSupervisoresDeUnaSucursal(idSucursal);

            ddlSupervisor.Items.Clear();

            if (arregloSupervisores != null)
            {
                listarSupervisoresXSucursal = new BindingList<supervisor>(arregloSupervisores);

                ddlSupervisor.DataSource = listarSupervisoresXSucursal;
                ddlSupervisor.DataTextField = "nombre";
                ddlSupervisor.DataValueField = "id_Persona";

                ddlSupervisor.DataBind();
            }
        }

        protected void ddlAreaXSucursal_SelectedIndexChanged(object sender, EventArgs e)
        {
            CargarSupervisoresXArea();
        }
    }
}