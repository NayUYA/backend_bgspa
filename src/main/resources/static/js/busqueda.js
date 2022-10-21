/* EN DESARROLLO 
//variables de la sección barra de busqueda
var boton = document.getElementById("lupa");
var barra = document.getElementById("barraBusqueda");
var cobertura =document.getElementById("cover");
var busqueda1 = document.getElementById("btnBq");
var cajabusqueda = document.getElementById("cajaBusqueda");

var buscar = document.querySelector("#entradaBusqueda");
var productos = JSON.parse(localStorage.getItem("producto"));
var resultado = document.querySelector("#cajaBusqueda");
console.log(productos);


//evento para mostrar barra
boton.addEventListener("click", function (e){
  e.preventDefault();
  barra.style.top = "130px";
  cobertura.style.display = "block";
  busqueda1.focus();
});


//evento para ocultar barra
cobertura.addEventListener("click", function(f){
  f.preventDefault();
  barra.style.top = "-10px";
  cobertura.style.display = "none";
  busqueda1.value = "";
  barra.style.zIndex= "10";
});

//funcion flecha de busqueda de productos en LocalStorage
const busqueda = () => {
  let textoBq = buscar.value.toLowerCase();
  for (let producto of productos) {
    let nombre = producto.name.toLowerCase();
    if (nombre.indexOf(textoBq) !== -1) {
        
      resultado.innerHTML += `
            <li><a href="#">${producto.name}</a> - Precio: $${producto.precio}</li>
            `;
    }
  }
  if (resultado.innerHTML === "") {
    resultado.innerHTML += `
        <li>Producto no encontrado/disponible... UnU</li>
        `;
  }
};

buscar.addEventListener("keyup", busqueda);
busqueda();*/