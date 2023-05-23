function getCars() {
    $.ajax({
        url: "https://g6f40614b1fac54-usergiodb.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/car/car",
        type: "GET",
        datatype: "JSON",
        success: function(response){
            console.log(response);
            console.log(response.items.length);
            printTable(response.items);

            /*
            1 - Ejemplo de una forma de incluir cada valor en la tabla
            for (let i = response.items.length - 1; i >= 0; i--) {
                const carElement = response.items[i];
                console.log(carElement);
                $("#result").append(carElement.id+" "+carElement.brand+"<br>");
            }*/

        },
        error: function(){
            alert("Estamos presentando problemas en la plataforma. Intente de nuevo mas tarde.");
        } 

    });
}

function printTable(items) {
    //  Accede al elemento tabla por medio del id. Luego accede al elemento por el nombre del tag "tbody"
    //  Obtiene el de la posición 0 ya que retorna una array de elementos o pordrían haber mas de uno.
    var bodyTable = document.getElementById("CarDatatable").getElementsByTagName("tbody")[0];
    var TheadTable = document.getElementById("CarDatatable").getElementsByTagName("thead")[0];

    //  Eliminamos el contenido anterior de la tabla
    $("CarDatatable").empty();
    $("tbody").empty();
    $("thead").empty();

    //  Insertamos una fila en la cabecera y en el body de la tabla
    var filaThead = TheadTable.insertRow();
    
    // Poner los nombres de las cabeceras
    Object.keys(items[0]).forEach(key => {
        var cellThead = filaThead.insertCell();
        cellThead.innerHTML = key;
    });
    // Insertar una columna adicional para mostrar los botones de eliminar
    filaThead.insertCell();


    items.forEach(item => {
        var filaBody = bodyTable.insertRow();
        Object.values(item).forEach((value, index) => {
            var cellBody = filaBody.insertCell();
            cellBody.innerHTML = value;
            
            // Almacenamos el valo de la primera celda de la fila (contiene el ID)
            if (index == 0) {
                // Lo hacemos mediante la creación de una atributo al objeto fila
                filaBody.setAttribute("valorId", value);
            }
        });

        // Insertamos una fila con un boton para eliminar
        var deleteButtonCell = filaBody.insertCell();
        // Creamos el botton y le ponemos el texto
        var deleteButton = document.createElement("button");
        deleteButton.innerHTML = "Delete Car";
        // Le creamos el listener para llamar la función cuando le den click
        deleteButton.addEventListener("click", function(){
            // Obtenemos el valor almacenado y se lo pasamos como parámetro a la función
            var valorId = filaBody.getAttribute("valorId");
            deleteCar(valorId);
        });

        // Adicionamos el boton a la celda
        deleteButtonCell.appendChild(deleteButton);

    });

}

function deleteCar(valueId){
    console.log("ID: "+valueId);
    let car ={
        id : valueId
    }
    car = JSON.stringify(car);
    $.ajax({
        url: "https://g6f40614b1fac54-usergiodb.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/car/car",
        type: "DELETE",
        datatype: "JSON",
        contentType: "application/JSON",
        data: car,
        success: function (response) {
            console.log(response);
            getCars();
        },
        error: function(){
            alert("The car didn't delete");
        }
    })    
}

function saveCar() {
    let car = {
        id: $("#car_id").val(),
        brand: $("#car_brand").val(),
        model: $("#car_model").val(),
        category_id: $("#car_categoryId").val()
    }   
    console.log("Car: "+car);
    postCar(car);
}

function postCar(Car) {
    $.ajax({
        url: "https://g6f40614b1fac54-usergiodb.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/car/car",
        type: "POST",
        datatype: "JSON",
        data: Car,

        success: function (respose) {
            
            limpiarDatosFormulario();
            // Mostramos en consola
            console.log(respose);

            // Volvemos a realizar la consulta para actualizar la tabla y confirmar que si se guardó
            getCars();
        },
        error: function(){
            alert("No se almacenó el carro");
        }
    });
}

function limpiarDatosFormulario() {
    // Limpiamos los campos del formulario
    $("#car_id").val("");
    $("#car_model").val("");
    $("#car_brand").val("");
    $("#car_categoryId").val("");
}

function updateCar() {

    if($("#car_id").val() == "" ||  $("#car_brand").val() == "" || $("#car_model").val() == "" || $("#car_categoryId").val() == ""){
        alert("Diligencie todos los campos del formulario para poder actualizar.");
    }else{
        let car = {
            id : $("#car_id").val(),
            brand : $("#car_brand").val(),
            model : $("#car_model").val(),
            category_id: $("#car_categoryId").val()
        }
        console.log("Car: "+car);
        putCar(car);
    }
    
}

function putCar(Car) {
    
    Car = JSON.stringify(Car);
    console.log(Car);
    $.ajax({
        url: "https://g6f40614b1fac54-usergiodb.adb.sa-saopaulo-1.oraclecloudapps.com/ords/admin/car/car",
        type: "PUT",
        data: Car,
        datatype: "JSON",
        contentType: "application/JSON",
        success: function(response){
            console.log(response);
            limpiarDatosFormulario();
            getCars();
        },
        error: function(){
            alert(" Car doesn't updated...Try again")
        }
    });
}


