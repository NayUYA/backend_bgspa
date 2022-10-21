let btnSubmit = document.getElementById("btnAgregar");
let productos = [];
let cont = 85;
let ident = 0;
let lista = document.getElementById("lista");
let contenedor = document.querySelector("#conta");
//const key = "productos";
let imgf ="";
let archivo = document.getElementById("campoArchivo");
let btnFake = document.getElementById("btnFake");

//Evento para cargar imagen
btnFake.addEventListener("click", function () {
    archivo.click();
  });
  
  //imagen a base64
  archivo.addEventListener("change", function () {
    //const file = archivo.files[0];
    let reader = new FileReader();
  
    reader.addEventListener("load", function(){
      //console.log(reader.result)
      imgf = reader.result;
    });
    let src = "";
    src = reader.readAsDataURL(archivo.files[0]);
    console.log(imgf);
  });

btnSubmit.addEventListener("click", function(e){ 
    e.preventDefault();
    let nombre = document.getElementById("campoProducto");
    //let archivo = document.getElementById("campoArchivo");
    let categoria = document.getElementById("inlineFormCustomSelect");
    let precio = document.getElementById("campoPrecio");
    let envia = document.getElementById("campoPrecio").value;
    let descripcion = document.getElementById("campoDescripcion");
    let alertexitosa = document.getElementById("alertaexitosa");
    let alerterror = document.getElementById("alertaerror");
    let formulario = document.getElementById("formulario"); 
    let sku= document.getElementById("campoSKU");
    let enviosku= document.getElementById("campoSKU").value;

	
    ///JSON Y LOCAL STORAGE
    let arregloProductos = {
        "id" : cont,
        "name": nombre.value,
        "img": imgf,
        "description": descripcion.value,
        "precio": parseFloat(envia),
        "categoria": categoria.value,
        "sku": enviosku
    };

    

    /* let id_row = 'row' + cont; //
    let fila_todascolumnas = `<tr id= ${id_row} row-sm-12 row-md-12 ><td> ${ident} </td><td>        
    ${nombre.value} </td><td> ${archivo.value} </td><td> ${descripcion.value} </td><td>$ ${parseFloat(precio.value)} </td><td> ${categoria.value} </td><td> ${sku.value} </td></tr>`;
   
    //Agregar a la tabla
    $("#lista").append(fila_todascolumnas); //

     //------------LocalStorage--------------------------------------
     
     //Comprobación de valores en la consola.
     let n = nombre.value;
     let a = archivo.value;
     let d = descripcion.value;
     let p = parseFloat(precio.value);
     let c = categoria.value;
     let s = sku.value
 
 
     console.log(n);
     console.log(a);
     console.log(d);
     console.log(p);
     console.log(c);
     console.log(s); */

     //VALIDACIONES DE FORMULARIO
     const flag = {
        nombre: false,
        precio: false,
        categoria: false,
        descripcion: false,
        archivo:false,
        sku:false
    }
    //validación de nombre producto
    nombre.classList.remove("is-invalid");
    nombre.classList.add("is-valid");

    if ((nombre.value.length >= 5) && !(nombre.value.trim() == "") && (nombre.value[0] != " ")) {
        nombre.classList.add("is-valid"); 
        flag.nombre = true
    }
    else{  
        nombre.classList.add("is-invalid");
        flag.nombre = false
    }

        //validación precio
        function validarC (campoPrecio){
            precio.classList.add("is-invalid");
            let expReg=  /^\d+(?:\.\d{0,2})$/;
            let validar= expReg.test(campoPrecio);
            if (validar){
                precio.classList.remove("is-invalid");
                precio.classList.add("is-valid");
                flag.precio = true
            }//if
            else{
                precio.classList.remove("is-valid");
                precio.classList.add("is-invalid");
                flag.precio = false
            }//else
        }//fuction
        validarC (envia);

    
    //Validación categoría
    if (categoria.selectedIndex!=0){   //validar estados
        categoria.classList.remove("is-invalid")
        categoria.classList.add("is-valid");
        flag.categoria = true
    } else {
        categoria.classList.remove("is-valid");
        categoria.classList.add("is-invalid");
        flag.categoria = false
    }; // != 0

    // validación de la descripción
    descripcion.classList.remove("is-invalid");
    descripcion.classList.add("is-valid");

    if ((descripcion.value.length >=10) && !(nombre.value.trim() == "") && (descripcion.value[0] != " ")){
    descripcion.classList.add("is-valid");
    flag.descripcion = true
    } else {
    descripcion.classList.add("is-invalid");
    flag.descripcion = false
    }

        // validación campo Archivo
        console.log(archivo.value) 
        if(archivo.value==""){
                flag.archivo= false;
                archivo.classList.remove("is-valid");
                archivo.classList.add("is-invalid");
    
            }//if
            else{
                flag.archivo=true;
                archivo.classList.remove("is-invalid");
                archivo.classList.add("is-valid");
            }//else
    

    // validación de campo SKU

    function validarS (campoSKU){
        sku.classList.add("is-invalid");
        let expReg= /[A-Z0-9]/ ;
        let validar= expReg.test(campoSKU);
        if (validar){
            sku.classList.remove("is-invalid");
            sku.classList.add("is-valid");
            flag.sku = true
        }//if
        else{
            sku.classList.remove("is-valid");
            sku.classList.add("is-invalid");
            flag.sku = false
        }//else
    }//fuction
    validarS (enviosku);


   //------------------------------------------------------
        
        let url= '/api/productos/';	
	
	//arreglo nuevo
	   let data = {
        nombre: nombre.value,
        sku: sku.value,
        descripcion: descripcion.value,
        precio: precio.value,
        img:imgf,
        categoria: categoria.value
    	};
		console.log(data);	
		
		//fetch
 const Prueba = () => {
	fetch(url,{
		method: 'POST' ,
		body: JSON.stringify(data),
		headers:{
			'Content-Type':'application/json'
		}
	}).then(res=> res.json())
	.catch(error=> console.error('Error:', error))
	};
	
	//---------------------------------------------

    //ALERTA GENERAL
    if (flag.nombre && flag.precio && flag.descripcion && flag.categoria && flag.archivo && flag.sku){     
    Prueba();
    
  
	
        cont++;
        ident++;
        
        productos.push(arregloProductos);
        JSON.stringify(productos);
        localStorage.setItem(key, JSON.stringify(productos));
        alertexitosa.style.display = "block";
        setTimeout(()=>{alertexitosa.style.display = "none"}, (5000));
        formulario.reset();
        nombre.classList.remove("is-valid")
        precio.classList.remove("is-valid")
        descripcion.classList.remove("is-valid")
        categoria.classList.remove("is-valid")
        archivo.classList.remove("is-valid")
        sku.classList.remove("is-valid")
        console.log("si funciona")
    } else {
        alerterror.style.display = "block";
        setTimeout(()=>{alerterror.style.display = "none"}, (7000));
        console.log("no funciona")
    }
    
    /// añadir card a pagina admin
    let item = JSON.parse(localStorage.getItem(key));

    // es igual a un forEach
    for (let producto of item) {
        contenedor.innerHTML += `<div class="card" style="width: 18rem;">
            <img src="${producto.img}" class="card-img-top imageFile" id="imgCard alt="Imagen de nuevo producto">
            <div class="card-body">
              <p class="card-title">Nombre: <strong>${producto.name}</strong><p>
              <hr/>
              <p class="card-text">Descripción: ${producto.description}</p>
              <p class="card-text">Precio: $${producto.precio}</p>
              <p class="card-text">Categoría: ${producto.categoria}</p>
              <p class="card-text">SKU: ${producto.sku}</p>
            </div>
          </div>`;
      }
});
