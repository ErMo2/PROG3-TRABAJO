function showModalFormProducto() {
    var modalFormProducto = new bootstrap.Modal(document.getElementById('form-modal-producto'));
    modalFormProducto.toggle();
}

function showModalFormEliminarPedido() {
    var modalFormEliminarPedido = new bootstrap.Modal(document.getElementById('form-modal-confirmarEliminarPedido'));
    modalFormEliminarPedido.toggle();
}