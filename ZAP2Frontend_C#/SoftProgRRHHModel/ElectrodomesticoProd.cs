using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgRRHHModel
{
    public class ElectrodomesticoProd:Producto
    {
        private DateTime fechaVencimiento;
        private String modelo;
        private bool TieneGarantia;

        public DateTime FechaVencimiento { get => fechaVencimiento; set => fechaVencimiento = value; }
        public string Modelo { get => modelo; set => modelo = value; }
        public bool TieneGarantia1 { get => TieneGarantia; set => TieneGarantia = value; }
    }
}
