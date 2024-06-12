using SoftProgRRHHModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftProgRHHController.DAO
{
    public interface ProductoDAO
    {
        int insertarProducto(Producto producto,int opcion);
    }
}
