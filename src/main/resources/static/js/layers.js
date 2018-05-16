var map = L.map('map',{ //CRS por defecto EPSG3857

    maxZoom: 20,
    minZoom: 18

});
var lat = 41.683229;
var lng = -0.887100;
map.setView([lat, lng], 17);
//Carga todos los layers de OSM y de geoserver
L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 20,
    attribution: 'Map data &copy; OpenStreetMap contributors'
}).addTo(map);
var wmsLayer0= L.tileLayer.wms("http://localhost:8088/geoserver/wms", {
    layers: 'WilleWMS:planta_0',
    format: 'image/png',
    maxZoom: 20,
    transparent: true
}).addTo(map);
var wmsLayer1= L.tileLayer.wms("http://localhost:8088/geoserver/wms", {
    layers: 'WilleWMS:planta_1',
    format: 'image/png',
    maxZoom: 20,
    transparent: true
});
var wmsLayer2= L.tileLayer.wms("http://localhost:8088/geoserver/wms", {
    layers: 'WilleWMS:planta_2',
    format: 'image/png',
    crs:L.CRS.EPSG3857,
    maxZoom: 20,
    transparent: true
});
var wmsLayer3= L.tileLayer.wms("http://localhost:8088/geoserver/wms", {
    layers: 'WilleWMS:planta_3',
    format: 'image/png',
    maxZoom: 20,
    transparent: true
});
var wmsLayerSot= L.tileLayer.wms("http://localhost:8088/geoserver/wms", {
    layers: 'WilleWMS:planta_sotano',
    format: 'image/png',
    maxZoom: 20,
    transparent: true
});
var wmsLayer4= L.tileLayer.wms("http://localhost:8088/geoserver/wms", {
    layers: 'WilleWMS:ada_planta_4',
    format: 'image/png',
    maxZoom: 20,
    transparent: true
});
//Control de las plantas que se muestran
/**var pisos = {
    "Sotanos":wmsLayerSot,
    "Planta baja":wmsLayer0,
    "Primer piso":wmsLayer1,
    "Segundo piso":wmsLayer2,
    "Tercer piso":wmsLayer3,
    "Cuarto piso (Ada)":wmsLayer4
};*/

var pisos = {
    "<span id=Sotano>Sotanos</span>":wmsLayerSot,
    "<span id=Plantabaja>Planta baja</span>":wmsLayer0,
    "<span id=Primerpiso>Primer piso</span>":wmsLayer1,
    "<span id=Segundopiso>Segundo piso</span>":wmsLayer2,
    "<span id=Tercerpiso>Tercer piso</span>":wmsLayer3,
    "<span id=Cuartopiso>Cuarto piso (Ada)</span>":wmsLayer4
};


L.control.layers(pisos).addTo(map);
//Barra lateral
var sidebar = L.control.sidebar('sidebar');
sidebar.addTo(map);



//Funcion que maneja los clicks en el mapa


////  COMPORTAMIENTO BOTON


var punto
var infoespacio
var marker=null;
var puntolat
var puntolong
var planta

$(document).ready(function(){

        console.log("voy al registro")
        url="/registro";
        var xmlhttp = new XMLHttpRequest();
        xmlhttp.open("GET", url, false);
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send();
        console.log(xmlhttp.response)
        var array={}
        array=JSON.parse(xmlhttp.response)
        console.log(array)
        todasnotificaciones=""
        for (x=0;x<array.length;x++){
            contenidoficha='<div id="ficha">'+
                '<b class="w3-center">Incidencia '+x+'</b><br>'+
                '<b>Nombre de la incidencia: '+ array[x]["nombre"] +' </b><br>'+
                '<b>Descripcion: '+ array[x]["descripcion"] +' </b><br>'+
                '<b>Planta: '+ array[x]["localizacion"]["planta"]+' </b><br>'+
                '<b>Fecha Creada: ' + array[x]["fechaCreada"]+' </b><br>'+
                '</div><br><hr/><hr/>'
            console.log("Vamos por " + array[x]["idespacio"])
            todasnotificaciones+=contenidoficha
        }
        document.getElementById('nuevasincidencias').innerHTML=todasnotificaciones;

});






