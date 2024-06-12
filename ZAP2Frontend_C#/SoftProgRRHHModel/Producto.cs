using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgRRHHModel
{
    public class Producto
    {
        private int idProducto;
        private string nombreProducto;
        private string descripcion;
        private bool Activo;

        public int IdProducto { get => idProducto; set => idProducto = value; }
        public string NombreProducto { get => nombreProducto; set => nombreProducto = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
        public bool Activo1 { get => Activo; set => Activo = value; }
    }
}
