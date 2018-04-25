## Instalación de postgreSQL (v9.6) y PostGIS

### Ubuntu:

Información extraida de la Wiki de PostGIS [aquí](http://trac.osgeo.org/postgis/wiki/UsersWikiPostGIS23UbuntuPGSQL96Apt):

Instalar postgreSQL 9.6 y postGIS:  
Para ubuntu 16, aradir el repositorio:  
`sudo sh -c 'echo "deb http://apt.postgresql.org/pub/repos/apt xenial-pgdg main" >> /etc/apt/sources.list'`  
en otras versiones cambiar `xenial` por el nombre de la distribución correspondiente.

Añadir las claves  
`wget --quiet -O - http://apt.postgresql.org/pub/repos/apt/ACCC4CF8.asc | sudo apt-key add -`
`sudo apt-get update`  
e instalar  
`sudo apt-get install postgresql-9.6`
`sudo apt-get install postgresql-9.6-postgis-2.3 postgresql-contrib-9.6 postgresql-9.6-postgis-scripts`
`sudo apt-get install postgresql-9.6-pgrouting`

### Windows
Instalar postgreSQL 9.6, [link](https://www.enterprisedb.com/thank-you-downloading-postgresql?anid=209611) al instalador para Windows x64  
Instalar [postGIS para 9.6 ](http://download.osgeo.org/postgis/windows/pg96/)

 ## Configuración y carga de los datos para Geoserver
 
 Cargar el fichero **gisdb** que se encuentra en la carpeta *Despliegue* mediante el comando  
 `psql -f nombre_del_fichero`  
Este comando debe tener permisos de superuser, en Ubuntu será necesario ejecutar algo como  
`sudo -u postgres psql -f gisdb `

Cargar este dump cambiará la contraseña del rol posrtgres a **postgres**, para su conexión con Geoserver

### Servidor Tomcat con Geoserver

Dispoible en [drive](https://drive.google.com/open?id=1aIKxPP4JdvjCAQVKtufwkcGRw8TKGDoK)  
El usuario es `admin` y la contraseña `geoserver`  
El servidor se lanza en el puerto 8088
