var map = L.map('map',{
    maxZoom: 20,
    minZoom: 18
});
var lat = 41.683229;
var lng = -0.887100;
map.setView([lat, lng], 17);
L.tileLayer('http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 20,
    attribution: 'Map data &copy; OpenStreetMap contributors'
}).addTo(map);
var wmsLayer0= L.tileLayer.wms("http://localhost:8088/geoserver/wms", {
    layers: 'WilleWMS:planta_0',
    format: 'image/png',
    crs:L.CRS.EPSG3857,
    maxZoom: 20,
    transparent: true
}).addTo(map);
var wmsLayer1= L.tileLayer.wms("http://localhost:8088/geoserver/wms", {
    layers: 'WilleWMS:planta_1',
    format: 'image/png',
    crs:L.CRS.EPSG3857,
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
    crs:L.CRS.EPSG3857,
    maxZoom: 20,
    transparent: true
});
var wmsLayerSot= L.tileLayer.wms("http://localhost:8088/geoserver/wms", {
    layers: 'WilleWMS:planta_sotano',
    format: 'image/png',
    crs:L.CRS.EPSG3857,
    maxZoom: 20,
    transparent: true
});
var wmsLayer4= L.tileLayer.wms("http://localhost:8088/geoserver/wms", {
    layers: 'WilleWMS:ada_planta_4',
    format: 'image/png',
    crs:L.CRS.EPSG3857,
    maxZoom: 20,
    transparent: true
});
var pisos = {
    "Sotanos":wmsLayerSot,
    "Planta baja":wmsLayer0,
    "Primer piso":wmsLayer1,
    "Segundo piso":wmsLayer2,
    "Tercer piso":wmsLayer3,
    "Cuarto piso (Ada)":wmsLayer4
}
L.control.layers(pisos).addTo(map);
var sidebar = L.control.sidebar('sidebar').addTo(map);