function muestraincidencias() {
    map.removeLayer(marker);
    var popup1 = L.responsivePopup().setContent('<div id="fichaincidencias">Incidencias del espacio '+infoespacio["nombre"]+'<br>\n' +todasnotificaciones + ' </div>')
    marker=L.marker(punto.latlng).addTo(map).bindPopup(popup1,{minWidth: 500});
    marker.openPopup();
}


function crearincidencia() {
    descripcion =document.getElementById("descripcion").value
    nombre= document.getElementById("nombre").value;
    latitud=puntolat
    longitud=puntolong
    var data = {}
    data.descripcion  = descripcion
    data.latitud  = latitud
    data.longitud  = longitud
    data.notificacion=false
    data.planta =planta
    data.nombre = nombre



    var json = JSON.stringify(data);
    console.log(json)
    url2="/crearincidencia"
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", url2, false);
    xmlhttp.setRequestHeader('Content-type','application/json; charset=utf-8');
    xmlhttp.send(json);


}

function menucrearincidencias() {
    map.removeLayer(marker);
    var formulario='<div class="w3-padding-32" >'+
        '<label class="w3-padding-16 w3-xlarge"><b>Nueva Incidencia</b></label><br>'+
        '<label class="w3-padding-16 w3-xlarge"><b>Nombre</b></label>'+
        '<input type="text" placeholder="Nombre de la incidencia" id="nombre" name="nombre" maxlength="70" class="w3-input"  required> <br>'+
        '<label  class="w3-padding-16 w3-xlarge"><b>Descripcion</b></label>'+
        '<input type="text" placeholder="Descripción breve de la incidencia"  maxlength="150" id="descripcion" name="descripcion" class="w3-input" required><br>'+
        '<div class = "w3-center">'+
        '<button type="reset" class="w3-button w3-blue">Cancelar</button>'+
        '<button onclick="crearincidencia()" class="w3-button w3-blue">Crear</button>'+
        '</div>'+
        '</div>'

    var popup1 = L.responsivePopup().setContent(formulario);
    marker=L.marker(punto.latlng).addTo(map).bindPopup(popup1,{minWidth: 500});
    marker.openPopup();
}





function getinfoEspacio(e) {
    // localizar el piso

    var x =  document.getElementsByName("leaflet-base-layers");

    if(x[0].checked){
        planta=-1
    }else if(x[1].checked){
        planta=0
    }else if(x[2].checked){
        planta=1
    }else if(x[3].checked){
        planta=2
    }else if(x[4].checked){
        planta=3
    }else if(x[5].checked){
        planta=4
    }


    // transformacion de coordenadas a 25830
    var bngprojection = "+proj=utm +zone=30 +ellps=GRS80 +units=m +no_defs ";
    punto = proj4(bngprojection, [ e.latlng.lng,e.latlng.lat]);
    puntolat=punto[1];
    puntolong=punto[0];
    var data = {};
    data.latitud =  punto[1];
    data.longitud=  punto[0];
    data.planta  = planta;

    var json = JSON.stringify(data);
    url="/espacio";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", url, false);
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(json);
    infoespacio=JSON.parse(xmlhttp.responseText)
    punto=e;

    var contenidoficha='<div id="ficha">'+
        '<b class="w3-center">Ficha</b><br>'+
        '<b>Edificio: '+infoespacio["edificio"] +' </b><br>'+
        '<b>Espacio: '+ infoespacio["nombre"]+' </b><br>'+
        '<b>Planta: '+ infoespacio["planta"]+' </b><br>'+
        '<b>Exterior:' + infoespacio["exterior"]+' </b><br>'+
        '<button  onclick="muestraincidencias()"  role="button" class="w3-button w3-blue">Ver incidencias</button>'+
        '<button  onclick="menucrearincidencias()"  role="button" class="w3-button w3-blue">Crear incidencia</button>'+
        '</div>'
    popup = L.responsivePopup().setContent(contenidoficha);
    marker=L.marker(e.latlng).addTo(map).bindPopup(popup);
    marker.openPopup();
}

function onMapClick(e) {
    if(marker!=null) {
        map.removeLayer(marker);
    }
    getinfoEspacio(e);
    map.flyTo(e.latlng);

}
map.on('click',onMapClick);