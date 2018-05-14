

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
var pisos = {
    "Sotanos":wmsLayerSot,
    "Planta baja":wmsLayer0,
    "Primer piso":wmsLayer1,
    "Segundo piso":wmsLayer2,
    "Tercer piso":wmsLayer3,
    "Cuarto piso (Ada)":wmsLayer4
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


function muestraincidencias() {
    map.removeLayer(marker);
    var popup1 = L.responsivePopup().setContent('<div id="fichaincidencias">ficha Con todas las incidencias que hay<br>incidencia=' +infoespacio["edificio"] + ' </div>')
    marker=L.marker(punto.latlng).addTo(map).bindPopup(popup1,{minWidth: 500});
    marker.openPopup();
}


function crearincidencia() {
    var data = {}
    data.nombre =  document.getElementById("nombre").value;
    data.descripcion  = document.getElementById("descripcion").value;
    data.valorlat  = puntolat
    data.valorlong  = puntolong;

    var json = JSON.stringify(data);
    console.log(json)
    url2="/crearincidencia"
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", url2, false);
    xmlhttp.setRequestHeader('Content-type','application/json; charset=utf-8');
    xmlhttp.send(json);

    console.log(infoespacio)
}

function menucrearincidencias() {
    map.removeLayer(marker);
    var formulario='<div class="w3-padding-32" >'+
                '<label class="w3-padding-16 w3-xlarge"><b>Nueva Incidencia</b></label><br>'+
                '<label class="w3-padding-16 w3-xlarge"><b>Nombre</b></label>'+
                '<input type="text" placeholder="Nombre de la incidencia" id="nombre" name="nombre" maxlength="70" class="w3-input"  required> <br>'+
                '<label  class="w3-padding-16 w3-xlarge"><b>Descripcion</b></label>'+
                '<input type="text" placeholder="Enter Password"  maxlength="150" id="descripcion" name="descripcion" class="w3-input" required><br>'+
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
    // transformacion de coordenadas a 25830
    var bngprojection = "+proj=utm +zone=30 +ellps=GRS80 +units=m +no_defs ";
    punto = proj4(bngprojection, [ e.latlng.lng,e.latlng.lat]);
    puntolat=punto[0];
    puntolong=punto[1];
    var data = {};
    data.latitud =  punto[1];
    data.longitud=  punto[0];
    data.planta  = 0;
    var json = JSON.stringify(data);
    url="/espacio";
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", url, false);
    xmlhttp.send(json);
    infoespacio=JSON.parse(xmlhttp.responseText)
    punto=e
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